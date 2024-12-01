package com.team2.sportsleague.service;

import com.team2.sportsleague.entity.Game;
import com.team2.sportsleague.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game getGameBySlug(String slug) {
        return gameRepository.findBySlug(slug);
    }
}
