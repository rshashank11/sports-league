package com.team2.sportsleague.service;
import com.team2.sportsleague.dtos.LeagueDTO;
import com.team2.sportsleague.model.League;
import com.team2.sportsleague.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeagueService {
    @Autowired
    private final LeagueRepository leagueRepository;
    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public List<League> getAllLeagues() {
        return leagueRepository.findAll(); // Assuming `findAll` is implemented in the repository
    }

    public List<League> getUpcomingLeagues() {
        List<League> leagues = leagueRepository.getUpcomingLeagues();

        // Remove duplicates by id
        return leagues.stream()
                .collect(Collectors.toMap(League::getId, league -> league, (existing, replacement) -> existing))
                .values()
                .stream()
                .collect(Collectors.toList());
    }


    public List<League> getRecentLeagues() {
        return leagueRepository.getRecentLeagues()
                .stream()
                .filter(league -> league.getSchedule() != null && league.getSchedule().isBefore(java.time.LocalDateTime.now()))
                .toList();
    }

    public List<League> getLeaguesBySport(String sport) {
        return leagueRepository.getLeaguesBySport(sport);
    }

    public void createLeague(LeagueDTO leagueDTO) throws SQLException {
        if (leagueDTO.getName() == null || leagueDTO.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("League name cannot be null or empty.");
        }
        if (leagueDTO.getSport() == null || leagueDTO.getSport().trim().isEmpty()) {
            throw new IllegalArgumentException("League sport cannot be null or empty.");
        }
        if (leagueDTO.getVenue() == null || leagueDTO.getVenue().trim().isEmpty()) {
            throw new IllegalArgumentException("Venue cannot be null or empty.");
        }

        try {
            LocalDateTime parsedSchedule = LocalDateTime.parse(leagueDTO.getSchedule());
            LocalDateTime parsedLastRegistrationDate = LocalDateTime.parse(leagueDTO.getLastRegistrationDate());

            League league = new League();
            league.setName(leagueDTO.getName());
            league.setSchedule(parsedSchedule);
            league.setLastRegistrationDate(parsedLastRegistrationDate);
            league.setVenue(leagueDTO.getVenue());
            league.setSports(leagueDTO.getSport());

            leagueRepository.createLeague(league);

        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Use 'yyyy-MM-dd'T'HH:mm:ss'.", e);
        }
    }


}


