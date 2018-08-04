/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Implementar;

import Modelo.Interfaz.Rol;
import Modelo.Tablas.RolTab;
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
public class RolImp extends Mensajero implements Rol {

    Connection con;

    final String Insert = "call LotusQA.rolIn(?, ?, ?);";
    final String Update = "call LotusQA.rolMo(?,?, ?, ?);";
    final String Delete = "call LotusQA.rolEl(?);";
    final String One = "call LotusQA.rolCo(?);";
    final String All = "call LotusQA.rolLi();";

    public RolImp(Connection con) {
        this.con = con;
    }

    @Override
    public msj Insert(RolTab r) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement(Insert);
            stat.setString(1, r.getNombre());
            stat.setString(2, r.getDescripcion());
            stat.setBoolean(3, r.isStatus());
            if (stat.executeUpdate() == 0) {
                m = InsertError(r.getNombre());
            } else {
                m = InsertOk(r.getNombre());
            }

        } catch (SQLException ex) {
            m = InsertError(r.getNombre(), ex);
        } finally {
            statsClose(stat);
        }
        return m;
    }

    @Override
    public msj Update(RolTab r) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement(Update);
            stat.setInt(1, r.getId());
            stat.setString(2, r.getNombre());
            stat.setString(3, r.getDescripcion());
            stat.setBoolean(4, r.isStatus());
            if (stat.executeUpdate() == 0) {
                m = UpdateError(r.getNombre());
            } else {
                m = UpdateOk(r.getNombre());
            }

        } catch (SQLException ex) {
            m = UpdateError(r.getNombre(), ex);
        } finally {
            statsClose(stat);
        }
        return m;
    }

    @Override
    public msj Delete(RolTab o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RolTab one(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RolTab get(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RolTab> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
