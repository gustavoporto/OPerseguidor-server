package br.com.calcard.calsystem.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.calcard.calsystem.checkedException.ServiceException;
import br.com.calcard.calsystem.entity.CartaSenha;
import br.com.calcard.calsystem.entity.CartaSenhaLote;
import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.entity.ParametroGlobal;
import br.com.calcard.calsystem.rn.exception.cartaSenha.NenhumLoteEncontradoException;
import br.com.calcard.calsystem.ws.dto.CartaSenhaLoteDTO;

@Repository
public class CartaSenhaService {

	@Autowired
	EstabelecimentoService estabelecimentoService;

	@Autowired
	GenericService genericService;

	@Autowired
	ParametroGlobalService parametroGlobalService;

	public static void main(String[] args) {

		CartaSenhaService c = new CartaSenhaService();

		try {
			c.doGerarCartaSenha();
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

	public void doAgendarLoteCartaSenha(CartaSenhaLoteDTO cartaSenhaLoteDTO) {

		Estabelecimento estabelecimento = estabelecimentoService
				.doGetEstabelecimento(cartaSenhaLoteDTO.getIdEstabelecimento());

		CartaSenhaLote cartaSenhaLote = new CartaSenhaLote(
				CartaSenhaLote.STATUS_AGENDADO, estabelecimento,
				cartaSenhaLoteDTO.getQuantidadeCartas());

		genericService.doInsert(cartaSenhaLote);

	}

	@SuppressWarnings("unchecked")
	public List<CartaSenhaLote> doListarLotes()
			throws NenhumLoteEncontradoException {

		List<CartaSenhaLote> listaCartasSenhas = (List<CartaSenhaLote>) genericService
				.doFindAll(CartaSenhaLote.class);

		if (listaCartasSenhas == null || listaCartasSenhas.size() == 0)
			throw new NenhumLoteEncontradoException(
					"Não foi encontrado nenhum cadastro de Lote de Carta Senha.");

		return listaCartasSenhas;

	}

	@SuppressWarnings("unchecked")
	private List<CartaSenhaLote> doListarLotesAgendados() {

		String query = "select c from CartaSenhaLote c  where c.status = :status";

		Map<String, String> parametros = new HashMap<String, String>();
		parametros.put("status", CartaSenhaLote.STATUS_AGENDADO);

		return (List<CartaSenhaLote>) genericService.doGetResultList(query,
				CartaSenhaLote.class, parametros);

	}

	private void doGerarArquivo(String nomeArquivo, int quantidadeRegistros,
			CartaSenhaLote lote, String codigoEstabelecimento)
			throws ServiceException {

		ParametroGlobal parametroLocalCartaSenha = parametroGlobalService
				.doGetParametro(ParametroGlobal.PARAMETRO_LOCAL_CARTA_SENHA);

		String loteStr = String.format("%06d", lote.getId());
		String codigoEstabelecimentoStr = String.format("%6s",
				codigoEstabelecimento).replace(' ', '0');

		File file = new File(parametroLocalCartaSenha.getValorTexto() + "/"
				+ nomeArquivo);

		try {

			FileWriter fw = new FileWriter(file);

			BufferedWriter bw = new BufferedWriter(fw);

			// HEADER DO ARQUIVO
			bw.write(loteStr + codigoEstabelecimentoStr);

			for (int index = 1; index <= quantidadeRegistros; index++) {

				bw.newLine();

				String randomStr = String.format("%04d",
						new Random().nextInt(9999));

				String senhaStr = String.format("%04d",
						new Random().nextInt(9999));

				String sequencialStr = String.format("%06d", index);

				String codigo = loteStr + randomStr + sequencialStr
						+ codigoEstabelecimentoStr;

				bw.write(codigo + senhaStr);

				CartaSenha cartaSenha = new CartaSenha(
						CartaSenha.STATUS_DISPONIVEL, codigo, senhaStr, lote);

				genericService.doInsert(cartaSenha);

			}

			bw.close();
			fw.close();

		} catch (IOException e) {
			throw new ServiceException(
					"Não foi possível gerar o Arquivo de Carta Senha!", e);
		}

	}

	public void doGerarCartaSenha() throws ServiceException {

		List<CartaSenhaLote> lotesAgendados = doListarLotesAgendados();

		if (lotesAgendados != null && lotesAgendados.size() > 0) {

			for (CartaSenhaLote lote : lotesAgendados) {

				String nomeArquivo = "carta_senha_"
						+ new SimpleDateFormat("yyyyMMdd").format(new Date())
						+ "_" + lote.getEstabelecimento().getCodigo();

				lote.setStatus(CartaSenhaLote.STATUS_PENDENTE);

				genericService.doUpdate(lote);

				this.doGerarArquivo(nomeArquivo, lote.getQuantidadeCartas(),
						lote, lote.getEstabelecimento().getCodigo());

				lote.setStatus(CartaSenhaLote.STATUS_DISPONIVEL);

			}
		}

	}
}
