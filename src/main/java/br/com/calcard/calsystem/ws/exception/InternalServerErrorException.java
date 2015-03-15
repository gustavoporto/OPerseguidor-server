package br.com.calcard.calsystem.ws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//500
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RuntimeException {

	private static final long serialVersionUID = 6080602889426681645L;

	public InternalServerErrorException() {
		super();
	}

	public InternalServerErrorException(String mensagem) {
		super(mensagem);
	}

}
