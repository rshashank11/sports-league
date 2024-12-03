package com.team2.sportsleague.service;
import com.team2.sportsleague.entity.LeagueEntity;
import com.team2.sportsleague.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeagueService {
    @Autowired
    private final LeagueRepository leagueRepository;


    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public List<LeagueEntity> getAllLeagues() {
        return leagueRepository.findAll(); // Assuming `findAll` is implemented in the repository
    }

    public List<LeagueEntity> getUpcomingLeagues() {
        List<LeagueEntity> leagues = leagueRepository.getUpcomingLeagues();

        // Remove duplicates by id
        return leagues.stream()
                .collect(Collectors.toMap(LeagueEntity::getId, league -> league, (existing, replacement) -> existing))
                .values()
                .stream()
                .collect(Collectors.toList());
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


