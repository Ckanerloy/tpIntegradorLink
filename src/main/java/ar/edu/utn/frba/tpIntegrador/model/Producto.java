package ar.edu.utn.frba.tpIntegrador.model;

public class Producto {
	private double precio;
	private String descripcion;
	private String nombre;
	private Cotizador cotizador;
	//private boolean estaDisponible;
	private int stock;
	private Proveedor proveedor;
	
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
