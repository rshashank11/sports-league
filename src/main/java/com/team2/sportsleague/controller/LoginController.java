package com.team2.sportsleague.controller;

import com.team2.sportsleague.dtos.LoginDTO;
import com.team2.sportsleague.model.User;
import com.team2.sportsleague.service.LoginService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String getLogin(Model model, Authentication authentication) {
        model.addAttribute("loginDTO", new LoginDTO());
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/";
        }
        return "login"; // Return the login view
    }
    @GetMapping("/signup")
    public String getSignup() {
        return "signup";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("loginDTO") @Valid LoginDTO loginDTO,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        return "redirect:/";

    }
}

