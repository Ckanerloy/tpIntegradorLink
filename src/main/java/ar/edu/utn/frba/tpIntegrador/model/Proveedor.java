package ar.edu.utn.frba.tpIntegrador.model;

import java.util.Objects;

import javax.persistence.Entity;

@Entity
public class Proveedor extends Rol{
	private String descripcion;
	private String telefono;
	private String mail;
	private int cantidadMinima;
	//private MedioDeComunicacion medioDeComunicacion;
	
	protected Proveedor() {
		super();
	}
	
	public Proveedor(String descripcion, String telefono, String mail, int cantidadMinima) {
		//super();
		this.descripcion = descripcion;
		this.telefono = telefono;
		this.mail = mail;
		this.cantidadMinima = cantidadMinima;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(int cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidadMinima, descripcion, mail, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proveedor other = (Proveedor) obj;
		return cantidadMinima == other.cantidadMinima && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(mail, other.mail) && Objects.equals(telefono, other.telefono);
	}
	
}
