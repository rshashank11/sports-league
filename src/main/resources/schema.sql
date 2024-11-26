DROP TABLE IF EXISTS matches;

CREATE TABLE matches (
                         match_id INT AUTO_INCREMENT PRIMARY KEY,
                         player1_id INT NOT NULL,
                         player2_id INT NOT NULL,
                         player1_name VARCHAR(128) NOT NULL,
                         player2_name VARCHAR(128) NOT NULL,
                         score_player1 INT NOT NULL,
                         score_player2 INT NOT NULL,
                         winner_id INT NOT NULL,
                         round_number INT NOT NULL
)engine=InnoDB;