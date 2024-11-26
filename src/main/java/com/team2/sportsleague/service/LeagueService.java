package com.team2.sportsleague.service;
import com.team2.sportsleague.entity.LeagueEntity;
import com.team2.sportsleague.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueService {
    @Autowired
    private final LeagueRepository leagueRepository;

    // Constructor-based injection
    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public List<LeagueEntity> getAllLeagues() {
        return leagueRepository.findAll(); // Assuming `findAll` is implemented in the repository
    }

    public List<LeagueEntity> getUpcomingLeagues() {
        return leagueRepository.getUpcomingLeagues()
                .stream()
                .filter(league -> league.getSchedule() != null && league.getSchedule().isAfter(java.time.LocalDateTime.now()))
                .toList();
    }

    public List<LeagueEntity> getRecentLeagues() {
        return leagueRepository.getRecentLeagues()
                .stream()
                .filter(league -> league.getSchedule() != null && league.getSchedule().isBefore(java.time.LocalDateTime.now()))
                .toList();
    }

    public List<LeagueEntity> getLeaguesBySport(String sport) {
        return leagueRepository.getLeaguesBySport(sport);
    }

}


