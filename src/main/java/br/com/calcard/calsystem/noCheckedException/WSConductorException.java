package br.com.calcard.calsystem.noCheckedException;

public class WSConductorException extends NoCheckedException {

	public static final String MENSAGEM_DEFAULT = "Não foi possível acessar o Web Service da Conductor.";

	private static final long serialVersionUID = -1895220734661646296L;

	public WSConductorException() {
		super(MENSAGEM_DEFAULT);
	}

	public WSConductorException(String mensagem) {
		super(mensagem);
	}

	public WSConductorException(String mensagem, Throwable e) {
		super(mensagem, e);
	}

}
