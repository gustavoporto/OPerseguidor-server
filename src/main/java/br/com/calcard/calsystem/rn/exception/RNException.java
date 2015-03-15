package br.com.calcard.calsystem.rn.exception;

public class RNException extends Exception {

	private static final long serialVersionUID = -9120545582111969269L;
	
	public RNException(String mensagem) {
		super(mensagem);
	}

	public RNException(String mensagem, Throwable e) {
		super(mensagem, e);
	}

	public RNException(Throwable e) {
		super(e);
	}

}
