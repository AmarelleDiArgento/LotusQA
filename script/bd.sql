SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- LotusQA
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS LotusQA DEFAULT CHARACTER SET utf8 ;
USE LotusQA ;

-- -----------------------------------------------------
-- Tabla: Usuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS LotusQA.Usuario (
  codigoUsu INT NOT NULL,
  nombreUsu VARCHAR(60) NOT NULL,
  apellidoUsu VARCHAR(60) NOT NULL,
  usuarioUsu VARCHAR(20) NOT NULL,
  passwordUsu VARCHAR(45) NOT NULL,
  nacimientoUsu DATE NOT NULL,
  ingresoUsu DATE NOT NULL,
  estadoUsu TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (codigoUsu),
  UNIQUE INDEX codigoUsu_UNIQUE (codigoUsu ASC))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Procedimientos LotusQA Tabla: Usuario
-- Insertar
-- -----------------------------------------------------

delimiter $$
create procedure rolIn (in uCodigo INT,in uNombre varchar(60),in uApellido varchar(60),in uUsuario varchar(20),in uPassword varchar(255),in uNacimiento date,in uIngreso date,in uEstado tinyint(4))
begin
insert into rol (codigoUsu,nombreUsu,apellidoUsu,usuarioUsu,passwordUsu,nacimientoUsu,ingresoUsu,estadoUsu) values (uCodigo,uNombre,uApellido,uUsuario,uPassword,uNacimiento,uIngreso,uEstado);
end $$
delimiter $$
-- -----------------------------------------------------
-- Id insertar
-- -----------------------------------------------------

delimiter $$
create procedure rolID ()
begin
select max(RolId) from rol;
end $$
delimiter $$


-- -----------------------------------------------------
-- Modificar
-- -----------------------------------------------------

delimiter $$
create procedure rolMo (in rId INT, in rNombre VARCHAR(45), in rDescripcion mediumtext, in rEstado tinyint(1))
begin
update rol SET RolNombre=rNombre, RolDescripcion=rDescripcion, RolEstado=rEstado where RolId = rId;
end $$
delimiter $$

-- -----------------------------------------------------
-- Eliminar
-- -----------------------------------------------------

delimiter $$
create procedure rolEl (in rId INT)
begin
delete from asignapermiso where RolId = rId;
delete from rol where RolId = rId;
end $$
delimiter $$

-- -----------------------------------------------------
-- Listar todos
-- -----------------------------------------------------

delimiter $$
create procedure rolLi ()
begin
select RolId,RolNombre,RolDescripcion,RolEstado from rol;
end $$
delimiter $$

-- -----------------------------------------------------
-- Consultar x id
-- -----------------------------------------------------

delimiter $$
create procedure rolCo (in rId INT)
begin
select RolId,RolNombre,RolDescripcion,RolEstado from rol where RolId = rId;
end $$
delimiter $$

-- -----------------------------------------------------
-- Tabla: Rol
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS LotusQA.Rol (
  idRol INT NOT NULL,
  nombreRol VARCHAR(60) NOT NULL,
  descripcionRol MEDIUMTEXT NOT NULL,
  estadoRol TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (idRol))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabla: AsignaRol
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS LotusQA.AsignaRol (
  CodigoUsu INT NOT NULL,
  IdRol INT NOT NULL,
  PRIMARY KEY (Codigo,U IdRol),
  INDEX fk_Usuario_has_Rol_Rol1_idx (IdRol ASC),
  INDEX fk_Usuario_has_Rol_Usuario_idx (CodigoUsu ASC),
  CONSTRAINT fk_Usuario_has_Rol_Usuario
    FOREIGN KEY (CodigoUsu)
    REFERENCES LotusQA.Usuario (codigoUsu)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Usuario_has_Rol_Rol1
    FOREIGN KEY (IdRol)
    REFERENCES LotusQA.Rol (idRol)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabla: Modulo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS LotusQA.Modulo (
  idMod INT NOT NULL AUTO_INCREMENT,
  nombreMod VARCHAR(60) NOT NULL,
  descripcionMod MEDIUMTEXT NOT NULL,
  PRIMARY KEY (idMod),
  UNIQUE INDEX nombreMod_UNIQUE (nombreMod ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabla: Permiso
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS LotusQA.Permiso (
  idPer INT NOT NULL AUTO_INCREMENT,
  nombrePer VARCHAR(60) NOT NULL,
  urlPer VARCHAR(50) NOT NULL DEFAULT 'main.jsp',
  icoPer VARCHAR(45) NOT NULL DEFAULT 'new_releases',
  descripcionMod MEDIUMTEXT NOT NULL,
  estadoPer VARCHAR(45) NOT NULL,
  Modulo_idMod INT NOT NULL,
  PRIMARY KEY (idPer, Modulo_idMod),
  UNIQUE INDEX nombrePer_UNIQUE (nombrePer ASC),
  UNIQUE INDEX icoPer_UNIQUE (icoPer ASC),
  INDEX fk_Permiso_Modulo1_idx (Modulo_idMod ASC),
  CONSTRAINT fk_Permiso_Modulo1
    FOREIGN KEY (Modulo_idMod)
    REFERENCES LotusQA.Modulo (idMod)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabla: AsignaPer
-- -----------------------------------------------------
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
    REFERENCES LotusQA.Permiso (idPer , Modulo_idMod)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
