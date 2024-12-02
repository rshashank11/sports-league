package com.team2.sportsleague.controller;

import com.team2.sportsleague.entity.Game;
import com.team2.sportsleague.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public String showGallery(Model model) {
        List<Game> games = gameService.getAllGames();
        for (Game game : games) {
            if (game.getPhotos() == null) {
                game.setPhotos(new ArrayList<>()); // Ensure photos list is never null
            }
        }
        model.addAttribute("games", games);
        return "gallery";
    }
}
