/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name="ArtPrecio")
public class ArtPrecio implements Serializable {
    
    	@XmlTransient
	private static final long serialVersionUID = 1L;
        
        @XmlAttribute
        private String PRECIO_UNITARIO;
        
        @XmlAttribute
        private String NOMBRE_PRECIO;
        
        public void setPrecioUnitario(String precio_unitario) {
            this.PRECIO_UNITARIO = precio_unitario;
        }
        
        public void setNombrePrecio(String nombre_precio) {
            this.NOMBRE_PRECIO = nombre_precio;
        }
        
        public String getPrecioUnitario() {
            return this.PRECIO_UNITARIO;
        }
        
        public String getNombrePrecio() {
            return this.NOMBRE_PRECIO;
        }
        
        public ArtPrecio() {
            super();
        }

}
