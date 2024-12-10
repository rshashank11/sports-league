package com.team2.sportsleague.controller;

import com.team2.sportsleague.entity.Game;
import com.team2.sportsleague.entity.Photo;
import com.team2.sportsleague.service.GameService;
import com.team2.sportsleague.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

    @Autowired
    private GameService gameService;

    @Autowired
    private PhotoService photoService; // Use PhotoService to handle photo saving

    // Render the gallery page (HTML view)
    @GetMapping
    public String showGalleryPage(Model model) {
        List<Game> games = gameService.getAllGames();
        model.addAttribute("games", games);
        return "gallery";
    }

    // Return JSON response for gallery data
    @GetMapping("/data")
    @ResponseBody
    public List<Game> showGalleryData() {
        return gameService.getAllGames();
    }

    // Upload an image with metadata
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(
            @RequestParam("gameSlug") String gameSlug,
            @RequestParam("imageFile") MultipartFile imageFile,
            @RequestParam("sportType") String sportType,
            @RequestParam("matchDate") String matchDate,
            @RequestParam("players") String players,
            @RequestParam("leagueName") String leagueName) {

        try {
            // Define the directory path where the image will be saved
            String directoryPath = System.getProperty("user.dir") + "/src/main/resources/static/images/";

            // Ensure the directory exists
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Define the file path with the original image name
            String filePath = directoryPath + imageFile.getOriginalFilename();
            File destFile = new File(filePath);
            imageFile.transferTo(destFile);

            // Get gameId from the gameSlug (Assuming you have a method to get the gameId by slug)
            Long gameId = gameService.getGameIdBySlug(gameSlug); // This method needs to be implemented in GameService

            // Create metadata string
            String metadata = String.format("Sport: %s, Match Date: %s, Players: %s, League: %s",
                    sportType, matchDate, players, leagueName);

            // Create the photo object
            Photo newPhoto = new Photo(gameId, "/images/" + imageFile.getOriginalFilename(), metadata); // Update file path for static

            // Save the photo object using the PhotoService
            photoService.save(newPhoto);

            return ResponseEntity.ok("Image uploaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error uploading image.");
        }
    }
}
