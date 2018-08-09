-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema futbol
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `futbol` ;

-- -----------------------------------------------------
-- Schema futbol
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `futbol` DEFAULT CHARACTER SET utf8 ;
USE `futbol` ;

-- -----------------------------------------------------
-- Table `town`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `town` ;

CREATE TABLE IF NOT EXISTS `town` (
  `town_id` INT NOT NULL,
  `town_name` VARCHAR(45) NULL,
  PRIMARY KEY (`town_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `team` ;

CREATE TABLE IF NOT EXISTS `team` (
  `team_id` INT NOT NULL,
  `team_name` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  `town_id` INT NOT NULL,
  PRIMARY KEY (`team_id`),
  INDEX `fk_team_town_idx` (`town_id` ASC),
  CONSTRAINT `fk_team_town`
    FOREIGN KEY (`town_id`)
    REFERENCES `town` (`town_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `matchup`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `matchup` ;

CREATE TABLE IF NOT EXISTS `matchup` (
  `home_id` INT NOT NULL,
  `visitor_id` INT NOT NULL,
  `home_goals` INT NULL,
  `visitor_goals` INT NULL,
  PRIMARY KEY (`home_id`, `visitor_id`),
  INDEX `fk_team_has_team_team2_idx` (`visitor_id` ASC),
  INDEX `fk_team_has_team_team1_idx` (`home_id` ASC),
  CONSTRAINT `fk_team_has_team_team1`
    FOREIGN KEY (`home_id`)
    REFERENCES `team` (`team_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_team_has_team_team2`
    FOREIGN KEY (`visitor_id`)
    REFERENCES `team` (`team_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `position`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `position` ;

CREATE TABLE IF NOT EXISTS `position` (
  `position_id` INT NOT NULL,
  `position_name` VARCHAR(45) NULL,
  PRIMARY KEY (`position_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `player`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `player` ;

CREATE TABLE IF NOT EXISTS `player` (
  `player_id` INT NOT NULL,
  `player_name` VARCHAR(45) NULL,
  `goals` INT NULL,
  `position_id` INT NULL,
  `team_id` INT NOT NULL,
  PRIMARY KEY (`player_id`, `team_id`),
  INDEX `fk_player_position1_idx` (`position_id` ASC),
  INDEX `fk_player_team1_idx` (`team_id` ASC),
  CONSTRAINT `fk_player_position1`
    FOREIGN KEY (`position_id`)
    REFERENCES `position` (`position_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_player_team1`
    FOREIGN KEY (`team_id`)
    REFERENCES `team` (`team_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `town`
-- -----------------------------------------------------
START TRANSACTION;
USE `futbol`;
INSERT INTO `town` (`town_id`, `town_name`) VALUES (1, 'Manchester');
INSERT INTO `town` (`town_id`, `town_name`) VALUES (2, 'Chelsea');
INSERT INTO `town` (`town_id`, `town_name`) VALUES (3, 'Liverpool');
INSERT INTO `town` (`town_id`, `town_name`) VALUES (4, 'West Ham');
INSERT INTO `town` (`town_id`, `town_name`) VALUES (5, 'Southampton');

COMMIT;


-- -----------------------------------------------------
-- Data for table `team`
-- -----------------------------------------------------
START TRANSACTION;
USE `futbol`;
INSERT INTO `team` (`team_id`, `team_name`, `color`, `town_id`) VALUES (1, 'Panthers', 'Yellow', 1);
INSERT INTO `team` (`team_id`, `team_name`, `color`, `town_id`) VALUES (2, 'Giants', 'Blue', 2);
INSERT INTO `team` (`team_id`, `team_name`, `color`, `town_id`) VALUES (3, 'RedSox', 'Red', 2);
INSERT INTO `team` (`team_id`, `team_name`, `color`, `town_id`) VALUES (4, 'Goobers', 'Purple', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `matchup`
-- -----------------------------------------------------
START TRANSACTION;
USE `futbol`;
INSERT INTO `matchup` (`home_id`, `visitor_id`, `home_goals`, `visitor_goals`) VALUES (1, 2, 4, 1);
INSERT INTO `matchup` (`home_id`, `visitor_id`, `home_goals`, `visitor_goals`) VALUES (1, 3, 6, 5);
INSERT INTO `matchup` (`home_id`, `visitor_id`, `home_goals`, `visitor_goals`) VALUES (1, 4, 2, 3);
INSERT INTO `matchup` (`home_id`, `visitor_id`, `home_goals`, `visitor_goals`) VALUES (2, 1, 2, 2);
INSERT INTO `matchup` (`home_id`, `visitor_id`, `home_goals`, `visitor_goals`) VALUES (2, 3, 5, 5);
INSERT INTO `matchup` (`home_id`, `visitor_id`, `home_goals`, `visitor_goals`) VALUES (2, 4, 2, 1);
INSERT INTO `matchup` (`home_id`, `visitor_id`, `home_goals`, `visitor_goals`) VALUES (3, 1, 2, 2);
INSERT INTO `matchup` (`home_id`, `visitor_id`, `home_goals`, `visitor_goals`) VALUES (3, 2, 1, 8);
INSERT INTO `matchup` (`home_id`, `visitor_id`, `home_goals`, `visitor_goals`) VALUES (3, 4, 0, 0);
INSERT INTO `matchup` (`home_id`, `visitor_id`, `home_goals`, `visitor_goals`) VALUES (4, 1, 3, 5);
INSERT INTO `matchup` (`home_id`, `visitor_id`, `home_goals`, `visitor_goals`) VALUES (4, 2, 4, 0);
INSERT INTO `matchup` (`home_id`, `visitor_id`, `home_goals`, `visitor_goals`) VALUES (4, 3, 2, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `position`
-- -----------------------------------------------------
START TRANSACTION;
USE `futbol`;
INSERT INTO `position` (`position_id`, `position_name`) VALUES (1, 'goalkeeper');
INSERT INTO `position` (`position_id`, `position_name`) VALUES (2, 'sweeper');
INSERT INTO `position` (`position_id`, `position_name`) VALUES (3, 'stopper');
INSERT INTO `position` (`position_id`, `position_name`) VALUES (4, 'left back');
INSERT INTO `position` (`position_id`, `position_name`) VALUES (5, 'right back');
INSERT INTO `position` (`position_id`, `position_name`) VALUES (6, 'left midfielder');
INSERT INTO `position` (`position_id`, `position_name`) VALUES (7, 'right midfielder');
INSERT INTO `position` (`position_id`, `position_name`) VALUES (8, 'defensive midfielder');
INSERT INTO `position` (`position_id`, `position_name`) VALUES (9, 'striker');
INSERT INTO `position` (`position_id`, `position_name`) VALUES (10, 'forward');

COMMIT;


-- -----------------------------------------------------
-- Data for table `player`
-- -----------------------------------------------------
START TRANSACTION;
USE `futbol`;
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (1, 'Bobby', 0, 1, 1);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (2, 'Susie', 3, 2, 1);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (3, 'Mikey', 1, 3, 1);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (4, 'Annie', 7, 9, 1);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (5, 'Johnny', 10, 10, 1);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (6, 'Jonathan', 0, 1, 2);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (7, 'An', 2, 2, 2);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (8, 'Jess', 4, 3, 2);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (9, 'Liang', 7, 9, 2);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (10, 'Xin', 5, 10, 2);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (11, 'Yihun', 0, 1, 3);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (12, 'Prateek', 2, 2, 3);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (13, 'Sanket', 0, 3, 3);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (14, 'Soumya', 7, 9, 3);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (15, 'Arima', 5, 10, 3);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (16, 'Will', 0, 1, 4);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (17, 'Prasanna', 1, 2, 4);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (18, 'Austin', 1, 3, 4);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (19, 'Samhita', 9, 9, 4);
INSERT INTO `player` (`player_id`, `player_name`, `goals`, `position_id`, `team_id`) VALUES (20, 'Megha', 2, 10, 4);

COMMIT;



use futbol;




-- QUIZ THREE: 105 POINTS + 10 POINTS EXTRA CREDIT

-- Please rename this file: quiz3_yourname.sql
-- Run this script in a root connection in order to build a database about soccer teams, players, and matchups.
-- Resave the file frequently so that you don't lose any work!
-- Attach the file to your quiz submission at the end of class.

-- WRITE A QUERY FOR EACH QUESTION BELOW
-- THERE ARE 15 QUESTIONS (7 POINTS EACH) + 2 EXTRA CREDIT QUESTIONS (5 POINTS EACH)
-- THE SECRET INTERVIEW QUESTION(S) SHALL BE REVEALED!
-- 
-- Some free advice: If faced with a challenging query, take it step by step.
-- Work incrementally, starting with one table, joining to add addition data that you need it.
-- Keep in mind the target columns you are aiming for.
-- With each step, try to get closer and closer to the target columns
-- Don't forget sorting criteria when requested.


select * from crew;
select * from matchup;
select * from player;
select * from position;
select * from follows;
select * from team;

-- 1. Who scored the most goals?
-- Output just the name of the player
select player_name
from player
order by goals desc
limit 1;

-- 2. how many matchups ended in a draw?
select count(*)
from matchup
where home_goals = visitor_goals;



-- 3. In how many matches were more than 10 goals scored?
select count(*)
from matchup
where home_goals + visitor_goals > 10;


-- 4. How many games were blowouts?
-- Let's say that a blowout is a game where the goal differential is GREATER THAN 3
select count(*)
from matchup
where abs(home_goals - visitor_goals) > 3;


-- 5. How many total goals are scored by players who do NOT wear a jersey that's a primary color
-- Primary colors are red, blue, and yellow
select count(goals)
from player join team using(team_id)
where color not in ('Red', 'Blue', 'Yellow');

-- 6. How many goals were scored by players on teams from Chelsea?
select count(goals)
from player join team using(team_id) join town using(town_id)
where town_name = 'Chelsea';

-- 7. What team does Soumya play for?
-- Output the name of the team, and the town that the team is from
select team_name, town_name
from player join team using(team_id) join town using(town_id)
where player_name = 'Soumya';


-- 8. Not counting goal keepers, what TWO positions scored the FEWEST goals?
-- Output the name of the position and the number of goals scored by that position
-- (Also ignore any positions for which there are no players.)
select position_id, position_name, sum(goals) as 'Total_goals'
from player join position using(position_id)
where position_name <> 'goalkeeper'
group by position_id
order by Total_goals
limit 2;

-- 9. How many teams come from each town?
-- Include towns that have no teams
-- Output town name and number of teams sorted from most teams to fewest teams
select town_name, count(team_id)
from team right join town using(town_id)
group by town_id
;
-- 10. How many players play for each position
-- Include in your table positions that have no players.
-- ONLY COUNT PLAYERS WHOSE NAME STARTS WITH THE LETTER 'S'
-- Order by the  number of players in that position descending
select position_name, count(player_id) as 'Players'
from
(
	select *
	from player join team using(team_id)
	where player_name like 's%'
) as t1 right join position using(position_id)
group by position_id
order by Players desc
;


-- 11. What players were above average in terms of goals scored?
-- Give the name of the player and their goals scored
-- DO NOT INCLUDE GOAL KEEPERS IN COMPUTING THE OVERALL AVERAGE!
select player_name, goals
from
(
	select avg(goals) as 'G_Avg'
	from player join position using(position_id)
	where position_name <> 'goalkeeper'
) as t1, player
where goals > G_Avg
;


-- 12. Who is the Striker for the team from Manchester?
-- Give the name and the number of goals she scored (That was a hint!)
select player_name, town_name, position_name
from player join team using(team_id) join town using(town_id) join position using(position_id)
where position_name = 'striker' and town_name = 'Manchester'
;

-- 13. In how many games were exactly k total goals scored (home_goals + visitor_goals)?
-- Output a record for each occuring value of total_goals.
-- Order by total_goals
-- set k = 5;

select *, home_goals + visitor_goals as 'total_goals'
from matchup
where home_goals + visitor_goals = 5
order by total_goals;


-- 14. How many games did the Giants lose?
select count(*) as 'Giant Defeats'
from
(
	select team_id as 'Giant_id'
	from team
	where team_name = 'Giants'
) as t1, matchup
where (Giant_id = home_id and home_goals < visitor_goals) or (Giant_id = visitor_id and home_goals > visitor_goals)
;


-- 15. Who is the best goal keeper?
-- Best is defined as the goal keeper whose team gave up the fewest goals
select home_id, sum(visitor_goals) as 'home_let_in'
from matchup
group by home_id;

select visitor_id, sum(home_goals) as 'visitor_let_in'
from matchup
group by visitor_id;

select *
from
(
	select home_let_in + visitor_let_in as 'let_in', t1.home_id
	from
	(select home_id, sum(visitor_goals) as 'home_let_in'
	from matchup
	group by home_id) as t1, (select visitor_id, sum(home_goals) as 'visitor_let_in'
	from matchup
	group by visitor_id) as t2
	where t1.home_id = t2.visitor_id
	order by let_in
	limit 1
) as t3 join team on(team.team_id = t3.home_id) join player using(team_id)
where position_id=1;



-- EXTRA CREDIT (5 points)
-- You might be asked this question on an interview!  :-)
-- (Usually it is framed as a question about employees and managers - but you know me!)
-- The "crew" table below identifies for each crew member of the Enterprise and who they report to.
-- For example, Uhuru reports to Scotty. Chapel reports directly to McCoy who reports to Spock.
-- Write a query that outputs the crew member name and the person they DIRECTLY report to.
-- Include crew that don't report to anyone (reports_to = null).
-- Order your output by the name of the person reported to.

drop table if exists crew;
create TABLE crew (
  crew_id INT PRIMARY KEY,
  crew_name VARCHAR(20),
  reports_to INT NULL,
  CONSTRAINT fk_manager FOREIGN KEY (reports_to) REFERENCES crew (crew_id)
  );
  
INSERT INTO crew VALUES
(1, 'Kirk', null),
(2, 'Spock', null),
(3, 'McCoy', 2),
(4, 'Scotty', null),
(5, 'Uhuru', 4),
(6, 'Chekov', 1),
(7, 'Sulu', 1),
(8, 'Chapel', 3),
(9, 'Oreilly', 6);



-- Put your answer here:
select c1.crew_name, c2.crew_name as 'reports to'
from crew c1 left join crew c2 on(c1.reports_to = c2.crew_id);




-- EXTRA CREDIT 2: (5 points)
-- I have also asked this question on an interview.
-- Suppose we had a database of who follows whom. (Where have I seen this?)
-- Write me a query that outputs a frequency distribution on the number of followers
-- In other words, ouput a set of (num_users, num_followers) pairs.
-- One of the rows of your output will be the tuple (5,1) because 5 users have only 1 follower.
-- Clearly label your columns "num_users" and "num_followers"
-- Order your output by the number of followers descending

drop table if exists follows;
create table follows (
  follower_id INT,
  followee_id INT
  );
  
insert into follows values
(2,1), (3,1), (4, 1), (5,1), (6,1),(7,1),
(1,2), (3,2), (4, 2),
(5,3), (6,3), (4, 3),
(1,4), (2, 4), (3,4),
(2,5), (4,5),
(2,6), (3,6),
(1,7),
(3,8),
(5,9),
(2,10),
(2,11);


-- Put your answer here:


select num_followers, count(*) as 'num_users'
from 
(
select count(follower_id) as 'num_followers', followee_id
from follows
group by followee_id
) as t1
group by num_followers


