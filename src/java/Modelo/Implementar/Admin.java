/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Implementar;

import Modelo.Interfaz.Modulo;
import Modelo.Interfaz.Permiso;
import Modelo.Interfaz.Rol;
import Modelo.Interfaz.Usuario;
import Modelo.Tablas.UsuarioTab;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import Modelo.Interfaz.Administrador;
import Servicios.Mensajes.Mensajero;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author almoreno
 */
public class Admin extends  Mensajero implements Administrador {

    Connection con;
    DataSource dt;

    final String user = "LotusQA";
    final String pass = "1311138C72A04BB7D228AFB9D574ED2D00DFD264C67161A958AD62E32672DEFF";
    final String database = "LotusQA";
    final String url = "jdbc:mysql://localhost:3306/" + database;

    private Usuario usu = null;
    private Modulo mod = null;
    private Permiso per = null;
    private Rol rol = null;

    public Admin() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            m = NotFound(ex);
        }
    }

    public Admin(DataSource dt) throws SQLException {
        this.dt = dt;
        this.con = dt.getConnection();

    }

    @Override
    public Usuario getUsuario() {
        if (usu == null) {
            usu = new UsuarioImp(con);
        }
        return usu;
    }

    @Override
    public Permiso getPermiso() {
        if (per == null) {
            per = new PermisoImp(con);
        }
        return per;
    }

    @Override
    public Rol getRol() {
        if (rol == null) {
            rol = new RolImp(con);
        }
        return rol; 
    }

    @Override
    public Modulo getModulo() {
        if (mod == null) {
            mod = new ModuloImp(con);
        }
        return mod; 
    }

}
