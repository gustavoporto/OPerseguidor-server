package br.com.calcard.calsystem.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.calsystem.entity.MetaDepartamento;
import br.com.calcard.calsystem.entity.MetaEstabelecimento;
import br.com.calcard.calsystem.ws.dto.MetaDTO;
import br.com.calcard.calsystem.ws.dto.MetaDepartamentoDTO;
import br.com.calcard.calsystem.ws.dto.MetaEstabelecimentoDTO;

@RestController
@RequestMapping("/ws/metas")
public class MetaWS extends AbstractWS<MetaWS> {

	public MetaWS() {
		super(MetaWS.class);
	}

	@RequestMapping(value = "/metaDTO", method = RequestMethod.GET, produces = "application/json")
	public MetaDTO doGetDTO(
			@RequestParam(value = "idEstabelecimento") int idEstabelecimento) {
		logger.info("Método: doGetDTO");

		MetaEstabelecimento metaEstabelecimento = metaService
				.doGetMetaEstabelecimento(idEstabelecimento);

		MetaEstabelecimentoDTO metaEstabelecimentoDTO = new MetaEstabelecimentoDTO(
				metaEstabelecimento);

		List<MetaDepartamento> metasDepartamento = metaService
				.doListMetaDepartamento(metaEstabelecimento.getId());
		List<MetaDepartamentoDTO> metasDepartamentoDTO = new ArrayList<MetaDepartamentoDTO>();
		for (MetaDepartamento meta : metasDepartamento) {
			MetaDepartamentoDTO metaDepartamentoDTO = new MetaDepartamentoDTO(
					meta);
			metasDepartamentoDTO.add(metaDepartamentoDTO);
		}

		MetaDTO metaDTO = new MetaDTO(metaEstabelecimentoDTO,
				metasDepartamentoDTO);

		return metaDTO;
	}
}
