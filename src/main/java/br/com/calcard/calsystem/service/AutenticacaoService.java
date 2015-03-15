package br.com.calcard.calsystem.service;

import java.util.HashMap;
import java.util.Map;
import javax.security.auth.login.LoginException;
import org.springframework.stereotype.Repository;
import br.com.calcard.calsystem.entity.Usuario;

@Repository
public class AutenticacaoService extends AbstractService<AutenticacaoService> {

	public AutenticacaoService() {
		super(AutenticacaoService.class);
	}

	public void doAutenticarUsuario(String login, String senha)
			throws LoginException {

		String query = "Select u from Usuario u where u.login = :login";

		Map<String, String> parametros = new HashMap<String, String>();
		parametros.put("login", login);

		Usuario usuario = (Usuario) super.doGetSingleResult(query,
				Usuario.class, parametros);

		if (usuario == null || usuario.getSenha() != senha)
			throw new LoginException("Nome do Usuário ou Senha inválidos");

	}
}
