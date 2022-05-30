package ar.edu.utn.frba.tpIntegrador.model;

public class PromoMedioDePago implements Promocion{
	private MedioDePago medioDePago;
	private double porcentaje;
	
	public PromoMedioDePago(MedioDePago medioDePago, double porcentaje) {
		super();
		this.medioDePago = medioDePago;
		this.porcentaje = porcentaje;
	}

	@Override
	public double aplicar(CarritoDeCompra carritoDeCompra) {
		if(carritoDeCompra.getMedioDePago().equals(this.medioDePago)) {
			return carritoDeCompra.calcularPrecioTotalSinPromociones() * porcentaje;
		}
		return 0.0;
	}
}
