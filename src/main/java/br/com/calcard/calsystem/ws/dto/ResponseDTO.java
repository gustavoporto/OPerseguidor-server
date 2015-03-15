package br.com.calcard.calsystem.ws.dto;

import java.io.Serializable;
import java.util.Map;

public class ResponseDTO implements Serializable {

	private static final long serialVersionUID = 8016500450900808522L;

	private Map<Object, Object> objeto;

	private String codigoExecucao;

	private String mensagemExecucao;

	public ResponseDTO() {
		super();
	}

	public ResponseDTO(Map<Object, Object> objeto, String codigoExecucao,
			String mensagemExecucao) {
		super();
		this.objeto = objeto;
		this.codigoExecucao = codigoExecucao;
		this.mensagemExecucao = mensagemExecucao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoExecucao == null) ? 0 : codigoExecucao.hashCode());
		result = prime
				* result
				+ ((mensagemExecucao == null) ? 0 : mensagemExecucao.hashCode());
		result = prime * result + ((objeto == null) ? 0 : objeto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseDTO other = (ResponseDTO) obj;
		if (codigoExecucao == null) {
			if (other.codigoExecucao != null)
				return false;
		} else if (!codigoExecucao.equals(other.codigoExecucao))
			return false;
		if (mensagemExecucao == null) {
			if (other.mensagemExecucao != null)
				return false;
		} else if (!mensagemExecucao.equals(other.mensagemExecucao))
			return false;
		if (objeto == null) {
			if (other.objeto != null)
				return false;
		} else if (!objeto.equals(other.objeto))
			return false;
		return true;
	}

	public String getCodigoExecucao() {
		return codigoExecucao;
	}

	public void setCodigoExecucao(String codigoExecucao) {
		this.codigoExecucao = codigoExecucao;
	}

	public String getMensagemExecucao() {
		return mensagemExecucao;
	}

	public void setMensagemExecucao(String mensagemExecucao) {
		this.mensagemExecucao = mensagemExecucao;
	}

	public Map<Object, Object> getObjeto() {
		return objeto;
	}

	public void setObjeto(Map<Object, Object> objeto) {
		this.objeto = objeto;
	}

}
