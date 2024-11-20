package com.team2.sportsleague.Controller;

import com.team2.sportsleague.Model.UserGamePreference;
import com.team2.sportsleague.Service.UserGamePreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-details")
public class UserDetail {

    @Autowired
    private UserGamePreferenceService gamePreferenceService;

    // Fetch user game preferences by user ID
    @GetMapping("/{userId}/games")
    public ResponseEntity<UserGamePreference> getUserGamePreferences(@PathVariable Long userId) {
        UserGamePreference preference = gamePreferenceService.getPreferencesByUserId(userId);
        if (preference != null) {
            return ResponseEntity.ok(preference);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Save or update user game preferences
    @PostMapping("/{userId}/games")
    public ResponseEntity<UserGamePreference> saveUserGamePreferences(
            @PathVariable Long userId,
            @RequestBody GamePreferenceRequest request) {
        if (request.getGames() == null || request.getGames().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        String games = String.join(",", request.getGames());
        UserGamePreference updatedPreference = gamePreferenceService.savePreferences(userId, games);
        return ResponseEntity.ok(updatedPreference);
    }
}

// DTO for game preference request
class GamePreferenceRequest {
    private List<String> games;

    public List<String> getGames() {
        return games;
    }

    public void setGames(List<String> games) {
        this.games = games;
    }
}
