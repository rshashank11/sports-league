package com.team2.sportsleague.model;

import com.team2.sportsleague.validation.ValidUsernameOrEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Login {

    @NotBlank(message = "Please enter a username or email.")
    @Size(min=6, max=50, message="Enter a valid Creditsafe email or username.")
    @ValidUsernameOrEmail
    private String username;

    @NotBlank(message = "Please enter a password.")
    @Size(min=8, message="Password must be at least 8 long.")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
