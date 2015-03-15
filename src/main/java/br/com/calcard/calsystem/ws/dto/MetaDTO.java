package br.com.calcard.calsystem.ws.dto;

import java.io.Serializable;
import java.util.List;

public class MetaDTO implements Serializable {

	private static final long serialVersionUID = -1272369662234855130L;

	private MetaEstabelecimentoDTO metaEstabelecimentoDTO;

	private List<MetaDepartamentoDTO> metasDepartamentoDTO;

	public MetaDTO(MetaEstabelecimentoDTO metaEstabelecimentoDTO,
			List<MetaDepartamentoDTO> metasDepartamentoDTO) {

		this.metaEstabelecimentoDTO = metaEstabelecimentoDTO;
		this.metasDepartamentoDTO = metasDepartamentoDTO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((metaEstabelecimentoDTO == null) ? 0
						: metaEstabelecimentoDTO.hashCode());
		result = prime
				* result
				+ ((metasDepartamentoDTO == null) ? 0 : metasDepartamentoDTO
						.hashCode());
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
		MetaDTO other = (MetaDTO) obj;
		if (metaEstabelecimentoDTO == null) {
			if (other.metaEstabelecimentoDTO != null)
				return false;
		} else if (!metaEstabelecimentoDTO.equals(other.metaEstabelecimentoDTO))
			return false;
		if (metasDepartamentoDTO == null) {
			if (other.metasDepartamentoDTO != null)
				return false;
		} else if (!metasDepartamentoDTO.equals(other.metasDepartamentoDTO))
			return false;
		return true;
	}

	public MetaEstabelecimentoDTO getMetaEstabelecimentoDTO() {
		return metaEstabelecimentoDTO;
	}

	public void setMetaEstabelecimentoDTO(
			MetaEstabelecimentoDTO metaEstabelecimentoDTO) {
		this.metaEstabelecimentoDTO = metaEstabelecimentoDTO;
	}

	public List<MetaDepartamentoDTO> getMetasDepartamentoDTO() {
		return metasDepartamentoDTO;
	}

	public void setMetasDepartamentoDTO(
			List<MetaDepartamentoDTO> metasDepartamentoDTO) {
		this.metasDepartamentoDTO = metasDepartamentoDTO;
	}

}
