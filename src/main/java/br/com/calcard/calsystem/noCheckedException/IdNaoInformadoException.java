package br.com.calcard.calsystem.noCheckedException;

public class IdNaoInformadoException extends
		DadosObrigatoriosNaoInformadosException {

	private static final long serialVersionUID = 7465902080870094343L;

	private static final String MENSAGEM_DEFAULT = "Id Conductor não informado!";

	public IdNaoInformadoException() {
		super(MENSAGEM_DEFAULT);
	}

}
