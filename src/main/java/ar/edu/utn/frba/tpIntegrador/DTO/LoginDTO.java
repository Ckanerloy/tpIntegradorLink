package ar.edu.utn.frba.tpIntegrador.DTO;

import java.util.UUID;

public class LoginDTO {
	private String tipoDeRol;
	private UUID id;
	
	public LoginDTO(String tipoDeRol, UUID id) {
		super();
		this.tipoDeRol = tipoDeRol;
		this.id = id;
	}

	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getTipoDeRol() {
		return tipoDeRol;
	}
	public void setTipoDeRol(String tipoDeRol) {
		this.tipoDeRol = tipoDeRol;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}

}
