package com.team2.sportsleague.service;

import com.team2.sportsleague.model.User;
import com.team2.sportsleague.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(int userId) {
        return userRepository.findUserById(userId);
    }

//    public int getLoggedInUserId() {
//        // Assuming the username is stored in the SecurityContext
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName(); // Get username of logged-in user
//
//        // Fetch user details by username and return the user ID
//        Optional<User> user = getUserByUsername(username);
//        return user.map(User::getUserId).orElseThrow(() -> new IllegalStateException("User not found"));
//    }
//
//    public Optional<User> getUserByUsername(String username) {
//        // Implement logic to fetch user by username, if not already present
//        // Example assumes a method exists in the repository
//        return Optional.empty(); // Replace this with your actual implementation
//    }
}
