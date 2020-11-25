package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ciudades database table.
 * 
 */
@Entity
@Table(name = "ciudades")
public class Ciudade implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Ciudade.FIND_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ciudad_serial")
	private int idCiudadSerial;

	@Column(name = "id_departamento")
	private int idDepartamento;

	private String nombre;

	public Ciudade() {
	}

	public int getIdCiudadSerial() {
		return this.idCiudadSerial;
	}

	public void setIdCiudadSerial(int idCiudadSerial) {
		this.idCiudadSerial = idCiudadSerial;
	}

	public int getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}