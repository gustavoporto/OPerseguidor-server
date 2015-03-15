package br.com.calcard.calsystem.entity;

import java.io.Serializable;
import java.security.KeyPair;
import java.util.Date;

public class Token implements Serializable {

	public static final String TIPO_TOKEN_LOGIN = "login";

	public static final String TIPO_TOKEN_USUARIO = "usuario";

	private static final long serialVersionUID = 2571198839545813383L;

	private String idPeriferico;

	private Long random;

	private String hash;

	private Usuario usuario;

	private Integer idUsuario;

	private Date dataCriacao;

	private Date dataExpiracao;

	private String permissao;

	private String tipo;

	private KeyPair keyPair;

	public Token() {
		super();
	}

	public Token(String idPeriferico, Long random, String hash,
			Usuario usuario, Date dataCriacao, Date dataExpiracao,
			String permissao, String tipo, KeyPair keyPair) {
		super();
		this.idPeriferico = idPeriferico;
		this.random = random;
		this.hash = hash;
		this.usuario = usuario;
		this.dataCriacao = dataCriacao;
		this.dataExpiracao = dataExpiracao;
		this.permissao = permissao;
		this.tipo = tipo;
		this.keyPair = keyPair;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result
				+ ((dataExpiracao == null) ? 0 : dataExpiracao.hashCode());
		result = prime * result + ((hash == null) ? 0 : hash.hashCode());
		result = prime * result
				+ ((idPeriferico == null) ? 0 : idPeriferico.hashCode());
		result = prime * result
				+ ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((keyPair == null) ? 0 : keyPair.hashCode());
		result = prime * result
				+ ((permissao == null) ? 0 : permissao.hashCode());
		result = prime * result + ((random == null) ? 0 : random.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dataExpiracao == null) {
			if (other.dataExpiracao != null)
				return false;
		} else if (!dataExpiracao.equals(other.dataExpiracao))
			return false;
		if (hash == null) {
			if (other.hash != null)
				return false;
		} else if (!hash.equals(other.hash))
			return false;
		if (idPeriferico == null) {
			if (other.idPeriferico != null)
				return false;
		} else if (!idPeriferico.equals(other.idPeriferico))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (keyPair == null) {
			if (other.keyPair != null)
				return false;
		} else if (!keyPair.equals(other.keyPair))
			return false;
		if (permissao == null) {
			if (other.permissao != null)
				return false;
		} else if (!permissao.equals(other.permissao))
			return false;
		if (random == null) {
			if (other.random != null)
				return false;
		} else if (!random.equals(other.random))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public Long getRandom() {
		return random;
	}

	public void setRandom(Long random) {
		this.random = random;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public KeyPair getKeyPair() {
		return keyPair;
	}

	public void setKeyPair(KeyPair keyPair) {
		this.keyPair = keyPair;
	}

	public String getIdPeriferico() {
		return idPeriferico;
	}

	public void setIdPeriferico(String idPeriferico) {
		this.idPeriferico = idPeriferico;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
