package br.com.calcard.calsystem.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_proposta_ativada", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"id_usuario", "id_estabelecimento", "data_ativacao", }) })
public class PropostaAtivada extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -6212633196315466148L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = 18, nullable = false, unique = true)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false, unique = false)
	private Usuario usuario;

	@Column(name = "quantidade", length = 3, nullable = false, unique = false)
	private int quantidade;

	@Column(name = "data_ativacao", unique = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAtivacao;

	@ManyToOne
	@JoinColumn(name = "id_estabelecimento", nullable = false, unique = false)
	private Estabelecimento estabelecimento;

	public PropostaAtivada() {
		super();
	}

	public PropostaAtivada(Usuario usuario, int quantidade, Date dataAtivacao,
			Estabelecimento estabelecimento) {
		super();
		this.usuario = usuario;
		this.quantidade = quantidade;
		this.setDataAtivacao(dataAtivacao);
		this.setEstabelecimento(estabelecimento);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataAtivacao == null) ? 0 : dataAtivacao.hashCode());
		result = prime * result
				+ ((estabelecimento == null) ? 0 : estabelecimento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + quantidade;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		PropostaAtivada other = (PropostaAtivada) obj;
		if (dataAtivacao == null) {
			if (other.dataAtivacao != null)
				return false;
		} else if (!dataAtivacao.equals(other.dataAtivacao))
			return false;
		if (estabelecimento == null) {
			if (other.estabelecimento != null)
				return false;
		} else if (!estabelecimento.equals(other.estabelecimento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantidade != other.quantidade)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Date getDataAtivacao() {
		return dataAtivacao;
	}

	public void setDataAtivacao(Date dataAtivacao) {
		this.dataAtivacao = dataAtivacao;
	}

}
