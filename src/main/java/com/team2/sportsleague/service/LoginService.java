package com.team2.sportsleague.service;

import com.team2.sportsleague.dtos.LoginDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Set;

@Service
public class LoginService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Method to fetch user_id by username
    public Long getUserIdByUsername(String username) {
        String sql = "SELECT user_id FROM users WHERE username = ?";

        Long userId = jdbcTemplate.queryForObject(sql, new Object[]{username}, Long.class);
        return userId;
    }
}
