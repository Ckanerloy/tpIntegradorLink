package ar.edu.utn.frba.tpIntegrador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class PromoMedioDePago extends Promocion{
	@Enumerated(EnumType.STRING)
	@Column(name = "medioDePago")
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
