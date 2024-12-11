package com.team2.sportsleague.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class SignupDTO {

    @NotBlank(message = "Please enter your first name.")
    private String firstName;

    @NotBlank(message = "Please enter your last name.")
    private String lastName;

    @NotBlank(message = "Please enter a valid email.")
    @Email(message = "Email should be valid.")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@creditsafe\\.com$", message = "Email must be a @creditsafe.com address.")
    private String email;

    @NotBlank(message = "Please enter a password.")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    private String password;

    @NotBlank(message = "Please confirm your password.")
    private String confirmPassword;

    @NotBlank(message = "Please enter your employee ID.")
    private String employeeId;

    @NotEmpty(message = "Please select at least one game.")
    private List<String> interestedGames;

    public String getUsername() {

        return email;
    }
}
