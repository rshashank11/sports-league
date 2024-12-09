package com.team2.sportsleague.controller;

import com.team2.sportsleague.model.Round;
import com.team2.sportsleague.model.User;
import com.team2.sportsleague.service.LoginService;
import com.team2.sportsleague.service.MatchService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MatchController {

    private final MatchService matchService;
    private final LoginService loginService;

    @Autowired
    public MatchController(MatchService matchService, LoginService loginService) {
        this.matchService = matchService;
        this.loginService = loginService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/update_match")
    public ModelAndView showAdminMatch(@RequestParam int leagueId) {
        ModelAndView mvc = new ModelAndView("match");

        List<Round> rounds = matchService.getAllRounds(leagueId);

        mvc.addObject("rounds", rounds);
        mvc.addObject("isAdmin", true);
        mvc.addObject("leagueId", leagueId); // Include leagueId for frontend context

        return mvc;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/admin/update-scores")
    public ResponseEntity<String> updateAdminScores(@RequestParam int player1Score,
                                               @RequestParam int player2Score,
                                               @RequestParam int matchId,
                                               @RequestParam int leagueId,
                                               @AuthenticationPrincipal UserDetails userDetails) {


        String username = userDetails.getUsername();
        Long userId = loginService.getUserIdByUsername(username);

        matchService.updateMatchScores(player1Score, player2Score, matchId, leagueId,userId);
        return ResponseEntity.ok("success");
    }

    @GetMapping("/match")
    public ModelAndView showUserMatch(@RequestParam int leagueId, @AuthenticationPrincipal UserDetails userDetails) {

        ModelAndView mvc = new ModelAndView("match");

        // Retrieve rounds for the specified league
        List<Round> rounds = matchService.getAllRounds(leagueId);

        String username = userDetails.getUsername();
        Long userId = loginService.getUserIdByUsername(username);


        mvc.addObject("userId", userId);
        mvc.addObject("rounds", rounds);
        mvc.addObject("isAdmin", false);
        mvc.addObject("leagueId", leagueId);
        return mvc;
    }

    @PostMapping("/match/update-scores")
    public ResponseEntity<String> updateUserScores(@RequestParam int player1Score,
                                               @RequestParam int player2Score,
                                               @RequestParam int matchId,
                                               @RequestParam int leagueId,
                                               @AuthenticationPrincipal UserDetails userDetails) {

        String username = userDetails.getUsername();
        Long userId = loginService.getUserIdByUsername(username);

        // Check if the user is part of the match
        if (!matchService.isUserOwnerOfMatch(matchId, userId)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You are not authorized to edit this match.");
        }

        matchService.updateMatchScores(player1Score, player2Score, matchId, leagueId, userId);
        return ResponseEntity.ok("success");
    }
}
