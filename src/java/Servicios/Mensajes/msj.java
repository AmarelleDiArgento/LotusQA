/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios.Mensajes;

import java.io.Serializable;

/**
 *
 * @author almoreno
 */
public class msj implements Serializable {
    private String tipo;
    private String msj;
    private String detalles;

    public msj() {
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the msj
     */
    public String getMsj() {
        return msj;
    }

    /**
     * @param msj the msj to set
     */
    public void setMsj(String msj) {
        this.msj = msj;
    }

    /**
     * @return the detalles
     */
    public String getDetalles() {
        return detalles;
    }

    /**
     * @param detalles the detalles to set
     */
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Tipo= " + tipo + "\n Msj= " + msj + "\n Detalles= " + detalles  + "\n";
    }
    
    
    public String toBody() {
         String Body = "";
        return Body;
    }
    
}
