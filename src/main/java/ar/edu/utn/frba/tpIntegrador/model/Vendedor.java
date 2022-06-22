package ar.edu.utn.frba.tpIntegrador.model;

import java.time.LocalDate;
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
public class Vendedor extends Rol{
	private String nombreYApellido;
	private String legajo;
	private LocalDate fechaDeNacimiento;
	private String email;
	@Enumerated(EnumType.STRING)
	@Column(name = "tipoDeDocumento")
	private TipoDeDocumento tipoDeDocumento;
	private String nroDeDocumento;
	@OneToMany
	@JoinColumn(name = "vendedor_id")
	private Collection<Producto> productosParaVender;
	@ManyToOne
	private Proveedor proveedor;
	private String tipoDeRol = "vendedor"; 
	
	protected Vendedor() {
		super();
	}
	
	public Vendedor(String nombreYApellido, String legajo, LocalDate fechaDeNacimiento, String email,
			TipoDeDocumento tipoDeDocumento, String nroDeDocumento, Collection<Producto> productosParaVender,
			Proveedor proveedor) {
		super();
		this.nombreYApellido = nombreYApellido;
		this.legajo = legajo;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.email = email;
		this.tipoDeDocumento = tipoDeDocumento;
		this.nroDeDocumento = nroDeDocumento;
		this.productosParaVender = productosParaVender;
		this.proveedor = proveedor;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Collection<Producto> getProductosParaVender() {
		return productosParaVender;
	}

	public void setProductosParaVender(Collection<Producto> productosParaVender) {
		this.productosParaVender = productosParaVender;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	} 
	
	public String getTipoDeRol() {
		return tipoDeRol;
	}

	public void setTipoDeRol(String tipoDeRol) {
		this.tipoDeRol = tipoDeRol;
	}

	public void agregarProducto(Producto producto) {
		this.productosParaVender.add(producto);
	}
	
	
}
