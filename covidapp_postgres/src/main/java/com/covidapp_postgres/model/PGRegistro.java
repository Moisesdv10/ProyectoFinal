package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the registros database table.
 * 
 */
@Entity
@Table(name="registros")

public class PGRegistro implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Registro.FIND_ALL";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_registro")
	private Integer idPersonaEmpresaSerial;

	@Column(name="fecha_ingreso")
	private Timestamp fechaIngreso;

	@Column(name="fecha_salida")
	private Timestamp fechaSalida;

	@Column(name="id_empresa")
	private Integer idEmpresaSerial;

	@Column(name="id_enfermedad")
	private Integer idEnfermedadSerial;

	@Column(name="id_persona")
	private Integer idPersonaSerial;

	private Boolean ingreso;

	private Boolean sintomas;

	private Integer temperatura;

	public PGRegistro() {
	}

	public Integer getIdPersonaEmpresaSerial() {
		return idPersonaEmpresaSerial;
	}

	public void setIdPersonaEmpresaSerial(Integer idPersonaEmpresaSerial) {
		this.idPersonaEmpresaSerial = idPersonaEmpresaSerial;
	}

	public Timestamp getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Timestamp getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Timestamp fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Integer getIdEmpresaSerial() {
		return idEmpresaSerial;
	}

	public void setIdEmpresaSerial(Integer idEmpresaSerial) {
		this.idEmpresaSerial = idEmpresaSerial;
	}

	public Integer getIdEnfermedadSerial() {
		return idEnfermedadSerial;
	}

	public void setIdEnfermedadSerial(Integer idEnfermedadSerial) {
		this.idEnfermedadSerial = idEnfermedadSerial;
	}

	public Integer getIdPersonaSerial() {
		return idPersonaSerial;
	}

	public void setIdPersonaSerial(Integer idPersonaSerial) {
		this.idPersonaSerial = idPersonaSerial;
	}

	public Boolean getIngreso() {
		return ingreso;
	}

	public void setIngreso(Boolean ingreso) {
		this.ingreso = ingreso;
	}

	public Boolean getSintomas() {
		return sintomas;
	}

	public void setSintomas(Boolean sintomas) {
		this.sintomas = sintomas;
	}

	public Integer getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}

	
}