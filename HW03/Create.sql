SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Part 2:
-- Schema Twitter
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Twitter` DEFAULT CHARACTER SET utf8 ;
USE `Twitter` ;

-- -----------------------------------------------------
-- Table `Twitter`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Twitter`.`Users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `is_person` TINYINT NULL DEFAULT 0 COMMENT '\n',
  `handle` VARCHAR(45) NOT NULL,
  `discription` CHAR(255) NULL,
  `is_hidden` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `handle_UNIQUE` (`handle` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Twitter`.`Tweets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Twitter`.`Tweets` (
  `tweet_id` INT NOT NULL AUTO_INCREMENT,
  `post` CHAR(160) NOT NULL,
  `user_id` INT NOT NULL,
  `timestamp` datetime NOT NULL DEFAULT now(),
  INDEX `user_id_UNIQUE` (`user_id` ASC),
  INDEX `user_id_idx` (`tweet_id` ASC),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `Twitter`.`Users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Twitter`.`Follows`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Twitter`.`Follows` (
  `Follower_id` INT NOT NULL,
  `Followee_id` INT NOT NULL,
  PRIMARY KEY (`Follower_id`, `Followee_id`),
  CONSTRAINT `Follower_id`
    FOREIGN KEY (`Follower_id`)
    REFERENCES `Twitter`.`Users` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Followee_id`
    FOREIGN KEY (`Followee_id`)
    REFERENCES `Twitter`.`Users` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `Twitter`.`Hashtag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Twitter`.`Hashtag` (
  `hash_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`hash_id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Twitter`.`Hashtags_in_tweets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Twitter`.`Hashtags_in_tweets` (
  `hash_id` INT NOT NULL,
  `tweet_id` INT NOT NULL,
  PRIMARY KEY (`hash_id`, `tweet_id`),
  CONSTRAINT `hash_id`
    FOREIGN KEY (`hash_id`)
    REFERENCES `Twitter`.`Hashtag` (`hash_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `tweet_id`
    FOREIGN KEY (`tweet_id`)
    REFERENCES `Twitter`.`Tweets` (`tweet_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Twitter`.`Likes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Twitter`.`Likes` (
  `user_id` INT NOT NULL,
  `tweet_id` INT NOT NULL,
  PRIMARY KEY (`tweet_id`, `user_id`),
  INDEX `iser_id_idx` (`user_id` ASC),
  INDEX `tweet_id_idx` (`tweet_id` ASC),
  CONSTRAINT `Likes_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `Twitter`.`Users` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Likes_tweet_id`
    FOREIGN KEY (`tweet_id`)
    REFERENCES `Twitter`.`Tweets` (`tweet_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Twitter`.`Interests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Twitter`.`interests` (
  `user_id` INT NOT NULL,
  `hash_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `hash_id`),
  INDEX `user_id_idx` (`user_id` ASC),
  INDEX `hash_id_idx` (`hash_id` ASC),
  CONSTRAINT `interest_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `Twitter`.`Users` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `interest_hash_id`
    FOREIGN KEY (`hash_id`)
    REFERENCES `Twitter`.`Hashtag` (`hash_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;