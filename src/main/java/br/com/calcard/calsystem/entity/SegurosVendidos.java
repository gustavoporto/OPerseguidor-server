package br.com.calcard.calsystem.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_seguros_vendidos", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"id_usuario", "id_estabelecimento", "data_venda", }) })
public class SegurosVendidos extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -2168576384545040929L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = 18, nullable = false, unique = true)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false, unique = false)
	private Usuario usuario;

	@Column(name = "quantidade", length = 3, nullable = false, unique = false)
	private int quantidade;

	@Column(name = "data_venda", unique = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataVenda;

	@ManyToOne
	@JoinColumn(name = "id_estabelecimento", nullable = false, unique = false)
	private Estabelecimento estabelecimento;

	public SegurosVendidos() {
		super();
	}

	public SegurosVendidos(Usuario usuario, int quantidade, Date dataVenda,
			Estabelecimento estabelecimento) {
		super();
		this.usuario = usuario;
		this.quantidade = quantidade;
		this.dataVenda = dataVenda;
		this.estabelecimento = estabelecimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

}
