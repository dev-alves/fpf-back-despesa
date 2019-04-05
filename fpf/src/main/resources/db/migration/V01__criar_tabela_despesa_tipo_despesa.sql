-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema fpf
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fpf
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fpf` DEFAULT CHARACTER SET utf8 ;
USE `fpf` ;

-- -----------------------------------------------------
-- Table `fpf`.`tipo_despesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fpf`.`tipo_despesa` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fpf`.`despesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fpf`.`despesa` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(50) NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `data_despesa` DATE NOT NULL,
  `tipo_despesa` BIGINT(11) NOT NULL,
  `anexo` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_despesa_tipo_despesa_idx` (`tipo_despesa` ASC),
  CONSTRAINT `fk_despesa_tipo_despesa`
    FOREIGN KEY (`tipo_despesa`)
    REFERENCES `fpf`.`tipo_despesa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

