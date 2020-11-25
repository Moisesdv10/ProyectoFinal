package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipos_documentos database table.
 * 
 */
@Entity
@Table(name="tipos_documentos")
public class PGTipoDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "PGTipoDocumento.FIND_ALL";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_documento")
	private Integer idTipoDocumentoSerial;

	private String descripcion;

	public PGTipoDocumento() {
	}

	public Integer getIdTipoDocumentoSerial() {
		return idTipoDocumentoSerial;
	}

	public void setIdTipoDocumentoSerial(Integer idTipoDocumentoSerial) {
		this.idTipoDocumentoSerial = idTipoDocumentoSerial;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

}