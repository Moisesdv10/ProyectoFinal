package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the registros database table.
 * 
 */
@Entity
@Table(name = "registros")
public class Registro implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Registro.FIND_ALL";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int idPersonaEmpresaSerial;

	@Temporal(TemporalType.TIMESTAMP)

	private Date fechaIngreso;

	@Temporal(TemporalType.TIMESTAMP)

	private Date fechaSalida;


	private int idEmpresaSerial;


	private int idEnfermedadSerial;


	private int idPersonaSerial;

	private byte ingreso;

	private byte sintomas;

	private int temperatura;

	public Registro() {
	}

	public int getIdPersonaEmpresaSerial() {
		return this.idPersonaEmpresaSerial;
	}

	public void setIdPersonaEmpresaSerial(int idPersonaEmpresaSerial) {
		this.idPersonaEmpresaSerial = idPersonaEmpresaSerial;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getIdEmpresaSerial() {
		return this.idEmpresaSerial;
	}

	public void setIdEmpresaSerial(int idEmpresaSerial) {
		this.idEmpresaSerial = idEmpresaSerial;
	}

	public int getIdEnfermedadSerial() {
		return this.idEnfermedadSerial;
	}

	public void setIdEnfermedadSerial(int idEnfermedadSerial) {
		this.idEnfermedadSerial = idEnfermedadSerial;
	}

	public int getIdPersonaSerial() {
		return this.idPersonaSerial;
	}

	public void setIdPersonaSerial(int idPersonaSerial) {
		this.idPersonaSerial = idPersonaSerial;
	}

	public byte getIngreso() {
		return this.ingreso;
	}

	public void setIngreso(byte ingreso) {
		this.ingreso = ingreso;
	}

	public byte getSintomas() {
		return this.sintomas;
	}

	public void setSintomas(byte sintomas) {
		this.sintomas = sintomas;
	}

	public int getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

}