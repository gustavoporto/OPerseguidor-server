package br.com.calcard.calsystem.ws.dto;

import java.io.Serializable;

import br.com.calcard.calsystem.entity.Menu;

public class MenuDTO implements Serializable {

	private static final long serialVersionUID = 4795392041894647222L;

	private Integer idMenu;

	private Integer idSubmenu;

	private String nome;

	private String descricao;

	public MenuDTO() {
		super();
	}

	public MenuDTO(Menu menu) {
		this.idMenu = menu.getMenuPK().getIdMenu();
		this.idSubmenu = menu.getMenuPK().getIdSubMenu();
		this.nome = menu.getNome();
		this.descricao = menu.getDescricao();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idMenu == null) ? 0 : idMenu.hashCode());
		result = prime * result
				+ ((idSubmenu == null) ? 0 : idSubmenu.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		MenuDTO other = (MenuDTO) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idMenu == null) {
			if (other.idMenu != null)
				return false;
		} else if (!idMenu.equals(other.idMenu))
			return false;
		if (idSubmenu == null) {
			if (other.idSubmenu != null)
				return false;
		} else if (!idSubmenu.equals(other.idSubmenu))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public Integer getIdSubmenu() {
		return idSubmenu;
	}

	public void setIdSubmenu(Integer idSubmenu) {
		this.idSubmenu = idSubmenu;
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

}
