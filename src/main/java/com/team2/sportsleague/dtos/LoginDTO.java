package com.team2.sportsleague.dtos;

import com.team2.sportsleague.validation.ValidUsernameOrEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class LoginDTO {

    @NotBlank(message = "Please enter a username or email.")
    @Size(min=6, max=50, message="Enter a valid Creditsafe email or username.")
    @ValidUsernameOrEmail
    private String username;

    @NotBlank(message = "Please enter a password.")
    @Size(min=8, message="Password must be at least 8 long.")
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginDTO() {
    }
}
