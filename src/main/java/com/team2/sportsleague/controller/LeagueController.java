package com.team2.sportsleague.controller;

import com.team2.sportsleague.dtos.LeagueDTO;
import com.team2.sportsleague.model.League;
import com.team2.sportsleague.repository.LeagueRegistrationRepository;
import com.team2.sportsleague.repository.MatchRepository;
import com.team2.sportsleague.service.LeagueRegistrationService;
import com.team2.sportsleague.service.LeagueService;
import com.team2.sportsleague.service.LoginService;
import com.team2.sportsleague.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

@Controller
public class LeagueController {
    private RankingService rankingService;
    private final LeagueRegistrationRepository leagueRegistrationRepository;
    private final LeagueRegistrationService leagueRegistrationService;
    private final LeagueService leagueService;
    private final LoginService loginService;
    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

    @Autowired
    public LeagueController(RankingService rankingService, LeagueService leagueService, MatchRepository matchRepository, LoginService loginService, LeagueRegistrationRepository leagueRegistrationRepository, LeagueRegistrationService leagueRegistrationService) {
        this.rankingService = rankingService;
        this.leagueService = leagueService;
        this.loginService = loginService;
        this.leagueRegistrationRepository = leagueRegistrationRepository;
        this.leagueRegistrationService = leagueRegistrationService;
    }


    @GetMapping("/")
    public String getLeagues(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        String username = userDetails.getUsername();
        Long userId = loginService.getUserIdByUsername(username);
        model.addAttribute("userId", userId);

        List<League> upcomingLeagues = leagueService.getUpcomingLeagues();
        List<League> recentLeagues = leagueService.getRecentLeagues();
        List<Long> joinedLeagues = leagueRegistrationRepository.getUserJoinedLeagues(userId);
        List<String> sports = Arrays.asList("Table Tennis", "Darts", "Pool");

        model.addAttribute("upcomingLeagues", upcomingLeagues);
        model.addAttribute("recentLeagues", recentLeagues);
        model.addAttribute("joinedLeagues", joinedLeagues);
        model.addAttribute("sports", sports);

        return "index";
    }

    @GetMapping("/rankings")
    public String showRankingList(Model model) {
        model.addAttribute("rankings", rankingService.getAllRankings());
        return "rankings";
    }


    // Show rules page
    @GetMapping("/rules")
    public ModelAndView showRules() {
        return new ModelAndView("rules");
    }



    @GetMapping("/register")
    public ResponseEntity<String> registerUserToLeague(
            @RequestParam("userId") Long userId,
            @RequestParam("leagueId") Long leagueId) {
        try {
            leagueRegistrationService.registerUserToLeague(userId, leagueId);
            return ResponseEntity.ok("User successfully registered to league.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Unable to register user to league.");
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<String> createLeague(
            @RequestParam("name") String name,
            @RequestParam("startDate") String schedule,
            @RequestParam("lastRegistrationDate") String lastRegistrationDate,
            @RequestParam("venue") String venue,
            @RequestParam("sport") String sport) {
        try {
            leagueService.createLeague(name, schedule, lastRegistrationDate, venue, sport);
            return ResponseEntity.ok("League '" + name + "' created successfully for " + sport + "!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (DateTimeParseException e) {
            return ResponseEntity.status(400).body("Invalid date format. Use 'yyyy-MM-dd'T'HH:mm:ss'.");
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Database error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error occurred while creating the league.");
        }
    }




    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleRegistrationException(IllegalArgumentException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }

}

