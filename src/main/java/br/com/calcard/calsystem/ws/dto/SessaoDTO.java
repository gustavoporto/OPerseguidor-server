package br.com.calcard.calsystem.ws.dto;

import java.io.Serializable;

import br.com.calcard.calsystem.entity.Usuario;

public class SessaoDTO implements Serializable {

	private static final long serialVersionUID = -7041594493956842356L;

	private Long id;

	private UsuarioDTO usuario;

	public SessaoDTO(Long id, Usuario usuario) {
		super();
		this.id = id;
		this.usuario = new UsuarioDTO(usuario);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

}
