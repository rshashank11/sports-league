package com.team2.sportsleague.controller;


import com.team2.sportsleague.service.LeagueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Controller
public class LeagueController {

    @GetMapping("/")
    public String getLeagues(Model model) {
        List<LeagueService> upcomingLeagues = new ArrayList<>();
        upcomingLeagues.add(new LeagueService("Winter Pool League", LocalDateTime.now().plusDays(10), LocalDateTime.now().plusDays(5), "Sports Club A"));
        upcomingLeagues.add(new LeagueService("Spring Darts League", LocalDateTime.now().plusDays(20), LocalDateTime.now().plusDays(15), null));

        List<LeagueService> recentLeagues = new ArrayList<>();
        recentLeagues.add(new LeagueService("Autumn Table Tennis League", LocalDateTime.now().minusDays(10), LocalDateTime.now().minusDays(15), "Community Center"));

        model.addAttribute("upcomingLeagues", upcomingLeagues);
        model.addAttribute("recentLeagues", recentLeagues);

        return "index";

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
