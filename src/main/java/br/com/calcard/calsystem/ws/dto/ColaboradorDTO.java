package br.com.calcard.calsystem.ws.dto;

import java.io.Serializable;

public class ColaboradorDTO implements Serializable {

	private static final long serialVersionUID = -1955886781371137293L;

	private UsuarioDTO usuario;

	private DepartamentoDTO departamento;

	public ColaboradorDTO(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public DepartamentoDTO getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoDTO departamento) {
		this.departamento = departamento;
	}

}
