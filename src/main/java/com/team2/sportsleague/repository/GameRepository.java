package com.team2.sportsleague.repository;

import com.team2.sportsleague.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    Game findBySlug(String slug);
}
