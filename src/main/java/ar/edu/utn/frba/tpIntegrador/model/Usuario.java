package ar.edu.utn.frba.tpIntegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String user;
	private String contra;
	@OneToOne
	private Rol rol;
	
	public Usuario( String user, String contra, Rol rol) {
		super();
		this.user = user;
		this.contra = contra;
		this.rol = rol;
	}
	
	public Usuario() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
}
