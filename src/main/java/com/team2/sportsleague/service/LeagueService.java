package com.team2.sportsleague.service;
import com.team2.sportsleague.dtos.LeagueDTO;
import com.team2.sportsleague.model.League;
import com.team2.sportsleague.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeagueService {
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

    public void createLeague(String name, String schedule, String lastRegistrationDate, String venue, String sport) throws SQLException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("League name cannot be null or empty.");
        }
        if (sport == null || sport.trim().isEmpty()) {
            throw new IllegalArgumentException("League sport cannot be null or empty.");
        }
        if (venue == null || venue.trim().isEmpty()) {
            throw new IllegalArgumentException("Venue cannot be null or empty.");
        }

        try {
            LocalDateTime parsedSchedule = LocalDateTime.parse(schedule);
            LocalDateTime parsedLastRegistrationDate = LocalDateTime.parse(lastRegistrationDate);

            // Create LeagueEntity object
            League league = new League();
            league.setName(name);
            league.setSchedule(parsedSchedule);
            league.setLastRegistrationDate(parsedLastRegistrationDate);
            league.setVenue(venue);
            league.setSports(sport);

            leagueRepository.createLeague(league);

        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Use 'yyyy-MM-dd'T'HH:mm:ss'.", e);
        }
    }



}


