
DROP SCHEMA IF EXISTS `blog` ;
CREATE SCHEMA IF NOT EXISTS `blog` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `blog` ;


-- -----------------------------------------------------
-- Table `blog`.`BOOK`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog`.`BOOK` ;

CREATE  TABLE IF NOT EXISTS `blog`.`BOOK` (
  `BOOK_ID` INT NOT NULL AUTO_INCREMENT ,
  `BOOK_NAME` VARCHAR(45) NOT NULL ,
  `BOOK_IMAGE` MEDIUMBLOB NOT NULL ,
  PRIMARY KEY (`BOOK_ID`) )
ENGINE = InnoDB;