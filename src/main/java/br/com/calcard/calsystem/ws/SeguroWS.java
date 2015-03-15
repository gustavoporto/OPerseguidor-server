package br.com.calcard.calsystem.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.calsystem.entity.SegurosVendidos;
import br.com.calcard.calsystem.service.SeguroService;

@RestController
@RequestMapping("/ws/seguros")
public class SeguroWS extends AbstractWS<SeguroWS> {

	@Autowired
	SeguroService seguroService;

	public SeguroWS() {
		super(SeguroWS.class);
	}

	/**
	 * WS responsável por consultar WS Conductor atualizar a base local com os
	 * seguros vendidos do dia.
	 * 
	 * @author gustavos
	 */
	@RequestMapping(value = "/segurosVendidos", method = RequestMethod.POST, produces = "application/json")
	public void doPostSegurosVendidos() {

		logger.debug("Atualizando seguros vendidos...");

		seguroService.doAtualizarSegurosVendidos();

	}

	@RequestMapping(value = "/segurosVendidos", method = RequestMethod.GET, produces = "application/json")
	public List<SegurosVendidos> doGetSegurosVendidos() {
		logger.info("Método: doGetSegurosVendidos");

		return seguroService.listSegurosVendidos();

	}
}
