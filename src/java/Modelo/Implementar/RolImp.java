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
import java.util.ArrayList;
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
            stat.setLong(1, r.getId());
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
    public msj Delete(Long Id) {

        RolTab r = one(Id);

        if (r != null) {
            PreparedStatement stat = null;
            try {
                stat = con.prepareCall(Delete);
                stat.setLong(1, Id);
                if (stat.executeUpdate() == 0) {

                    m = DeleteError(r.getNombre());
                } else {
                    m = DeleteOk(r.getNombre());
                }
            } catch (SQLException ex) {
                m = DeleteError(r.getNombre(), ex);
            } finally {
                m = statsClose(stat);
            }

        } else {
            m = DeleteError();
        }
        return m;
    }

    @Override
    public RolTab gets(ResultSet rs) throws SQLException {
        Long Id = rs.getLong("idRol");
        String Nombre = rs.getString("nombreRol");
        String Descripcion = rs.getString("descripcionRol");
        boolean Stat = rs.getBoolean("estadoRol");
        RolTab rt = new RolTab(Id, Nombre, Descripcion, Stat);
        return rt;
    }

    @Override
    public RolTab one(Long Id) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        RolTab r = null;
        try {
            stat = con.prepareCall(One);
            stat.setLong(1, Id);
            rs = stat.executeQuery();
            if (rs.next()) {
                r = gets(rs);
            } else {
                m = oneError(Id);
            }
        } catch (SQLException ex) {
            m = OneError(Id, ex);
        } finally {
            statsClose(stat, rs);
        }

        return r;
    }

    @Override
    public List<RolTab> all() {

        PreparedStatement stat = null;
        ResultSet rs = null;
        List<RolTab> r = new ArrayList<>();
        try {
            stat = con.prepareCall(All);
            rs = stat.executeQuery();
            while (rs.next()) {
                r.add(gets(rs));
            }
        } catch (SQLException ex) {
        } finally {
            statsClose(stat, rs);
        }

        return r;
    }

}
