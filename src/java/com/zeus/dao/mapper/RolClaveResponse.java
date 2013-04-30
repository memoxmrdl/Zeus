/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.dao.mapper;

/**
 *
 * @author Guillermo
 */
import com.zeus.domain.RolClave;
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
@XmlRootElement(name="RolClaveResponse")
public class RolClaveResponse implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name= "RolClave")
	private List<RolClave> RolClave;

	public RolClaveResponse() {
		super();
	}

	public List<RolClave> getRolClave() {
		return RolClave;
	}

	public void setRolClave(List<RolClave> RolClave) {
		this.RolClave = RolClave;
	}

	
}