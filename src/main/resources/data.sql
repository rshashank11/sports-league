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