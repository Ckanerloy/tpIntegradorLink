package ar.edu.utn.frba.tpIntegrador.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("1")
public class CuponProveedor extends Promocion{
	private boolean noEstaUsado;
	private Double descuento;
	@ManyToOne
	private Proveedor proveedor;
	
	protected CuponProveedor() {
		super();
	}
	public CuponProveedor(boolean estaUsado, double descuento, Proveedor proveedor) {
		super();
		this.noEstaUsado = estaUsado;
		this.descuento = descuento;
		this.proveedor = proveedor;
	}
	
	@Override
	public Double aplicar(CarritoDeCompra carritoDeCompra) {
		return 	carritoDeCompra.getItemsCompras().stream().filter(x->x.mismoProveedor(proveedor)&noEstaUsado).mapToDouble(x->x.calcularPrecioItem() * descuento).sum();
	}
	public boolean isNoEstaUsado() {
		return noEstaUsado;
	}
	public void setNoEstaUsado(boolean noEstaUsado) {
		this.noEstaUsado = noEstaUsado;
	}
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
}
