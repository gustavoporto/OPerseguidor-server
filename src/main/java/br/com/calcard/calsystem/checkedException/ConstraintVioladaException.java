package br.com.calcard.calsystem.checkedException;

public class ConstraintVioladaException extends Exception {

	private static final long serialVersionUID = 7994868465673402558L;

	public ConstraintVioladaException() {
		super(MensagemException.MSG_CONSTRAINT_VIOLADA_EXCEPTION_001);
	}

	public ConstraintVioladaException(String mensagem) {
		super(mensagem);
	}

}
