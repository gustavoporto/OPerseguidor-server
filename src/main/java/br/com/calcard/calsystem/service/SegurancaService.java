package br.com.calcard.calsystem.service;

import java.security.KeyPair;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.calcard.calsystem.checkedException.ServiceException;
import br.com.calcard.calsystem.entity.Menu;
import br.com.calcard.calsystem.entity.Perfil;
import br.com.calcard.calsystem.entity.Token;
import br.com.calcard.calsystem.entity.Url;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.rn.exception.CredenciaisInvalidasException;
import br.com.calcard.calsystem.rn.exception.NoDataFoundException;
import br.com.calcard.calsystem.rn.exception.RNException;
import br.com.calcard.calsystem.ws.dto.CredencialDTO;
import br.com.calcard.calsystem.ws.dto.MenuDTO;
import br.com.calcard.calsystem.ws.dto.TokenDTO;

@Repository
public class SegurancaService extends AbstractService<SegurancaService> {

	@Autowired
	UsuarioService usuarioService;

	public SegurancaService() {
		super(SegurancaService.class);
	}

	/*
	 * Menu Service
	 */
	public void doCadastrarNovoMenu(String hashToken, MenuDTO menuDTO) {

		Menu menu = new Menu(null, menuDTO.getNome(), menuDTO.getDescricao(),
				null);

		doCadastrarNovoMenu(menu);

	}

	public List<MenuDTO> doListarMenusAutorizados(String hashToken)
			throws RNException, ServiceException {

		Perfil perfil = doValidarToken(hashToken).doGetPerfilToken(hashToken);

		List<Menu> menus = null;

		if (perfil.getCodigo().equals(Perfil.PERFIL_SUPER))
			menus = doListarMenus();

		else
			menus = doListarMenus(perfil);

		if (menus.size() == 0)
			throw new RNException(
					"Nenhum menu autorizado para o Perfil do Usuário. Verifique configuração do sistema!");

		List<MenuDTO> menusDTO = new ArrayList<MenuDTO>();
		for (Menu m : menus) {
			menusDTO.add(new MenuDTO(m));
		}

		return menusDTO;
	}

	@SuppressWarnings("unchecked")
	public List<Menu> doListMenus() {
		logger.info("Método: doListMenus()");

		String query = "select m from Menu m";

		List<Menu> menus = (List<Menu>) this.doGetResultList(query, Menu.class,
				null);

		return menus;
	}

	public List<Menu> doListarMenus() {
		return doListarMenus(null);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Menu> doListarMenus(Perfil perfil) {

		String query = null;
		Map parametros = null;

		if (perfil != null) {
			query = "select m from Menu m join m.perfis p where p.id = :perfil";
			parametros = new HashMap();
			parametros.put("perfil", perfil.getId());

		} else
			query = "select m from Menu m";

		return (List<Menu>) super
				.doGetResultList(query, Menu.class, parametros);

	}

	public void doCadastrarNovoMenu(Menu menu) {

		super.doCreate(menu);

	}

	/*
	 * Token Service
	 */
	private static Map<String, Token> tokens = new HashMap<String, Token>();

	public boolean isUsuarioAutenticado(String hashToken)
			throws ServiceException {

		return doValidarToken(hashToken).isTokenUsuario(hashToken);

	}

	public TokenDTO doGerarTokenUsuario(String hashTokenLogin,
			CredencialDTO credencial) throws ServiceException,
			CredenciaisInvalidasException {

		if (credencial.getLogin() == null || credencial.getSenha() == null)
			throw new CredenciaisInvalidasException(
					"Login e/ou Senha não informados!");

		Usuario usuario = usuarioService.doAutenticarUsuario(
				credencial.getLogin(), credencial.getSenha());

		if (usuario == null)
			throw new CredenciaisInvalidasException(
					"Usuário e/ou Senha inválidos");

		String hashTokenUsuario = doGerarTokenUsuario(hashTokenLogin, usuario);

		String key = doGetKeyToken(hashTokenUsuario);

		return new TokenDTO(hashTokenUsuario, key, usuario.getPerfil().getId());

	}

	public TokenDTO doGerarTokenLogin(String idPeriferico)
			throws ServiceException {

		if (idPeriferico == null)
			throw new ServiceException(
					"Identificador do Periférico não infomado para geração do Token de login.");

		Token token = doGerarToken(Token.TIPO_TOKEN_LOGIN, idPeriferico, null);

		tokens.put(token.getHash(), token);

		String hashToken = token.getHash();

		String key = doGetKeyToken(hashToken);

		return new TokenDTO(hashToken, key, null);

	}

	public String doGerarTokenUsuario(String tokenLogin, Usuario usuario)
			throws ServiceException {

		if (tokenLogin == null)
			throw new ServiceException(
					"Token de Login não infomado para geração do Token de Usuário.");

		Token token = tokens.get(tokenLogin);

		if (token == null)
			throw new ServiceException("Token de Login inválido.");

		Token tokenUsuario = doGerarToken(Token.TIPO_TOKEN_USUARIO,
				token.getIdPeriferico(), usuario);

		tokens.put(tokenUsuario.getHash(), tokenUsuario);
		tokens.remove(tokenLogin);

		return tokenUsuario.getHash();
	}

	private Token doGerarToken(String tipoToken, String idPeriferico,
			Usuario usuario) throws ServiceException {

		if (usuario == null && tipoToken != Token.TIPO_TOKEN_LOGIN)
			throw new ServiceException(
					"Usuário é obrigatório para geração de Token de Usuário");

		Date dataCriacao = new Date();

		Long random = new SecureRandom().nextLong();

		String semente = idPeriferico
				+ new SimpleDateFormat("MMddyyyyHHmmss").format(dataCriacao)
				+ random;

		String hashToken = new CriptografiaService().new HASH().MD5(semente);

		KeyPair keyPair = new CriptografiaService().new RSA()
				.doGerarChave(1024).getKeyPair();

		Token token = new Token(idPeriferico, random, hashToken, usuario,
				dataCriacao, null, null, tipoToken, keyPair);

		return token;

	}

	public String doGetKeyToken(String hashToken) throws ServiceException {

		String stringKey = null;
		Token token = tokens.get(hashToken);

		if (token == null)
			throw new ServiceException(
					"Não foi possível encontrar um token para o hash informado. "
							+ hashToken);

		stringKey = new CriptografiaService().new RSA().doKeyToString(token
				.getKeyPair().getPrivate());

		return stringKey;

	}

	public SegurancaService doValidarToken(String hashToken)
			throws ServiceException {

		if (hashToken == null)
			throw new ServiceException("Token não informado!");

		Token token = tokens.get(hashToken);

		if (token == null)
			throw new ServiceException("Token inválido!");

		return this;

	}

	public boolean isTokenUsuario(String hashToken) throws ServiceException {

		return tokens.get(hashToken).getTipo().equals(Token.TIPO_TOKEN_USUARIO);

	}

	public Perfil doGetPerfilToken(String hashToken) throws ServiceException {

		return tokens.get(hashToken).getUsuario().getPerfil();

	}

	/*
	 * URL Service
	 */

	public boolean isUrlAutorizado(String nomeUrl, String hashToken)
			throws ServiceException {

		List<Url> urls;

		Perfil perfil = doValidarToken(hashToken).doGetPerfilToken(hashToken);

		if (perfil.getCodigo().equals(Perfil.PERFIL_SUPER))
			return true;

		try {
			urls = this.doListarUrlsAutorizados(hashToken);
		} catch (NoDataFoundException e) {
			e.printStackTrace();
			return false;
		}

		Url url = doGetUrl(nomeUrl);

		return urls.contains(url);

	}

	public List<Url> doListarUrlsAutorizados(String hashToken)
			throws ServiceException, NoDataFoundException {

		Perfil perfil = doValidarToken(hashToken).doGetPerfilToken(hashToken);

		List<Url> urls = doListarUrls(perfil);

		if (urls.size() == 0)
			throw new NoDataFoundException(
					"Nenhum URL autorizado para o Perfil do Usuário.");

		return urls;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Url doGetUrl(String nomeUrl) throws ServiceException {

		if (nomeUrl == null)
			throw new ServiceException("Nome da URL não informada.");

		String query = "select u from Url u where u.nome = :nome";

		Map parametros = new HashMap();

		parametros.put("nome", nomeUrl);

		Url url = (Url) super.doGetSingleResult(query, Url.class, parametros);

		if (url == null)
			throw new ServiceException("Nenhum URL cadastrado com o nome "
					+ nomeUrl + " foi encontrado. Verifique configuração.");

		return url;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Url> doListarUrls(Perfil perfil) {

		String query = null;
		Map parametros = null;
		if (!perfil.getCodigo().equals(Perfil.PERFIL_SUPER)) {

			query = "select u from Url u join u.perfis p where p.id = :perfil";

			parametros = new HashMap();

			parametros.put("perfil", perfil.getId());

		} else
			query = "select u from Url u";

		return (List<Url>) super.doGetResultList(query, Url.class, parametros);

	}
}
