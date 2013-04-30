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
@XmlRootElement(name="ImptoDoctoVe")
public class ImptoDoctoVe implements Serializable {
    
    	@XmlTransient
	private static final long serialVersionUID = 1L;
        
        @XmlAttribute
        private String IMPUESTO_ID;
        
        @XmlAttribute        
        private String PCTJE_IMPUESTO;
        
        @XmlAttribute
        private String VENTA_NETA;
        
        @XmlAttribute
        private String IMPORTE_IMPTO;
                
        public void setImpuestoId(String impuesto_id) {
            this.IMPUESTO_ID = impuesto_id;
        }
        
        public String getImpuestoId() {
            return this.IMPUESTO_ID;
        }
        
        public void setPctjeImpuesto(String pctje_impuesto) {
            this.PCTJE_IMPUESTO = pctje_impuesto;
        }
        
        public String getPctjeImpuesto() {
            return this.PCTJE_IMPUESTO;
        }
        
        public void setVentaNeta(String venta_neta) {
            this.VENTA_NETA = venta_neta;
        }
        
        public String getVentaNeta() {
            return this.VENTA_NETA;
        }
        
        public void setImporteImpto(String importe_impto) {
            this.IMPORTE_IMPTO = importe_impto;
        }
        
        public String getImporteImpto() {
            return this.IMPORTE_IMPTO;
        }
                       
        public ImptoDoctoVe() {
            super();
        }

}
