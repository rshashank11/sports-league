package com.team2.sportsleague.Controller;

import com.team2.sportsleague.Model.Login;
import com.team2.sportsleague.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import jakarta.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public ModelAndView getLogin() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @PostMapping("/login")
    public String postLogin(Login login,
                            BindingResult bindingResult,
                            Model model) {
//        loginService.validateLogin(login, bindingResult);
        if(bindingResult.hasErrors()) {
            return "login";
        }

        try {
            return "index";
        } catch(Exception e) {
            return "login";
        }


    }
}
