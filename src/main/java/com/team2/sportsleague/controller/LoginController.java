package com.team2.sportsleague.controller;

import com.team2.sportsleague.model.Login;
import com.team2.sportsleague.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ModelAndView getLogin() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @PostMapping("/login")
    public String postLogin(@Valid Login login,
                            BindingResult bindingResult,
                            Model model) {
        loginService.validateLogin(login, bindingResult);
        if(bindingResult.hasErrors()) {
            return "login";
        }

        boolean authenticated = loginService.authenticateUser(login);

        if (authenticated) {
            return "redirect:/";
        } else {
            model.addAttribute("error", "Enter a valid username or password.");
            return "login";
        }


    }
}
