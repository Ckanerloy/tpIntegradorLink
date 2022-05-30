package ar.edu.utn.frba.tpIntegrador.model;

public class ItemCompra {
	private Producto producto;
	private int cantidad;
	private double precioCompra;
		
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
		return precioCompra;
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
