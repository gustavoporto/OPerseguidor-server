package br.com.calcard.calsystem.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class WSEntity {

	private String mensagemRetorno;

	public String getMensagemRetorno() {
		return mensagemRetorno;
	}

	public void setMensagemRetorno(String mensagemRetorno) {
		this.mensagemRetorno = mensagemRetorno;
	}

}
