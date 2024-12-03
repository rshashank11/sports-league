package com.team2.sportsleague.controller;

import com.team2.sportsleague.entity.LeagueEntity;
import com.team2.sportsleague.model.Match;
import com.team2.sportsleague.model.Round;
import com.team2.sportsleague.model.User;
import com.team2.sportsleague.repository.MatchRepository;
import com.team2.sportsleague.service.LeagueService;
import com.team2.sportsleague.service.LoginService;
import com.team2.sportsleague.service.RankingService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

@Controller
public class LeagueController {


    @Autowired
    private RankingService rankingService;
    private MatchRepository matchRepository;
    private final LeagueService leagueService;

    @Autowired
    private final LoginService loginService;
    @Autowired
    public LeagueController(LeagueService leagueService, MatchRepository matchRepository, LoginService loginService) {
        this.leagueService = leagueService;
        this.matchRepository = matchRepository;
        this.loginService = loginService;
    }


    @GetMapping("/")
    public String getLeagues(@AuthenticationPrincipal UserDetails userDetails, Model model) {

        String username = userDetails.getUsername();
        Long userId = loginService.getUserIdByUsername(username);
        model.addAttribute("userId", userId);
        List<LeagueEntity> upcomingLeagues = leagueService.getUpcomingLeagues();
        List<LeagueEntity> recentLeagues = leagueService.getRecentLeagues();
        List<LeagueEntity> allLeagues = leagueService.getAllLeagues();
        // In your service or controller method


        List<String> sports = Arrays.asList("Table Tennis", "Darts", "Pool");

        model.addAttribute("upcomingLeagues", upcomingLeagues);
        model.addAttribute("recentLeagues", recentLeagues);
        model.addAttribute("sports", sports);


        return "index";

    }



    @GetMapping("/rankings")
    public String showRankingList(Model model) {
        model.addAttribute("rankings", rankingService.getAllRankings());
        return "rankings";
    }


    @GetMapping("/gallery")
    public ModelAndView showGallery() {
        return new ModelAndView("gallery"); // Thymeleaf template for gallery
    }


    @GetMapping("/rules")
    public ModelAndView showRules() {
        return new ModelAndView("rules"); // Thymeleaf template for rules
    }


    // Show match page
    @GetMapping("/match")
    public ModelAndView showMatch() {
        ModelAndView mvc = new ModelAndView("match");

        List<Round> rounds = matchRepository.getAllRounds();

        // Pass data to the view
        mvc.addObject("rounds", rounds);
        return mvc;
    }


    @GetMapping("/profile")
    public String showUserProfile(Model model) {
        User user = new User(
                "John Doe",
                "john.doe@example.com",
                "23456",
                "IT",
                "Software Engineer",
                Arrays.asList("Dart", "Table Tennis")
        );

        model.addAttribute("user", user);

        return "UserProfile";
    }
}
