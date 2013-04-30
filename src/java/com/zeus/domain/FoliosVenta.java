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
@XmlRootElement(name="FoliosVenta")
public class FoliosVenta implements Serializable {
    
    	@XmlTransient
	private static final long serialVersionUID = 1L;
        
        @XmlAttribute
        private String FOLIO;
        
        @XmlAttribute
        private String FOLIO_VENTA;
        
        @XmlAttribute
        private String CONSEC;
        
        public void setFolio(String folio) {
            this.FOLIO = folio;
        }
        
        public String getFolio() {
            return this.FOLIO;
        }
        
        public void setFolioVentaId(String folio_venta) {
            this.FOLIO_VENTA = folio_venta;
        }
        
        public String getFolioVentaId() {
            return this.FOLIO_VENTA;
        }
        
        public void setConsec(String consec) {
            this.CONSEC = consec;
        }
        
        public String getConsec() {
            return this.CONSEC;
        }
        
        public FoliosVenta() {
            super();
        }

}
