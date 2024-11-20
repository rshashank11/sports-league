/*package com.team2.sportsleague.validation;

import com.team2.sportsleague.service.LeagueService;
import org.springframework.stereotype.Component;

@Component
public class LeagueValidator {

    public boolean isValidLeague(LeagueService league) {
        // Example validation logic
        return league.getName() != null && !league.getName().isEmpty() &&
                league.getSchedule() != null &&
                league.getLastRegistrationDate() != null &&
                (league.getLocation() == null || !league.getLocation().isEmpty());
    }
}*/
