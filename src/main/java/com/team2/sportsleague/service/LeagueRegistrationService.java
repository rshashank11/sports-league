package com.team2.sportsleague.service;

import com.team2.sportsleague.repository.LeagueRegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class LeagueRegistrationService {

    private LeagueRegistrationRepository leagueRegistrationRepository;

    private static final int MIN_REGISTRATIONS = 8;
    private static final int MAX_REGISTRATIONS = 16;

    public LeagueRegistrationService(LeagueRegistrationRepository leagueRegistrationRepository) {
        this.leagueRegistrationRepository = leagueRegistrationRepository;
    }

    public void registerUserToLeague(Long userId, Long leagueId) {
        if (leagueRegistrationRepository.isUserAlreadyRegistered(userId, leagueId)) {
            throw new IllegalArgumentException("User has already registered for this league.");
        }

        int currentCount = leagueRegistrationRepository.getRegistrationCountForLeague(leagueId);
        if (currentCount >= MAX_REGISTRATIONS) {
            throw new IllegalArgumentException("League has reached the maximum number of registrations.");
        }

        leagueRegistrationRepository.registerUserToLeague(userId, leagueId);
    }

    public void unregisterUserFromLeague(Long userId, Long leagueId) {
        int currentCount = leagueRegistrationRepository.getRegistrationCountForLeague(leagueId);
        if (currentCount <= MIN_REGISTRATIONS) {
            throw new IllegalArgumentException("Cannot unregister. Minimum registration limit is 8.");
        }

        leagueRegistrationRepository.unregisterUserFromLeague(userId, leagueId);
    }
}

