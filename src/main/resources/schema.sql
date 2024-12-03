# USE sports_league_db;

# drop table games;
# drop table photos;

-- Create the games table
CREATE TABLE IF NOT EXISTS games (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
                                     slug VARCHAR(255) NOT NULL
);

-- Create the photos table
CREATE TABLE IF NOT EXISTS photos (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      game_id INT NOT NULL,
                                      src VARCHAR(255) NOT NULL,
                                      metadata VARCHAR(255),
                                      FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE
);

-- Insert sample data into the games table
INSERT INTO games (name, slug) VALUES
                                   ('Dart', 'dartleague'),
                                   ('Table Tennis', 'table-tennisleague'),
                                   ('Pool', 'poolleague');

-- Insert sample data into the photos table
INSERT INTO photos (game_id, src, metadata) VALUES
                                                (1, '/images/dart/demo.jpg', 'Background of Dart Game'),
                                                (1, '/images/dart/dart.jpg', 'Dart game action shot'),
                                                (1, '/images/dart/Profile.jpg', 'Dart demonstration'),
                                                (2, '/images/tabletennis/pool.jpg', 'Kids playing table tennis'),
                                                (3, '/images/pool/dart.jpg', 'World Cup details for Pool');
