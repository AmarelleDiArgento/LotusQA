/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Servicios.Mensajes.msj;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author almoreno
 */
public interface DAO <R,O,K>{
    msj Insert(O o);
    msj Update(O o);
    msj Delete(K Id);
    O one(K Id);
    O gets(R rs) throws SQLException;
    List<O> all();
}
