package br.com.calcard.calsystem.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_usuario_estabelecimeto")
public class UsuarioEstabelecimento implements Serializable {

	private static final long serialVersionUID = 3926795254082019902L;

	@EmbeddedId
	private UsuarioEstabelecimentoPK usuarioEstabelecimentoPK;

	@ManyToOne
	@JoinColumn(name = "id_departamento", nullable = true, unique = false)
	private Departamento departamento;

	public UsuarioEstabelecimentoPK getUsarioEstabelecimentoPK() {
		return getUsuarioEstabelecimentoPK();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((departamento == null) ? 0 : departamento.hashCode());
		result = prime
				* result
				+ ((usuarioEstabelecimentoPK == null) ? 0
						: usuarioEstabelecimentoPK.hashCode());
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
		UsuarioEstabelecimento other = (UsuarioEstabelecimento) obj;
		if (departamento == null) {
			if (other.departamento != null)
				return false;
		} else if (!departamento.equals(other.departamento))
			return false;
		if (usuarioEstabelecimentoPK == null) {
			if (other.usuarioEstabelecimentoPK != null)
				return false;
		} else if (!usuarioEstabelecimentoPK
				.equals(other.usuarioEstabelecimentoPK))
			return false;
		return true;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public UsuarioEstabelecimentoPK getUsuarioEstabelecimentoPK() {
		return usuarioEstabelecimentoPK;
	}

	public void setUsuarioEstabelecimentoPK(
			UsuarioEstabelecimentoPK usuarioEstabelecimentoPK) {
		this.usuarioEstabelecimentoPK = usuarioEstabelecimentoPK;
	}

}
