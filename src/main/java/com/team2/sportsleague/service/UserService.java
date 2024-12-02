package com.team2.sportsleague.service;

import com.team2.sportsleague.repository.UserDAO;
import com.team2.sportsleague.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }
}
