package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the empresa_login database table.
 * 
 */
@Entity
@Table(name = "empresa_login")
public class EmpresaLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "EmpresasLogin.FIND_ALL";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empresa_login")
	private Integer idEmpresaLogin;

	private int estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_cancelado")
	private Date fechaCancelado;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Column(name = "id_empresa_serial")
	private int idEmpresaSerial;

	@Column(name = "id_login_serial")
	private int idLoginSerial;

	public EmpresaLogin() {
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFechaCancelado() {
		return this.fechaCancelado;
	}

	public void setFechaCancelado(Date fechaCancelado) {
		this.fechaCancelado = fechaCancelado;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getIdEmpresaSerial() {
		return this.idEmpresaSerial;
	}

	public void setIdEmpresaSerial(int idEmpresaSerial) {
		this.idEmpresaSerial = idEmpresaSerial;
	}

	public int getIdLoginSerial() {
		return this.idLoginSerial;
	}

	public void setIdLoginSerial(int idLoginSerial) {
		this.idLoginSerial = idLoginSerial;
	}

}