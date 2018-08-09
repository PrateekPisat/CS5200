-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Splitwise
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Splitwise` ;

-- -----------------------------------------------------
-- Schema Splitwise
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Splitwise` DEFAULT CHARACTER SET utf8 ;
USE `Splitwise` ;

-- -----------------------------------------------------
-- Table `Splitwise`.`Users`
-- This Table stores the users
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Splitwise`.`Users` ;

CREATE TABLE IF NOT EXISTS `Splitwise`.`Users` (
  `Users_id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Budget` FLOAT NULL DEFAULT -1,
  `Phone` CHAR(11) NULL,
  `Hide_Data` TINYINT NULL,
  PRIMARY KEY (`Users_id`),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC),
  UNIQUE INDEX `Phone_UNIQUE` (`Phone` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Splitwise`.`Bills`
-- This table stores all the bills.
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Splitwise`.`Bills` ;

CREATE TABLE IF NOT EXISTS `Splitwise`.`Bills` (
  `Bills_id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `Description` VARCHAR(45) NULL,
  `Paid_By` INT NOT NULL,
  PRIMARY KEY (`Bills_id`),
  INDEX `Paid_by_idx` (`Paid_By` ASC),
  CONSTRAINT `Paid_by`
    FOREIGN KEY (`Paid_By`)
    REFERENCES `Splitwise`.`Users` (`Users_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Splitwise`.`Bill_Requests`
-- Once a bill is created, it is shared amongst all its participants.
-- The creator of the bill will distribute the said bill 
-- amongst all the participants, and the records will be stored in 
-- this table.
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Splitwise`.`Bill_Requests` ;

CREATE TABLE IF NOT EXISTS `Splitwise`.`Bill_Requests` (
  `To_id` INT NOT NULL,
  `Bills_id` INT NOT NULL,
  PRIMARY KEY (`To_id`, `Bills_id`),
  INDEX `To_idx` (`To_id` ASC),
  INDEX `Bill_idx` (`Bills_id` ASC),
  CONSTRAINT `To`
    FOREIGN KEY (`To_id`)
    REFERENCES `Splitwise`.`Users` (`Users_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Bill`
    FOREIGN KEY (`Bills_id`)
    REFERENCES `Splitwise`.`Bills` (`Bills_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Splitwise`.`Bill_Items`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Splitwise`.`Bill_Items` ;

CREATE TABLE IF NOT EXISTS `Splitwise`.`Bill_Items` (
  `Item_id` INT NOT NULL,
  `Bills_id` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Cost` FLOAT NOT NULL DEFAULT 0.00,
  PRIMARY KEY (`Item_id`, `Bills_id`),
  CONSTRAINT `Bill_id`
    FOREIGN KEY (`Bills_id`)
    REFERENCES `Splitwise`.`Bills` (`Bills_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Splitwise`.`Share`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Splitwise`.`Share` ;

CREATE TABLE IF NOT EXISTS `Splitwise`.`Share` (
  `Bills_id` INT NOT NULL,
  `Item_id` INT NOT NULL,
  `Users_id` INT NOT NULL,
  `Is_Paid` TINYINT DEFAULT 0,
  PRIMARY KEY (`Bills_id`, `Item_id`, `Users_id`),
  INDEX `Items_idx` (`Item_id` ASC),
  INDEX `Users_idx` (`Users_id` ASC),
  CONSTRAINT `Bills_id`
    FOREIGN KEY (`Bills_id`)
    REFERENCES `Splitwise`.`Bills` (`Bills_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Items_id`
    FOREIGN KEY (`Item_id`)
    REFERENCES `Splitwise`.`Bill_Items` (`Item_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Users_id`
    FOREIGN KEY (`Users_id`)
    REFERENCES `Splitwise`.`Users` (`Users_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Splitwise`.`Ledger`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Splitwise`.`Ledger` ;

CREATE TABLE IF NOT EXISTS `Splitwise`.`Ledger` (
  `Bills_id` INT NOT NULL,
  `Item_id` INT NOT NULL,
  `Amount` FLOAT NOT NULL DEFAULT 0.00,
  PRIMARY KEY (`Bills_id`, `Item_id`),
  INDEX `Bills_idx` (`Bills_id` ASC),
  INDEX `Items_idx` (`Item_id` ASC),
  CONSTRAINT `Ledger_Bill`
    FOREIGN KEY (`Bills_id`)
    REFERENCES `Splitwise`.`Bills` (`Bills_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Items`
    FOREIGN KEY (`Item_id`)
    REFERENCES `Splitwise`.`Bill_Items` (`Item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- ALTER TABLE `splitwise`.`ledger` 
-- DROP FOREIGN KEY `Ledger_Bill`;
-- ALTER TABLE `splitwise`.`ledger` 
-- CHANGE COLUMN `Bill_id` `Bills_id` INT(11) NOT NULL ;
-- ALTER TABLE `splitwise`.`ledger` 
-- ADD CONSTRAINT `Ledger_Bill`
-- FOREIGN KEY (`Bills_id`)
  -- REFERENCES `splitwise`.`bills` (`bills_id`)
  -- ON DELETE CASCADE
  -- ON UPDATE CASCADE;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
