package br.com.calcard.calsystem.ws.dto;

public class TokenDTO {

	private String hashToken;

	private String key;

	private Integer idPerfilUsuario;

	public TokenDTO() {
		super();
	}

	public TokenDTO(String hashToken, String key, Integer idPerfilUsuario) {
		super();
		this.hashToken = hashToken;
		this.key = key;
		this.idPerfilUsuario = idPerfilUsuario;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getHashToken() {
		return hashToken;
	}

	public void setHashToken(String hashToken) {
		this.hashToken = hashToken;
	}

	public Integer getIdPerfilUsuario() {
		return idPerfilUsuario;
	}

	public void setIdPerfilUsuario(Integer idPerfilUsuario) {
		this.idPerfilUsuario = idPerfilUsuario;
	}

}
