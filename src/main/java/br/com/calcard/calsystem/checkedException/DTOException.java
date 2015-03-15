package br.com.calcard.calsystem.checkedException;

public class DTOException extends Exception {

	private static final long serialVersionUID = -1099410682811566782L;

	public DTOException() {
		super(MensagemException.MSG_DTO_EXCEPTION_001);
	}

	public DTOException(String mensagem) {
		super(mensagem);
	}

}
