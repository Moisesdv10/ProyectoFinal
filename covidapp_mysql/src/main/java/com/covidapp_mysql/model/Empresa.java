package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the empresas database table.
 * 
 */
@Entity
@Table(name = "empresas")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Empresa.FIND_ALL";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empresa_serial")
	private int idEmpresaSerial;

	@Column(name = "cantidad_empleados")
	private int cantidadEmpleados;

	private String direccion;

	private String email;

	private int nit;

	private String nombres;

	@Column(name = "numero_verificacion")
	private int numeroVerificacion;

	private String representante;

	private BigDecimal telefono;

	public Empresa() {
	}

	public int getIdEmpresaSerial() {
		return this.idEmpresaSerial;
	}

	public void setIdEmpresaSerial(int idEmpresaSerial) {
		this.idEmpresaSerial = idEmpresaSerial;
	}

	public int getCantidadEmpleados() {
		return this.cantidadEmpleados;
	}

	public void setCantidadEmpleados(int cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNit() {
		return this.nit;
	}

	public void setNit(int nit) {
		this.nit = nit;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public int getNumeroVerificacion() {
		return this.numeroVerificacion;
	}

	public void setNumeroVerificacion(int numeroVerificacion) {
		this.numeroVerificacion = numeroVerificacion;
	}

	public String getRepresentante() {
		return this.representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public BigDecimal getTelefono() {
		return this.telefono;
	}

	public void setTelefono(BigDecimal telefono) {
		this.telefono = telefono;
	}

}