package br.com.calcard.calsystem.enums;

public enum TipoTokenEnum {

	LOGIN("login"), ACESSO("acesso");

	private String tipoToken;

	TipoTokenEnum(String tipoToken) {
		this.tipoToken = tipoToken;
	}

	public String getTipoToken() {
		return tipoToken;
	}

}
