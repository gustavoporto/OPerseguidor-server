package br.com.calcard.calsystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_meta_departamento")
public class MetaDepartamento implements Serializable {

	private static final long serialVersionUID = 3664452041892717614L;

	@EmbeddedId
	private MetaDepartamentoPK metaDepartametoPK;

	@Column(name = "percentual", length = 6, nullable = false, unique = false)
	private int percentual;

	public MetaDepartamentoPK getMetaDepartametoPK() {
		return metaDepartametoPK;
	}

	public void setMetaDepartametoPK(MetaDepartamentoPK metaDepartametoPK) {
		this.metaDepartametoPK = metaDepartametoPK;
	}

	public int getPercentual() {
		return percentual;
	}

	public void setPercentual(int percentual) {
		this.percentual = percentual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((metaDepartametoPK == null) ? 0 : metaDepartametoPK
						.hashCode());
		result = prime * result + percentual;
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
		MetaDepartamento other = (MetaDepartamento) obj;
		if (metaDepartametoPK == null) {
			if (other.metaDepartametoPK != null)
				return false;
		} else if (!metaDepartametoPK.equals(other.metaDepartametoPK))
			return false;
		if (percentual != other.percentual)
			return false;
		return true;
	}

}
