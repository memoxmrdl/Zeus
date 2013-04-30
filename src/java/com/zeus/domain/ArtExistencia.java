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
@XmlRootElement(name="ArtExistencia")
public class ArtExistencia implements Serializable {
    
    	@XmlTransient
	private static final long serialVersionUID = 1L;
        
        @XmlAttribute
        private String EXIS_ACTUAL;
        
        @XmlAttribute
        private String EXIS_COMPROM;
        
        @XmlAttribute
        private String EXIS_DISP;
        
        
        public void setExisActual(String exis_actual) {
            this.EXIS_ACTUAL = exis_actual;
        }
        
        public void setExisComprom(String exis_comprom) {
            this.EXIS_COMPROM = exis_comprom;
        }
        
        public void setExisDisp(String exis_disp) {
            this.EXIS_DISP = exis_disp;                              
        }      
        
        public String getExisActual() {
            return this.EXIS_ACTUAL;
        }        
        
        public String getExisComprom() {
            return this.EXIS_COMPROM;
        }
        
        public String getExisDisp() {
            return this.EXIS_DISP;
        }
        
        public ArtExistencia() {
            super();
        }
    
}
