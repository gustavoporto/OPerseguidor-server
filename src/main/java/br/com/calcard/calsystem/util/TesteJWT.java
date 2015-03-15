package br.com.calcard.calsystem.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import br.com.calcard.calsystem.service.CriptografiaService;

public class TesteJWT {

	public static void main(String[] args) {

		String identificador = "calcard";

		String data = new SimpleDateFormat("ddMMyyyyHHmmssS")
				.format(new Date());

		Double numero = new Random().nextDouble();

		String semente = identificador + data + numero;
		
		String hash = CriptografiaService.HASH.MD5(semente);
		
		System.out.println("Report Date: " + semente);
		System.out.println("Report Hash: " + hash);
		
		
		

	}

}
