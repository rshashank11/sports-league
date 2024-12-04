package com.team2.sportsleague.controller;

import com.team2.sportsleague.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Controller
public class UserProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String getUserProfile(Model model) {
        // Fetch the logged-in username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Fetch the user ID using the username
        Optional<Integer> userIdOptional = userService.getUserIdByUsername(username);
        System.out.println(userIdOptional);

        if (userIdOptional.isEmpty()) {
            return "error";
        }

        int userId = userIdOptional.get();

        userService.getUserById(userId).ifPresent(user -> model.addAttribute("user", user));

        return "userProfile";
    }
}
