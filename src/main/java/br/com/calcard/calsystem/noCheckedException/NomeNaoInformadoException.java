package br.com.calcard.calsystem.noCheckedException;

public class NomeNaoInformadoException extends
		DadosObrigatoriosNaoInformadosException {

	private static final long serialVersionUID = -7476712327647604899L;

	private static final String MENSAGEM_DEFAULT = "Nome não informado!";

	public NomeNaoInformadoException() {
		super(MENSAGEM_DEFAULT);
	}

}
