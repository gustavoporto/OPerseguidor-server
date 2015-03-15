package br.com.calcard.calsystem.checkedException;

public class LoginNaoInformadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2961119321637611489L;

	public LoginNaoInformadoException() {
		super("Login não informado");
	}

}
