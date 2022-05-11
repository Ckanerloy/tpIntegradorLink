package ar.edu.utn.frba.tpIntegrador.model;

public class CuponProveedor implements Promocion{
	private boolean estaUsado;
	private double descuento;
	private Proveedor proveedor;
	
	public CuponProveedor(boolean estaUsado, double descuento, Proveedor proveedor) {
		super();
		this.estaUsado = estaUsado;
		this.descuento = descuento;
		this.proveedor = proveedor;
	}
	
	@Override
	public double aplicar(OrdenDeCompra ordenDeCompra) {
		return 	ordenDeCompra.getItemsCompras().stream().filter(x->x.mismoProveedor(proveedor)).mapToDouble(x->x.calcularPrecioItem() * descuento).sum();
	}
	
}
