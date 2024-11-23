package com.team2.sportsleague.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration //Configuration class to setup security
@EnableWebSecurity //Adds spring security's web security functionality
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    public static final String[] ENDPOINTS_WHITELIST = { //URLs that do not require authentication.
            "/login",
//            "/",
//            "/rankings",
//            "/gallery/**",
//            "/rules",
//            "/profile/**",
            "/css/**", "/js/**", "/images/**", "static/**"
    };

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, authority from users_authorities where username=?");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{ //Defines security configuration for HTTP requests using HttpSecurity object.
        // Rules for authorization
        httpSecurity.authorizeHttpRequests(httpRequest -> httpRequest
                .requestMatchers(ENDPOINTS_WHITELIST).permitAll()
                        .anyRequest().authenticated()) // Any request other than ENDPOINTS_WHITELIST requires authentication
                .csrf(AbstractHttpConfigurer::disable) //Enabling it is causing errors(deprecated)
                // Login Configuration
                .formLogin(form -> form.loginPage("/login").permitAll()
                        // Login successful and failure handlers. These will be called based on the outcome of the authentication process.
                        .successHandler((request, response, authentication) -> {
                            System.out.println("Login successful! Redirecting to home page.");
                            response.sendRedirect("/"); // Redirect to home page
                        })
                        .failureHandler((request, response, exception) -> {
                            exception.printStackTrace();
                            response.sendRedirect("/login?error");
                        }).loginProcessingUrl("/login") // Form will be submitted to /login URL
                        ).logout((logout) -> logout.permitAll().logoutSuccessUrl("/login")).exceptionHandling(e -> e.accessDeniedPage("/"));
        // Builds and returns the configured security settings
        return httpSecurity.build();
    }

    @Bean
    public CommandLineRunner encodePasswordRunner() {
        return args -> {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String rawPassword = "tahaA@34"; // Replace with plain actual password
            String encodedPassword = encoder.encode(rawPassword);
            System.out.println("Encoded Password: " + encodedPassword);
            // Save the encoded password on the database
        };
    }
}
