package br.com.calcard.calsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.calcard.calsystem.entity.CartaSenha;
import br.com.calcard.calsystem.entity.Cartao;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.rn.exception.cartaSenha.CartaSenhaNaoEncontradaException;
import br.com.calcard.calsystem.rn.exception.cartaSenha.CartaSenhaUtilizadaException;
import br.com.calcard.calsystem.rn.exception.cartao.CartaoNaoEncontradoException;
import br.com.calcard.calsystem.rn.exception.usuario.UsuarioNaoEncontradoException;
import br.com.calcard.calsystem.util.Logger2;

@Repository
public class CartaoService extends Logger2 {

	@Autowired
	GenericService genericService;

	public CartaoService() {
		super(CartaoService.class);
	}

	public void doCadastrarSenha(Integer idCartao, Integer idCartaSenha,
			Integer idUsuario) throws CartaoNaoEncontradoException,
			CartaSenhaNaoEncontradaException, UsuarioNaoEncontradoException,
			CartaSenhaUtilizadaException {

		Cartao cartao = (Cartao) genericService.doFind(Cartao.class, idCartao);

		if (cartao == null)
			throw new CartaoNaoEncontradoException(
					"Não foi possível encontrar um Cartão com o ID informado!");

		CartaSenha cartaSenha = (CartaSenha) genericService.doFind(
				CartaSenha.class, idCartaSenha);

		if (cartaSenha == null)
			throw new CartaSenhaNaoEncontradaException(
					"Não foi possível encontrar uma Carta Senha com o ID informado!");

		else if (cartaSenha.getStatus().equals(CartaSenha.STATUS_UTILIZADA))
			throw new CartaSenhaUtilizadaException(
					"A Carta Senha informada já foi utilizada!");

		Usuario usuario = (Usuario) genericService.doFind(Usuario.class,
				idUsuario);

		if (usuario == null)
			throw new UsuarioNaoEncontradoException(
					"Não foi possível encontrar um Usuario com o ID informado!");

		cartao.setSenha(cartaSenha.getSenha());
		genericService.doUpdate(cartao);

		cartaSenha.setStatus(CartaSenha.STATUS_UTILIZADA);
		genericService.doUpdate(cartaSenha);
		
		

	}
}
