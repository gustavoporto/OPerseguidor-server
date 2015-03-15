package br.com.calcard.calsystem.checkedException;

import br.com.calcard.calsystem.rn.exception.RNException;

public class EstabelecimentoDuplicadoException extends RNException {

	private static final long serialVersionUID = 241605599686118257L;

	private static final String MENSAGEM_DEFAULT = "Estabelecimento duplicado!";

	public EstabelecimentoDuplicadoException(String mensagem) {
		super(mensagem);
	}

	public EstabelecimentoDuplicadoException() {
		super(MENSAGEM_DEFAULT);
	}

}
