package br.com.calcard.calsystem.noCheckedException;

public class NoCheckedException extends RuntimeException {

	private static final long serialVersionUID = 1763163184313845176L;
	
	public NoCheckedException(String mensagem) {
		super(mensagem);
	}

	public NoCheckedException(Throwable e) {
		super(e);
	}

	public NoCheckedException(String mensagem, Throwable e) {
		super(mensagem, e);
	}

}
