package com.team2.sportsleague.controller;

import com.team2.sportsleague.entity.LeagueEntity;
import com.team2.sportsleague.model.Round;
import com.team2.sportsleague.repository.MatchRepository;
import com.team2.sportsleague.service.LeagueService;
import com.team2.sportsleague.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import com.team2.sportsleague.service.UserService;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class LeagueController {

    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

    private final RankingService rankingService;
    private final LeagueService leagueService;
    private final MatchRepository matchRepository;

    @Autowired
    public LeagueController(RankingService rankingService, LeagueService leagueService, MatchRepository matchRepository) {
        this.rankingService = rankingService;
        this.leagueService = leagueService;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/")
    public String getLeagues(Model model) {

        List<LeagueEntity> upcomingLeagues = leagueService.getUpcomingLeagues();
        List<LeagueEntity> recentLeagues = leagueService.getRecentLeagues();
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
        return new ModelAndView("gallery");
    }

    @GetMapping("/rules")
    public ModelAndView showRules() {
        return new ModelAndView("rules");
    }

    @GetMapping("/match")
    public ModelAndView showMatch() {
        ModelAndView mvc = new ModelAndView("match");
        List<Round> rounds = matchRepository.getAllRounds();
        mvc.addObject("rounds", rounds);
        return mvc;
    }

//    @GetMapping("/profile")
//    public String showUserProfile(@RequestParam String username, Model model) {
//        // Assuming User is a valid entity or model class
//        var user = leagueService.getUserByUsername(username); // Replace with the appropriate service method
//        model.addAttribute("user", user);
//        return "UserProfile";
//    }
//
//    @PostMapping("/profile/update")
//    public String updateUserProfile(
//            @RequestParam String username,
//            @RequestParam String name,
//            @RequestParam(required = false) String email,
//            @RequestParam(required = false) String department,
//            @RequestParam(required = false) String role,
//            @RequestParam(value = "profileImage", required = false) MultipartFile profileImage,
//            Model model
//    ) {
//        try {
//            var user = leagueService.getUserByUsername(username); // Replace with appropriate service method
//
//            user.setName(name);
//            user.setEmail(email);
//            user.setDepartment(department);
//            user.setRole(role);
//
//            if (profileImage != null && !profileImage.isEmpty()) {
//                String imagePath = UPLOAD_DIR + profileImage.getOriginalFilename();
//                profileImage.transferTo(new File(imagePath));
//                user.setProfileImage(profileImage.getOriginalFilename());
//            }
//
//            leagueService.updateUser(user); // Replace with appropriate service method
//            model.addAttribute("user", user);
//            model.addAttribute("message", "Profile updated successfully");
//        } catch (IOException e) {
//            model.addAttribute("error", "Error uploading file");
//            return "UserProfile";
//        } catch (Exception e) {
//            model.addAttribute("error", "An error occurred while updating the profile");
//            return "UserProfile";
//        }
//
//        return "UserProfile";
//    }
}
