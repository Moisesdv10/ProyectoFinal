package com.covidapp_mysql.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the personas database table.
 * 
 */
@Entity
@Table(name = "personas")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Persona.FIND_ALL";
	public static final String FIND_BY_DOCUMENT = "Persona.FIND_BY_DOCUMENT";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona_serial")
	private int idPersonaSerial;

	private String clave;

	private String documento;

	private String email;

	private String estatura;

	private BigDecimal cellPhone;
	

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	private String genero;

	@Column(name = "grupo_sanguineo")
	private String grupoSanguineo;

	@Column(name = "id_ciudad_serial")
	private int idCiudadSerial;

	@Column(name = "id_tipo_documento_serial")
	private int idTipoDocumentoSerial;

	@Column(name = "lugar_nacimiento")
	private int lugarNacimiento;

	private Integer peso;

	@Column(name = "primer_apellido")
	private String primerApellido;

	@Column(name = "primer_nombre")
	private String primerNombre;

	@Column(name = "segundo_apellido")
	private String segundoApellido;

	@Column(name = "segundo_nombre")
	private String segundoNombre;

	private String telefono;

	@Column(name = "tipo_documento")
	private int tipoDocumento;

	private String rhBlood;

	public Persona() {
	}

	public int getIdPersonaSerial() {
		return idPersonaSerial;
	}

	public void setIdPersonaSerial(int idPersonaSerial) {
		this.idPersonaSerial = idPersonaSerial;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public String getEstatura() {
		return estatura;
	}

	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}

	public int getIdCiudadSerial() {
		return idCiudadSerial;
	}

	public void setIdCiudadSerial(int idCiudadSerial) {
		this.idCiudadSerial = idCiudadSerial;
	}

	public int getIdTipoDocumentoSerial() {
		return idTipoDocumentoSerial;
	}

	public void setIdTipoDocumentoSerial(int idTipoDocumentoSerial) {
		this.idTipoDocumentoSerial = idTipoDocumentoSerial;
	}

	public int getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(int lugarNacimiento) {
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(int tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getRhBlood() {
		return rhBlood;
	}

	public void setRhBlood(String rhBlood) {
		this.rhBlood = rhBlood;
	}

	public BigDecimal getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(BigDecimal cellPhone) {
		this.cellPhone = cellPhone;
	}

}