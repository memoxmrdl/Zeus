/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.domain;

/**
 *
 * @author Guillermo
 */
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name="ListaArticulos")
public class ListaArticulos implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;

	@XmlAttribute
	private long ARTICULO_ID;
        
        @XmlAttribute
        private String NOMBRE_ARTICULO;
        
        @XmlAttribute
        private long LINEA_ARTICULO_ID;
        
        @XmlAttribute
        private String NOMBRE_LINEA_ARTICULO;
        
        @XmlAttribute
        private String UNIDAD_MEDIDA;
        
        @XmlAttribute
        private String UNIDAD_COMPRA;
        
        @XmlAttribute
	private String CLAVE_ARTICULO;
        
        @XmlAttribute
        private String ES_ALMACENABLE;
        
        @XmlAttribute
        private String ES_JUEGO;
        
        @XmlAttribute
        private String ESTATUS;
        
        @XmlAttribute
        private long GRUPO_LINEA_ID;
        
        @XmlAttribute
        private String NOMBRE_GRUPO_LINEA;
        
        
        public void setArticuloId(long articulo_id) {
            this.ARTICULO_ID = articulo_id;
        }
        
        public void setNombreArticulo(String nombre_articulo) {
            this.NOMBRE_ARTICULO = nombre_articulo;
        }
	
        public void setLineaArticuloId(long linea_articulo_id) {
            this.LINEA_ARTICULO_ID = linea_articulo_id;
        }
        
        public void setNombreLineaArticulo(String nombre_linea_articulo) {
            this.NOMBRE_LINEA_ARTICULO = nombre_linea_articulo;
        }
        
        public void setUnidadMedida(String unidad_medida) {
            this.UNIDAD_MEDIDA = unidad_medida;
        }
        
        public void setUnidadCompra(String unidad_compra) {
            this.UNIDAD_COMPRA = unidad_compra;
        }
        
        public void setClaveArticulo(String clave_articulo) {
            this.CLAVE_ARTICULO = clave_articulo;
        }
        
        public void setEsAlmacenable(String es_almacenable) {
            this.ES_ALMACENABLE = es_almacenable;
        }
        
        public void setEsJuego(String es_juego) {
            this.ES_JUEGO = es_juego;
        }
        
        public void setEstatus(String estatus) {
            this.ESTATUS = estatus;
        }
        
        public void setGrupoLineaId(long grupo_linea_id) {
            this.GRUPO_LINEA_ID = grupo_linea_id;
        }
        
        public void setNombreGrupoLinea(String nombre_grupo_linea) {
            this.NOMBRE_GRUPO_LINEA = nombre_grupo_linea;
        }
        
        public long getArticuloId() {
            return this.ARTICULO_ID;
        }
        
        public String getNombreArticulo() {
            return this.NOMBRE_ARTICULO;
        }
        
        public long getLineaArticuloId() {
            return this.LINEA_ARTICULO_ID;
        }
        
        public String getNombreLineaArticulo() {
            return this.NOMBRE_LINEA_ARTICULO;
        }
        
        public String getUnidadMedida() {
            return this.UNIDAD_MEDIDA;
        }
        
        public String getUnidadCompra() {
            return this.UNIDAD_COMPRA;
        }
        
        public String getClaveArticulo() {
            return this.CLAVE_ARTICULO;                   
        }
        
        public String getEsAlmacenable() {
            return this.ES_ALMACENABLE;
        }
        
        public String getEsJuego() {
            return this.ES_JUEGO;
        }
        
        public String getEstatus() {
            return this.ESTATUS;
        }
        
        public long getGrupoLineaId() {
            return  this.GRUPO_LINEA_ID;
        }
        
        public String getNombreGrupoLinea() {
            return this.NOMBRE_GRUPO_LINEA;
        }
	
	public ListaArticulos() {
		super();
	}
				
}