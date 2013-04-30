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
@XmlRootElement(name="DirsClientes")
public class DirsClientes implements Serializable {
    
    	@XmlTransient
	private static final long serialVersionUID = 1L;
        
        @XmlAttribute
        private String DIR_CLI_ID;
        
        @XmlAttribute        
        private String NOMBRE_CONSIG;
        
        @XmlAttribute
        private String ES_DIR_PPAL;
                
        public void setDirCliId(String dir_cli_id) {
            this.DIR_CLI_ID = dir_cli_id;
        }
        
        public String getDirCliId() {
            return this.DIR_CLI_ID;
        }
        
        public void setNombreConsig(String nombre_consig) {
            this.NOMBRE_CONSIG = nombre_consig;
        }
        
        public String getNombreConsig() {
            return this.NOMBRE_CONSIG;
        }
        
        public void setEsDirPpal(String es_dir_ppal) {
            this.ES_DIR_PPAL = es_dir_ppal;
        }
        
        public String getEsDirPpal() {
            return this.ES_DIR_PPAL;
        }
                                 
        public DirsClientes() {
            super();
        }

}
