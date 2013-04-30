/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.dao.mapper;

/**
 *
 * @author Guillermo
 */
import com.zeus.domain.ArtPrecio;
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
@XmlRootElement(name="ArtPrecio")
public class ArtPrecioResponse implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name= "ArtPrecio")
	private List<ArtPrecio> ArtPrecio;

	public ArtPrecioResponse() {
		super();
	}

	public List<ArtPrecio> getArtPrecio() {
		return ArtPrecio;
	}

	public void setArtPrecio(List<ArtPrecio> ArtPrecio) {
		this.ArtPrecio = ArtPrecio;
	}

	
}