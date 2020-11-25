package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the historico_decretos database table.
 * 
 */
@Entity
@Table(name = "historico_decretos")
public class HistoricosDecreto implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "HistoricosDecreto.FIND_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_historico_serial")
	private int idHistoricoSerial;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_decreto")
	private Date fechaDecreto;

	@Column(name = "id_ciudad_serial")
	private int idCiudadSerial;

	private String url;

	public HistoricosDecreto() {
	}

	public int getIdHistoricoSerial() {
		return this.idHistoricoSerial;
	}

	public void setIdHistoricoSerial(int idHistoricoSerial) {
		this.idHistoricoSerial = idHistoricoSerial;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaDecreto() {
		return this.fechaDecreto;
	}

	public void setFechaDecreto(Date fechaDecreto) {
		this.fechaDecreto = fechaDecreto;
	}

	public int getIdCiudadSerial() {
		return this.idCiudadSerial;
	}

	public void setIdCiudadSerial(int idCiudadSerial) {
		this.idCiudadSerial = idCiudadSerial;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}