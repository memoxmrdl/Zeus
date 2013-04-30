/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.dao.mapper;

import com.zeus.domain.zmUsers;
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
@XmlRootElement(name="zmUsersResponse")
public class zmUsersResponse implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name= "zmUsers")
	private List<zmUsers> zmUsers;

	public zmUsersResponse() {
		super();
	}

	public List<zmUsers> getzmUsers() {
		return zmUsers;
	}

	public void setzmUsers(List<zmUsers> zmUsers) {
		this.zmUsers = zmUsers;
	}

	
}