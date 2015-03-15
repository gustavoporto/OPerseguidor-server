package br.com.calcard.calsystem.rn.exception.usuario;

import br.com.calcard.calsystem.checkedException.MensagemException;
import br.com.calcard.calsystem.rn.exception.RNException;

public class UsuarioNaoEncontradoException extends RNException {

	private static final long serialVersionUID = 3716673491089115582L;

	public UsuarioNaoEncontradoException() {
		super(MensagemException.MSG_USUARIO_NAO_ENCONTRADO_EXCEPTION_001);
	}

	public UsuarioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

}
