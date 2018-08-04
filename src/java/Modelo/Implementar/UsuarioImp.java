/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Implementar;

import Modelo.Interfaz.Usuario;
import Modelo.Tablas.UsuarioTab;
import Servicios.Mensajes.msj;
import Servicios.Mensajes.Mensajero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author almoreno
 */
public class UsuarioImp extends Mensajero implements Usuario {

    Connection con;

    final String Insert = "call lotusqa.usuarioIn(?, ?, ?, ?, ?, ?, ?, ?);";
    final String update = "";
    final String delete = "";
    final String one = "";
    final String all = "";

    public UsuarioImp(Connection con) {
        this.con = con;
    }

    @Override
    public msj Insert(UsuarioTab u) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement(Insert);
            stat.setString(1, u.getUsuario());
            stat.setInt(2, u.getCodigo());
            stat.setString(3, u.getNombre());
            stat.setString(4, u.getApellido());
            stat.setString(5, u.getPassword());
            stat.setDate(6, u.getNacimiento());
            stat.setDate(7, u.getIngreso());
            stat.setBoolean(8, u.isStatus());
            if (stat.executeUpdate() == 0) {
                m = InsertError(u.getNombre());

            } else {
                m = InsertOk(u.getNombre());
            }

        } catch (SQLException ex) {
            m = InsertError(u.getNombre(), ex);
        } finally {
            statsClose(stat);
        }
        return m;
    }

    @Override
    public msj Update(UsuarioTab o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public msj Delete(UsuarioTab o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioTab one(String Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioTab get(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioTab> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
