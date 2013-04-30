/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.dao.mapper;

/**
 *
 * @author Guillermo
 */
import com.zeus.domain.ArtExistencia;
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
@XmlRootElement(name="ArtExistencia")
public class ArtExistenciaResponse implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name= "ArtExistencia")
	private List<ArtExistencia> ArtExistencia;

	public ArtExistenciaResponse() {
		super();
	}

	public List<ArtExistencia> getArtExistencia() {
		return ArtExistencia;
	}

	public void setArtExistencia(List<ArtExistencia> ArtExistencia) {
		this.ArtExistencia = ArtExistencia;
	}

	
}