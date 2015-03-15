package br.com.calcard.calsystem.ws.dto;

import java.io.Serializable;

import br.com.calcard.calsystem.entity.Perfil;

public class PerfilDTO implements Serializable {

	private static final long serialVersionUID = -3140915740300373474L;

	private Integer id;

	private String nome;

	private String codigo;

	public PerfilDTO() {
		super();
	}

	public PerfilDTO(Perfil perfil) {
		super();
		this.id = perfil.getId();
		this.nome = perfil.getNome();
		this.codigo = perfil.getCodigo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
