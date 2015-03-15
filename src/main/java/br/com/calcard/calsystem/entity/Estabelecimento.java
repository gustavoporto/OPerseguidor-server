package br.com.calcard.calsystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_estabelecimento")
public class Estabelecimento extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 8447343672383564988L;

	@Column(name = "nome", length = 50, nullable = false, unique = false)
	private String nome;

	@Column(name = "codigo", length = 6, nullable = false, unique = false)
	private String codigo;

	@ManyToOne
	@JoinColumn(name = "id_lojista", nullable = false, unique = false)
	private Lojista lojista;

	public Estabelecimento() {
		super();
	}

	public Estabelecimento(String status, String nome, String codigo,
			Lojista lojista) {
		super(status);
		this.nome = nome;
		this.codigo = codigo;
		this.lojista = lojista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((lojista == null) ? 0 : lojista.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Estabelecimento other = (Estabelecimento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (lojista == null) {
			if (other.lojista != null)
				return false;
		} else if (!lojista.equals(other.lojista))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
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

	public Lojista getLojista() {
		return lojista;
	}

	public void setLojista(Lojista lojista) {
		this.lojista = lojista;
	}

}
