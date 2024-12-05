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

    public Optional<User> getUserById(int userId) {
        return userRepository.findUserById(userId);
    }

    public Optional<Integer> getUserIdByUsername(String username) {
        return userRepository.findUserIdByUsername(username);
    }
}
