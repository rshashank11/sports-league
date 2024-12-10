package com.team2.sportsleague.controller;

import com.team2.sportsleague.model.Round;
import com.team2.sportsleague.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
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
    public ResponseEntity<String> updateScores(@RequestParam int player1Score,
                                               @RequestParam int player2Score,
                                               @RequestParam int matchId,
                                               @RequestParam int leagueId) {

        matchService.updateMatchScores(player1Score, player2Score, matchId, leagueId);
        return ResponseEntity.ok("success");
    }

    @GetMapping("/match")
    public ModelAndView showUserMatch(@RequestParam int leagueId) {
        ModelAndView mvc = new ModelAndView("match");

        // Retrieve rounds for the specified league
        List<Round> rounds = matchService.getAllRounds(leagueId);

        mvc.addObject("rounds", rounds);
        mvc.addObject("isAdmin", false);
        mvc.addObject("leagueId", leagueId);
        return mvc;
    }
}
