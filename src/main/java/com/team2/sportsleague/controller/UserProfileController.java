package com.team2.sportsleague.controller;

import com.team2.sportsleague.model.User;
import com.team2.sportsleague.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/profile")
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
        // Fetch the logged-in username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Fetch the user details using the username
        Optional<User> userOptional = userService.getUserByUsername(username);
        if (userOptional.isEmpty()) {
            return "error"; // Redirect to an error page if user not found
        }

        // Add user details to the model
        model.addAttribute("user", userOptional.get());
        return "userProfile"; // Render the user profile page
    }

    /**
     * Updates the user's profile.
     *
     * @param updatedUser The user details to be updated
     * @return Success or error message
     */
    @PutMapping("/update")
    public ResponseEntity<?> updateUserProfile(@RequestBody User updatedUser) {
        // Fetch the logged-in username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Fetch the existing user
        Optional<User> userOptional = userService.getUserByUsername(username);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(404).body("User not found");
        }

        User user = userOptional.get();

        // Update only the fields that are provided
        if (updatedUser.getName() != null) user.setName(updatedUser.getName());
        if (updatedUser.getEmail() != null) user.setEmail(updatedUser.getEmail());
        if (updatedUser.getDepartment() != null) user.setDepartment(updatedUser.getDepartment());
        if (updatedUser.getRole() != null) user.setRole(updatedUser.getRole());
        if (updatedUser.getProfileImage() != null) user.setProfileImage(updatedUser.getProfileImage());

        // Save the updated user to the database
        userService.saveUser(user);

        return ResponseEntity.ok("Profile updated successfully");
    }
}
