package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the empresas_logins database table.
 * 
 */
@Entity
@Table(name="empresas_login")

public class PGEmpresasLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "EmpresasLogin.FIND_ALL";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empresa_login")
	private Integer idEmpresaLogin;

	private Integer estado;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="fecha_retiro")
	private Timestamp fechaCancelado;

	@Column(name="id_empresa")
	private Integer idEmpresaSerial;

	@Column(name="id_login")
	private Integer idLoginSerial;

	public PGEmpresasLogin() {
	}

	public Integer getIdEmpresaLogin() {
		return idEmpresaLogin;
	}

	public void setIdEmpresaLogin(Integer idEmpresaLogin) {
		this.idEmpresaLogin = idEmpresaLogin;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaCancelado() {
		return fechaCancelado;
	}

	public void setFechaCancelado(Timestamp fechaCancelado) {
		this.fechaCancelado = fechaCancelado;
	}

	public Integer getIdEmpresaSerial() {
		return idEmpresaSerial;
	}

	public void setIdEmpresaSerial(Integer idEmpresaSerial) {
		this.idEmpresaSerial = idEmpresaSerial;
	}

	public Integer getIdLoginSerial() {
		return idLoginSerial;
	}

	public void setIdLoginSerial(Integer idLoginSerial) {
		this.idLoginSerial = idLoginSerial;
	}

	
}