DROP TABLE IF EXISTS matches;
DROP TABLE IF EXISTS leagues;

CREATE TABLE leagues (
                         league_id INT AUTO_INCREMENT PRIMARY KEY,   -- Unique ID for each league
                         league_name VARCHAR(255) NOT NULL,           -- Name of the league (e.g., "Premier League")
                         number_of_players INT,                      -- Number of players in the league
                         start_date DATE,                             -- Start date of the league
                         end_date DATE,                               -- End date of the league
                         status VARCHAR(50)                           -- Status of the league (e.g., active, completed)
)engine= InnoDB;


CREATE TABLE matches (
                         league_id INT,
                         match_id INT AUTO_INCREMENT PRIMARY KEY,
                         player1_id INT NOT NULL,
                         player2_id INT NOT NULL,
                         player1_name VARCHAR(128) NOT NULL,
                         player2_name VARCHAR(128) NOT NULL,
                         score_player1 INT NULL,
                         score_player2 INT NULL,
                         winner_id INT NULL,
                         round_number INT NOT NULL,
                         FOREIGN KEY (league_id) REFERENCES leagues(league_id)
)engine=InnoDB;