package br.com.calcard.calsystem.ws;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.service.SessaoService;
import br.com.calcard.calsystem.ws.dto.CredencialDTO;
import br.com.calcard.calsystem.ws.dto.SessaoDTO;

import com.google.gson.Gson;

@RestController
@RequestMapping("/ws/autenticacao")
public class AutenticacaoWS extends AbstractWS<AutenticacaoWS> {

	@Autowired
	SessaoService sessaoService;

	SessaoDTO sessaoDTOWS;

	public AutenticacaoWS() {
		super(AutenticacaoWS.class);
	}

	@Transactional
	@RequestMapping(value = "/tokenLogin", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public String doGerarTokenLogin(@RequestBody String identificador) {
		logger.info("Método: doGerarTokenLogin()");
		
		
		
		Gson gson = new Gson();

		SessaoDTO sessao = new SessaoDTO(1L, new Usuario(12, "gportos", null,
				"Gustavo Porto", null));

		return gson.toJson(sessao);

	}

	@Transactional
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public String login(@RequestBody CredencialDTO credencial) {
		logger.info("Método: SessaoDTOWS()");

		Gson gson = new Gson();

		SessaoDTO sessao = new SessaoDTO(1L, new Usuario(12, "gportos", null,
				"Gustavo Porto", null));

		return gson.toJson(sessao);

	}
}
