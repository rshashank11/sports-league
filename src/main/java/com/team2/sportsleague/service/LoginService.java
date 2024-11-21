package com.team2.sportsleague.service;

import com.team2.sportsleague.model.Login;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Set;

@Service
public class LoginService {

    private final Validator validator;

    @Autowired
    public LoginService(Validator validator) {
        this.validator = validator;
    }

    public void validateLogin(Login login, BindingResult bindingResult) {
        Set<ConstraintViolation<Login>> violations = validator.validate(login);

        for (ConstraintViolation<Login> violation : violations) {
            bindingResult.rejectValue(violation.getPropertyPath().toString(), null, violation.getMessage());
        }
    }

    public boolean authenticateUser(Login login) {
        return true;
    }

    }
