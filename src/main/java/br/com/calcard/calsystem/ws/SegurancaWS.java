package br.com.calcard.calsystem.ws;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.calsystem.checkedException.ServiceException;
import br.com.calcard.calsystem.entity.Url;
import br.com.calcard.calsystem.rn.exception.CredenciaisInvalidasException;
import br.com.calcard.calsystem.rn.exception.NoDataFoundException;
import br.com.calcard.calsystem.rn.exception.RNException;
import br.com.calcard.calsystem.service.SegurancaService;
import br.com.calcard.calsystem.ws.dto.CredencialDTO;
import br.com.calcard.calsystem.ws.dto.MenuDTO;
import br.com.calcard.calsystem.ws.dto.TokenDTO;
import br.com.calcard.calsystem.ws.dto.UrlDTO;
import br.com.calcard.calsystem.ws.exception.InternalServerErrorException;
import br.com.calcard.calsystem.ws.exception.UnauthorizedException;

@RestController
@RequestMapping("/ws/seguranca")
public class SegurancaWS extends AbstractWS<SegurancaWS> {

	@Autowired
	SegurancaService segurancaService;

	public SegurancaWS() {
		super(SegurancaWS.class);
	}

	/*
	 * Token WS
	 */
	@RequestMapping(value = "/usuarioAutenticado", method = RequestMethod.GET, produces = "application/json")
	public boolean isUsuarioAutenticado(
			@RequestHeader(value = "hashToken") String hashToken) {
		logger.info("Método: isUsuarioAutenticado()");

		try {
			return segurancaService.isUsuarioAutenticado(hashToken);
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new InternalServerErrorException("Erro de sistema.");
		}

	}

	@Transactional
	@RequestMapping(value = "/tokenLogin", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public TokenDTO doGerarTokenLogin(
			@RequestHeader(value = "idPeriferico") String idPeriferico) {
		logger.info("Método: doGerarTokenLogin()");

		try {
			return segurancaService.doGerarTokenLogin(idPeriferico);
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new InternalServerErrorException("Erro de sistema.");
		}

	}

	@Transactional
	@RequestMapping(value = "/tokenUsuario", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public TokenDTO doGerarTokenUsuario(
			@RequestHeader(value = "hashToken") String hashToken,
			@RequestBody CredencialDTO credencial) {
		logger.info("Método: doGerarTokenLogin()");

		try {
			return segurancaService.doGerarTokenUsuario(hashToken, credencial);
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new InternalServerErrorException("Erro de sistema.");
		} catch (CredenciaisInvalidasException e) {
			throw new UnauthorizedException("Não autorizado!");
		}
	}

	/*
	 * Menu WS
	 */
	@RequestMapping(value = "/menusAutorizados", method = RequestMethod.GET, produces = "application/json")
	public List<MenuDTO> doListarMenusAutorizados(
			@RequestHeader(value = "hashToken") String hashToken)
			throws ServiceException {
		logger.info("Método: doListMenus()");

		try {
			return segurancaService.doListarMenusAutorizados(hashToken);
		} catch (RNException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@RequestMapping(value = "/menus", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void doCadastrarNovoMenu(@RequestBody MenuDTO menuDTO) {

		segurancaService.doCadastrarNovoMenu(null, menuDTO);

	}

	/*
	 * @RequestMapping(value = "/menus", method = RequestMethod.POST, produces =
	 * "application/json") public void doCadastrarNovoMenu(
	 * 
	 * @RequestHeader(value = "hashToken") String hashToken,
	 * 
	 * @RequestBody MenuDTO menuDTO) {
	 * 
	 * segurancaRN.doCadastrarNovoMenu(hashToken, menuDTO);
	 * 
	 * }
	 */

	/*
	 * URL WS
	 */
	@RequestMapping(value = "/urlsAutorizados", method = RequestMethod.GET, produces = "application/json")
	public List<UrlDTO> doListarUrlsAutorizados(
			@RequestHeader(value = "hashToken") String hashToken) {

		List<Url> urls = null;

		try {
			urls = segurancaService.doListarUrlsAutorizados(hashToken);
		} catch (NoDataFoundException e) {
			e.printStackTrace();
			throw new UnauthorizedException(
					"Nenhum URL autorizado para o Perfil do Usuário.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		List<UrlDTO> urlsDTO = new ArrayList<UrlDTO>();

		for (Url url : urls) {
			urlsDTO.add(new UrlDTO(url));
		}

		return urlsDTO;

	}

	@RequestMapping(value = "/urlsAutorizados/{nomeUrl}", method = RequestMethod.GET, produces = "application/json")
	public Boolean isUrlAutorizado(@PathVariable String nomeUrl,
			@RequestHeader(value = "hashToken") String hashToken) {

		try {
			return segurancaService.isUrlAutorizado(nomeUrl, hashToken);
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new InternalServerErrorException("Erro de sistema.");
		}

	}
}
