package br.com.calcard.calsystem.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class MetaDepartamentoPK implements Serializable {

	private static final long serialVersionUID = -736935144407074073L;

	@ManyToOne
	@JoinColumn(name = "id_meta_estabelecimento", nullable = false, unique = false)
	protected MetaEstabelecimento metaEstabelecimento;

	@ManyToOne
	@JoinColumn(name = "id_departamento", nullable = false, unique = false)
	protected Departamento departamento;

	public MetaEstabelecimento getMetaEstabelecimento() {
		return metaEstabelecimento;
	}

	public void setMetaEstabelecimento(MetaEstabelecimento metaEstabelecimento) {
		this.metaEstabelecimento = metaEstabelecimento;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((departamento == null) ? 0 : departamento.hashCode());
		result = prime
				* result
				+ ((metaEstabelecimento == null) ? 0 : metaEstabelecimento
						.hashCode());
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
		MetaDepartamentoPK other = (MetaDepartamentoPK) obj;
		if (departamento == null) {
			if (other.departamento != null)
				return false;
		} else if (!departamento.equals(other.departamento))
			return false;
		if (metaEstabelecimento == null) {
			if (other.metaEstabelecimento != null)
				return false;
		} else if (!metaEstabelecimento.equals(other.metaEstabelecimento))
			return false;
		return true;
	}

}
