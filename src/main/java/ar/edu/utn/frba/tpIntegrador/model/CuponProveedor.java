package ar.edu.utn.frba.tpIntegrador.model;

public class CuponProveedor implements Promocion{
	private boolean estaUsado;
	private double descuento;
	private Proveedor proveedor;
	
	@Override
	public double aplicar(OrdenDeCompra ordenDeCompra) {
		return ordenDeCompra.getItemsCompras().stream().filter(x->x.mismoProveedor(proveedor)).mapToDouble(x->x.calcularPrecioItem()).sum();
	}
}
