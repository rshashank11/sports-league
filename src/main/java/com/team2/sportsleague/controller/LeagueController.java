package com.team2.sportsleague.controller;

import com.team2.sportsleague.entity.LeagueEntity;
import com.team2.sportsleague.model.Round;
import com.team2.sportsleague.repository.UserDAO;
import com.team2.sportsleague.model.User;
import com.team2.sportsleague.repository.MatchRepository;
import com.team2.sportsleague.service.LeagueService;
import com.team2.sportsleague.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.IOException;

@Controller
public class LeagueController {


    @Autowired
    private RankingService rankingService;

    @Autowired
    private UserDAO userDAO;

    private static final String UPLOAD_DIR = "src/main/resources/static/images/";
    private MatchRepository matchRepository;
    private final LeagueService leagueService;
    @Autowired
    public LeagueController(LeagueService leagueService, MatchRepository matchRepository) {
        this.leagueService = leagueService;
        this.matchRepository = matchRepository;
    }


    @GetMapping("/")
    public String getLeagues(Model model) {
        List<LeagueEntity> upcomingLeagues = leagueService.getUpcomingLeagues();
        List<LeagueEntity> recentLeagues = leagueService.getRecentLeagues();
        List<LeagueEntity> allLeagues = leagueService.getAllLeagues();

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
    public String showUserProfile(@RequestParam String username, Model model) {
        User user = userDAO.getUserByUsername(username);
        model.addAttribute("user", user);
        return "UserProfile";
    }

    @PostMapping("/profile/update")
    public String updateUserProfile(@RequestParam String username,
                                    @RequestParam String name,
                                    @RequestParam String email,
                                    @RequestParam String department,
                                    @RequestParam String role,
                                    @RequestParam(value = "profileImage", required = false) MultipartFile profileImage,
                                    Model model) {

        User user = userDAO.getUserByUsername(username);
        user.setName(name);
        user.setEmail(email);
        user.setDepartment(department);
        user.setRole(role);

        if (profileImage != null && !profileImage.isEmpty()) {
            try {
                String imagePath = UPLOAD_DIR + profileImage.getOriginalFilename();
                profileImage.transferTo(new File(imagePath));
                user.setProfileImage(profileImage.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("error", "Error uploading file");
                return "UserProfile";
            }
        }

        userDAO.updateUser(user);
        model.addAttribute("user", user);
        model.addAttribute("message", "Profile updated successfully");
        return "UserProfile";
    }
}
