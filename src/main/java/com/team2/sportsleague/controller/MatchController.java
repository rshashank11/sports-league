package com.team2.sportsleague.controller;

import com.team2.sportsleague.model.Round;
import com.team2.sportsleague.repository.MatchRepository;
import com.team2.sportsleague.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class MatchController {

    private MatchRepository matchRepository;

    @Autowired
    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")  // Ensure only ADMIN can access
    @GetMapping("/admin/match")
    public ModelAndView showMatch() {
        ModelAndView mvc = new ModelAndView("match");

        List<Round> rounds = matchRepository.getAllRounds();

        // Pass data to the view
        mvc.addObject("rounds", rounds);
        return mvc;
    }
}
