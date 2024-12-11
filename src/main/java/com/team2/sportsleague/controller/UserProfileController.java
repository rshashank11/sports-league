package com.team2.sportsleague.controller;

import com.team2.sportsleague.model.User;
import com.team2.sportsleague.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/profile")
@Validated
public class UserProfileController {

    @Autowired
    private UserService userService;

    /**
     * Displays the user's profile.
     *
     * @param model Model to hold user data for the view
     * @return Profile page or error page if user not found
     */
    @GetMapping
    public String getUserProfile(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();


        Optional<User> userOptional = userService.getUserByUsername(username);
        if (userOptional.isEmpty()) {
            return "error";
        }


        model.addAttribute("user", userOptional.get());
        return "userProfile";
    }

    /**
     * Updates the user's profile.
     *
     * @param updatedUser The user details to be updated
     * @return Success or error message
     */
    @PutMapping("/update")
    public ResponseEntity<?> updateUserProfile(@Valid @RequestBody User updatedUser) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();


        Optional<User> userOptional = userService.getUserByUsername(username);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(404).body("User not found");
        }

        User user = userOptional.get();

        if (updatedUser.getName() != null) user.setName(updatedUser.getName());
        if (updatedUser.getUsername() != null) user.setUsername(updatedUser.getUsername());
        if (updatedUser.getDepartment() != null) user.setDepartment(updatedUser.getDepartment());
        if (updatedUser.getUserRole() != null) user.setUserRole(updatedUser.getUserRole());

        userService.updateUser(user);

        return ResponseEntity.ok("Profile updated successfully");
    }


    public static class UserValidation {
        @NotEmpty(message = "Name cannot be empty")
        private String name;

        @Email(message = "Invalid email format")
        private String email;

        @Pattern(regexp = "^(user|admin)$", message = "Role can only be 'user' or 'admin'")
        private String role;

    }
}
