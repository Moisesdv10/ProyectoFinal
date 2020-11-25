package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the historicos_decretos database table.
 * 
 */
@Entity
@Table(name="historicos_decretos")
public class PGHistoricosDecreto implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "HistoricosDecreto.FIND_ALL";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_historico")
	private Integer idHistoricoSerial;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_decreto")
	private Date fechaDecreto;

	@Column(name="id_ciudad")
	private Integer idCiudadSerial;

	@Column(name="id_decreto")
	private Integer idDecreto;

	private String url;

	public PGHistoricosDecreto() {
	}

	public Integer getIdHistoricoSerial() {
		return idHistoricoSerial;
	}

	public void setIdHistoricoSerial(Integer idHistoricoSerial) {
		this.idHistoricoSerial = idHistoricoSerial;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaDecreto() {
		return fechaDecreto;
	}

	public void setFechaDecreto(Date fechaDecreto) {
		this.fechaDecreto = fechaDecreto;
	}

	public Integer getIdCiudadSerial() {
		return idCiudadSerial;
	}

	public void setIdCiudadSerial(Integer idCiudadSerial) {
		this.idCiudadSerial = idCiudadSerial;
	}

	public Integer getIdDecreto() {
		return idDecreto;
	}

	public void setIdDecreto(Integer idDecreto) {
		this.idDecreto = idDecreto;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

}