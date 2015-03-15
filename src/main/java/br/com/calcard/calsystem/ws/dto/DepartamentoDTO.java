package br.com.calcard.calsystem.ws.dto;

import java.io.Serializable;

import br.com.calcard.calsystem.entity.Departamento;

public class DepartamentoDTO implements Serializable {

	private static final long serialVersionUID = -6095394125839202241L;

	private Integer id;

	private String descricao;

	public DepartamentoDTO() {

	}

	public DepartamentoDTO(Departamento departamento) {
		this.id = departamento.getId();
		this.descricao = departamento.getDescricao();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		DepartamentoDTO other = (DepartamentoDTO) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
