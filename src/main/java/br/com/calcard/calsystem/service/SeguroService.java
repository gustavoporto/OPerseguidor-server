package br.com.calcard.calsystem.service;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.calcard.calsystem.checkedException.EstabelecimentoDuplicadoException;
import br.com.calcard.calsystem.checkedException.LoginDuplicadoException;
import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.entity.SegurosVendidos;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.noCheckedException.DadosObrigatoriosNaoInformadosException;
import br.com.calcard.calsystem.noCheckedException.WSConductorException;
import br.com.conductor.AcumuladorSeguros;
import br.com.conductor.AcumuladorSegurosResp;
import br.com.conductor.FlashVendasSoapProxy;

@Repository
public class SeguroService extends AbstractService<SeguroService> {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	EstabelecimentoService estabelecimentoService;

	public SeguroService() {
		super(SeguroService.class);
	}

	private boolean isValidaSegurosVendidos(SegurosVendidos segurosVendidos) {
		logger.info("Validando Seguros vendidos...");

		if (segurosVendidos.getDataVenda() == null) {
			logger.error("Data da venda não informada!");
			throw new DadosObrigatoriosNaoInformadosException(
					"Data da venda não informada!");
		} else if (segurosVendidos.getEstabelecimento().equals(null)) {
			logger.error("Estabelecimento não informado!");
			throw new DadosObrigatoriosNaoInformadosException(
					"Estabelecimento não informado!");
		} else if (segurosVendidos.getUsuario().equals(null)) {
			logger.error("Usuário não informada!");
			throw new DadosObrigatoriosNaoInformadosException(
					"Usuário não informada!");
		}

		return true;

	}

	@Transactional
	public void doCadastrarVendaSeguro(SegurosVendidos segurosVendidos) {
		logger.info("Cadastrando seguros vendidos...");

		this.isValidaSegurosVendidos(segurosVendidos);

		SegurosVendidos seg = this.getSegurosVendidos(
				segurosVendidos.getEstabelecimento(),
				segurosVendidos.getUsuario(), segurosVendidos.getDataVenda());

		if (seg != null) {
			segurosVendidos.setId(seg.getId());
			this.edit(segurosVendidos);
		} else
			this.doCreate(segurosVendidos);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private SegurosVendidos getSegurosVendidos(Estabelecimento estabelecimento,
			Usuario usuario, Date dataVenda) {
		logger.info("Consultando Seguros vendidos... ");

		Map parametros = new HashMap();
		parametros.put("estabelecimento", estabelecimento);
		parametros.put("usuario", usuario);
		parametros.put("dataVenda", dataVenda);

		return (SegurosVendidos) super
				.doGetSingleResult(
						"Select u from SegurosVendidos u where u.estabelecimento = :estabelecimento and u.usuario = :usuario and dataVenda = :dataVenda",
						SegurosVendidos.class, parametros);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SegurosVendidos> listSegurosVendidos(
			Estabelecimento estabelecimento, Date dataVenda) {
		logger.info("Método: listSegurosVendidos");

		String query = "select s from SegurosVendidos s where s.dataVenda = :dataVenda and s.estabelecimento = :estabelecimento";
		Map parametros = new HashMap();
		parametros.put("estabelecimento", estabelecimento);
		parametros.put("dataVenda", dataVenda);

		List<SegurosVendidos> segurosVendidos = (List<SegurosVendidos>) this
				.doGetResultList(query, SegurosVendidos.class, parametros);

		return segurosVendidos;
	}

	/**
	 * Serviço responsável por consultar WS Conductor e atualizar a base local
	 * com os seguros vendidos.
	 * 
	 * @author gustavos
	 * 
	 */
	@Transactional
	public void doAtualizarSegurosVendidos() {
		logger.info("Atualizando seguros vendidos...");

		FlashVendasSoapProxy sampleFlashVendasSoapProxyid = new FlashVendasSoapProxy();

		AcumuladorSegurosResp acumuladorSegurosAderidos35mtemp;

		// Realiza consulta no Web Service da Conductor
		try {
			acumuladorSegurosAderidos35mtemp = sampleFlashVendasSoapProxyid
					.acumuladorSegurosAderidos();
		} catch (RemoteException e1) {
			logger.error(WSConductorException.MENSAGEM_DEFAULT + "["
					+ "AcumuladorSegurosAderidos" + "]", e1);
			throw new WSConductorException(
					WSConductorException.MENSAGEM_DEFAULT, e1);
		}

		/*
		 * Mocka o retorno do Web Service
		 */
		// AcumuladorSeguros[] mockAcumuladorSeguros = { new AcumuladorSeguros(
		// 103, "LOJA-103", "01496209001", "gportos", 18), };
		//
		// acumuladorSegurosAderidos35mtemp = new AcumuladorSegurosResp();
		// acumuladorSegurosAderidos35mtemp.setDataAtual("20141225");
		// acumuladorSegurosAderidos35mtemp
		// .setAcumuladorSeguros(mockAcumuladorSeguros);

		/*
		 * Converte a Data da consulta retornado pelo WS de String em Date
		 */
		Date dataConsulta;

		try {
			logger.debug(acumuladorSegurosAderidos35mtemp.getDataAtual());
			dataConsulta = new SimpleDateFormat("yyyyMMdd")
					.parse(acumuladorSegurosAderidos35mtemp.getDataAtual());
		} catch (ParseException e) {
			logger.error(
					"Erro ao converter data da consulta retornado pelo WS", e);
			throw new WSConductorException(
					"Erro ao converter data da consulta retornado pelo WS", e);
		}

		if (acumuladorSegurosAderidos35mtemp.getAcumuladorSeguros() != null) {
			for (int i = 0; i < acumuladorSegurosAderidos35mtemp
					.getAcumuladorSeguros().length; i++) {

				AcumuladorSeguros acumuladorSeguros = acumuladorSegurosAderidos35mtemp
						.getAcumuladorSeguros(i);

				// Cadastra os usuários não existentes
				Usuario usuario = new Usuario(acumuladorSeguros.getLogin(),
						acumuladorSeguros.getCPF());

				try {
					usuarioService.doCadastrarNovoUsuario(usuario);
				} catch (LoginDuplicadoException e) {
					usuario = usuarioService.getUsuarioByLogin(usuario
							.getLogin());
				}

				// Cadastra os estabelecimentos não existentes
				Estabelecimento estabelecimento = new Estabelecimento(
						acumuladorSeguros.getId_Estabelecimento(),
						acumuladorSeguros.getNomeEstabelecimento());

				try {
					estabelecimentoService
							.doCadastrarNovoEstabelecimento(estabelecimento);
				} catch (EstabelecimentoDuplicadoException e) {
					estabelecimento = (Estabelecimento) estabelecimentoService
							.doFind(Estabelecimento.class,
									estabelecimento.getId());
				}

				// Cadastra as vendas de seguros realizadas
				SegurosVendidos segurosVendidos = new SegurosVendidos(usuario,
						acumuladorSeguros.getQuantidadeRegistros(),
						dataConsulta, estabelecimento);

				this.doCadastrarVendaSeguro(segurosVendidos);

			}
		}

	}
}
