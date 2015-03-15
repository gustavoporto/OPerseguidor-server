package br.com.calcard.calsystem.checkedException;

import br.com.calcard.calsystem.rn.exception.RNException;

public class LoginDuplicadoException extends RNException {

	private static final long serialVersionUID = 8682299791998406892L;

	public static final String MENSAGEM_DEFAULT = "Já existe outro Usuário cadastrado com o login informado!";

	public LoginDuplicadoException() {
		super(MENSAGEM_DEFAULT);
	}

}
