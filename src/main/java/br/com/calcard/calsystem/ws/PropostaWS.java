package br.com.calcard.calsystem.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.entity.PropostaAtivada;
import br.com.calcard.calsystem.service.PropostaService;
import br.com.calcard.calsystem.ws.dto.PropostaAtivadaDTO;

@RestController
@RequestMapping("/ws/propostas")
public class PropostaWS extends AbstractWS<PropostaWS> {

	@Autowired
	PropostaService propostaService;

	public PropostaWS() {
		super(PropostaWS.class);
	}

	@RequestMapping(value = "/{idEstabelecimento}/ativadas", method = RequestMethod.GET, produces = "application/json")
	public List<PropostaAtivadaDTO> doGetPropostasAtivadas(
			@PathVariable int idEstabelecimento) {
		logger.info("Método: doGetPropostasAtivadas");

		Estabelecimento e = (Estabelecimento) propostaService.doFind(
				Estabelecimento.class, idEstabelecimento);

		List<PropostaAtivadaDTO> propostasDTO = new ArrayList<PropostaAtivadaDTO>();
		for (PropostaAtivada p : propostaService.doListPropostasAtivadas(e)) {

			propostasDTO.add(new PropostaAtivadaDTO(p.getId(), p.getUsuario(),
					p.getQuantidade(), p.getDataAtivacao(), p
							.getEstabelecimento()));
		}

		return propostasDTO;

	}

}
