package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the personas database table.
 * 
 */
@Entity
@Table(name="personas")

public class PGPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Persona.FIND_ALL";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona")
	private Integer idPersonaSerial;

	private String documento;

	private String email;

	private Integer estatura;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private Integer genero;

	@Column(name="grupo_sangineo")
	private String grupoSangineo;

	@Column(name="lugar_nacimiento")
	private Integer lugarNacimiento;

	private Integer peso;

	@Column(name="primer_apellido")
	private String primerApellido;

	@Column(name="primer_nombre")
	private String primerNombre;

	@Column(name="segundo_apellido")
	private String segundoApellido;

	@Column(name="segundo_nombre")
	private String segundoNombre;

	private BigDecimal telefono;

	@Column(name="tipo_documento")
	private Integer tipoDocumento;

	public PGPersona() {
	}

	public Integer getIdPersonaSerial() {
		return idPersonaSerial;
	}

	public void setIdPersonaSerial(Integer idPersonaSerial) {
		this.idPersonaSerial = idPersonaSerial;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEstatura() {
		return estatura;
	}

	public void setEstatura(Integer estatura) {
		this.estatura = estatura;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getGenero() {
		return genero;
	}

	public void setGenero(Integer genero) {
		this.genero = genero;
	}

	public String getGrupoSangineo() {
		return grupoSangineo;
	}

	public void setGrupoSangineo(String grupoSangineo) {
		this.grupoSangineo = grupoSangineo;
	}

	public Integer getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(Integer lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public BigDecimal getTelefono() {
		return telefono;
	}

	public void setTelefono(BigDecimal telefono) {
		this.telefono = telefono;
	}

	public Integer getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	

}