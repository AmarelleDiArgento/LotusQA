/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Interfaz;

import Modelo.DAO;
import Modelo.Tablas.PermisoTab;
import java.sql.ResultSet;

/**
 *
 * @author almoreno
 */
public interface Permiso extends DAO <ResultSet,PermisoTab,Long> {
    
}
