package com.team2.sportsleague.controller;

import com.team2.sportsleague.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile/{userId}")
    public String getUserProfile(@PathVariable int userId, Model model) {
        // Debug log to see userId
        System.out.println("User ID: " + userId); // This will print the userId in the server log

        model.addAttribute("userId", userId);
        // Fetch user data and add to the model
        userService.getUserById(userId).ifPresent(user -> model.addAttribute("user", user));

//        // Pass the userId to the model for the fragment
//        model.addAttribute("userId", userId);

        return "userProfile";
    }

}
