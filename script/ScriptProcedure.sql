-- ---------------------------------------------------------------------------------------------------------------
-- Procedimientos LotusQA Tabla: Usuario
-- Insertar
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure usuarioIn (in uUsuario varchar(20), in uCodigo INT,in uNombre varchar(60),in uApellido varchar(60),in uPassword varchar(255),in uNacimiento date,in uIngreso date,in uEstado tinyint(4))
begin
insert into Usuario (usuarioUsu,codigoUsu,nombreUsu,apellidoUsu,passwordUsu,nacimientoUsu,ingresoUsu,estadoUsu) values (uUsuario,uCodigo,uNombre,uApellido,uPassword,uNacimiento,uIngreso,uEstado);
end $$
delimiter

-- ---------------------------------------------------------------------------------------------------------------
-- Modificar
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure usuarioMo (in uUsuario varchar(20), in uCodigo INT,in uNombre varchar(60),in uApellido varchar(60),in uPassword varchar(255),in uNacimiento date,in uIngreso date,in uEstado tinyint(4))
begin
update Usuario SET Usuario.usuarioUsu=uUsuario,Usuario.codigoUsu=uCodigo,Usuario.nombreUsu=uNombre,Usuario.apellidoUsu=uApellido,Usuario.passwordUsu=uPassword,Usuario.nacimientoUsu=uNacimiento,Usuario.ingresoUsu=uIngreso,Usuario.estadoUsu=uEstado where Usuario.usuarioUsu=uUsuario;
-- update AsignaRol SET AsignaRol.UsuarioUsu=uUsuario, AsignaRol.IdRol=rId where AsignaRol.UsuarioUsu=uUsuario and AsignaRol.IdRol=rId;
-- , in rId INT
end $$
delimiter

-- ---------------------------------------------------------------------------------------------------------------
-- Eliminar
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure usuarioEl (in uUsuario varchar(20))
begin
delete from AsignaRol where AsignaRol.UsuarioUsu = uUsuario;
delete from Usuario where Usuario.usuarioUsu=uUsuario;
end $$
delimiter

-- ---------------------------------------------------------------------------------------------------------------
-- Listar todos
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure usuarioLi ()
begin
select usuarioUsu,codigoUsu,nombreUsu,apellidoUsu,passwordUsu,nacimientoUsu,ingresoUsu,estadoUsu from Usuario;
end $$
delimiter

-- ---------------------------------------------------------------------------------------------------------------
-- Consultar x id
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure usuarioCo (in uUsuario varchar(20))
begin
select usuarioUsu,codigoUsu,nombreUsu,apellidoUsu,passwordUsu,nacimientoUsu,ingresoUsu,estadoUsu from Usuario where usuarioUsu=uUsuario;
end $$
delimiter

-- ---------------------------------------------------------------------------------------------------------------
-- Procedimientos LotusQA Tabla: Rol
-- Insertar
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure LotusQA.rolIn (in rNombre VARCHAR(60), in rDescripcion mediumtext, in rEstado tinyint(1))
begin
insert into Rol (nombreRol,descripcionRol,estadoRol) values (rNombre,rDescripcion,rEstado);
end $$
delimiter

-- ---------------------------------------------------------------------------------------------------------------
-- Modificar
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure LotusQA.rolMo (in rId INT, in rNombre VARCHAR(45), in rDescripcion mediumtext, in rEstado tinyint(1))
begin
update Rol SET nombreRol=rNombre, descripcionRol=rDescripcion, estadoRol=rEstado where idRol = rId;
end $$
delimiter

-- ---------------------------------------------------------------------------------------------------------------
-- Eliminar
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure LotusQA.rolEl (in rId INT)
begin
delete from AsignaPer where AsignaPer.IdRol = rId;
delete from Rol where rol.RolId = rId;
end $$
delimiter

-- ---------------------------------------------------------------------------------------------------------------
-- Listar todos
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure LotusQA.rolLi ()
begin
select idRol,nombreRol,descripcionRol,estadoRol from Rol;
end $$
delimiter

-- ---------------------------------------------------------------------------------------------------------------
-- Consultar x id
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure LotusQA.rolCo (in rId INT)
begin
select idRol,nombreRol,descripcionRol,estadoRol from Rol where idRol = rId;
end $$
delimiter

-- ---------------------------------------------------------------------------------------------------------------
-- Procedimientos LotusQA Tabla: Modulo
-- Insertar
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure LotusQA.modIn (in mNombre VARCHAR(60), in mDescripcion mediumtext, in mEstado tinyint(1))
begin
insert into Modulo (nombreMod,descripcionMod,estadoMod) values (mNombre,mDescripcion,mEstado);
end $$
delimiter

-- ---------------------------------------------------------------------------------------------------------------
-- Modificar
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure LotusQA.modMo (in moId INT, in mNombre VARCHAR(60), in mDescripcion mediumtext, in mEstado tinyint(1))
begin
update Modulo SET nombreMod=mNombre, descripcionMod=mDescripcion, estadoMod=mEstado where idMod = moId ;
end $$
delimiter

-- ---------------------------------------------------------------------------------------------------------------
-- Eliminar
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure LotusQA.modEl (in moId INT)
begin
delete from Permiso where Permiso.idMod = moId ;
delete from Modulo where Modulo.idMod = moId ;
end $$
delimiter

-- ---------------------------------------------------------------------------------------------------------------
-- Listar todos
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure LotusQA.modLi ()
begin
select idMod,nombreMod,descripcionMod,estadoMod from Modulo;
end $$
delimiter

-- ---------------------------------------------------------------------------------------------------------------
-- Consultar x id
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure LotusQA.modCo (in moId INT)
begin
select idMod,nombreMod,descripcionMod,estadoMod from Modulo where idMod = moId;
end $$
delimiter 

-- ---------------------------------------------------------------------------------------------------------------
-- Procedimientos LotusQA Tabla: Modulo
-- Insertar
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure LotusQA.perIn (in pNombre VARCHAR(60) ,in pUrl VARCHAR(50), in pIco VARCHAR(45), in pDescripcion MEDIUMTEXT, in pEstado VARCHAR(45), in moId INT)
begin
insert into Permiso (nombrePer,urlPer,icoPer,descripcionMod,estadoPer,IdMod) values (pNombre,pUrl,pIco,pDescripcion,pEstado,moId);
end $$
delimiter

-- ---------------------------------------------------------------------------------------------------------------
-- Modificar
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure LotusQA.perMo (in pId INT, in pNombre VARCHAR(60) ,in pUrl VARCHAR(50), in pIco VARCHAR(45), in pDescripcion MEDIUMTEXT, in pEstado VARCHAR(45), in moId INT)
begin
update Permiso SET nombrePer=pNombre,urlPer=pUrl,icoPer=pIco,descripcionMod=pDescripcion,estadoPer=pDescripcion,IdMod=moId where idPer = pId ;
end $$
delimiter

-- ---------------------------------------------------------------------------------------------------------------
-- Eliminar
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure LotusQA.perEl (in pId INT)
begin
delete from Permiso where idPer = pId ;
end $$
delimiter

-- ---------------------------------------------------------------------------------------------------------------
-- Listar todos
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure LotusQA.perLi ()
begin
select idPer,nombrePer,urlPer,icoPer,descripcionMod,estadoPer,IdMod from Permiso;
end $$
delimiter

-- ---------------------------------------------------------------------------------------------------------------
-- Consultar x id
-- ---------------------------------------------------------------------------------------------------------------

delimiter $$
create procedure LotusQA.perCo (in pId INT)
begin
select idPer,nombrePer,urlPer,icoPer,descripcionMod,estadoPer,IdMod from Permiso where idPer = pId;
end $$
delimiter 
