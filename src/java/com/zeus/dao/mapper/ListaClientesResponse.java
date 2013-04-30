/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.dao.mapper;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//import com.zeus.ws.*;
import com.zeus.domain.ListaClientes;
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name="ListaClientesResponse")
public class ListaClientesResponse implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name= "clientes")
	private List<ListaClientes> ListaClientes;

	public ListaClientesResponse() {
		super();
	}

	public List<ListaClientes> getListaClientes() {
		return ListaClientes;
	}

	public void setListaClientes(List<ListaClientes> ListaClientes) {
		this.ListaClientes = ListaClientes;
	}

	
}

