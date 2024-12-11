package com.team2.sportsleague.controller;

import com.team2.sportsleague.model.Match;
import com.team2.sportsleague.model.Round;
import com.team2.sportsleague.service.LoginService;
import com.team2.sportsleague.service.MatchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MatchControllerTest {

    @Mock
    private MatchService matchService;

    @Mock
    private LoginService loginService;

    @InjectMocks
    private MatchController matchController;

    private UserDetails userDetails;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Mock UserDetails object
        userDetails = User.builder()
                .username("testuser")
                .password("password")
                .roles("USER")
                .build();
    }

    @Test
    void testShowAdminMatch() {
        int leagueId = 1;

        // Create mock matches
        Match match1 = new Match(1, 1, 1, 2, "Player1", "Player2", 2, 1, 1, 1);
        Match match2 = new Match(2, 1, 3, 4, "Player3", "Player4", 1, 0, 3, 1);

        // Create a mock round containing the matches
        Round round1 = new Round(Arrays.asList(match1, match2));

        List<Round> mockRounds = Arrays.asList(round1);

        when(matchService.getAllRounds(leagueId)).thenReturn(mockRounds);

        ModelAndView modelAndView = matchController.showAdminMatch(leagueId);

        assertEquals("match", modelAndView.getViewName());
        assertEquals(mockRounds, modelAndView.getModel().get("rounds"));
        assertEquals(leagueId, modelAndView.getModel().get("leagueId"));
        assertTrue((boolean) modelAndView.getModel().get("isAdmin"));

        verify(matchService).getAllRounds(leagueId);
    }

    @Test
    void testUpdateAdminScores() {
        int player1Score = 5;
        int player2Score = 3;
        int matchId = 1;
        int leagueId = 1;
        Long userId = 101L;

        when(loginService.getUserIdByUsername(userDetails.getUsername())).thenReturn(userId);

        ResponseEntity<String> response = matchController.updateAdminScores(player1Score, player2Score, matchId, leagueId, userDetails);

        assertEquals("success", response.getBody());
        assertEquals(200, response.getStatusCodeValue());

        verify(matchService).updateMatchScores(player1Score, player2Score, matchId, leagueId, userId);
    }

    @Test
    void testShowUserMatch() {
        int leagueId = 1;
        Long userId = 101L;

        // Create mock matches
        Match match1 = new Match(1, 1, 1, 2, "Player1", "Player2", 2, 1, 1, 1);
        Match match2 = new Match(2, 1, 3, 4, "Player3", "Player4", 1, 0, 3, 1);

        // Create a mock round containing the matches
        Round round1 = new Round(Arrays.asList(match1, match2));

        List<Round> mockRounds = Arrays.asList(round1);

        when(matchService.getAllRounds(leagueId)).thenReturn(mockRounds);
        when(loginService.getUserIdByUsername(userDetails.getUsername())).thenReturn(userId);

        ModelAndView modelAndView = matchController.showUserMatch(leagueId, userDetails);

        assertEquals("match", modelAndView.getViewName());
        assertEquals(mockRounds, modelAndView.getModel().get("rounds"));
        assertEquals(leagueId, modelAndView.getModel().get("leagueId"));
        assertEquals(userId, modelAndView.getModel().get("userId"));
        assertFalse((boolean) modelAndView.getModel().get("isAdmin"));

        verify(matchService).getAllRounds(leagueId);
        verify(loginService).getUserIdByUsername(userDetails.getUsername());
    }

    @Test
    void testUpdateUserScores_Authorized() {
        int player1Score = 5;
        int player2Score = 3;
        int matchId = 1;
        int leagueId = 1;
        Long userId = 101L;

        when(loginService.getUserIdByUsername(userDetails.getUsername())).thenReturn(userId);
        when(matchService.isUserOwnerOfMatch(matchId, userId)).thenReturn(true);

        ResponseEntity<String> response = matchController.updateUserScores(player1Score, player2Score, matchId, leagueId, userDetails);

        assertEquals("success", response.getBody());
        assertEquals(200, response.getStatusCodeValue());

        verify(matchService).isUserOwnerOfMatch(matchId, userId);
        verify(matchService).updateMatchScores(player1Score, player2Score, matchId, leagueId, userId);
    }

    @Test
    void testUpdateUserScores_Unauthorized() {
        int player1Score = 5;
        int player2Score = 3;
        int matchId = 1;
        int leagueId = 1;
        Long userId = 101L;

        when(loginService.getUserIdByUsername(userDetails.getUsername())).thenReturn(userId);
        when(matchService.isUserOwnerOfMatch(matchId, userId)).thenReturn(false);

        ResponseEntity<String> response = matchController.updateUserScores(player1Score, player2Score, matchId, leagueId, userDetails);

        assertEquals("You are not authorized to edit this match.", response.getBody());
        assertEquals(403, response.getStatusCodeValue());

        verify(matchService).isUserOwnerOfMatch(matchId, userId);
        verify(matchService, never()).updateMatchScores(anyInt(), anyInt(), anyInt(), anyInt(), anyLong());
    }
}