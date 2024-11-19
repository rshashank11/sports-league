package com.team2.sportsleague.league;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LeagueController {

    @GetMapping("/")
    public ModelAndView showLeagueList(){
        ModelAndView mvc = new ModelAndView("index");

        return mvc;
    }
}
