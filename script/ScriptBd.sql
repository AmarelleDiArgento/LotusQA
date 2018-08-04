-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Schema LotusProject
 CREATE USER IF NOT EXISTS 'LotusQA'@'localhost' IDENTIFIED BY '1311138C72A04BB7D228AFB9D574ED2D00DFD264C67161A958AD62E32672DEFF';
 GRANT ALL PRIVILEGES ON * . * TO 'LotusQA'@'localhost';
 FLUSH PRIVILEGES;
 -- DROP USER IF EXISTS LotusProyect@localhost;
 -- ---------------------------------------------------------------------------------------------------------------------------------------------------------------
 
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- ---------------------------------------------------------------------------------------------------------------
-- Script: LotusQA
-- ---------------------------------------------------------------------------------------------------------------

CREATE DATABASE IF NOT EXISTS LotusQA DEFAULT CHARACTER SET utf8 ;
USE LotusQA;

-- ---------------------------------------------------------------------------------------------------------------
-- LotusQA Tabla: Usuario
-- ---------------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LotusQA.Usuario (
  usuarioUsu VARCHAR(20) NOT NULL,
  codigoUsu INT NOT NULL,
  nombreUsu VARCHAR(60) NOT NULL,
  apellidoUsu VARCHAR(60) NOT NULL,
  passwordUsu VARCHAR(45) NOT NULL,
  nacimientoUsu DATE NOT NULL,
  ingresoUsu DATE NOT NULL,
  estadoUsu TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (usuarioUsu),
  UNIQUE INDEX codigoUsu_UNIQUE (codigoUsu ASC),
  UNIQUE INDEX usuarioUsu_UNIQUE (usuarioUsu ASC))
ENGINE = InnoDB;

-- ---------------------------------------------------------------------------------------------------------------
-- LotusQA Tabla: Rol
-- ---------------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LotusQA.Rol (
  idRol INT NOT NULL AUTO_INCREMENT,
  nombreRol VARCHAR(60) NOT NULL,
  descripcionRol MEDIUMTEXT NOT NULL,
  estadoRol TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (idRol),
  UNIQUE INDEX nombreRol_UNIQUE (nombreRol ASC))
ENGINE = InnoDB;

-- ---------------------------------------------------------------------------------------------------------------
-- LotusQA Tabla: Modulo
-- ---------------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LotusQA.Modulo (
  idMod INT NOT NULL AUTO_INCREMENT,
  nombreMod VARCHAR(60) NOT NULL,
  descripcionMod MEDIUMTEXT NOT NULL,
  estadoMod TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (idMod),
  UNIQUE INDEX nombreMod_UNIQUE (nombreMod ASC))
ENGINE = InnoDB;

-- ---------------------------------------------------------------------------------------------------------------
-- LotusQA Tabla: Permiso
-- ---------------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LotusQA.Permiso (
  idPer INT NOT NULL AUTO_INCREMENT,
  nombrePer VARCHAR(60) NOT NULL,
  urlPer VARCHAR(50) NOT NULL DEFAULT 'main.jsp',
  icoPer VARCHAR(45) NOT NULL DEFAULT 'new_releases',
  descripcionMod MEDIUMTEXT NOT NULL,
  estadoPer VARCHAR(45) NOT NULL,
  IdMod INT NOT NULL,
  PRIMARY KEY (idPer, IdMod),
  UNIQUE INDEX nombrePer_UNIQUE (nombrePer ASC),
  INDEX fk_Permiso_Modulo1_idx (IdMod ASC),
  CONSTRAINT fk_Permiso_Modulo1
    FOREIGN KEY (IdMod)
    REFERENCES LotusQA.Modulo (idMod)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- ---------------------------------------------------------------------------------------------------------------
-- LotusQA Tabla: AsignaPer
-- ---------------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LotusQA.AsignaPer (
  IdRol INT NOT NULL,
  IdPer INT NOT NULL,
  IdMod INT NOT NULL,
  leerAP TINYINT NULL,
  accederAP TINYINT NULL DEFAULT 0,
  nuevoAP TINYINT NULL DEFAULT 0,
  modificarAP TINYINT NULL DEFAULT 0,
  eliminarAP TINYINT NULL DEFAULT 0,
  todosAP TINYINT NULL DEFAULT 0,
  PRIMARY KEY (IdRol, IdPer, IdMod),
  INDEX fk_Rol_has_Permiso_Permiso1_idx (IdPer ASC, IdMod ASC),
  INDEX fk_Rol_has_Permiso_Rol1_idx (IdRol ASC),
  CONSTRAINT fk_Rol_has_Permiso_Rol1
    FOREIGN KEY (IdRol)
    REFERENCES LotusQA.Rol (idRol)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Rol_has_Permiso_Permiso1
    FOREIGN KEY (IdPer , IdMod)
    REFERENCES LotusQA.Permiso (idPer , IdMod)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- ---------------------------------------------------------------------------------------------------------------
-- LotusQA Tabla: AsignaRol
-- ---------------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LotusQA.AsignaRol (
  UsuarioUsu VARCHAR(20) NOT NULL,
  IdRol INT NOT NULL,
  PRIMARY KEY (UsuarioUsu, IdRol),
  INDEX fk_Usuario_has_Rol_Rol1_idx (IdRol ASC),
  INDEX fk_Usuario_has_Rol_Usuario1_idx (UsuarioUsu ASC),
  CONSTRAINT fk_Usuario_has_Rol_Usuario1
    FOREIGN KEY (UsuarioUsu)
    REFERENCES LotusQA.Usuario (usuarioUsu)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Usuario_has_Rol_Rol1
    FOREIGN KEY (IdRol)
    REFERENCES LotusQA.Rol (idRol)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;