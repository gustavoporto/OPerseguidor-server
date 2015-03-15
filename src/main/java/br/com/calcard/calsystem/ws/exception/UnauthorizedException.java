package br.com.calcard.calsystem.ws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//401
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {

	private static final long serialVersionUID = 8402691794315504630L;

	public UnauthorizedException(String mensagem) {
		super(mensagem);
	}

}
