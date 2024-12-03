package com.team2.sportsleague.controller;

import com.team2.sportsleague.model.User;
import com.team2.sportsleague.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile/{userId}")
    public String getUserProfile(@PathVariable int userId, Model model) {
        userRepository.findUserById(userId).ifPresent(user -> model.addAttribute("user", user));
        return "userProfile";
    }
}

