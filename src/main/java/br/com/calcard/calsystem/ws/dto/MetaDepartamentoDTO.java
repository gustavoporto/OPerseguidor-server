package br.com.calcard.calsystem.ws.dto;

import java.io.Serializable;

public class MetaDepartamentoDTO implements Serializable {

	private static final long serialVersionUID = -1378338185550405484L;

	private DepartamentoDTO departamento;

	private float percentual;

	public MetaDepartamentoDTO(DepartamentoDTO departamento, float percentual) {
		this.departamento = departamento;
		this.percentual = percentual;
	}

	public DepartamentoDTO getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoDTO departamento) {
		this.departamento = departamento;
	}

	public float getPercentual() {
		return percentual;
	}

	public void setPercentual(float percentual) {
		this.percentual = percentual;
	}

}
