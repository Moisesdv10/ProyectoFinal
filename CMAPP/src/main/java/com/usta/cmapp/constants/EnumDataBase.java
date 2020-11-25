package com.usta.cmapp.constants;

/**
 * Contiene valores constantes que jamás van a cambiar en la aplicación
 * 
 * @author Moises Villalba
 *
 */
public enum EnumDataBase {

	MYSQL(1, "mysql"), POSTGRESQL(2, "postgresql");

	private int id;

	private String description;

	private EnumDataBase(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}


}
