package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the empresas database table.
 * 
 */
@Entity
@Table(name="empresas")

public class PGEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Empresa.FIND_ALL";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empresa")
	private Integer idEmpresaSerial;

	@Column(name="cantidad_empleados")
	private Integer cantidadEmpleados;

	private String direccion;

	private String email;

	private BigDecimal nit;

	@Column(name="nombre_empresa")
	private String nombreEmpresa;

	@Column(name="numero_verificacion")
	private Integer numeroVerificacion;

	private String representante;

	private BigDecimal telefono;

	public PGEmpresa() {
	}

	public Integer getIdEmpresaSerial() {
		return idEmpresaSerial;
	}

	public void setIdEmpresaSerial(Integer idEmpresaSerial) {
		this.idEmpresaSerial = idEmpresaSerial;
	}

	public Integer getCantidadEmpleados() {
		return cantidadEmpleados;
	}

	public void setCantidadEmpleados(Integer cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getNit() {
		return nit;
	}

	public void setNit(BigDecimal nit) {
		this.nit = nit;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public Integer getNumeroVerificacion() {
		return numeroVerificacion;
	}

	public void setNumeroVerificacion(Integer numeroVerificacion) {
		this.numeroVerificacion = numeroVerificacion;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public BigDecimal getTelefono() {
		return telefono;
	}

	public void setTelefono(BigDecimal telefono) {
		this.telefono = telefono;
	}

	

}