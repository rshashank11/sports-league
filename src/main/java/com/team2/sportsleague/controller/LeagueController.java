package com.team2.sportsleague.controller;

import com.team2.sportsleague.model.Match;
import com.team2.sportsleague.model.Round;
import com.team2.sportsleague.model.User;
import com.team2.sportsleague.repository.MatchRepository;
import com.team2.sportsleague.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private MatchRepository matchRepository;

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

        List<Round> rounds = matchRepository.getAllRounds();

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
