package com.team2.sportsleague.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class Signup {

    @NotBlank(message = "Please enter a username.")
    @Size(min = 6, max = 50, message = "Username must be between 6 and 50 characters.")
    private String username;

    @NotBlank(message = "Please enter an email.")
    @Email(message = "Please enter a valid email address.")
    private String email;

    @NotBlank(message = "Please enter a password.")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    private String password;

    @NotBlank(message = "Please confirm your password.")
    private String confirmPassword;

}
