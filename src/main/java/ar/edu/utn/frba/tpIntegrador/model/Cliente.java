package ar.edu.utn.frba.tpIntegrador.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Cliente extends Rol{
	private String nombreYApellido;
	//@ManyToOne
	//private CarritoDeCompra carritoDeCompra;
	@OneToMany
	@JoinColumn(name = "cliente_id")
	private Collection<OrdenDeCompra> comprasRealizadas;
	private LocalDate fechaDeNacimiento;
	@Enumerated(EnumType.STRING)
	@Column(name = "tipoDeDocumento")
	private TipoDeDocumento tipoDeDocumento;
	private String nroDeDocumento;
	private String telefono;
	private String mail;
	@Transient
	private String tipoDeRol="cliente"; 
	
	protected Cliente() {
		super();
	}
	
	public Cliente(String nombreYApellido, LocalDate fechaDeNacimiento,
			TipoDeDocumento tipoDeDocumento, String nroDeDocumento, String telefono, String mail) {
		super();
		this.nombreYApellido = nombreYApellido;
		this.comprasRealizadas = new ArrayList<>();
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.tipoDeDocumento = tipoDeDocumento;
		this.nroDeDocumento = nroDeDocumento;
		this.telefono = telefono;
		this.mail = mail;
	}
	
	public Cliente(LocalDate fechaDeNacimiento, String mail, String nombreYApellido,String nroDeDocumento, 
			String telefono, TipoDeDocumento tipoDeDocumento) {
		super();
		this.nombreYApellido = nombreYApellido;
		this.comprasRealizadas = new ArrayList<>();
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.tipoDeDocumento = tipoDeDocumento;
		this.nroDeDocumento = nroDeDocumento;
		this.telefono = telefono;
		this.mail = mail;
	}
	
	public String getNombreYApellido() {
		return nombreYApellido;
	}
	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}
	
	public Collection<OrdenDeCompra> getComprasRealizadas() {
		return comprasRealizadas;
	}
	public void setComprasRealizadas(Collection<OrdenDeCompra> comprasRealizadas) {
		this.comprasRealizadas = comprasRealizadas;
	}
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public TipoDeDocumento getTipoDeDocumento() {
		return tipoDeDocumento;
	}
	public void setTipoDeDocumento(TipoDeDocumento tipoDeDocumento) {
		this.tipoDeDocumento = tipoDeDocumento;
	}
	public String getNroDeDocumento() {
		return nroDeDocumento;
	}
	public void setNroDeDocumento(String nroDeDocumento) {
		this.nroDeDocumento = nroDeDocumento;
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
	
	public String getTipoDeRol() {
		return tipoDeRol;
	}

	public void setTipoDeRol(String tipoDeRol) {
		this.tipoDeRol = tipoDeRol;
	}

	// Funciones
	public void realizarComprar(OrdenDeCompra ordenDeCompra) {
		comprasRealizadas.add(ordenDeCompra);
	}
	
	
}
