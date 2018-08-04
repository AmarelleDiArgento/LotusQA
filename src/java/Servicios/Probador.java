/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.Implementar.Admin;
import Modelo.Tablas.ModuloTab;
import Modelo.Tablas.PermisoTab;
import Modelo.Tablas.RolTab;
import Modelo.Tablas.UsuarioTab;
import Servicios.Mensajes.Mensajero;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author almoreno
 */
public class Probador extends Mensajero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Probador p = new Probador();
        p.test();
    }

    public void test() {
        try {
            Admin asql = new Admin();

            Long Id = Long.valueOf(7);
            List<RolTab> r = asql.getRol().all();
            for (RolTab fr : r) {
                System.out.println(fr.toString());
            }

            /*
            // TODO code application logic here
            // Permiso Modificar
            int Id = 1;
            String Nombre = "Tester";
            String Url = "";
            String Ico = "";
            String Descripcion = "Opciones de testeo, otra vez";
            boolean Stat = true;
            int Mod = 1;

            PermisoTab r = new PermisoTab(Id, Nombre, Url, Ico, Descripcion, Stat, Mod);
            m = asql.getPermiso().Update(r);

            // Modulo Modificar
            int Id = 1;
            String Nombre = "Tester 2";
            String Descripcion = "Opciones de testeo";
            boolean Stat = true;

            ModuloTab r = new ModuloTab(Id, Nombre, Descripcion, Stat);
            m = asql.getModulo().Update(r);
            // Rol Modificar
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

            String Nombre = "Diana Patricia";
            String Apellido = "Perdigon Ladino";
            String Usuario = "dperdigon";
            String Pass = "56789";
            int Code = 4864;

            Date fc1 = f.parse("2018-08-06");
            Date fc2 = f.parse("2017-12-01");
            long mseg1 = fc1.getTime();
            long mseg2 = fc2.getTime();
            java.sql.Date fcSql1 = new java.sql.Date(mseg1);
            java.sql.Date fcSql2 = new java.sql.Date(mseg2);

            UsuarioTab u = new UsuarioTab(Usuario, Code, Nombre, Apellido, Pass, fcSql1, fcSql2, true);
            m = asql.getUsuario().Update(u);

            // Rol Modificar
            int Id = 8;
            String Nombre = "Tester";
            String Descripcion = "Opciones de testeo";
            boolean Stat = true;

            RolTab r = new RolTab(Id, Nombre, Descripcion, Stat);
            m = asql.getRol().Update(r);

            // Permiso Insertar
            String Nombre = "Tester";
            String Url = "";
            String Ico = "";
            String Descripcion = "Opciones de testeo";
            boolean Stat = true;
            int Mod = 1;

            PermisoTab r = new PermisoTab(Nombre, Url, Ico, Descripcion, Stat, Mod);
            m = asql.getPermiso().Insert(r);

            // Modulo Insertar
            String Nombre = "Tester";
            String Descripcion = "Opciones de testeo";
            boolean Stat = true;

            ModuloTab r = new ModuloTab(Nombre, Descripcion, Stat);
            m = asql.getModulo().Insert(r);

            // Rol Insertar
            String Nombre = "Tester";
            String Descripcion = "Opciones de testeo";
            boolean Stat = true;

            RolTab r = new RolTab(Nombre, Descripcion, Stat);
            m = asql.getRol().Insert(r);

            // Usuario Insertar
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
        } catch (ParseException ex) {
            m.setTipo("Error");
            m.setMsj("Error Parse: " + ex.getMessage());
            m.setDetalles("Hubo un error al ingresar los datos, Error: " + ex);
        }
             */
        } catch (SQLException ex) {
            m = NotSql(ex);

            /*
        } catch (ParseException ex) {
            m = NotParse(ex); */
        }

        System.out.print(m.toString());

    }

}
