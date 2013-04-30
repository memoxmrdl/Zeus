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
@XmlRootElement(name="ClienteSaldo")
public class ClienteSaldo implements Serializable {
    
    	@XmlTransient
	private static final long serialVersionUID = 1L;
        
        @XmlAttribute
        private String SALDO_CXC;
        
        @XmlAttribute
        private String SALDO_ANTICIPOS;
        
        public void setSaldoCxc(String saldo_cxc) {
            this.SALDO_CXC = saldo_cxc;
        }
        
        public void setSaldoAnticipos(String saldo_anticipos) {
            this.SALDO_ANTICIPOS = saldo_anticipos;
        }

        public String getSaldoCxc() {
            return this.SALDO_CXC;
        }
        
        public String getSaldoAnticipos() {
            return this.SALDO_ANTICIPOS;
        }
        
        public ClienteSaldo() {
            super();
        }

}
