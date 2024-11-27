package com.team2.sportsleague.controller;

import com.team2.sportsleague.entity.LeagueEntity;
import com.team2.sportsleague.model.Match;
import com.team2.sportsleague.model.Round;
import com.team2.sportsleague.model.User;
import com.team2.sportsleague.service.LeagueService;
import com.team2.sportsleague.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    // Display leagues (upcoming and recent)
    @GetMapping("/")
    public String getLeagues(Model model) {
        List<LeagueEntity> upcomingLeagues = leagueService.getUpcomingLeagues();
        List<LeagueEntity> recentLeagues = leagueService.getRecentLeagues();
        List<LeagueEntity> allLeagues = leagueService.getAllLeagues();
        // Assuming you have a method to get all sports or a predefined list
        List<String> sports = Arrays.asList("Table Tennis", "Darts", "Pool");

        model.addAttribute("upcomingLeagues", upcomingLeagues);
        model.addAttribute("recentLeagues", recentLeagues);
        model.addAttribute("sports", sports);  // Add sports to the model


        return "index";

    }


    // Show rankings page
    @GetMapping("/rankings")
    public String showRankingList(Model model) {
        model.addAttribute("rankings", rankingService.getAllRankings());
        return "rankings";
    }

    // Show gallery page
    @GetMapping("/gallery")
    public ModelAndView showGallery() {
        return new ModelAndView("gallery"); // Thymeleaf template for gallery
    }

    // Show rules page
    @GetMapping("/rules")
    public ModelAndView showRules() {
        return new ModelAndView("rules"); // Thymeleaf template for rules
    }


    @GetMapping("/match")
    public ModelAndView showMatch() {
        ModelAndView mvc = new ModelAndView("match");

        // List to hold all rounds
        List<Round> rounds = new ArrayList<>();

        // Round 1
        List<Match> round1Matches = new ArrayList<>();
        round1Matches.add(new Match(101, 102, "John", "Sarah", 3, 5));
        round1Matches.add(new Match(103, 104, "Alice", "Bob", 7, 2));
        round1Matches.add(new Match(105, 106, "Eve", "Charlie", 7, 6));
        round1Matches.add(new Match(107, 108, "Grace", "David", 4, 8));
        rounds.add(new Round(1, round1Matches));

        // Round 2
        List<Match> round2Matches = new ArrayList<>();
        round2Matches.add(new Match(101, 104, "John", "Bob", 9, 3));
        round2Matches.add(new Match(105, 108, "Eve", "David", 4, 7));
        rounds.add(new Round(2, round2Matches));

        // Round 3
        List<Match> round3Matches = new ArrayList<>();
        round3Matches.add(new Match(101, 108, "John", "David", 10, 7));
        rounds.add(new Round(3, round3Matches));

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

        return "UserProfile"; // Thymeleaf template for user profile
    }
}
