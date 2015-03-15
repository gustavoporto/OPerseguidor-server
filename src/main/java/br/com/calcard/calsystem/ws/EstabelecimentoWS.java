package br.com.calcard.calsystem.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.calsystem.checkedException.ServiceException;
import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.service.EstabelecimentoService;
import br.com.calcard.calsystem.ws.dto.ColaboradorDTO;
import br.com.calcard.calsystem.ws.dto.DepartamentoDTO;
import br.com.calcard.calsystem.ws.dto.EstabelecimentoDTO;
import br.com.calcard.calsystem.ws.dto.MetaAtivacaoDTO;
import br.com.calcard.calsystem.ws.dto.MetaDepartamentoDTO;
import br.com.calcard.calsystem.ws.dto.MetaEstabelecimentoDTO;
import br.com.calcard.calsystem.ws.dto.ResponseDTO;

@RestController
@RequestMapping("/ws/estabelecimentos")
public class EstabelecimentoWS extends AbstractWS<EstabelecimentoWS> {

	@Autowired
	EstabelecimentoService estabelecimentoService;

	public EstabelecimentoWS() {
		super(EstabelecimentoWS.class);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public ResponseDTO doListarEstabelecimentos(
			@RequestHeader(value = "hashToken") String hashToken) {

		try {
			List<Estabelecimento> estabelecimentos = estabelecimentoService
					.doListarEstabelecimentos(hashToken);

			List<EstabelecimentoDTO> estabelecimentosDTO = new ArrayList<EstabelecimentoDTO>();

			Map<Object, Object> objeto = new HashMap<Object, Object>();

			for (Estabelecimento estabelecimento : estabelecimentos) {

				EstabelecimentoDTO estabelecimentoDTO = new EstabelecimentoDTO(
						estabelecimento);

				estabelecimentosDTO.add(estabelecimentoDTO);

				objeto.put("EstabelecimentoDTO", estabelecimentosDTO);
			}
			return new ResponseDTO(objeto, "00",
					"Consulta realizada com sucesso!");

		} catch (ServiceException e) {
			e.printStackTrace();
			return new ResponseDTO(null, "99",
					"Não foi possível processar a solicitação realizada!");
		}

	}

	
	@RequestMapping(value = "/{codigoEstabelecimento}", method = RequestMethod.GET, produces = "application/json")
	public EstabelecimentoDTO doGetEstabelecimento(
			@PathVariable int idEstabelecimento) {

		
		/*
		 * logger.info("Método: doGetEstabelecimento");
		 * logger.debug("Consultando loja pelo id: " + idEstabelecimento);
		 * 
		 * Estabelecimento estabelecimento = (Estabelecimento)
		 * estabelecimentoService .doFind(Estabelecimento.class,
		 * idEstabelecimento);
		 * 
		 * return new EstabelecimentoDTO(estabelecimento);
		 */
		
		return null;

	}

	@RequestMapping(value = "/{idEstabelecimento}/metaAtivacao", method = RequestMethod.GET, produces = "application/json")
	public MetaAtivacaoDTO doGetMetaAtivacao(@PathVariable int idEstabelecimento) {

		/*
		 * Estabelecimento estabelecimento = (Estabelecimento)
		 * estabelecimentoService .doFind(Estabelecimento.class,
		 * idEstabelecimento);
		 * 
		 * MetaEstabelecimento metaEstabelecimento = estabelecimentoService
		 * .doGetMetaEstabelecimento(estabelecimento);
		 * 
		 * List<Departamento> departamentos = estabelecimentoService
		 * .doListDepartamentos();
		 * 
		 * List<MetaDepartamentoDTO> metaDepartamentos = new
		 * ArrayList<MetaDepartamentoDTO>(); for (Departamento departamento :
		 * departamentos) {
		 * 
		 * metaDepartamentos.add(new MetaDepartamentoDTO(new DepartamentoDTO(
		 * departamento), estabelecimentoService
		 * .doGetMetaDepartamento(departamento, metaEstabelecimento)
		 * .getPercentual())); }
		 * 
		 * return new MetaAtivacaoDTO(new EstabelecimentoDTO(estabelecimento),
		 * metaEstabelecimento.getQuantidade(), metaDepartamentos);
		 */

		return null;
	}

	@RequestMapping(value = "/departamentoByUsuario", method = RequestMethod.GET, produces = "application/json")
	public DepartamentoDTO doGetDepartamentoByUsuario(
			@RequestParam(value = "idUsuario") int idUsuario) {

		/*
		 * logger.info("Método: doGetDepartamentoByUsuario");
		 * 
		 * Usuario usuario = (Usuario) estabelecimentoService.doFind(
		 * Usuario.class, idUsuario);
		 * 
		 * Departamento departamento = estabelecimentoService
		 * .doGetDepartamentoUsuario(usuario);
		 * 
		 * return departamento == null ? null : new
		 * DepartamentoDTO(departamento);
		 */

		return null;

	}

	@RequestMapping(value = "/{idEstabelecimento}/colaboradores", method = RequestMethod.GET, produces = "application/json")
	public List<ColaboradorDTO> doListColaboradores(
			@PathVariable int idEstabelecimento) {

		/*
		 * Estabelecimento estabelecimento = (Estabelecimento) usuarioService
		 * .doFind(Estabelecimento.class, idEstabelecimento);
		 * 
		 * List<ColaboradorDTO> colaboradores = new ArrayList<ColaboradorDTO>();
		 * 
		 * for (Usuario u : usuarioService
		 * .doListUsuariosByEstabelecimento(estabelecimento)) {
		 * 
		 * ColaboradorDTO colaboradorDTO = new ColaboradorDTO( new
		 * UsuarioDTO(u));
		 * 
		 * Departamento d = estabelecimentoService.doGetDepartamentoUsuario(u);
		 * 
		 * if (d != null) colaboradorDTO.setDepartamento(new
		 * DepartamentoDTO(d));
		 * 
		 * colaboradores.add(colaboradorDTO);
		 * 
		 * }
		 * 
		 * return colaboradores;
		 */

		return null;
	}

	// @RequestMapping(value = "/colaboradores", method = RequestMethod.GET,
	// produces = "application/json")
	// public List<ColaboradorDTO> doListColaboradores(
	// @RequestParam(value = "idEstabelecimento") int idEstabelecimento) {
	//
	// Estabelecimento estabelecimento = (Estabelecimento) usuarioService
	// .doFind(Estabelecimento.class, idEstabelecimento);
	//
	// List<ColaboradorDTO> colaboradores = new ArrayList<ColaboradorDTO>();
	//
	// for (Usuario u : usuarioService
	// .doListUsuariosByEstabelecimento(estabelecimento)) {
	//
	// ColaboradorDTO colaboradorDTO = new ColaboradorDTO(
	// new UsuarioDTO(u));
	//
	// Departamento d = estabelecimentoService.doGetDepartamentoUsuario(u);
	//
	// if (d != null)
	// colaboradorDTO.setDepartamento(new DepartamentoDTO(d));
	//
	// colaboradores.add(colaboradorDTO);
	//
	// }
	//
	// return colaboradores;
	// }

	@RequestMapping(value = "/metaDepartamento", method = RequestMethod.GET, produces = "application/json")
	public List<MetaDepartamentoDTO> doListMetaDepartamento(
			@RequestParam(value = "idMetaEstabelecimento") int idMetaEstabelecimento) {
		// logger.info("Método: doListMetaDepartamento");
		//
		// List<MetaDepartamentoDTO> metaDTO = new
		// ArrayList<MetaDepartamentoDTO>();
		// for (MetaDepartamento meta : estabelecimentoService
		// .doListMetaDepartamento(idMetaEstabelecimento)) {
		// MetaDepartamentoDTO m = new MetaDepartamentoDTO(meta);
		// metaDTO.add(m);
		// }

		// return metaDTO;

		return null;

	}

	@RequestMapping(value = "/metaEstabelecmento", method = RequestMethod.GET, produces = "application/json")
	public MetaEstabelecimentoDTO doGetMetaEstabelecimento(
			@RequestParam(value = "idEstabelecimento") int idEstabelecimento) {
		logger.info("Método: doGetMetaEstabelecimento");

		// return new MetaEstabelecimentoDTO(
		// estabelecimentoService
		// .doGetMetaEstabelecimento(idEstabelecimento));

		return null;
	}

	@RequestMapping(value = "/departamentos", method = RequestMethod.GET, produces = "application/json")
	public List<DepartamentoDTO> doListDepartamentos() {
		// logger.info("Método: doGetEstabelecimento");
		//
		// List<DepartamentoDTO> departamentos = new
		// ArrayList<DepartamentoDTO>();
		// for (Departamento d : estabelecimentoService.doListDepartamentos()) {
		// DepartamentoDTO dpto = new DepartamentoDTO(d);
		// departamentos.add(dpto);
		// }
		//
		// return departamentos;

		return null;

	}

}
