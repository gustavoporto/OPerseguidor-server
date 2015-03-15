package br.com.calcard.calsystem.ws.dto;

import java.io.Serializable;
import java.util.List;

public class MetaAtivacaoDTO implements Serializable {

	private static final long serialVersionUID = -8086501228997694160L;

	private EstabelecimentoDTO estabelecimento;

	private int quantidade;

	private List<MetaDepartamentoDTO> metaDepartamentos;

	public MetaAtivacaoDTO(EstabelecimentoDTO estabelecimento, int quantidade) {
		this.estabelecimento = estabelecimento;
		this.quantidade = quantidade;
	}

	public MetaAtivacaoDTO(EstabelecimentoDTO estabelecimento, int quantidade,
			List<MetaDepartamentoDTO> metaDepartamentos) {
		this.estabelecimento = estabelecimento;
		this.quantidade = quantidade;
		this.metaDepartamentos = metaDepartamentos;
	}

	public EstabelecimentoDTO getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(EstabelecimentoDTO estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public List<MetaDepartamentoDTO> getMetaDepartamento() {
		return metaDepartamentos;
	}

	public void setMetaDepartamento(List<MetaDepartamentoDTO> metaDepartamentos) {
		this.metaDepartamentos = metaDepartamentos;
	}

}
