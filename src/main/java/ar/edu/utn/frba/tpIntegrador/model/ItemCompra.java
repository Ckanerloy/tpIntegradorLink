package ar.edu.utn.frba.tpIntegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemCompra {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	private Producto producto;
	private int cantidad;
	private double precioCompra;
	
	protected ItemCompra(){
		super();
	}
	
	public ItemCompra(Producto producto, int cantidad) throws StockInsuficienteException{
		super();
		producto.restarStock(cantidad);
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioCompra = producto.getPrecio();
	}
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioCompra() {
		return producto.getPrecio();
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	
	//Funciones
	public double calcularPrecioItem(){
		return this.cantidad * this.precioCompra;
	}

	public boolean mismoProveedor(Proveedor proveedor) {
		return this.getProducto().getProveedor().equals(proveedor);
	}
}
