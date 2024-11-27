-- Insert users into the users table
INSERT INTO users (username, name, password, enabled) VALUES
                                                          ('shashankr1@creditsafe.com', 'Shashank Ramesha', '$2a$10$SiZBkjrJhn19Bpn5EomAAevx0HprUAJKPps4wJbT8FO3kE5Ar1Nme', true), -- Password: shashankR@1
                                                          ('prateekk2@creditsafe.it', 'Prateek Kesarwani', '$2a$10$/mifxplYOJ726OyJ9JVT5OnX9W3WWPf32nVrJelTLO/EcRCjrYt4.', true),   -- Password: prateekK@2
                                                          ('ankits34@creditsafeuk.com', 'Ankit Srivastava', '$2a$10$Nqk3UHGNuQj4oqXiCwhQ.umIgbGTuv8PBZlmN2HuFXx3IeG4YdOaC', true), -- Password: ankitS@34
                                                          ('tahaa4@creditsafe.co.in', 'Taha Ali', '$2a$10$tAN4gGkjiE69gq6D.wbr4ubznQoPOuwOLiUZfFGGqcOmBVFpT2jR.', true);           -- Password: tahaA@4

-- Insert roles into the roles table
INSERT INTO roles (role_id, role_name)
VALUES
    (1, 'user'),
    (2, 'admin');

-- Assign roles to users in the users_roles table
INSERT INTO users_roles (username, role_id) VALUES
                                                ('shashankr1@creditsafe.com', 1),  -- User role for Shashank
                                                ('prateekk2@creditsafe.it', 1),    -- User role for Prateek
                                                ('ankits34@creditsafeuk.com', 1), -- User role for Ankit
                                                ('tahaa4@creditsafe.co.in', 2);   -- Admin role for Taha

-- Insert data into rankings table (with example values for wins, losses, points, rank, no longer associated with any sport)
-- Now, users' rankings are tracked across all sports
INSERT INTO rankings (user_id, wins, losses, points, rank) VALUES
                                                               ((SELECT user_id FROM users WHERE username = 'shashankr1@creditsafe.com'), 10, 2, 100, 3),  -- Shashank Ramesha
                                                               ((SELECT user_id FROM users WHERE username = 'prateekk2@creditsafe.it'), 8, 4, 80, 4),     -- Prateek Kesarwani
                                                               ((SELECT user_id FROM users WHERE username = 'ankits34@creditsafeuk.com'), 12, 1, 120, 2),  -- Ankit Srivastava
                                                               ((SELECT user_id FROM users WHERE username = 'tahaa4@creditsafe.co.in'), 15, 0, 150, 1);   -- Taha Ali
-- Insert into leagues
INSERT INTO leagues (league_name, number_of_players, start_date, end_date, status)
VALUES
    ('Table Tennis', 8, '2024-01-01', '2024-12-31', 'active');

-- Quarter-Final Matches (Round 1)
INSERT INTO matches (league_id, player1_id, player2_id, player1_name, player2_name, score_player1, score_player2, winner_id, round_number)
VALUES
    (1, 1, 2, 'Alice', 'Bob', 21, 18, 1, 1),
    (1, 3, 4, 'Charlie', 'David', 15, 21, 4, 1),
    (1, 5, 6, 'Emma', 'Frank', 22, 20, 5, 1),
    (1, 7, 8, 'Grace', 'Henry', 19, 21, 8, 1);
