package com.usta.cmapp.constants;

public enum EnumRhBlood {

	ABPOS("AB+", "AB POS"), ABNEG("AB-", "AB NEG"), APOS("A+", "A POS"), ANEG("A-", "A NEG"), BPOS("B+", "B POS"),
	BNEG("B-", "B NEG"), OPOS("O+", "O POS"), ONEG("O-", "O NEG");

	private String id;
	private String descripcion;

	private EnumRhBlood(String id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}


}
