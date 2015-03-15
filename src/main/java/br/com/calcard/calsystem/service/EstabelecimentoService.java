package br.com.calcard.calsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.calcard.calsystem.checkedException.EstabelecimentoDuplicadoException;
import br.com.calcard.calsystem.checkedException.ServiceException;
import br.com.calcard.calsystem.entity.Departamento;
import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.entity.MetaDepartamento;
import br.com.calcard.calsystem.entity.MetaEstabelecimento;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.entity.UsuarioEstabelecimento;
import br.com.calcard.calsystem.noCheckedException.IdNaoInformadoException;
import br.com.calcard.calsystem.noCheckedException.NomeNaoInformadoException;

@Repository
public class EstabelecimentoService extends
		AbstractService<EstabelecimentoService> {

	@Autowired
	SegurancaService segurancaService;

	public EstabelecimentoService() {
		super(EstabelecimentoService.class);
	}

	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// public Estabelecimento getEstabelecimentoById(Integer id) {
	// logger.info("Consultando Estabelecimento pelo Id no banco de dados... ");
	//
	// if (id == null)
	// throw new DadosObrigatoriosNaoInformadosException(
	// "Id não informado!");
	//
	// Map parametros = new HashMap();
	// parametros.put("id", id);
	//
	// return (Estabelecimento) this.getSingleResult(
	// "Select u from Estabelecimento u where u.id = :id",
	// Estabelecimento.class, parametros);
	//
	// }

	@SuppressWarnings("unchecked")
	public List<Estabelecimento> doListarEstabelecimentos(String hashToken)
			throws ServiceException {

		return (List<Estabelecimento>) super.findAll(Estabelecimento.class);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<MetaDepartamento> doListMetaDepartamento(
			Integer idMetaEstabelecimento) {
		logger.info("Método: doGetMetaDepartamento");

		String query = "select m from MetaDepartamento m where m.metaDepartametoPK.metaEstabelecimento = :metaEstabelecimento";
		Map parametros = new HashMap();

		MetaEstabelecimento metaEstabelecimento = (MetaEstabelecimento) super
				.doFind(MetaEstabelecimento.class, idMetaEstabelecimento);

		parametros.put("metaEstabelecimento", metaEstabelecimento);

		return (List<MetaDepartamento>) this.doGetResultList(query,
				MetaDepartamento.class, parametros);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Departamento doGetDepartamentoUsuario(Usuario usuario) {
		logger.info("Método: doGetDepartamentoUsuario");

		String query = "select ue from UsuarioEstabelecimento ue where ue.usuarioEstabelecimentoPK.usuario = :usuario";

		Map parametros = new HashMap();
		parametros.put("usuario", usuario);

		UsuarioEstabelecimento usuarioEstabelecimento = (UsuarioEstabelecimento) super
				.doGetSingleResult(query, UsuarioEstabelecimento.class,
						parametros);

		return usuarioEstabelecimento.getDepartamento();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MetaDepartamento doGetMetaDepartamento(Departamento departamento,
			MetaEstabelecimento metaEstabelecimento) {
		logger.info("Método: doGetMetaDepartamento");

		Map parametros = new HashMap();
		parametros.put("departamento", departamento);
		parametros.put("metaEstabelecimento", metaEstabelecimento);

		MetaDepartamento metaDepartamento = (MetaDepartamento) super
				.doGetSingleResult(
						"select m from MetaDepartamento m "
								+ "where m.metaDepartametoPK.departamento = :departamento "
								+ "and m.metaDepartametoPK.metaEstabelecimento = :metaEstabelecimento",
						MetaDepartamento.class, parametros);

		return metaDepartamento;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MetaEstabelecimento doGetMetaEstabelecimento(
			Estabelecimento estabelecimento) {
		logger.info("Método: doGetMetaEstabelecimento");

		Map parametros = new HashMap();
		parametros.put("estabelecimento", estabelecimento);

		MetaEstabelecimento metaEstabelecimento = (MetaEstabelecimento) super
				.doGetSingleResult(
						"select m from MetaEstabelecimento m where m.estabelecimento = :estabelecimento",
						MetaEstabelecimento.class, parametros);

		return metaEstabelecimento;

	}

	public Estabelecimento doGetEstabelecimento(Integer id) {
		logger.info("Método: doGetEstabelecimento()");

		return (Estabelecimento) this.doFind(Estabelecimento.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Departamento> doListDepartamentos() {
		logger.info("Método: doListDepartamentos");

		String query = "select d from Departamento d";
		List<Departamento> departamentos = (List<Departamento>) this
				.doGetResultList(query, Departamento.class, null);

		return departamentos;

	}

	@Transactional
	public void doCadastrarNovoEstabelecimento(Estabelecimento estabelecimento)
			throws EstabelecimentoDuplicadoException {
		logger.info("Cadastrando novo estabelecimento...");

		if (estabelecimento.getId().equals(null)) {
			logger.error("Id não informado!");
			throw new IdNaoInformadoException();
		} else if (estabelecimento.getNome().equals(null)) {
			logger.error("Nome não informado!");
			throw new NomeNaoInformadoException();
		}

		if (this.doFind(Estabelecimento.class, estabelecimento.getId()) != null) {
			logger.warn("Já existe um estabelecimento cadastrado com este Id!");
			throw new EstabelecimentoDuplicadoException(
					"Já existe um estabelecimento cadastrado com este Id!");
		}

		this.doCreate(estabelecimento);

	}

}
