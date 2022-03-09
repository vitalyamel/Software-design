-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema schedule
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema schedule
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `schedule` DEFAULT CHARACTER SET utf8 ;
USE `schedule` ;

-- -----------------------------------------------------
-- Table `schedule`.`subject`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`subject` (
  `ID_subject` INT NOT NULL AUTO_INCREMENT,
  `Name_subject` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_subject`),
  UNIQUE INDEX `idsubject_UNIQUE` (`ID_subject` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `schedule`.`teachers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`teachers` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Surname` VARCHAR(45) NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Patronymic` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `schedule`.`timetable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`timetable` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Day_week` VARCHAR(45) NOT NULL,
  `ID_subject` INT NOT NULL,
  `ID_teachers` INT NOT NULL,
  `Classroom` INT NOT NULL,
  `Number_of_students` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_timetable_subject_idx` (`ID_subject` ASC) VISIBLE,
  INDEX `fk_timetable_teachers1_idx` (`ID_teachers` ASC) VISIBLE,
  CONSTRAINT `fk_timetable_subject`
    FOREIGN KEY (`ID_subject`)
    REFERENCES `schedule`.`subject` (`ID_subject`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_timetable_teachers1`
    FOREIGN KEY (`ID_teachers`)
    REFERENCES `schedule`.`teachers` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
