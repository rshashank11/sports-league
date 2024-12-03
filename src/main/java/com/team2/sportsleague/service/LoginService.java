package com.team2.sportsleague.service;

import com.team2.sportsleague.dtos.LoginDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Set;

@Service
public class LoginService {

    public boolean authenticateUser(LoginDTO loginDTO) {
        return true;
    }
}
