/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.domain;

/**
 *
 * @author Guillermo
 */
public class CiuEstPas {
    
    private String ciudad_id;
    private String estado_id;
    private String pais_id;
    
    public void setCiudadId(String ciudad_id) {
        this.ciudad_id = ciudad_id;
    }
    
    public void setEstadoId(String estado_id) {
        this.estado_id = estado_id;
    }
    
    public void setPaisId(String pais_id) {
        this.pais_id = pais_id;
    }
    
    public String getCiudadId() {
        return this.ciudad_id;
    }
    
    public String getEstadoId() {
        return this.estado_id;
    }
    
    public String getPaisId() {
        return this.pais_id;
    }
}
