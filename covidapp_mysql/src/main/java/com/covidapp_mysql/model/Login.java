package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the login database table.
 * 
 */
@Entity
@Table(name = "Login")

public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Login.FIND_ALL";

	public static final String FIND_USER_CREDENTIALS_MYSQL = "Login.FIND_USER_CREDENTIALS_MYSQL";
	
	public static final String FIND_USER = "Login.FIND_USER";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_login_serial")
	private int idLoginSerial;

	private String clave;

	private String usuario;

	public Login() {
	}

	public int getIdLoginSerial() {
		return this.idLoginSerial;
	}

	public void setIdLoginSerial(int idLoginSerial) {
		this.idLoginSerial = idLoginSerial;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}