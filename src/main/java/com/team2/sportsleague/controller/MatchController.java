package com.team2.sportsleague.controller;

import com.team2.sportsleague.model.Round;
import com.team2.sportsleague.repository.MatchRepository;
import com.team2.sportsleague.service.LeagueService;
import com.team2.sportsleague.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
public class MatchController {

    @Autowired
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")  // Ensure only ADMIN can access
    @GetMapping("/admin/update_match")
    public ModelAndView showAdminMatch() {
        ModelAndView mvc = new ModelAndView("match");

        List<Round> rounds = matchService.getAllRounds();

        mvc.addObject("rounds", rounds);
        mvc.addObject("isAdmin", true);
        return mvc;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/admin/update-scores")
    public RedirectView updateScores(@RequestParam int player1Score,
                                     @RequestParam int player2Score,
                                     @RequestParam int matchId) {
        // Call service to update scores
        System.out.println("Over here now!");  // Log the response
        matchService.updateMatchScores(player1Score, player2Score, matchId);
        System.out.println("Response: success");  // Log the response

        // Redirect to the match page to refresh the view
        return new RedirectView("/admin/update_match");  // Adjust this to your actual URL
    }

    @GetMapping("/match")
    public ModelAndView showUserMatch() {
        ModelAndView mvc = new ModelAndView("match");

        List<Round> rounds = matchService.getAllRounds();

        // Pass data to the view
        mvc.addObject("rounds", rounds);
        mvc.addObject("isAdmin", false);
        return mvc;
    }
}
