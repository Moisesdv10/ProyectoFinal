package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the decretos database table.
 * 
 */
@Entity
@Table(name="decretos")
public class PGDecreto implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Decreto.FIND_ALL";
	//Falta unos datos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_decreto")
	private Integer idDecretoSerial;

	@Column (name = "descripcio")
	private String descripcion;

	@Column(name="numero_decreto")
	private String numeroDecreto;

	public PGDecreto() {
	}

	public Integer getIdDecretoSerial() {
		return this.idDecretoSerial;
	}

	public void setIdDecreto(Integer idDecretoSerial) {
		this.idDecretoSerial = idDecretoSerial;
	}

	public String getDescripcio() {
		return this.descripcion;
	}

	public void setDescripcio(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNumeroDecreto() {
		return this.numeroDecreto;
	}

	public void setNumeroDecreto(String numeroDecreto) {
		this.numeroDecreto = numeroDecreto;
	}

}