-- Insert roles
INSERT INTO roles (role_name)
VALUES
    ('ROLE_USER'),
    ('ROLE_ADMIN');

-- Insert users
INSERT INTO users (username, name, password, email, department, role, profile_image, enabled)
VALUES
    ('shashankr1@creditsafe.com', 'Shashank Ramesha', '$2a$10$kcPWazDCSLJOiC6y3ib/ZO5R9Q3srwF5dgkVZ7GCnbWwEM6oZ3s/C', 'shashank@example.com', 'IT', 'Admin', 'profile1.jpg', true),
    ('prateekk2@creditsafe.it', 'Prateek Kesarwani', '$2a$10$GOVHQ8FzG9qmbQGw7bUezemFCG4FfwQzbFne5YfYLhiVAQ4LcrqMS', 'prateek@example.com', 'IT', 'User', 'profile2.jpg', true),
    ('ankits34@creditsafeuk.com', 'Ankit Srivastava', '$2a$10$Nqk3UHGNuQj4oqXiCwhQ.umIgbGTuv8PBZlmN2HuFXx3IeG4YdOaC', 'ankit@example.com', 'Finance', 'User', 'profile3.jpg', true),
    ('tahaa4@creditsafe.co.in', 'Taha Ali', '$2a$10$tAN4gGkjiE69gq6D.wbr4ubznQoPOuwOLiUZfFGGqcOmBVFpT2jR.', 'taha@example.com', 'Marketing', 'User', 'profile4.jpg', true);

-- Assign roles to users
INSERT INTO users_roles (username, role_id)
VALUES
    ('shashankr1@creditsafe.com', (SELECT role_id FROM roles WHERE role_name = 'ROLE_ADMIN')),
    ('prateekk2@creditsafe.it', (SELECT role_id FROM roles WHERE role_name = 'ROLE_ADMIN')),
    ('ankits34@creditsafeuk.com', (SELECT role_id FROM roles WHERE role_name = 'ROLE_ADMIN')),
    ('tahaa4@creditsafe.co.in', (SELECT role_id FROM roles WHERE role_name = 'ROLE_ADMIN'));
-- Step 4: Insert rankings

INSERT INTO rankings (user_id, wins, losses, points)
VALUES
    ((SELECT user_id FROM users WHERE username = 'shashankr1@creditsafe.com'), 10, 2, 100),
    ((SELECT user_id FROM users WHERE username = 'prateekk2@creditsafe.it'), 8, 4, 80),
    ((SELECT user_id FROM users WHERE username = 'ankits34@creditsafeuk.com'), 12, 1, 120),
    ((SELECT user_id FROM users WHERE username = 'tahaa4@creditsafe.co.in'), 15, 0, 150);

-- Insert leagues
INSERT INTO leagues (name, schedule, last_registration_date, venue, sports, description)
VALUES
    ('Winter Pool League', '2024-12-15 10:00:00', '2024-12-10 23:59:59', 'Sports Club A', 'Pool', 'A fun winter league for pool enthusiasts.'),
    ('Spring Darts League', '2024-03-20 14:00:00', '2024-03-15 23:59:59', 'Community Hall B', 'Darts', 'Sharpen your aim this spring.'),
    ('Autumn Table Tennis League', '2024-10-01 09:00:00', '2024-09-25 23:59:59', 'Downtown Sports Center', 'Table Tennis', 'Compete for the championship this autumn.'),
    ('Summer Darts League', '2024-06-10 16:00:00', '2024-06-05 23:59:59', 'Olympic Arena', 'Darts', 'Experience the thrill of summer darts.'),
    ('National Pool Championship', '2024-08-20 12:00:00', '2024-08-10 23:59:59', 'Grand Plaza', 'Pool', 'The ultimate pool championship.');

-- Insert matches
INSERT INTO matches (league_id, player1_id, player2_id, player1_name, player2_name, score_player1, score_player2, winner_id, round_number, match_time)
VALUES
    ((SELECT id FROM leagues WHERE name = 'Winter Pool League'),
     (SELECT user_id FROM users WHERE username = 'shashankr1@creditsafe.com'),
     (SELECT user_id FROM users WHERE username = 'prateekk2@creditsafe.it'),
     'Shashank Ramesha', 'Prateek Kesarwani', 21, 18,
     (SELECT user_id FROM users WHERE username = 'shashankr1@creditsafe.com'), 1, '2024-12-15 10:30:00'),
    ((SELECT id FROM leagues WHERE name = 'Winter Pool League'),
     (SELECT user_id FROM users WHERE username = 'ankits34@creditsafeuk.com'),
     (SELECT user_id FROM users WHERE username = 'tahaa4@creditsafe.co.in'),
     'Ankit Srivastava', 'Taha Ali', 15, 21,
     (SELECT user_id FROM users WHERE username = 'tahaa4@creditsafe.co.in'), 1, '2024-12-15 11:00:00');

-- Insert user updates (example updates)
INSERT INTO user_updates (user_id, updated_fields)
VALUES
    ((SELECT user_id FROM users WHERE username = 'shashankr1@creditsafe.com'), 'Updated profile picture'),
    ((SELECT user_id FROM users WHERE username = 'prateekk2@creditsafe.it'), 'Updated password');
     'Shashank Ramesha', 'Prateek Kesarwani', 32, 16,
     (SELECT user_id FROM users WHERE username = 'shashankr1@creditsafe.com'), 1),
    ((SELECT id FROM leagues WHERE name = 'Winter Pool League'),
     (SELECT user_id FROM users WHERE username = 'ankits34@creditsafeuk.com'),
     (SELECT user_id FROM users WHERE username = 'tahaa4@creditsafe.co.in'),
     'Ankit Srivastava', 'Taha Ali', 21, 42,
     (SELECT user_id FROM users WHERE username = 'tahaa4@creditsafe.co.in'), 1),
    ((SELECT id FROM leagues WHERE name = 'Winter Pool League'),
     (SELECT user_id FROM users WHERE username = 'johndoe5@creditsafe.com'),
     (SELECT user_id FROM users WHERE username = 'jane.smith@companycheck.co.uk'),
     'John Doe', 'Jane Smith', 34, 23,
     (SELECT user_id FROM users WHERE username = 'johndoe5@creditsafe.com'), 1),
    ((SELECT id FROM leagues WHERE name = 'Winter Pool League'),
     (SELECT user_id FROM users WHERE username = 'alex.brown@creditsafe.be'),
     (SELECT user_id FROM users WHERE username = 'emily.davis@creditsafe.co.in'),
     'Alex Brown', 'Emily Davis', 14, 134,
     (SELECT user_id FROM users WHERE username = 'emily.davis@creditsafe.co.in'), 1);
