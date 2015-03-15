package br.com.calcard.calsystem.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.calsystem.checkedException.ServiceException;
import br.com.calcard.calsystem.entity.CartaSenhaLote;
import br.com.calcard.calsystem.rn.exception.cartaSenha.NenhumLoteEncontradoException;
import br.com.calcard.calsystem.service.CartaSenhaService;
import br.com.calcard.calsystem.ws.dto.CartaSenhaLoteDTO;
import br.com.calcard.calsystem.ws.dto.ResponseDTO;

@RestController
@RequestMapping("/ws/cartaSenha")
public class CartaSenhaWS extends AbstractWS<CartaSenhaWS> {

	@Autowired
	CartaSenhaService cartaSenhaService;

	public CartaSenhaWS() {
		super(CartaSenhaWS.class);
	}

	@Transactional
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseDTO doAgendarLoteCartasenha(
			@RequestBody CartaSenhaLoteDTO cartaSenhaLoteDTO) {

		ResponseDTO responseTO = new ResponseDTO(null, "00",
				"Agendamento realizado com sucesso!");

		cartaSenhaService.doAgendarLoteCartaSenha(cartaSenhaLoteDTO);

		return responseTO;

	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json")
	public ResponseDTO doListarLotes(
			@RequestHeader(value = "hashToken") String hashToken) {

		try {
			List<CartaSenhaLote> listaLotesCartasSenhas = cartaSenhaService
					.doListarLotes();

			List<CartaSenhaLoteDTO> listaCartaSenhaLoteDTO = new ArrayList<CartaSenhaLoteDTO>();

			for (CartaSenhaLote cartaSenhaLote : listaLotesCartasSenhas) {
				CartaSenhaLoteDTO cartaSenhaLoteDTO = new CartaSenhaLoteDTO(
						cartaSenhaLote);
				listaCartaSenhaLoteDTO.add(cartaSenhaLoteDTO);
			}

			Map<Object, Object> objeto = new HashMap<Object, Object>();
			objeto.put("ListaCartaSenhaLoteDTO", listaCartaSenhaLoteDTO);

			return new ResponseDTO(objeto, "00",
					"Consulta realizada com sucesso!");

		} catch (NenhumLoteEncontradoException e) {
			e.printStackTrace();
			return new ResponseDTO(null, "01",
					"Não foi encontrado nenhum cadastro de Lote de Carta Senha!");
		}

	}

	@Transactional
	@RequestMapping(value = "/gerar", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseDTO doGerarCartaSenha() {

		try {
			cartaSenhaService.doGerarCartaSenha();

			return new ResponseDTO(null, "00",
					"Serviço de Geração de Carta Senha executado com sucesso!");
		} catch (ServiceException e) {
			e.printStackTrace();
			return new ResponseDTO(null, "01",
					"Não foi possível executar o Serviço de Geração de Carta Senha!");
		}

	}

}
