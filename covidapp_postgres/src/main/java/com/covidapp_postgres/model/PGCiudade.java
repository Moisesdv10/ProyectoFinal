package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ciudades database table.
 * 
 */
@Entity
@Table(name="ciudades")
@NamedQuery(name="PGCiudade.findAll", query="SELECT c FROM PGCiudade c")
public class PGCiudade implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Ciudade.FIND_ALL";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ciudad")
	private Integer idCiudadSerial;

	@Column(name="id_departamento")
	private Integer idDepartamento;

	private String nombre;

	public PGCiudade() {
	}

	public Integer getIdCiudad() {
		return this.idCiudadSerial;
	}

	public void setIdCiudad(Integer idCiudadSerial) {
		this.idCiudadSerial = idCiudadSerial;
	}

	public Integer getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}