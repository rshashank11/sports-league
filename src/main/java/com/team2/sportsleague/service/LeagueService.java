package com.team2.sportsleague.service;
import com.team2.sportsleague.entity.LeagueEntity;
import com.team2.sportsleague.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeagueService {
    @Autowired
    private final LeagueRepository leagueRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean isUserAlreadyRegistered(Long userId, Long leagueId) {
        String sql = "SELECT COUNT(*) FROM league_registrations WHERE user_id = ? AND league_id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, userId, leagueId);
        return count > 0;  // If count is greater than 0, the user is already registered
    }

    public void registerUserToLeague(Long userId, Long leagueId) {
        if (isUserAlreadyRegistered(userId, leagueId)) {
            throw new IllegalArgumentException("User has already registered for this league.");
        }

        String sql = "INSERT INTO league_registrations (league_id, user_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, leagueId, userId);
    }

    public List<Long> getUserJoinedLeagues(Long userId) {
        // SQL query to fetch league IDs where the user is registered
        String sql = "SELECT league_id FROM league_registrations WHERE user_id = ?";

        // Execute the query and return the list of league IDs
        return jdbcTemplate.queryForList(sql, Long.class, userId);
    }

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


