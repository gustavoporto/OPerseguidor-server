package br.com.calcard.calsystem.ws.dto.cartao;

import java.io.Serializable;

public class CadastroSenhaDTO implements Serializable {

	private static final long serialVersionUID = -566991223192493172L;

	private Integer idCartao;

	private Integer idCartaSenha;

	private Integer idUsuario;

	public CadastroSenhaDTO() {
		super();
	}

	public CadastroSenhaDTO(Integer idCartao, Integer idCartaSenha,
			Integer idUsuario) {
		super();
		this.idCartao = idCartao;
		this.idCartaSenha = idCartaSenha;
		this.idUsuario = idUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCartaSenha == null) ? 0 : idCartaSenha.hashCode());
		result = prime * result
				+ ((idCartao == null) ? 0 : idCartao.hashCode());
		result = prime * result
				+ ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		CadastroSenhaDTO other = (CadastroSenhaDTO) obj;
		if (idCartaSenha == null) {
			if (other.idCartaSenha != null)
				return false;
		} else if (!idCartaSenha.equals(other.idCartaSenha))
			return false;
		if (idCartao == null) {
			if (other.idCartao != null)
				return false;
		} else if (!idCartao.equals(other.idCartao))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}

	public Integer getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(Integer idCartao) {
		this.idCartao = idCartao;
	}

	public Integer getIdCartaSenha() {
		return idCartaSenha;
	}

	public void setIdCartaSenha(Integer idCartaSenha) {
		this.idCartaSenha = idCartaSenha;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

}
