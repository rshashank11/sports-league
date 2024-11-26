package com.team2.sportsleague.controller;

import com.team2.sportsleague.entity.LeagueEntity;
import com.team2.sportsleague.model.User;
import com.team2.sportsleague.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class LeagueController {

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

        return "index"; // Thymeleaf template name
    }


    // Show rankings page
    @GetMapping("/rankings")
    public ModelAndView showRankingList() {
        return new ModelAndView("rankings"); // Thymeleaf template for rankings
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

    // Show user profile page
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
