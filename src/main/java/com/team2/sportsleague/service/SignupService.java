package com.team2.sportsleague.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.team2.sportsleague.model.Signup;
import com.team2.sportsleague.model.User;
import com.team2.sportsleague.repository.UserRepository;

import java.util.Optional;

@Service
public class SignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SignupService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void validateSignup(Signup signup, BindingResult bindingResult) {
        if (!signup.getPassword().equals(signup.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "error.signup", "Passwords do not match.");
        }

  /*      Optional<User> existingUserByEmail = userRepository.findByEmail(signup.getUsername());
        if (existingUserByEmail.isPresent()) {
            bindingResult.rejectValue("email", "error.signup", "This email is already in use.");
        }*/

        Optional<User> existingUserByUsername = userRepository.findByUsername(signup.getUsername());
        if (existingUserByUsername.isPresent()) {
            bindingResult.rejectValue("username", "error.signup", "This username is already taken.");
        }
    }


    public boolean registerUser(Signup signup) {
        try {
            User user = new User();
            user.setUsername(signup.getUsername());
            user.setName(signup.getName());
            user.setPassword(passwordEncoder.encode(signup.getPassword()));
            user.setEnabled(true);
            user.setUserRole("User");
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
