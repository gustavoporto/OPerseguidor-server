package br.com.calcard.calsystem.ws;

import java.security.PrivateKey;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.calcard.calsystem.util.FileKeyTool;
import br.com.calcard.calsystem.util.KeyTool;
import br.com.calcard.calsystem.util.Logger;
import br.com.calcard.calsystem.ws.dto.CredencialDTO;

public abstract class AbstractWS<T> { // extends Logger<T> {

	protected org.apache.logging.log4j.Logger logger;

	public AbstractWS(Class<T> entityClass) {
		logger = LogManager.getLogger(entityClass.getName());
		// super(entityClass);
	}

	@RequestMapping(value = "/teste", method = RequestMethod.GET, produces = "text/plain")
	public String teste() {
		return "Serviço no ar: " + new Date();

	}

	@RequestMapping(value = "/testeCripto", method = RequestMethod.POST, consumes = "text/plain", produces = "text/plain")
	public String testeCripto(@RequestBody String mensagem) {

		FileKeyTool fkt = new FileKeyTool();
		PrivateKey chavePrivada = fkt.carregarPrivateKey();		
		KeyTool kt = new KeyTool();
		
		String msgOriginal = kt.descriptografar(chavePrivada, mensagem);

		System.out.println(mensagem);
		
		System.out.println(msgOriginal);

		return msgOriginal;

	}

}
