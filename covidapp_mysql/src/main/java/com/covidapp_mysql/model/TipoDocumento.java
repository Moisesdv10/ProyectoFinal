package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tipo_documentos database table.
 * 
 */
@Entity
@Table(name = "tipo_documentos")

public class TipoDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "TipoDocumento.FIND_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_documento_serial")
	private int idTipoDocumentoSerial;

	private String descripcion;

	public TipoDocumento() {
	}

	public int getIdTipoDocumentoSerial() {
		return this.idTipoDocumentoSerial;
	}

	public void setIdTipoDocumentoSerial(int idTipoDocumentoSerial) {
		this.idTipoDocumentoSerial = idTipoDocumentoSerial;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}