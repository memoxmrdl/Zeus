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
@XmlRootElement(name="JuegoDet")
public class JuegoDet implements Serializable {
    
    	@XmlTransient
	private static final long serialVersionUID = 1L;
        
        @XmlAttribute
        private String CLAVE_ARTICULO;
        
        @XmlAttribute
        private String UNIDADES;
        
        
        public void setClaveArticulo(String clave_articulo) {
            this.CLAVE_ARTICULO = clave_articulo;
        }
        
        public String getClaveArticulo() {
            return this.CLAVE_ARTICULO;
        }
        
        public void setUnidades(String unidades){
            this.UNIDADES = unidades;
        }
        
        public String getUnidades() {
            return this.UNIDADES;
        }
        
        public JuegoDet() {
            super();
        }

}
