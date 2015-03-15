package br.com.calcard.calsystem.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_log")
public class Log extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 6319257835216581633L;

	@Column(name = "log", length = 50, nullable = false, unique = true)
	private String log;

	@Column(name = "de", length = 50, nullable = false, unique = true)
	private String de;

	@Column(name = "para", length = 50, nullable = false, unique = true)
	private String para;

	public Log() {
		super();
	}

	public Log(String status, Date dataRegistro, Date dataAtualizacao,
			Integer id, String log, String de, String para) {
		super(status);
		this.log = log;
		this.de = de;
		this.para = para;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((de == null) ? 0 : de.hashCode());
		result = prime * result + ((log == null) ? 0 : log.hashCode());
		result = prime * result + ((para == null) ? 0 : para.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Log other = (Log) obj;
		if (de == null) {
			if (other.de != null)
				return false;
		} else if (!de.equals(other.de))
			return false;
		if (log == null) {
			if (other.log != null)
				return false;
		} else if (!log.equals(other.log))
			return false;
		if (para == null) {
			if (other.para != null)
				return false;
		} else if (!para.equals(other.para))
			return false;
		return true;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

}
