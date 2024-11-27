INSERT INTO `sports` (`sport_name`) VALUES
                                        ('Soccer'),
                                        ('Basketball'),
                                        ('Tennis');

INSERT INTO `users` (`username`, `email`) VALUES
                                              ('john_doe', 'john@example.com'),
                                              ('jane_doe', 'jane@example.com'),
                                              ('alex_smith', 'alex@example.com'),
                                              ('mary_jones', 'mary@example.com'),
                                              ('bob_brown', 'bob@example.com');

-- Insert predefined data into rankings table (using sport_id and user_id from sports and users)
INSERT INTO `rankings` (`sport_id`, `user_id`, `wins`, `losses`, `points`, `rank`) VALUES
                                                                                       (1, 1, 10, 5, 50, 1),  -- John Doe, Soccer
                                                                                       (2, 2, 8, 7, 45, 2),   -- Jane Doe, Basketball
                                                                                       (1, 3, 12, 3, 60, 3),  -- Alex Smith, Soccer
                                                                                       (3, 4, 5, 10, 30, 4),  -- Mary Jones, Tennis
                                                                                       (2, 5, 7, 8, 40, 5);   -- Bob Brown, Basketball
