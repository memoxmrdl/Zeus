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
@XmlRootElement(name="FolioVenta")
public class FolioVenta implements Serializable {
    
    	@XmlTransient
	private static final long serialVersionUID = 1L;
        
        @XmlAttribute
        private String SERIE;
        
        @XmlAttribute
        private String CONSECUTIVO;
        
        @XmlAttribute
        private String FOLIO_VENTAS_ID;
                
        public void setSerie(String serie) {
            this.SERIE = serie;
        }
        
        public String getSerie() {
            return this.SERIE;
        }
        
        public void setConsecutivo(String consecutivo) {
            this.CONSECUTIVO = consecutivo;
        }
        
        public String getConsecutivo() {
            return this.CONSECUTIVO;
        }
        
        public void setFolioVenta(String folio_venta) {
            this.FOLIO_VENTAS_ID = folio_venta;
        }
        
        public String getFolioVenta() {
            return this.FOLIO_VENTAS_ID;
        }
               
        public FolioVenta() {
            super();
        }

}
