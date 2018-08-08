/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios.Mensajes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author almoreno
 */
public abstract class Mensajero {

    protected msj m = new msj();

    public msj NotFound(ClassNotFoundException ex) {
        m.setTipo("Error");
        m.setMsj("¡Hubo un error! ");
        m.setDetalles("Error: " + ex.getMessage() + "\n Detalelles: " + ex);
        return m;
    }

    public msj NotSql(SQLException ex) {
        m.setTipo("Error");
        m.setMsj("¡Hubo un error! ");
        m.setDetalles("Error: " + ex.getMessage() + "\n Detalelles: " + ex);
        return m;
    }

    public msj NotParse(ParseException ex) {

        m.setTipo("Error");
        m.setMsj("Error Parse: " + ex.getMessage());
        m.setDetalles("Error: " + ex.getMessage() + "\n Detalelles: " + ex);
        return m;
    }

    public msj InsertOk(String Nombre) {
        m.setTipo("Ok");
        m.setMsj("Registro exitoso");
        m.setDetalles(Nombre + " Se ha ingresado satisfactoriamente.");
        return m;
    }

    public msj InserDuplo(String Id, String Nombre) {
        m.setTipo("Error");
        m.setMsj("¡Hubo un error! ");
        m.setDetalles(Nombre + ", no pudo se púdo registrar. \n El ID: " + Id + " Ya fue registrado.");
        return m;
    }

    public msj InserDuplo(Long Id, String Nombre) {
        m.setTipo("Error");
        m.setMsj("¡Hubo un error! ");
        m.setDetalles(Nombre + ", no pudo se púdo registrar. \n El ID: " + Id + " Ya fue registrado.");
        return m;
    }

    public msj InsertError(String Nombre) {
        m.setTipo("Error");
        m.setMsj("¡Hubo un error! ");
        m.setDetalles(Nombre + ", no pudo se púdo registrar. \n Por favor verifica la informacion ingresada.");
        return m;
    }

    public msj InsertError(String Nombre, SQLException ex) {
        m.setTipo("Error");
        m.setMsj("¡Hubo un error!");
        m.setDetalles("Sql: " + Nombre + ", no pudo se púdo registrar. \n Por favor verifica la informacion ingresada. \n Error: " + ex.getMessage() + "\n " + ex);
        return m;
    }

    public msj UpdateOk(String Nombre) {
        m.setTipo("Ok");
        m.setMsj("Actualización exitosa");
        m.setDetalles(Nombre + " Se ha ingresado satisfactoriamente.");
        return m;
    }

    public msj UpdateError(String Nombre) {
        m.setTipo("Error");
        m.setMsj("¡Hubo un error! ");
        m.setDetalles(Nombre + ", no pudo se púdo actualizar. \n Por favor verifica la informacion ingresada.");
        return m;
    }

    public msj DeleteOk(String Nombre) {
        m.setTipo("Ok");
        m.setMsj("Actualización exitosa");
        m.setDetalles(Nombre + " Se ha ingresado satisfactoriamente.");
        return m;
    }

    public msj DeleteError() {
        m.setTipo("Error");
        m.setMsj("¡Hubo un error! ");
        m.setDetalles("El Identificador no existe. \n Por favor verifica la informacion ingresada.");
        return m;
    }

    public msj DeleteError(String Nombre) {
        m.setTipo("Error");
        m.setMsj("¡Hubo un error! ");
        m.setDetalles(Nombre + ", no pudo se púdo actualizar. \n Por favor verifica la informacion ingresada.");
        return m;
    }

    public msj DeleteError(String Nombre, SQLException ex) {
        m.setTipo("Error");
        m.setMsj("¡Hubo un error!");
        m.setDetalles("Sql: " + Nombre + ", no pudo se púdo Eliminar. \n Por favor verifica la informacion ingresada. \n Error: " + ex.getMessage() + "\n " + ex);
        return m;
    }

    public msj UpdateError(String Nombre, SQLException ex) {
        m.setTipo("Error");
        m.setMsj("¡Hubo un error!");
        m.setDetalles("Sql: " + Nombre + ", no pudo se púdo actualizar. \n Por favor verifica la informacion ingresada. \n Error: " + ex.getMessage() + "\n " + ex);
        return m;
    }

    public msj oneError(String Id) {
        m.setTipo("Error");
        m.setMsj("¡Hubo un error!");
        m.setDetalles("No se pudo localizar el identificador " + Id + ". \n Por favor verifica la informacion ingresada.");
        return m;
    }

    public msj oneError(Long Id) {
        m.setTipo("Error");
        m.setMsj("¡Hubo un error!");
        m.setDetalles("No se pudo localizar el identificador " + Id + ". \n Por favor verifica la informacion ingresada.");
        return m;
    }

    public msj OneError(String Id, SQLException ex) {
        m.setTipo("Error");
        m.setMsj("¡Hubo un error!");
        m.setDetalles("No se pudo localizar el identificador " + Id + ". \n Por favor verifica la informacion ingresada. \n Error: " + ex.getMessage() + "\n " + ex);
        return m;
    }

    public msj OneError(Long Id, SQLException ex) {
        m.setTipo("Error");
        m.setMsj("¡Hubo un error!");
        m.setDetalles("No se pudo localizar el identificador " + Id + ". \n Por favor verifica la informacion ingresada. \n Error: " + ex.getMessage() + "\n " + ex);
        return m;
    }

    public msj statsClose(PreparedStatement ps) {

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                m.setTipo("Error");
                m.setMsj("¡Hubo un error!");
                m.setDetalles("No pudo cerrarse el proceso Prepared Statement. \n Error: " + ex.getMessage() + "\n " + ex);
            }
        }
        return m;
    }

    public msj statsClose(PreparedStatement ps, ResultSet rs) {

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                m.setTipo("Error");
                m.setMsj("¡Hubo un error!");
                m.setDetalles("No pudo cerrarse el proceso Prepared Statement. \n Error: " + ex.getMessage() + "\n " + ex);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                m.setTipo("Error");
                m.setMsj("¡Hubo un error!");
                m.setDetalles("No pudo cerrarse el proceso Result Set. \n Error: " + ex.getMessage() + "\n " + ex);
            }
        }
        return m;
    }
}
