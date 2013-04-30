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
@XmlRootElement(name="ListaClientes")
public class ListaClientes implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;

	@XmlAttribute
	private String CLIENTE_ID;
        
        @XmlAttribute
        private String NOMBRE_CLIENTE;
        
        @XmlAttribute
        private String CONTACTO1;
        
        @XmlAttribute
        private String CONTACTO2;
        
        @XmlAttribute
        private String ESTATUS;
        
        @XmlAttribute
        private String LIMITE_CREDITO;
        
        @XmlAttribute
        private String MONEDA_ID;
        
        @XmlAttribute
        private String NOMBRE_MONEDA;
        
        @XmlAttribute
        private String COND_PAGO_ID;
        
        @XmlAttribute
        private String NOMBRE_COND_PAGO;
        
        @XmlAttribute
        private String TIPO_CLIENTE_ID;
        
        @XmlAttribute
        private String NOMBRE_TIPO_CLIENTE;
        
        @XmlAttribute
        private String ZONA_CLIENTE_ID;
        
        @XmlAttribute
        private String NOMBRE_ZONA_CLIENTE;
        
        @XmlAttribute
        private String COBRADOR_ID;
        
        @XmlAttribute
        private String NOMBRE_COBRADOR;
        
        @XmlAttribute
        private String VENDEDOR_ID;
        
        @XmlAttribute
        private String NOMBRE_VENDEDOR;
        
        @XmlAttribute
        private String CLAVE_CLIENTE;
        
        
        public void setClienteId(String cliente_id) {
            this.CLIENTE_ID = cliente_id;                     
        }
        
        public void setNombreCliente(String nombre_cliente) {
            this.NOMBRE_CLIENTE = nombre_cliente;
        }
        
        public void setContacto1(String contacto1) {
            this.CONTACTO1 = contacto1;
        }
        
        public void setContacto2(String contacto2) {
            this.CONTACTO2 = contacto2;
        }
        
        public void setEstatus(String estatus) {
            this.ESTATUS = estatus;
        }
        
        public void setLimiteCredito(String limite_credito) {
            this.LIMITE_CREDITO = limite_credito;
        }
        
        public void setMonedaId(String moneda_id) {
            this.MONEDA_ID = moneda_id;
        }
        
        public void setNombreMoneda(String nombre_moneda) {
            this.NOMBRE_MONEDA = nombre_moneda;
        }
        
        public void setCondPagoId(String cond_pago_id) {
            this.COND_PAGO_ID = cond_pago_id;
        }        
        
        public void setNombreCondPago(String nombre_cond_pago) {
            this.NOMBRE_COND_PAGO = nombre_cond_pago;
        }
        
        public void setTipoClienteId(String tipo_cliente_id) {
            this.TIPO_CLIENTE_ID = tipo_cliente_id;
        }
        
        public void setNombreTipoCliente(String nombre_tipo_cliente) {
            this.NOMBRE_TIPO_CLIENTE = nombre_tipo_cliente;
        }
        
        public void setZonaClienteId(String zona_cliente_id) {
            this.ZONA_CLIENTE_ID = zona_cliente_id;
        }
        
        public void setNombreZonaCliente(String nombre_zona_cliente) {
            this.NOMBRE_ZONA_CLIENTE = nombre_zona_cliente;
        }
        
        public void setCobradorId(String cobrador_id) {
            this.COBRADOR_ID = cobrador_id;
        }
        
        public void setNombreCobrador(String nombre_cobrador) {
            this.NOMBRE_COBRADOR = nombre_cobrador;
        }
        
        public void setVendedorId(String vendedor_id) {
            this.VENDEDOR_ID = vendedor_id;
        }
        
        public void setNombreVendedor(String nombre_vendedor) {
            this.NOMBRE_VENDEDOR = nombre_vendedor;
        }
            
        public void setClaveCliente(String clave_cliente) {
            this.CLAVE_CLIENTE = clave_cliente;
        }
        
        public String getClienteId() {
            return this.CLIENTE_ID;
        }
        
        public String getNombreCliente() {
            return this.NOMBRE_CLIENTE;
        }   
        
        public String getContacto1() {
            return this.CONTACTO1;
        }
        
        public String getContacto2() {
            return this.CONTACTO2;
        }
        
        public String getEstatus() {
            return this.ESTATUS;
        }
        
        public String getLimiteCredito() {
            return this.LIMITE_CREDITO;
        }
        
        public String getMonedaId() {
            return this.MONEDA_ID;               
        }
        
        public String getNombreMoneda() {
            return this.NOMBRE_MONEDA;
        }
        
        public String getCondPagoId() {
            return this.COND_PAGO_ID;
        }                
        
        public String getNombreCondPago() {
            return this.NOMBRE_COND_PAGO;
        }
        
        public String getTipoClienteId() {
            return this.TIPO_CLIENTE_ID;
        }
        
        public String getNombreTipoCliente() {
            return this.NOMBRE_TIPO_CLIENTE;
        }
        
        public String getZonaClienteId() {
            return this.ZONA_CLIENTE_ID;
        }
        
        public String getNombreZonaCliente() {
            return this.NOMBRE_ZONA_CLIENTE;
        }
        
        public String getCobradorId() {
            return this.COBRADOR_ID;
        }
        
        public String getNombreCobrador() {
            return this.NOMBRE_COBRADOR;
        }
        
        public String getVendedorId() {
            return this.VENDEDOR_ID;
        }
        
        public String getNombreVendedor() {
            return this.NOMBRE_VENDEDOR;
        }      
        
        public String getClaveCliente() {
            return this.CLAVE_CLIENTE;
        }
	
	public ListaClientes() {
		super();
		// TODO Auto-generated constructor stub
	}
				
}