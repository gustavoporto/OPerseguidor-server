package br.com.calcard.calsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_parametro_global")
public class ParametroGlobal extends BaseEntity {

	public static final String PARAMETRO_LOCAL_CARTA_SENHA = "LOCAL_CARTA_SENHA";

	private static final long serialVersionUID = -5512559889223164201L;

	public static final String TIPO_TEXTO = "TEXTO";

	@Column(name = "nome", length = 20, nullable = false, unique = false)
	private String nome;

	@Column(name = "tipo", length = 10, nullable = false, unique = false)
	private String tipo;

	@Column(name = "valor_texto", length = 50, nullable = false, unique = false)
	private String valorTexto;

	@Column(name = "descricao", length = 200, nullable = true, unique = false)
	private String descricao;

	public ParametroGlobal() {
		super();
	}

	public ParametroGlobal(String status, String nome, String tipo,
			String valorTexto) {
		super(status);
		this.nome = nome;
		this.tipo = tipo;
		this.valorTexto = valorTexto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result
				+ ((valorTexto == null) ? 0 : valorTexto.hashCode());
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
		ParametroGlobal other = (ParametroGlobal) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (valorTexto == null) {
			if (other.valorTexto != null)
				return false;
		} else if (!valorTexto.equals(other.valorTexto))
			return false;
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getValorTexto() {
		return valorTexto;
	}

	public void setValorTexto(String valorTexto) {
		this.valorTexto = valorTexto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
