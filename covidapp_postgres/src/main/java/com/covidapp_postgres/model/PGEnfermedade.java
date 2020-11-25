package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the enfermedades database table.
 * 
 */
@Entity
@Table(name="enfermedades")
public class PGEnfermedade implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Enfermedade.FIND_ALL";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_enfermedad")
	private Integer idEnfermedadSerial;

	private String descripcion;

	public PGEnfermedade() {
	}

	public Integer getIdEnfermedadSerial() {
		return idEnfermedadSerial;
	}

	public void setIdEnfermedadSerial(Integer idEnfermedadSerial) {
		this.idEnfermedadSerial = idEnfermedadSerial;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}