/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Interfaz;

import Modelo.DAO;
import Modelo.Tablas.ModuloTab;
import java.sql.ResultSet;

/**
 *
 * @author almoreno
 */
public interface Modulo extends DAO <ResultSet,ModuloTab,Long> {
    
    
}
