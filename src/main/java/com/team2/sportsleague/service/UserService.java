package com.team2.sportsleague.service;

import com.team2.sportsleague.model.User;
import com.team2.sportsleague.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Fetch user details by user ID
    public Optional<User> getUserById(int userId) {
        return userRepository.findUserById(userId);
    }

    // Fetch user ID by username
    public Optional<Integer> getUserIdByUsername(String username) {
        return userRepository.findUserIdByUsername(username);
    }

    // Fetch user details by username
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    // Save or update a user
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
