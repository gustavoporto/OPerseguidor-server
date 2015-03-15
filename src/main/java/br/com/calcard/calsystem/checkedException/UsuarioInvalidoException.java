package br.com.calcard.calsystem.checkedException;

public class UsuarioInvalidoException extends Exception {

	private static final long serialVersionUID = 3716673491089115582L;

	public UsuarioInvalidoException() {
		super(MensagemException.MSG_USUARIO_INVALIDO_EXCEPTION_001);
	}

	public UsuarioInvalidoException(String mensagem) {
		super(mensagem);
	}

}
