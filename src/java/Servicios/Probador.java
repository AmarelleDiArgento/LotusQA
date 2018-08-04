/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.Implementar.Admin;
import Modelo.Tablas.UsuarioTab;
import Servicios.Mensajes.msj;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author almoreno
 */
public class Probador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        msj m = new msj();
        try {

            // TODO code application logic here
            Admin asql = new Admin();
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

            String Nombre = "Diana Patricia";
            String Apellido = "Perdigon Ladino";
            String Usuario = "dperdigon";
            String Pass = "1234";
            int Code = 4864;

            Date fc1 = f.parse("2018-08-06");
            Date fc2 = f.parse("2017-12-01");
            long mseg1 = fc1.getTime();
            long mseg2 = fc2.getTime();
            java.sql.Date fcSql1 = new java.sql.Date(mseg1);
            java.sql.Date fcSql2 = new java.sql.Date(mseg2);

            UsuarioTab u = new UsuarioTab(Usuario, Code, Nombre, Apellido, Pass, fcSql1, fcSql2, true);
            m = asql.getUsuario().Insert(u);
            System.out.print(m.toString());

        } catch (SQLException ex) {
            m.setTipo("Error");
            m.setMsj("Error SQL: " + ex.getMessage());
            m.setDetalles("Hubo un error al ingresar los datos, Error: " + ex);
        } catch (ParseException ex) {
            m.setTipo("Error");
            m.setMsj("Error Parse: " + ex.getMessage());
            m.setDetalles("Hubo un error al ingresar los datos, Error: " + ex);
        }

    }

}
