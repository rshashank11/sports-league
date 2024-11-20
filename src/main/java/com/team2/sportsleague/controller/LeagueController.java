package com.team2.sportsleague.controller;


import com.team2.sportsleague.service.LeagueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.*;


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

        // List to hold round data
        List<List<Map<String, String>>> rounds = new ArrayList<>();

        // Round 1
        List<Map<String, String>> round1 = new ArrayList<>();
        Map<String, String> match1 = new HashMap<>();
        match1.put("team1", "Team Red");
        match1.put("team2", "Team Blue");
        round1.add(match1);

        Map<String, String> match2 = new HashMap<>();
        match2.put("team1", "Team Yellow");
        match2.put("team2", "Team Black");
        round1.add(match2);

        Map<String, String> match3 = new HashMap<>();
        match3.put("team1", "Team White");
        match3.put("team2", "Team Pink");
        round1.add(match3);

        Map<String, String> match4 = new HashMap<>();
        match4.put("team1", "Team Green");
        match4.put("team2", "Team Indigo");
        round1.add(match4);

        rounds.add(round1);

        // Round 2
        List<Map<String, String>> round2 = new ArrayList<>();
        Map<String, String> match5 = new HashMap<>();
        match5.put("team1", "Team Red");
        match5.put("team2", "Team Black");
        round2.add(match5);

        Map<String, String> match6 = new HashMap<>();
        match6.put("team1", "Team White");
        match6.put("team2", "Team Indigo");
        round2.add(match6);

        rounds.add(round2);

        // Round 3
        List<Map<String, String>> round3 = new ArrayList<>();
        Map<String, String> match7 = new HashMap<>();
        match7.put("team1", "Team Red");
        match7.put("team2", "Team Indigo");
        round3.add(match7);

        rounds.add(round3);

        // Pass data to the view
        mvc.addObject("rounds", rounds);
        return mvc;
    }
}
