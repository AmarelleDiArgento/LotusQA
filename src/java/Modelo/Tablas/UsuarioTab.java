/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Tablas;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author almoreno
 */
public class UsuarioTab implements Serializable {

    private String Usuario;
    private int Codigo;
    private String Nombre;
    private String Apellido;
    private String Password;
    private Date Nacimiento;
    private Date Ingreso;
    private boolean Status;

    private List<RolTab> RolU;

    public UsuarioTab(String Usuario, int Codigo, String Nombre, String Apellido, String Password, Date Nacimiento, Date Ingreso, boolean Status) {
        this.Usuario = Usuario;
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Password = Password;
        this.Nacimiento = Nacimiento;
        this.Ingreso = Ingreso;
        this.Status = Status;
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return the Codigo
     */
    public int getCodigo() {
        return Codigo;
    }

    /**
     * @param Codigo the Codigo to set
     */
    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
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
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the Nacimiento
     */
    public Date getNacimiento() {
        return Nacimiento;
    }

    /**
     * @param Nacimiento the Nacimiento to set
     */
    public void setNacimiento(Date Nacimiento) {
        this.Nacimiento = Nacimiento;
    }

    /**
     * @return the Ingreso
     */
    public Date getIngreso() {
        return Ingreso;
    }

    /**
     * @param Ingreso the Ingreso to set
     */
    public void setIngreso(Date Ingreso) {
        this.Ingreso = Ingreso;
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
        this.Status = Status == 1;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    /**
     * @return the RolU
     */
    public List<RolTab> getRolU() {
        return RolU;
    }

    /**
     * @param RolU the RolU to set
     */
    public void setRolU(List<RolTab> RolU) {
        this.RolU = RolU;
    }

}
