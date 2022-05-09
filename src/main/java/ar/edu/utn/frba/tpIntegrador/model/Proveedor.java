package ar.edu.utn.frba.tpIntegrador.model;

import java.util.Objects;

public class Proveedor {
	private String descripcion;
	private String telefono;
	private String mail;
	private int cantidadMinima;
	//private MedioDeComunicacion medioDeComunicacion;
	
	public Proveedor(String descripcion, String telefono, String mail, int cantidadMinima) {
		super();
		this.descripcion = descripcion;
		this.telefono = telefono;
		this.mail = mail;
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
