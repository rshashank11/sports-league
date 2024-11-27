drop table rankings;
drop table sports;
drop table users;

CREATE TABLE `rankings` (
                            `ranking_id` INT(11) NOT NULL AUTO_INCREMENT,
                            `sport_id` INT(11) NULL DEFAULT NULL,
                            `user_id` INT(11) NULL DEFAULT NULL,
                            `wins` INT(11) NULL DEFAULT '0',
                            `losses` INT(11) NULL DEFAULT '0',
                            `points` INT(11) NULL DEFAULT '0',
                            `rank` INT(11) NULL DEFAULT '0',
                            PRIMARY KEY (`ranking_id`),
                            INDEX `sport_id` (`sport_id`),
                            INDEX `user_id` (`user_id`)
);


CREATE TABLE `sports` (
                          `sport_id` INT(11) NOT NULL AUTO_INCREMENT,
                          `sport_name` VARCHAR(255) NOT NULL,
                          PRIMARY KEY (`sport_id`)
);

CREATE TABLE `users` (
                         `user_id` INT(11) NOT NULL AUTO_INCREMENT,
                         `username` VARCHAR(255) NOT NULL,
                         `email` VARCHAR(255) NOT NULL,
                         PRIMARY KEY (`user_id`)
);
