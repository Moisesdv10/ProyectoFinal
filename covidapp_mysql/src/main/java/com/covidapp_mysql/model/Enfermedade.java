package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the enfermedades database table.
 * 
 */
@Entity
@Table(name = "enfermedades")
public class Enfermedade implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Enfermedade.FIND_ALL";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_enfermedad_serial")
	private int idEnfermedadSerial;

	private String descripcion;

	public Enfermedade() {
	}

	public int getIdEnfermedadSerial() {
		return this.idEnfermedadSerial;
	}

	public void setIdEnfermedadSerial(int idEnfermedadSerial) {
		this.idEnfermedadSerial = idEnfermedadSerial;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}