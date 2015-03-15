package br.com.calcard.calsystem.ws.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.calcard.calsystem.entity.CartaSenhaLote;

public class CartaSenhaLoteDTO implements Serializable {

	private static final long serialVersionUID = 8152320177990478328L;

	private Integer id;

	private EstabelecimentoDTO estabelecimentoDTO;

	private int quantidadeCartas;

	private String status;

	private Date dataRegistro;

	public CartaSenhaLoteDTO() {
		super();
	}

	public CartaSenhaLoteDTO(CartaSenhaLote cartaSenhaLote) {
		this.quantidadeCartas = cartaSenhaLote.getQuantidadeCartas();
		this.estabelecimentoDTO = new EstabelecimentoDTO(
				cartaSenhaLote.getEstabelecimento());
		this.id = cartaSenhaLote.getId();
		this.status = cartaSenhaLote.getStatus();
		this.setDataRegistro(cartaSenhaLote.getDataRegistro());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((getDataRegistro() == null) ? 0 : getDataRegistro()
						.hashCode());
		result = prime
				* result
				+ ((estabelecimentoDTO == null) ? 0 : estabelecimentoDTO
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + quantidadeCartas;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		CartaSenhaLoteDTO other = (CartaSenhaLoteDTO) obj;
		if (getDataRegistro() == null) {
			if (other.getDataRegistro() != null)
				return false;
		} else if (!getDataRegistro().equals(other.getDataRegistro()))
			return false;
		if (estabelecimentoDTO == null) {
			if (other.estabelecimentoDTO != null)
				return false;
		} else if (!estabelecimentoDTO.equals(other.estabelecimentoDTO))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantidadeCartas != other.quantidadeCartas)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public int getQuantidadeCartas() {
		return quantidadeCartas;
	}

	public void setQuantidadeCartas(int quantidadeCartas) {
		this.quantidadeCartas = quantidadeCartas;
	}

	public EstabelecimentoDTO getEstabelecimentoDTO() {
		return estabelecimentoDTO;
	}

	public void setEstabelecimentoDTO(EstabelecimentoDTO estabelecimentoDTO) {
		this.estabelecimentoDTO = estabelecimentoDTO;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

}
