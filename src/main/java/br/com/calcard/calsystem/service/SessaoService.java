package br.com.calcard.calsystem.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.calcard.calsystem.checkedException.ServiceException;
import br.com.calcard.calsystem.checkedException.UsuarioInvalidoException;
import br.com.calcard.calsystem.entity.Sessao;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.rn.exception.usuario.UsuarioNaoEncontradoException;

@Repository
public class SessaoService extends AbstractService<Sessao> {

	@Autowired
	UsuarioService usuarioService;

	Sessao sessao;

	public SessaoService() {
		super(Sessao.class);
	}

	public Sessao login(String login, String senha)
			throws UsuarioInvalidoException, ServiceException,
			UsuarioNaoEncontradoException {
		logger.info("Logando...");

		// return novaSessao(usuarioService.autenticarUsuario(login, senha));

		return null;

	}

	private Long getNovoIdSessao() {

		return Long.parseLong(new SimpleDateFormat("yyMMddHHmmssSS")
				.format(new Date())
				+ String.format("%04d", new Random().nextInt(9999)));

	}

	private Date calcularDataExpiracao(Date data) {

		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(data);
		gc.add(Calendar.MINUTE, 30);

		return gc.getTime();

	}

	public Sessao novaSessao(Usuario usuario) throws ServiceException {

		sessao = new Sessao(getNovoIdSessao(), usuario, new Date(), new Date(),
				1, calcularDataExpiracao(new Date()));

		super.doCreate(sessao);
		return sessao;

	}
}
