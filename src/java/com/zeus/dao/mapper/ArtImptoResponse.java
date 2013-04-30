/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.dao.mapper;

/**
 *
 * @author Guillermo
 */
import com.zeus.domain.ArtImpto;
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
@XmlRootElement(name="ArtImpto")
public class ArtImptoResponse implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name= "ArtExistencia")
	private List<ArtImpto> ArtImpto;

	public ArtImptoResponse() {
		super();
	}

	public List<ArtImpto> getArtImpto() {
		return ArtImpto;
	}

	public void setArtImpto(List<ArtImpto> ArtImpto) {
		this.ArtImpto = ArtImpto;
	}

	
}