package com.team2.sportsleague.service;

import com.team2.sportsleague.model.Signup;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class SignupService {

    public void validateSignup(Signup signup, BindingResult bindingResult) {
        if (!signup.getPassword().equals(signup.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "error.signup", "Passwords do not match.");
        }
    }

    public boolean registerUser(Signup signup) {
        return true;
    }
}
