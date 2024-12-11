DELIMITER $$

CREATE PROCEDURE insertLeagues()
BEGIN
    INSERT INTO leagues (name, schedule, last_registration_date, venue, sports)
    VALUES
        ('Winter Darts League', DATE_ADD(NOW(), INTERVAL 5 DAY), DATE_ADD(NOW(), INTERVAL 4 DAY), 'Community Hall A', 'Darts'),
        ('Spring Pool Challenge', DATE_ADD(NOW(), INTERVAL 5 DAY), DATE_ADD(NOW(), INTERVAL 4 DAY), 'Stadium B', 'Pool'),
        ('Summer Table Tennis Classic', DATE_ADD(NOW(), INTERVAL 5 DAY), DATE_ADD(NOW(), INTERVAL 4 DAY), 'Sports Arena C', 'Table Tennis'),
        ('Autumn Pool Championship', DATE_ADD(NOW(), INTERVAL 5 DAY), DATE_ADD(NOW(), INTERVAL 4 DAY), 'Recreation Center D', 'Pool');
END$$

DELIMITER ;
