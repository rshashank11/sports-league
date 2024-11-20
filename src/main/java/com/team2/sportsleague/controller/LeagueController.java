package com.team2.sportsleague.controller;

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

    @GetMapping("/rankings")
    public ModelAndView showRankingList(){
        ModelAndView mvc = new ModelAndView("rankings");
        return mvc;
    }

    @GetMapping("/gallery")
    public ModelAndView showGallery(){
        ModelAndView mvc = new ModelAndView("gallery");
        return mvc;
    }

    @GetMapping("/rules")
    public ModelAndView showRules(){
        ModelAndView mvc = new ModelAndView("rules");
        return mvc;
    }

    @GetMapping("/match")
    public ModelAndView showMatch(){
        ModelAndView mvc = new ModelAndView("match");

        return mvc;
    }
}
