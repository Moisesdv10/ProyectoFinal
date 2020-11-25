package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the decretos database table.
 * 
 */
@Entity
@Table(name = "decretos")
public class Decreto implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Decreto.FIND_ALL";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_decreto_serial")
	private int idDecretoSerial;

	private String descripcion;

	@Column(name = "id_historico_serial")
	private int idHistoricoSerial;

	@Column(name = "numero_decreto")
	private String numeroDecreto;

	public Decreto() {
	}

	public int getIdDecretoSerial() {
		return this.idDecretoSerial;
	}

	public void setIdDecretoSerial(int idDecretoSerial) {
		this.idDecretoSerial = idDecretoSerial;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdHistoricoSerial() {
		return this.idHistoricoSerial;
	}

	public void setIdHistoricoSerial(int idHistoricoSerial) {
		this.idHistoricoSerial = idHistoricoSerial;
	}

	public String getNumeroDecreto() {
		return this.numeroDecreto;
	}

	public void setNumeroDecreto(String numeroDecreto) {
		this.numeroDecreto = numeroDecreto;
	}

}