package ar.edu.utn.frba.tpIntegrador.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Producto {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private double precio;
	private String descripcion;
	private String nombre;
	@Transient
	private Cotizador cotizador;
	//private boolean estaDisponible;
	private int stock;
	@ManyToOne
	private Proveedor proveedor;
	
	protected Producto() {
		super();
	}
	
	public Producto( String descripcion, String nombre,Cotizador cotizador, boolean estaDisponible, int stock,
			Proveedor proveedor) {
		super();
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.cotizador = cotizador;
		this.precio= cotizador.calcularPrecio();
		//this.estaDisponible = estaDisponible;
		this.stock = stock;
		this.proveedor = proveedor;
	}
	
	public Producto( String descripcion, String nombre,Cotizador cotizador, boolean estaDisponible, int stock) {
		super();
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.cotizador = cotizador;
		this.precio= cotizador.calcularPrecio();
		//this.estaDisponible = estaDisponible;
		this.stock = stock;
	}
	
	public Producto(String descripcion, String nombre ) {
		super();
		this.descripcion = descripcion;
		this.nombre = nombre;
	}
	public double getPrecio() {
		return cotizador.calcularPrecio();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

/*	public boolean isEstaDisponible() {
		return estaDisponible;
	}

	public void setEstaDisponible(boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}
*/
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	//Funciones

	public void restarStock(int cantidad) throws StockInsuficienteException{
		if(stock<cantidad){
			throw new StockInsuficienteException("El stock es insuficiente en el producto");
		}
		this.stock= stock- cantidad;
	}
	
	//public double calcularPrecioEnDolar(){}
}
