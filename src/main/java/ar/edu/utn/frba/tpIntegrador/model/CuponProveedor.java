package ar.edu.utn.frba.tpIntegrador.model;

public class CuponProveedor implements Promocion{
	private boolean noEstaUsado;
	private double descuento;
	private Proveedor proveedor;
	
	public CuponProveedor(boolean estaUsado, double descuento, Proveedor proveedor) {
		super();
		this.noEstaUsado = estaUsado;
		this.descuento = descuento;
		this.proveedor = proveedor;
	}
	
	@Override
	public double aplicar(CarritoDeCompra carritoDeCompra) {
		return 	carritoDeCompra.getItemsCompras().stream().filter(x->x.mismoProveedor(proveedor)&noEstaUsado).mapToDouble(x->x.calcularPrecioItem() * descuento).sum();
	}
	
}
