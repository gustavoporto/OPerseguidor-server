package br.com.calcard.calsystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
// @Inheritance(strategy = InheritanceType.JOINED)
//@Table(name = "tbl_job")
public class Job implements Serializable {

	private static final long serialVersionUID = -9039488316590610735L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = 5, nullable = false, unique = true)
	private Long id;

	@Column(name = "status", length = 10, nullable = false, unique = false)
	private String status;

	@Column(name = "nome", length = 100, nullable = false, unique = true)
	private String nome;

	@Column(name = "descricao", length = 100, nullable = false, unique = false)
	private String descricao;

	@Column(name = "periodo_execucao", length = 20, nullable = false, unique = false)
	private String periodoExecucao;

	@Column(name = "diretorio_origem", length = 100, nullable = false, unique = false)
	private String diretorioOrigem;

	@Column(name = "diretorio_destino", length = 100, nullable = false, unique = false)
	private String diretorioDestino;

	@Column(name = "nome_arquivo_origem", length = 100, nullable = false, unique = false)
	private String nomeArquivoOrigem;

	@Column(name = "nome_arquivo_destino", length = 100, nullable = false, unique = false)
	private String nomeArquivoDestino;

	@Column(name = "usuario_origem", length = 100, nullable = false, unique = false)
	private String usuarioOrigem;

	@Column(name = "senha_origem", length = 100, nullable = true, unique = false)
	private String senhaOrigem;

	@Column(name = "chave_privada_origem", length = 100, nullable = true, unique = false)
	private String chavePrivadaOrigem;

	@Column(name = "usuario_destino", length = 100, nullable = false, unique = false)
	private String usuarioDestino;

	@Column(name = "senha_destino", length = 100, nullable = true, unique = false)
	private String senhaDestino;

	@Column(name = "chave_privada_destino", length = 100, nullable = true, unique = false)
	private String chavePrivadaDestino;

	@Column(name = "host_origem", length = 100, nullable = false, unique = false)
	private String hostOrigem;

	@Column(name = "porta_origem", length = 10, nullable = false, unique = false)
	private int portaOrigem;

	@Column(name = "host_destino", length = 100, nullable = false, unique = false)
	private String hostDestino;

	@Column(name = "porta_destino", length = 10, nullable = false, unique = false)
	private int portaDestino;

	public Job() {
		super();
	}

	public Job(Long id, String status, String nome, String descricao,
			String periodoExecucao, String diretorioOrigem,
			String diretorioDestino, String nomeArquivoOrigem,
			String nomeArquivoDestino, String usuarioOrigem,
			String senhaOrigem, String chavePrivadaOrigem,
			String usuarioDestino, String senhaDestino,
			String chavePrivadaDestino, String hostOrigem, int portaOrigem,
			String hostDestino, int portaDestino) {
		super();
		this.id = id;
		this.status = status;
		this.nome = nome;
		this.descricao = descricao;
		this.periodoExecucao = periodoExecucao;
		this.diretorioOrigem = diretorioOrigem;
		this.diretorioDestino = diretorioDestino;
		this.nomeArquivoOrigem = nomeArquivoOrigem;
		this.nomeArquivoDestino = nomeArquivoDestino;
		this.usuarioOrigem = usuarioOrigem;
		this.senhaOrigem = senhaOrigem;
		this.chavePrivadaOrigem = chavePrivadaOrigem;
		this.usuarioDestino = usuarioDestino;
		this.senhaDestino = senhaDestino;
		this.chavePrivadaDestino = chavePrivadaDestino;
		this.hostOrigem = hostOrigem;
		this.portaOrigem = portaOrigem;
		this.hostDestino = hostDestino;
		this.portaDestino = portaDestino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((chavePrivadaDestino == null) ? 0 : chavePrivadaDestino
						.hashCode());
		result = prime
				* result
				+ ((chavePrivadaOrigem == null) ? 0 : chavePrivadaOrigem
						.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime
				* result
				+ ((diretorioDestino == null) ? 0 : diretorioDestino.hashCode());
		result = prime * result
				+ ((diretorioOrigem == null) ? 0 : diretorioOrigem.hashCode());
		result = prime * result
				+ ((hostDestino == null) ? 0 : hostDestino.hashCode());
		result = prime * result
				+ ((hostOrigem == null) ? 0 : hostOrigem.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime
				* result
				+ ((nomeArquivoDestino == null) ? 0 : nomeArquivoDestino
						.hashCode());
		result = prime
				* result
				+ ((nomeArquivoOrigem == null) ? 0 : nomeArquivoOrigem
						.hashCode());
		result = prime * result
				+ ((periodoExecucao == null) ? 0 : periodoExecucao.hashCode());
		result = prime * result + portaDestino;
		result = prime * result + portaOrigem;
		result = prime * result
				+ ((senhaDestino == null) ? 0 : senhaDestino.hashCode());
		result = prime * result
				+ ((senhaOrigem == null) ? 0 : senhaOrigem.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((usuarioDestino == null) ? 0 : usuarioDestino.hashCode());
		result = prime * result
				+ ((usuarioOrigem == null) ? 0 : usuarioOrigem.hashCode());
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
		Job other = (Job) obj;
		if (chavePrivadaDestino == null) {
			if (other.chavePrivadaDestino != null)
				return false;
		} else if (!chavePrivadaDestino.equals(other.chavePrivadaDestino))
			return false;
		if (chavePrivadaOrigem == null) {
			if (other.chavePrivadaOrigem != null)
				return false;
		} else if (!chavePrivadaOrigem.equals(other.chavePrivadaOrigem))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (diretorioDestino == null) {
			if (other.diretorioDestino != null)
				return false;
		} else if (!diretorioDestino.equals(other.diretorioDestino))
			return false;
		if (diretorioOrigem == null) {
			if (other.diretorioOrigem != null)
				return false;
		} else if (!diretorioOrigem.equals(other.diretorioOrigem))
			return false;
		if (hostDestino == null) {
			if (other.hostDestino != null)
				return false;
		} else if (!hostDestino.equals(other.hostDestino))
			return false;
		if (hostOrigem == null) {
			if (other.hostOrigem != null)
				return false;
		} else if (!hostOrigem.equals(other.hostOrigem))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeArquivoDestino == null) {
			if (other.nomeArquivoDestino != null)
				return false;
		} else if (!nomeArquivoDestino.equals(other.nomeArquivoDestino))
			return false;
		if (nomeArquivoOrigem == null) {
			if (other.nomeArquivoOrigem != null)
				return false;
		} else if (!nomeArquivoOrigem.equals(other.nomeArquivoOrigem))
			return false;
		if (periodoExecucao == null) {
			if (other.periodoExecucao != null)
				return false;
		} else if (!periodoExecucao.equals(other.periodoExecucao))
			return false;
		if (portaDestino != other.portaDestino)
			return false;
		if (portaOrigem != other.portaOrigem)
			return false;
		if (senhaDestino == null) {
			if (other.senhaDestino != null)
				return false;
		} else if (!senhaDestino.equals(other.senhaDestino))
			return false;
		if (senhaOrigem == null) {
			if (other.senhaOrigem != null)
				return false;
		} else if (!senhaOrigem.equals(other.senhaOrigem))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (usuarioDestino == null) {
			if (other.usuarioDestino != null)
				return false;
		} else if (!usuarioDestino.equals(other.usuarioDestino))
			return false;
		if (usuarioOrigem == null) {
			if (other.usuarioOrigem != null)
				return false;
		} else if (!usuarioOrigem.equals(other.usuarioOrigem))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPeriodoExecucao() {
		return periodoExecucao;
	}

	public void setPeriodoExecucao(String periodoExecucao) {
		this.periodoExecucao = periodoExecucao;
	}

	public String getDiretorioOrigem() {
		return diretorioOrigem;
	}

	public void setDiretorioOrigem(String diretorioOrigem) {
		this.diretorioOrigem = diretorioOrigem;
	}

	public String getDiretorioDestino() {
		return diretorioDestino;
	}

	public void setDiretorioDestino(String diretorioDestino) {
		this.diretorioDestino = diretorioDestino;
	}

	public String getNomeArquivoOrigem() {
		return nomeArquivoOrigem;
	}

	public void setNomeArquivoOrigem(String nomeArquivoOrigem) {
		this.nomeArquivoOrigem = nomeArquivoOrigem;
	}

	public String getNomeArquivoDestino() {
		return nomeArquivoDestino;
	}

	public void setNomeArquivoDestino(String nomeArquivoDestino) {
		this.nomeArquivoDestino = nomeArquivoDestino;
	}

	public String getUsuarioOrigem() {
		return usuarioOrigem;
	}

	public void setUsuarioOrigem(String usuarioOrigem) {
		this.usuarioOrigem = usuarioOrigem;
	}

	public String getSenhaOrigem() {
		return senhaOrigem;
	}

	public void setSenhaOrigem(String senhaOrigem) {
		this.senhaOrigem = senhaOrigem;
	}

	public String getChavePrivadaOrigem() {
		return chavePrivadaOrigem;
	}

	public void setChavePrivadaOrigem(String chavePrivadaOrigem) {
		this.chavePrivadaOrigem = chavePrivadaOrigem;
	}

	public String getUsuarioDestino() {
		return usuarioDestino;
	}

	public void setUsuarioDestino(String usuarioDestino) {
		this.usuarioDestino = usuarioDestino;
	}

	public String getSenhaDestino() {
		return senhaDestino;
	}

	public void setSenhaDestino(String senhaDestino) {
		this.senhaDestino = senhaDestino;
	}

	public String getChavePrivadaDestino() {
		return chavePrivadaDestino;
	}

	public void setChavePrivadaDestino(String chavePrivadaDestino) {
		this.chavePrivadaDestino = chavePrivadaDestino;
	}

	public String getHostOrigem() {
		return hostOrigem;
	}

	public void setHostOrigem(String hostOrigem) {
		this.hostOrigem = hostOrigem;
	}

	public int getPortaOrigem() {
		return portaOrigem;
	}

	public void setPortaOrigem(int portaOrigem) {
		this.portaOrigem = portaOrigem;
	}

	public String getHostDestino() {
		return hostDestino;
	}

	public void setHostDestino(String hostDestino) {
		this.hostDestino = hostDestino;
	}

	public int getPortaDestino() {
		return portaDestino;
	}

	public void setPortaDestino(int portaDestino) {
		this.portaDestino = portaDestino;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
