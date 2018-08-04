/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Tablas;

import java.io.Serializable;

/**
 *
 * @author almoreno
 */
public class ModuloTab implements Serializable {
    private int Id;
    private String Nombre;
    private String Descripcion;
    private boolean Status;

    public ModuloTab(String Nombre, String Descripcion, boolean Status) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Status = Status;
    }

    public ModuloTab(int Id, String Nombre, String Descripcion, boolean Status) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Status = Status;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the Status
     */
    public boolean isStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(int Status) {
        this.Status = Status==1;
    }
    
       public void setStatus(boolean Status) {
        this.Status = Status;
    } 
    
    
}
