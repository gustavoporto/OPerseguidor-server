package br.com.calcard.calsystem.checkedException;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -505516593501714206L;

	public ServiceException() {
		super(MensagemException.MSG_SERVICE_EXCEPTION_001);
	}

	public ServiceException(String mensagem) {
		super(mensagem);
	}

	public ServiceException(String mensagem, Throwable e) {
		super(mensagem, e);
	}

}
