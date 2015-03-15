package br.com.calcard.calsystem.rn.exception.cartao;

import br.com.calcard.calsystem.rn.exception.RNException;

public class CartaoNaoEncontradoException extends RNException {

	private static final long serialVersionUID = -4749738261978294841L;

	public CartaoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

}
