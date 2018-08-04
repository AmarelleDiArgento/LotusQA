/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Implementar;

import Modelo.Interfaz.Modulo;
import Modelo.Tablas.ModuloTab;
import Servicios.Mensajes.msj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author almoreno
 */
public class ModuloImp implements Modulo {

    Connection con;
    msj m = new msj();

    final String Insert = "";
    final String update = "";
    final String delete = "";
    final String one = "";
    final String all = "";

    public ModuloImp(Connection con) {
        this.con = con;
    }

    @Override
    public msj Insert(ModuloTab mo) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement(Insert);
            stat.setString(1, mo.getNombre());
            stat.setString(2, mo.getDescripcion());
            stat.setBoolean(3, mo.isStatus());
            if (stat.executeUpdate() == 0) {
                m.setTipo("Error");
                m.setMsj("Error al ingresar los datos de " + mo.getNombre());
                m.setDetalles("Hubo un error al ingresar los datos, por favor verifica la informacion ingresada");

            } else {
                m.setTipo("Ok");
                m.setMsj("Registro exitoso");
                m.setDetalles("Se ha ingresado satisfactoriamente a " + mo.getNombre());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModuloImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }

    @Override
    public msj Update(ModuloTab m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public msj Delete(ModuloTab m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModuloTab one(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModuloTab get(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ModuloTab> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
