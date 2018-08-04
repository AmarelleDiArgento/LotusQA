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
public class PermisoTab implements Serializable {
    private int Id;
    private String Nombre;
    private String Url;
    private String Icon;
    private String Descripcion;
    private boolean Status;
    private int Id_Mod;

    public PermisoTab(String Nombre, String Url, String Icon, String Descripcion, boolean Status, int Id_Mod) {
        this.Nombre = Nombre;
        this.Url = Url;
        this.Icon = Icon;
        this.Descripcion = Descripcion;
        this.Status = Status;
        this.Id_Mod = Id_Mod;
    }

    public PermisoTab(int Id, String Nombre, String Url, String Icon, String Descripcion, boolean Status, int Id_Mod) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Url = Url;
        this.Icon = Icon;
        this.Descripcion = Descripcion;
        this.Status = Status;
        this.Id_Mod = Id_Mod;
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
     * @return the Url
     */
    public String getUrl() {
        return Url;
    }

    /**
     * @param Url the Url to set
     */
    public void setUrl(String Url) {
        this.Url = Url;
    }

    /**
     * @return the Icon
     */
    public String getIcon() {
        return Icon;
    }

    /**
     * @param Icon the Icon to set
     */
    public void setIcon(String Icon) {
        this.Icon = Icon;
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
    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    /**
     * @return the Id_Mod
     */
    public int getId_Mod() {
        return Id_Mod;
    }

    /**
     * @param Id_Mod the Id_Mod to set
     */
    public void setId_Mod(int Id_Mod) {
        this.Id_Mod = Id_Mod;
    }
    
    
   
}
