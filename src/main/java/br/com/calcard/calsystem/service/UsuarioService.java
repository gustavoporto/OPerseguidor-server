package br.com.calcard.calsystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.calcard.calsystem.checkedException.LoginDuplicadoException;
import br.com.calcard.calsystem.checkedException.ServiceException;
import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.entity.Perfil;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.entity.UsuarioEstabelecimento;
import br.com.calcard.calsystem.noCheckedException.DadosObrigatoriosNaoInformadosException;

@Repository
public class UsuarioService extends AbstractService<UsuarioService> {

	public UsuarioService() {
		super(UsuarioService.class);
	}

	@Transactional
	public void doCadastrarNovoUsuario(Usuario usuario)
			throws LoginDuplicadoException {
		logger.info("Cadastrando novo Usuario na base de dados: "
				+ usuario.toString());

		if (usuario.getLogin().equals(null)) {
			logger.error("O login não informado.");
			throw new DadosObrigatoriosNaoInformadosException(
					"O login não informado.");
		} else if (usuario.getCpf().equals(null)) {
			logger.error("O CPF não informado.");
			throw new DadosObrigatoriosNaoInformadosException(
					"O CPF não informado.");
		}

		if (this.getUsuarioByLogin(usuario.getLogin()) != null) {
			logger.warn(LoginDuplicadoException.MENSAGEM_DEFAULT);
			throw new LoginDuplicadoException();
		}

		this.doCreate(usuario);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Usuario> doListUsuariosByEstabelecimento(
			Estabelecimento estabelecimento) {
		logger.info("Método: listUsuariosByEstabelecimento");

		String query = "select ue from UsuarioEstabelecimento ue where ue.usuarioEstabelecimentoPK.estabelecimento = :estabelecimento";
		Map parametros = new HashMap();
		parametros.put("estabelecimento", estabelecimento);
		List<UsuarioEstabelecimento> usuariosEstabelecimento = (List<UsuarioEstabelecimento>) this
				.doGetResultList(query, UsuarioEstabelecimento.class,
						parametros);

		List<Usuario> usuarios = new ArrayList<Usuario>();

		for (UsuarioEstabelecimento u : usuariosEstabelecimento) {
			usuarios.add(u.getUsarioEstabelecimentoPK().getUsuario());
		}

		return usuarios;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Usuario getUsuarioByLogin(String login) {
		logger.info("Consultando Usuario pelo login no banco de dados... ");

		if (login == null) {
			logger.error("Login obrigatório e não informado!");
			throw new DadosObrigatoriosNaoInformadosException(
					"Login obrigatório e não informado!");
		}

		Map parametros = new HashMap();
		parametros.put("login", login);

		return (Usuario) this.doGetSingleResult(
				"Select u from Usuario u where u.login = :login",
				Usuario.class, parametros);

	}

	public Usuario doAutenticarUsuario(String login, String senha)
			throws ServiceException {
		logger.info("Autenticando usuario...");

		if (login == null || senha == null)
			throw new ServiceException(
					"Para autenticação do Usuário é necessário informar login e senha");

		String query = "select u from Usuario u where u.login = :login and u.senha = :senha";

		Map<String, String> parametros = new HashMap<String, String>();
		parametros.put("login", login);
		parametros.put("senha", senha);

		return (Usuario) this.doGetSingleResult(query, Usuario.class,
				parametros);

	}

	public Perfil doGetPerfil(Integer idPerfil) throws ServiceException {

		Perfil perfil = (Perfil) super.doFind(Perfil.class, idPerfil);

		if (perfil == null)
			throw new ServiceException("Perfil não encontrado");

		return perfil;

	}

}
