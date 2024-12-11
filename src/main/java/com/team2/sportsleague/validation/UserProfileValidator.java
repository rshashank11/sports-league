package com.team2.sportsleague.validation;

import org.springframework.stereotype.Component;

@Component
public class UserProfileValidator {

    /**
     * Validates the user's profile details.
     *
     * @param name  the user's name
     * @param email the user's email
     * @param role  the user's role
     * @return a validation message or null if all fields are valid
     */
    public String validateUserProfile(String name, String email, String role) {
        // Validate name
        if (name == null || name.trim().isEmpty()) {
            return "Name cannot be empty.";
        }

        // Validate email
        if (email == null || !email.contains("@")) {
            return "Email must contain '@'.";
        }

        // Validate role
        if (role == null || (!role.equalsIgnoreCase("user") && !role.equalsIgnoreCase("admin"))) {
            return "Role must be either 'user' or 'admin'.";
        }

        return null; // No validation errors
    }
}
