package br.com.calcard.calsystem.ws.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.entity.Usuario;

public class PropostaAtivadaDTO implements Serializable {

	private static final long serialVersionUID = -8245492475376900805L;

	private Integer id;

	private UsuarioDTO usuario;

	private int quantidade;

	private Date dataAtivacao;

	private EstabelecimentoDTO estabelecimento;

	public PropostaAtivadaDTO(Integer id, Usuario usuario, int quantidade,
			Date dataAtivacao, Estabelecimento estabelecimento) {
		super();
		this.id = id;
		this.usuario = new UsuarioDTO(usuario);
		this.quantidade = quantidade;
		this.dataAtivacao = dataAtivacao;
		this.estabelecimento = new EstabelecimentoDTO(estabelecimento);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataAtivacao() {
		return dataAtivacao;
	}

	public void setDataAtivacao(Date dataAtivacao) {
		this.dataAtivacao = dataAtivacao;
	}

	public EstabelecimentoDTO getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(EstabelecimentoDTO estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

}
