/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Implementar;

import Modelo.Interfaz.Modulo;
import Modelo.Tablas.ModuloTab;
import Servicios.Mensajes.Mensajero;
import Servicios.Mensajes.msj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author almoreno
 */
public class ModuloImp extends Mensajero implements Modulo {

    Connection con;

    final String Insert = "call LotusQA.moduloIn(?,?,?);";
    final String Update = "call LotusQA.moduloMo(?,?,?,?);";
    final String Delete = "call LotusQA.moduloEl(?);";
    final String One = "call LotusQA.moduloCo(?);";
    final String All = "call LotusQA.moduloLi();";

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
                m = InsertError(mo.getNombre());
            } else {
                m = InsertOk(mo.getNombre());
            }
        } catch (SQLException ex) {
            m = InsertError(mo.getNombre(), ex);
        }
        return m;
    }

    @Override
    public msj Update(ModuloTab mo) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement(Update);
            stat.setInt(1, mo.getId());
            stat.setString(2, mo.getNombre());
            stat.setString(3, mo.getDescripcion());
            stat.setBoolean(4, mo.isStatus());
            if (stat.executeUpdate() == 0) {
                m = UpdateError(mo.getNombre());
            } else {
                m = UpdateOk(mo.getNombre());
            }
        } catch (SQLException ex) {
            m = UpdateError(mo.getNombre(), ex);
        }
        return m;
    }

    @Override
    public msj Delete(Long Id) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement(Delete);
            stat.setLong(1, Id);
            if (stat.executeUpdate() == 0) {
                m = UpdateError(String.valueOf(Id));
            } else {
                m = UpdateOk(String.valueOf(Id));
            }
        } catch (SQLException ex) {
            m = UpdateError(String.valueOf(Id), ex);
        }
        return m;
    }

    @Override
    public ModuloTab one(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModuloTab gets(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ModuloTab> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
