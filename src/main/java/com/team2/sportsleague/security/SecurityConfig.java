package com.team2.sportsleague.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashMap;

@Configuration //Configuration class to setup security
@EnableWebSecurity //Adds spring security's web security functionality
public class SecurityConfig {
    public static final String[] ENDPOINTS_WHITELIST = { //URLs that do not require authentication.
            "/login",
//            "/",
//            "/rankings",
//            "/gallery/**",
//            "/rules",
//            "/profile/**",
            "/css/**", "/js/**", "/images/**", "static/**"
    };

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
                        );
        // Builds and returns the configured security settings
        return httpSecurity.build();
    }


    @Bean
    // A bean used for managing users and their authentication
    public UserDetailsService userDetailsService() {
        HashMap<String, UserDetails> userDetailsHashMap= new HashMap<>();
        userDetailsHashMap.put("rshashank@creditsafe.com", User.withDefaultPasswordEncoder()
                .username("rshashank@creditsafe.com")
                .password("shashankR@11")
                .roles("user")
                .build());

        userDetailsHashMap.put("kprateek@creditsafe.it", User.withDefaultPasswordEncoder()
                .username("kprateek@creditsafe.it")
                .password("prateekK@1")
                .roles("user")
                .build());
        userDetailsHashMap.put("ankits@creditsafeuk.com", User.withDefaultPasswordEncoder()
                .username("ankits@creditsafeuk.com")
                .password("ankitS@2")
                .roles("user")
                .build());
        userDetailsHashMap.put("ataha@creditsafe.co.in", User.withDefaultPasswordEncoder()
                .username("ataha@creditsafe.co.in")
                .password("tahaA@34")
                .roles("user")
                .build());
        return username -> {
            UserDetails user = userDetailsHashMap.get(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found: " + username);
            }
            return user;
        };
    }
}
