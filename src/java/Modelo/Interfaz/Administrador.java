/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Interfaz;

/**
 *
 * @author almoreno
 */
public interface Administrador {

    Usuario getUsuario();

    Permiso getPermiso();

    Rol getRol();

    Modulo getModulo();

}
