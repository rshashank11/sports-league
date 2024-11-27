import jakarta.persistence.*;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String src;
    private String metadata;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    // Getters and Setters
}
