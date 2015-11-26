-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema amazing_control
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema amazing_control
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `amazing_control` DEFAULT CHARACTER SET latin1 ;
USE `amazing_control` ;

-- -----------------------------------------------------
-- Table `amazing_control`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amazing_control`.`usuarios` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(255) NOT NULL COMMENT '',
  `senha` VARCHAR(16) NOT NULL COMMENT '',
  `confirmacaoSenha` VARCHAR(16) NOT NULL COMMENT '',
  `ativo` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `amazing_control`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amazing_control`.`clientes` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `Nome` VARCHAR(255) NOT NULL COMMENT '',
  `Endereco` VARCHAR(255) NULL COMMENT '',
  `Telefone` CHAR(15) NULL COMMENT '',
  `Cidade` VARCHAR(45) NULL COMMENT '',
  `Cep` CHAR(8) NULL COMMENT '',
  `UF` CHAR(2) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amazing_control`.`vendas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amazing_control`.`vendas` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `data` DATE NOT NULL COMMENT '',
  `cliente_id` INT NOT NULL COMMENT '',
  `usuario_id` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_vendas_clientes_idx` (`cliente_id` ASC)  COMMENT '',
  INDEX `fk_vendas_usuarios1_idx` (`usuario_id` ASC)  COMMENT '',
  CONSTRAINT `fk_vendas_clientes`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `amazing_control`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vendas_usuarios1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `amazing_control`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amazing_control`.`fornecedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amazing_control`.`fornecedores` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `Nome` VARCHAR(255) NOT NULL COMMENT '',
  `Telefone` CHAR(11) NULL COMMENT '',
  `Endereco` VARCHAR(255) NOT NULL COMMENT '',
  `Cidade` VARCHAR(45) NOT NULL COMMENT '',
  `Cep` CHAR(8) NOT NULL COMMENT '',
  `UF` CHAR(2) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amazing_control`.`produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amazing_control`.`produtos` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `Nome` VARCHAR(255) NOT NULL COMMENT '',
  `Marca` VARCHAR(255) NOT NULL COMMENT '',
  `Tipo` VARCHAR(45) NOT NULL COMMENT '',
  `ValorCusto` DOUBLE NOT NULL COMMENT '',
  `ValorVenda` DOUBLE NOT NULL COMMENT '',
  `quantidade` INT NOT NULL COMMENT '',
  `fornecedores_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`, `fornecedores_id`)  COMMENT '',
  INDEX `fk_produtos_fornecedores1_idx` (`fornecedores_id` ASC)  COMMENT '',
  CONSTRAINT `fk_produtos_fornecedores1`
    FOREIGN KEY (`fornecedores_id`)
    REFERENCES `amazing_control`.`fornecedores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amazing_control`.`itensVendas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amazing_control`.`itensVendas` (
  `produtos_id` INT NOT NULL COMMENT '',
  `vendas_id` INT NOT NULL COMMENT '',
  `ValorTotal` DOUBLE NULL COMMENT '',
  `quantidade` INT NULL COMMENT '',
  PRIMARY KEY (`produtos_id`, `vendas_id`)  COMMENT '',
  INDEX `fk_produtos_has_vendas_vendas1` (`vendas_id` ASC)  COMMENT '',
  INDEX `fk_produtos_has_vendas_produtos1` (`produtos_id` ASC)  COMMENT '',
  CONSTRAINT `fk_produtos_has_vendas_produtos1`
    FOREIGN KEY (`produtos_id`)
    REFERENCES `amazing_control`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produtos_has_vendas_vendas1`
    FOREIGN KEY (`vendas_id`)
    REFERENCES `amazing_control`.`vendas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
