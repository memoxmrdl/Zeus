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
@XmlRootElement(name="RolClave")
public class RolClave implements Serializable {
    
    	@XmlTransient
	private static final long serialVersionUID = 1L;
        
        @XmlAttribute
        private String ROL_ID;
        
        @XmlAttribute
        private String CLAVE;
        
        
        public void setRolId(String rol_id) {
            this.ROL_ID = rol_id;
        }
        
        public void setClave(String clave) {
            this.CLAVE = clave;
        }
        
        public String getRolId() {
            return this.ROL_ID;
        }
        
        public String getClave() {
            return this.CLAVE;
        }
               
        public RolClave() {
            super();
        }

}
