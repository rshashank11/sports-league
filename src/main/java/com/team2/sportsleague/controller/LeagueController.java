package com.team2.sportsleague.controller;

import com.team2.sportsleague.model.Match;
import com.team2.sportsleague.model.Round;
import com.team2.sportsleague.model.User;
import com.team2.sportsleague.service.LeagueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
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
    public ModelAndView showRankingList() {
        ModelAndView mvc = new ModelAndView("rankings");
        return mvc;
    }

    @GetMapping("/gallery")
    public ModelAndView showGallery() {
        ModelAndView mvc = new ModelAndView("gallery");
        return mvc;
    }

    @GetMapping("/rules")
    public ModelAndView showRules() {
        ModelAndView mvc = new ModelAndView("rules");
        return mvc;
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
        // Create and populate the user object
        User user = new User(
                "John Doe",
                "john.doe@example.com",
                "23456",
                "IT",
                "Software Engineer",
                Arrays.asList("Dart", "Table Tennis") // Example games user is interested in
        );

        // Add the user to the model
        model.addAttribute("user", user);

        return "UserProfile"; // Return the view name for the profile
    }
}
