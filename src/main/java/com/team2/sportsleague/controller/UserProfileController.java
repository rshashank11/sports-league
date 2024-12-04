//package com.team2.sportsleague.controller;
//
//import com.team2.sportsleague.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;

//@Controller
//public class UserProfileController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/profile/{userId}")
//    public String getUserProfile(@PathVariable int userId, Model model) {
//        // Debug log to see userId
//        System.out.println("User ID: " + userId); // This will print the userId in the server log
//
//        model.addAttribute("userId", userId);
//        // Fetch user data and add to the model
//        userService.getUserById(userId).ifPresent(user -> model.addAttribute("user", user));
//
////        // Pass the userId to the model for the fragment
////        model.addAttribute("userId", userId);
//
//        return "userProfile";
//    }
//
//}

package com.team2.sportsleague.controller;

import com.team2.sportsleague.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional; // Import for Optional

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

        if (userIdOptional.isEmpty()) { // Check if Optional is empty
            // Handle case where user ID is not found (e.g., redirect or error message)
            return "error";
        }

        int userId = userIdOptional.get(); // Retrieve the value from Optional

        // Add user information to the model
        userService.getUserById(userId).ifPresent(user -> model.addAttribute("user", user));

        return "userProfile";
    }
}
