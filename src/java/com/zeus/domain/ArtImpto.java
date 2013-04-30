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
@XmlRootElement(name="ArtImpto")
public class ArtImpto implements Serializable {
    
    	@XmlTransient
	private static final long serialVersionUID = 1L;
        
        @XmlAttribute
        private String IMPUESTO;
        
        public void setImpuesto(String impuesto) {
            this.IMPUESTO = impuesto;
        }        
        
        public String getImpuesto() {
            return this.IMPUESTO;
        }
        
        public ArtImpto() {
            super();
        }
    
}
