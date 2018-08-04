/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Implementar;

import Modelo.Interfaz.Permiso;
import Modelo.Tablas.PermisoTab;
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
public class PermisoImp extends Mensajero implements Permiso {

    Connection con;

    final String Insert = "call LotusQA.permisoIn(?, ?, ?, ?, ?, ?);";
    final String Update = "call LotusQA.permisoMo(?,?, ?, ?, ?, ?, ?);";
    final String Delete = "call LotusQA.permisoEl(?);";
    final String One = "call LotusQA.permisoCo(?);";
    final String All = "call LotusQA.permisoLi();";

    public PermisoImp(Connection con) {
        this.con = con;
    }

    @Override
    public msj Insert(PermisoTab p) {
        PreparedStatement stat = null;

        try {
            stat = con.prepareStatement(Insert);
            stat.setString(1, p.getNombre());
            stat.setString(2, p.getUrl());
            stat.setString(3, p.getIcon());
            stat.setString(4, p.getDescripcion());
            stat.setBoolean(5, p.isStatus());
            stat.setInt(6, p.getId_Mod());
            if (stat.executeUpdate() == 0) {
                m = InsertError(p.getNombre());
            } else {
                m = InsertOk(p.getNombre());
            }
        } catch (SQLException ex) {
            m = InsertError(p.getNombre(), ex);
        } finally {
            statsClose(stat);
        }
        return m;
    }

    @Override
    public msj Update(PermisoTab p) {
       
        PreparedStatement stat = null;

        try {
            stat = con.prepareStatement(Update);
            stat.setInt(1, p.getId());
            stat.setString(2, p.getNombre());
            stat.setString(3, p.getUrl());
            stat.setString(4, p.getIcon());
            stat.setString(5, p.getDescripcion());
            stat.setBoolean(6, p.isStatus());
            stat.setInt(7, p.getId_Mod());
            if (stat.executeUpdate() == 0) {
                m = UpdateError(p.getNombre());
            } else {
                m = UpdateOk(p.getNombre());
            }
        } catch (SQLException ex) {
            m = UpdateError(p.getNombre(), ex);
        } finally {
            statsClose(stat);
        }
        return m;
    }

    @Override
    public msj Delete(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PermisoTab one(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PermisoTab gets(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PermisoTab> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
