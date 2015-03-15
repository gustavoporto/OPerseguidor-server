package br.com.calcard.calsystem.checkedException;

public class CPFNaoInformadoException extends Exception {

	private static final long serialVersionUID = -6488788260680548773L;

	public CPFNaoInformadoException() {
		super("CPF não foi informado!");
	}

}
