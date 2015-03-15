package br.com.calcard.calsystem.ws.dto;

import java.io.Serializable;

import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.ws.LojistaDTO;

public class EstabelecimentoDTO implements Serializable {

	private static final long serialVersionUID = -8583664453323257538L;

	private Integer id;

	private String nome;

	private LojistaDTO lojistaDTO;

	public EstabelecimentoDTO(Estabelecimento estabelecimento) {
		this.id = estabelecimento.getId();
		this.nome = estabelecimento.getNome();
		this.lojistaDTO = new LojistaDTO(estabelecimento.getLojista());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lojistaDTO == null) ? 0 : lojistaDTO.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		EstabelecimentoDTO other = (EstabelecimentoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lojistaDTO == null) {
			if (other.lojistaDTO != null)
				return false;
		} else if (!lojistaDTO.equals(other.lojistaDTO))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
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

	public LojistaDTO getLojistaDTO() {
		return lojistaDTO;
	}

	public void setLojistaDTO(LojistaDTO lojistaDTO) {
		this.lojistaDTO = lojistaDTO;
	}

}
