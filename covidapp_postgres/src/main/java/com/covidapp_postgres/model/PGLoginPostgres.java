package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the login database table.
 * 
 */
@Entity
@Table(name="login")
public class PGLoginPostgres implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "LoginPostgres.FIND_ALL";
	public static final String FIND_USER_CREDENTIALS_POSTGRESQL = "PGLoginPostgres.FIND_USER_CREDENTIALS_POSTGRESQL";
	public static final String FIND_USER = "LoginPostgres.FIND_USER";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_login")
	private Integer idLoginSerial;

	private String clave;

	private String usuario;

	public PGLoginPostgres() {
	}

	public Integer getIdLoginSerial() {
		return idLoginSerial;
	}

	public void setIdLoginSerial(Integer idLoginSerial) {
		this.idLoginSerial = idLoginSerial;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}