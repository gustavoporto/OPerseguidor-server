package br.com.calcard.calsystem.ws;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.calsystem.rn.exception.cartaSenha.CartaSenhaNaoEncontradaException;
import br.com.calcard.calsystem.rn.exception.cartaSenha.CartaSenhaUtilizadaException;
import br.com.calcard.calsystem.rn.exception.cartao.CartaoNaoEncontradoException;
import br.com.calcard.calsystem.rn.exception.usuario.UsuarioNaoEncontradoException;
import br.com.calcard.calsystem.service.CartaoService;
import br.com.calcard.calsystem.ws.dto.ResponseDTO;
import br.com.calcard.calsystem.ws.dto.cartao.CadastroSenhaDTO;

@RestController
@RequestMapping("/ws/cartao")
public class CartaoWS {

	@Autowired
	CartaoService cartaoService;

	@Transactional
	@RequestMapping(value = "/senha", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseDTO doCadastrarSenha(
			@RequestBody CadastroSenhaDTO cadastroSenhaDTO) {

		try {
			cartaoService.doCadastrarSenha(cadastroSenhaDTO.getIdCartao(),
					cadastroSenhaDTO.getIdCartaSenha(),
					cadastroSenhaDTO.getIdUsuario());

			return new ResponseDTO(null, "00",
					"Cadastro realizado com sucesso!");

		} catch (CartaoNaoEncontradoException e) {
			e.printStackTrace();
			return new ResponseDTO(null, "01",
					"Não foi possível encontrar um Cartão com o ID informado!");
		} catch (CartaSenhaNaoEncontradaException e) {
			e.printStackTrace();
			return new ResponseDTO(null, "02",
					"Não foi possível encontrar uma Carta Senha com o ID informado!");
		} catch (UsuarioNaoEncontradoException e) {
			e.printStackTrace();
			return new ResponseDTO(null, "03",
					"Não foi possível encontrar um Usuario com o ID informado!");
		} catch (CartaSenhaUtilizadaException e) {
			e.printStackTrace();
			return new ResponseDTO(null, "04",
					"Carta Senha informada já foi utilizada!");
		}

	}
}
