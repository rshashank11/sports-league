package com.team2.sportsleague.controller;

import com.team2.sportsleague.model.User;
import com.team2.sportsleague.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;

    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

    @GetMapping("/userProfile")
    public String getUserProfile(@RequestParam String username, Model model) {
        User user = userDAO.getUserByUsername(username);
        model.addAttribute("user", user);
        return "UserProfile";
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam String username,
                             @RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String department,
                             @RequestParam String role,
                             @RequestParam(value = "profileImage", required = false) MultipartFile profileImage,
                             Model model) {

        User user = userDAO.getUserByUsername(username);
        user.setName(name);
        user.setEmail(email);
        user.setDepartment(department);
        user.setRole(role);

        if (profileImage != null && !profileImage.isEmpty()) {
            try {
                String imagePath = UPLOAD_DIR + profileImage.getOriginalFilename();
                profileImage.transferTo(new File(imagePath));
                user.setProfileImage(profileImage.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("error", "Error uploading file");
                return "UserProfile";
            }
        }

        userDAO.updateUser(user);
        model.addAttribute("user", user);
        model.addAttribute("message", "Profile updated successfully");
        return "UserProfile";
    }
}
