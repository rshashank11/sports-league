package com.team2.sportsleague.service;

import com.team2.sportsleague.model.User;
import com.team2.sportsleague.repository.UserRepository;
import com.team2.sportsleague.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    // Fetch user details by user ID
    public Optional<User> getUserById(int userId) {
        return userRepositoryImpl.findUserById(userId);
    }

    // Fetch user ID by username
    public Optional<Integer> getUserIdByUsername(String username) {
        return userRepositoryImpl.findUserIdByUsername(username);
    }

    // Fetch user details by username
    public Optional<User> getUserByUsername(String username) {
        return userRepositoryImpl.findByUsername(username);
    }

    // Save or update a user
    public void saveUser(User user) {
        userRepositoryImpl.save(user);
    }

    public void updateUser(User user){userRepositoryImpl.updateUser(user);};
}
