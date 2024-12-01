package com.team2.sportsleague.controller;

import com.team2.sportsleague.entity.Game;
import com.team2.sportsleague.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GalleryController {
    private final GameService gameService;

    public GalleryController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/gallery")
    public String showGallery(Model model) {
        model.addAttribute("games", gameService.getAllGames());
        return "gallery";
    }

    @GetMapping("/gallery/{slug}")
    public String showGamePhotos(@PathVariable String slug, Model model) {
        model.addAttribute("game", gameService.getGameBySlug(slug));
        return "game-details";
    }
}
