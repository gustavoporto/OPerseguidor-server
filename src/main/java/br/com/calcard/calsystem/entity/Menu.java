package br.com.calcard.calsystem.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_menu")
public class Menu implements Serializable {

	private static final long serialVersionUID = 3114665897790779831L;

	@EmbeddedId
	private MenuPK menuPK;

	@Column(name = "nome", length = 20, nullable = false, unique = false)
	private String nome;

	@Column(name = "descricao", length = 30, nullable = true, unique = false)
	private String descricao;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_menu_perfil", joinColumns = {
			@JoinColumn(name = "id_menu"), @JoinColumn(name = "id_submenu") }, inverseJoinColumns = { @JoinColumn(name = "id_perfil") })
	private List<Perfil> perfis;

	public Menu() {
		super();
	}

	public Menu(MenuPK menuPK, String nome, String descricao,
			List<Perfil> perfis) {
		super();
		this.menuPK = menuPK;
		this.nome = nome;
		this.descricao = descricao;
		this.perfis = perfis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((menuPK == null) ? 0 : menuPK.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((perfis == null) ? 0 : perfis.hashCode());
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
		Menu other = (Menu) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (menuPK == null) {
			if (other.menuPK != null)
				return false;
		} else if (!menuPK.equals(other.menuPK))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (perfis == null) {
			if (other.perfis != null)
				return false;
		} else if (!perfis.equals(other.perfis))
			return false;
		return true;
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

	public MenuPK getMenuPK() {
		return menuPK;
	}

	public void setMenuPK(MenuPK menuPK) {
		this.menuPK = menuPK;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

}
