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

    public Optional<User> getUserById(int userId) {
        return userRepositoryImpl.findUserById(userId);
    }

    public Optional<Integer> getUserIdByUsername(String username) {
        return userRepositoryImpl.findUserIdByUsername(username);
    }
}
