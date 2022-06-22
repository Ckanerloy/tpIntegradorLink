package ar.edu.utn.frba.tpIntegrador.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Administrador extends Rol{
	private String nombreYapellido;
	@Transient
	private String tipoDeRol="administrador";
	
	
	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Administrador(String nombreYapellido) {
		super();
		this.nombreYapellido = nombreYapellido;
	}
	public String getNombreYapellido() {
		return nombreYapellido;
	}
	public void setNombreYapellido(String nombreYapellido) {
		this.nombreYapellido = nombreYapellido;
	}
	public String getTipoDeRol() {
		return tipoDeRol;
	}
	public void setTipoDeRol(String tipoDeRol) {
		this.tipoDeRol = tipoDeRol;
	} 
	
}
