package com.team2.sportsleague.controller;

import com.team2.sportsleague.dtos.SignupDTO;
import com.team2.sportsleague.model.Signup;
import com.team2.sportsleague.service.SignupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    private final SignupService signupService;

    @Autowired
    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }


    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("signup", new Signup());
        return "signup";
    }

    @PostMapping("/signup")
    public String handleSignup(@Valid @ModelAttribute("signup") Signup signup, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        signupService.validateSignup(signup, bindingResult);

        if (bindingResult.hasErrors()) {
            return "signup";
        }

        boolean success = signupService.registerUser(signup);
        if (success) {
            model.addAttribute("successMessage", "Congratulations! Your Account is Created.");
            return "login";
        } else {
            model.addAttribute("error", "Registration failed. Please try again.");
            return "signup";
        }
    }}
