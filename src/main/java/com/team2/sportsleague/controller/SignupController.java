package com.team2.sportsleague.controller;

import com.team2.sportsleague.model.Signup;
import com.team2.sportsleague.service.SignupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    private final SignupService signupService;

    @Autowired
    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @GetMapping("/signup")
    public String getSignup(Model model) {
        model.addAttribute("signup", new Signup());
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignup(@Valid Signup signup,
                             BindingResult bindingResult,
                             Model model) {
        signupService.validateSignup(signup, bindingResult);
        if (!bindingResult.hasErrors()) {
            model.addAttribute("error", "Registration failed. Please try again.");
        }
        return "signup";
    }
}
