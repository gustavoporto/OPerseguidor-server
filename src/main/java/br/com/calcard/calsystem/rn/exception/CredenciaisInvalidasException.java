package br.com.calcard.calsystem.rn.exception;

public class CredenciaisInvalidasException extends RNException {

	private static final long serialVersionUID = -4849992688338105400L;

	public CredenciaisInvalidasException(String mensagem) {
		super(mensagem);
	}

	public CredenciaisInvalidasException(String mensagem, Throwable e) {
		super(mensagem, e);
	}

}
