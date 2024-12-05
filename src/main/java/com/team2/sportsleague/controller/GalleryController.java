

package com.team2.sportsleague.controller;

import com.team2.sportsleague.entity.Game;
import com.team2.sportsleague.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // <-- Import Model class
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GalleryController {

    @Autowired
    private GameService gameService;

    // Render the gallery page (HTML view)
    @GetMapping("/gallery")
    public String showGalleryPage(Model model) {
        List<Game> games = gameService.getAllGames();
        model.addAttribute("games", games);
        return "gallery";
    }

    // Return JSON response for gallery data
    @GetMapping("/gallery/data")
    @ResponseBody
    public List<Game> showGalleryData() {
        return gameService.getAllGames();
    }
}
