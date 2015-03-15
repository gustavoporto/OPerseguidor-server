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
import br.com.calcard.calsystem.entity.PropostaAtivada;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.noCheckedException.WSConductorException;
import br.com.conductor.AcumuladorPropostasAtivadas;
import br.com.conductor.AcumuladorPropostasAtivadasResp;
import br.com.conductor.FlashVendasSoapProxy;

@Repository
public class PropostaService extends AbstractService<PropostaService> {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	EstabelecimentoService estabelecimentoService;

	public PropostaService() {
		super(PropostaService.class);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<PropostaAtivada> doListPropostasAtivadas(
			Estabelecimento estabelecimento) {
		logger.info("Método: doListPropostasAtivadas()");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date d = null;
		try {
			d = dateFormat.parse(dateFormat.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String query = "select pa from PropostaAtivada pa where pa.estabelecimento = :estabelecimento and pa.dataAtivacao = :data";

		Map parametros = new HashMap();
		parametros.put("estabelecimento", estabelecimento);
		parametros.put("data", d);

		return (List<PropostaAtivada>) this.doGetResultList(query,
				PropostaAtivada.class, parametros);

	}

	public void doAtualizarPropostaAtivadas() {
		logger.info("Método: doAtualizarPropostaAtivadas()");

		FlashVendasSoapProxy sampleFlashVendasSoapProxyid = new FlashVendasSoapProxy();

		// AcumuladorSegurosResp acumuladorSegurosAderidos35mtemp;
		AcumuladorPropostasAtivadasResp acumuladorPropostasAtivadasResp;

		// Realiza consulta no Web Service da Conductor
		try {
			acumuladorPropostasAtivadasResp = sampleFlashVendasSoapProxyid
					.acumuladorPropostasAtivadas();
		} catch (RemoteException e1) {
			logger.error(WSConductorException.MENSAGEM_DEFAULT + "["
					+ "AcumuladorPropostasAtivadas" + "]", e1);
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
			// logger.debug(acumuladorSegurosAderidos35mtemp.getDataAtual());
			dataConsulta = new SimpleDateFormat("yyyyMMdd")
					.parse(acumuladorPropostasAtivadasResp.getDataAtual());
		} catch (ParseException e) {
			logger.error(
					"Erro ao converter data da consulta retornado pelo WS", e);
			throw new WSConductorException(
					"Erro ao converter data da consulta retornado pelo WS", e);
		}

		if (acumuladorPropostasAtivadasResp.getAcumuladorPropostasAtivadas() != null) {

			for (int i = 0; i < acumuladorPropostasAtivadasResp
					.getAcumuladorPropostasAtivadas().length; i++) {

				AcumuladorPropostasAtivadas acumuladorPropostaAtivadas = acumuladorPropostasAtivadasResp
						.getAcumuladorPropostasAtivadas(i);

				// Cadastra os usuários não existentes
				Usuario usuario = new Usuario(
						acumuladorPropostaAtivadas.getLogin(),
						acumuladorPropostaAtivadas.getCPF());

				try {
					usuarioService.doCadastrarNovoUsuario(usuario);
				} catch (LoginDuplicadoException e) {
					usuario = usuarioService.getUsuarioByLogin(usuario
							.getLogin());
				}

				// Cadastra os estabelecimentos não existentes
				Estabelecimento estabelecimento = new Estabelecimento(
						acumuladorPropostaAtivadas.getId_Estabelecimento(),
						acumuladorPropostaAtivadas.getNomeEstabelecimento());

				try {
					estabelecimentoService
							.doCadastrarNovoEstabelecimento(estabelecimento);
				} catch (EstabelecimentoDuplicadoException e) {
					estabelecimento = (Estabelecimento) estabelecimentoService
							.doFind(Estabelecimento.class,
									estabelecimento.getId());
				}

				// Cadastra as vendas de seguros realizadas
				PropostaAtivada propostaAtivada = new PropostaAtivada(usuario,
						acumuladorPropostaAtivadas
								.getQuantidadePropostasAtivadas(),
						dataConsulta, estabelecimento);

				this.doCadastrarPropostaAtivada(propostaAtivada);

			}
		}

	}

	@Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doCadastrarPropostaAtivada(PropostaAtivada propostaAtivada) {
		logger.info("Método: doCadastrarPropostaAtivada()");

		Map parametros = new HashMap();
		parametros.put("estabelecimento", propostaAtivada.getEstabelecimento());
		parametros.put("usuario", propostaAtivada.getUsuario());
		parametros.put("dataAtivacao", propostaAtivada.getDataAtivacao());
		String query = "Select pa from PropostaAtivada pa where pa.estabelecimento = :estabelecimento and pa.usuario = :usuario and pa.dataAtivacao = :dataAtivacao";

		PropostaAtivada proposta = (PropostaAtivada) super.doGetSingleResult(
				query, PropostaAtivada.class, parametros);

		// ATUALIZA PROPOSTA SE JÁ EXISTE
		if (proposta != null) {
			propostaAtivada.setId(proposta.getId());
			this.edit(propostaAtivada);
		}

		// CADASTRA PROPOSTA SE NÃO EXISTE
		else
			this.doCreate(propostaAtivada);

	}
}
