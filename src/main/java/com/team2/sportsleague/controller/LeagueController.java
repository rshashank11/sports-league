package com.team2.sportsleague.controller;

import com.team2.sportsleague.entity.LeagueEntity;
import com.team2.sportsleague.model.User;
import com.team2.sportsleague.service.LeagueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class LeagueController {
    private final LeagueService leagueService;

    // Constructor-based injection
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    // Display leagues (upcoming and recent)
    @GetMapping("/")
    public String getLeagues(Model model) {
        // Fetch data from the LeagueService layer
        List<LeagueEntity> upcomingLeagues = leagueService.getUpcomingLeagues();
        List<LeagueEntity> recentLeagues = leagueService.getRecentLeagues();

        // Add data to the model for rendering in the template
        model.addAttribute("upcomingLeagues", upcomingLeagues);
        model.addAttribute("recentLeagues", recentLeagues);

        // Return the view template name
        return "index"; // Corresponds to src/main/resources/templates/index.html
    }

    // Display the rankings page
    @GetMapping("/rankings")
    public ModelAndView showRankingList() {
        return new ModelAndView("rankings"); // Corresponds to src/main/resources/templates/rankings.html
    }

    // Display the gallery page
    @GetMapping("/gallery")
    public ModelAndView showGallery() {
        return new ModelAndView("gallery"); // Corresponds to src/main/resources/templates/gallery.html
    }

    // Display the rules page
    @GetMapping("/rules")
    public ModelAndView showRules() {
        return new ModelAndView("rules"); // Corresponds to src/main/resources/templates/rules.html
    }

    // Display the user profile page
    @GetMapping("/profile")
    public String showUserProfile(Model model) {
        // Create and populate the User object
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

        // Return the view template name for the user profile
        return "UserProfile"; // Corresponds to src/main/resources/templates/UserProfile.html
    }
}
