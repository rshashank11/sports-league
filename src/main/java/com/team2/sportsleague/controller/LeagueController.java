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

import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class LeagueController {

    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

    private final RankingService rankingService;
    private final LeagueService leagueService;

    @Autowired
    public LeagueController(RankingService rankingService, LeagueService leagueService) {
        this.rankingService = rankingService;
        this.leagueService = leagueService;

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

}