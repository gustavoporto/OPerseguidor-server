package br.com.calcard.calsystem.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.calcard.calsystem.checkedException.ServiceException;
import br.com.calcard.calsystem.entity.ParametroGlobal;

@Repository
public class ParametroGlobalService {

	@Autowired
	GenericService genericService;

	public ParametroGlobal doGetParametro(String nomeParamentro)
			throws ServiceException {

		String query = "select pg from ParametroGlobal pg where pg.nome = :nomeParametro";

		Map<String, String> parametros = new HashMap<String, String>();
		parametros.put("nomeParametro", nomeParamentro);

		ParametroGlobal parametroGlobal = (ParametroGlobal) genericService
				.doGetSingleResult(query, ParametroGlobal.class, parametros);

		if (parametroGlobal == null)
			throw new ServiceException("Parâmetro " + nomeParamentro
					+ " não encontrado!");

		return parametroGlobal;

	}

}
