package br.com.calcard.calsystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_carta_senha")
public class CartaSenha extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7858686878843613447L;

	public static final String STATUS_DISPONIVEL = "DISPONIVEL";
	public static final String STATUS_UTILIZADA = "UTILIZADA";

	@Column(name = "codigo", length = 22, nullable = false, unique = true)
	private String codigo;

	@Column(name = "senha", length = 4, nullable = false, unique = false)
	private String senha;

	@ManyToOne
	@JoinColumn(name = "id_lote", nullable = false, unique = false)
	private CartaSenhaLote lote;

	public CartaSenha() {
		super();
	}

	public CartaSenha(String status, String codigo, String senha,
			CartaSenhaLote lote) {
		super(status);
		this.codigo = codigo;
		this.senha = senha;
		this.lote = lote;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((lote == null) ? 0 : lote.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartaSenha other = (CartaSenha) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (lote == null) {
			if (other.lote != null)
				return false;
		} else if (!lote.equals(other.lote))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public CartaSenhaLote getLote() {
		return lote;
	}

	public void setLote(CartaSenhaLote lote) {
		this.lote = lote;
	}

}
