package br.com.calcard.calsystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_carta_senha_lote")
public class CartaSenhaLote extends BaseEntity implements Serializable {

	// STATUS QUANDO O LOTE DA CARTA SENHA ESTÁ AGENDADO PARA SER GERADO
	public static final String STATUS_AGENDADO = "AGENDADO";

	// STATUS QUANDO O LOTE DA CARTA SENHA ESTÁ SENDO GERADO
	public static final String STATUS_PENDENTE = "PENDENTE";

	// STATUS QUANDO O LOTE DA CARTA SENHA FOI GERADO COM SUCESSO
	public static final String STATUS_DISPONIVEL = "DISPONIVEL";

	private static final long serialVersionUID = -745755550929354246L;

	@ManyToOne
	@JoinColumn(name = "id_estabelecimento", nullable = false, unique = false)
	private Estabelecimento estabelecimento;

	@Column(name = "quantidade_cartas", length = 6, nullable = false, unique = false)
	private int quantidadeCartas;

	public CartaSenhaLote() {
		super();
	}

	public CartaSenhaLote(String status, Estabelecimento estabelecimento,
			int quantidadeCartas) {
		super(status);
		this.estabelecimento = estabelecimento;
		this.quantidadeCartas = quantidadeCartas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((estabelecimento == null) ? 0 : estabelecimento.hashCode());
		result = prime * result + quantidadeCartas;
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
		CartaSenhaLote other = (CartaSenhaLote) obj;
		if (estabelecimento == null) {
			if (other.estabelecimento != null)
				return false;
		} else if (!estabelecimento.equals(other.estabelecimento))
			return false;
		if (quantidadeCartas != other.quantidadeCartas)
			return false;
		return true;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public int getQuantidadeCartas() {
		return quantidadeCartas;
	}

	public void setQuantidadeCartas(int quantidadeCartas) {
		this.quantidadeCartas = quantidadeCartas;
	}

}
