import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/gallery")
public class GalleryController {
    private final GameService gameService;

    public GalleryController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{slug}")
    public Game getGameBySlug(@PathVariable String slug) {
        return gameService.getGameBySlug(slug);
    }
}
