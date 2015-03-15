package br.com.calcard.calsystem.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Table(name = "tbl_sessao")
public class Sessao extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 8475544441196755960L;

	@Id
	@Column(name = "id", nullable = false, unique = true)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false, unique = false)
	private Usuario usuario;

	@Column(name = "dt_autenticacao", unique = false, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAutenticacao;

	@Column(name = "dt_ultima_autenticacao", unique = false, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAutenticacao;

	@Column(name = "qtd_autenticacao", unique = false, nullable = false)
	private int quantidadeAutenticacao;

	@Column(name = "dt_expiracao", unique = false, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataExpiracao;

	public Sessao() {
	}

	public Sessao(Long id, Usuario usuario, Date dataAutenticacao,
			Date dataUltimaAutenticacao, int quantidadeAutenticacao,
			Date dataExpiracao) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.dataAutenticacao = dataAutenticacao;
		this.dataUltimaAutenticacao = dataUltimaAutenticacao;
		this.quantidadeAutenticacao = quantidadeAutenticacao;
		this.dataExpiracao = dataExpiracao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDataAutenticacao() {
		return dataAutenticacao;
	}

	public void setDataAutenticacao(Date dataAutenticacao) {
		this.dataAutenticacao = dataAutenticacao;
	}

	public Date getDataUltimaAutenticacao() {
		return dataUltimaAutenticacao;
	}

	public void setDataUltimaAutenticacao(Date dataUltimaAutenticacao) {
		this.dataUltimaAutenticacao = dataUltimaAutenticacao;
	}

	public int getQuantidadeAutenticacao() {
		return quantidadeAutenticacao;
	}

	public void setQuantidadeAutenticacao(int quantidadeAutenticacao) {
		this.quantidadeAutenticacao = quantidadeAutenticacao;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

}
