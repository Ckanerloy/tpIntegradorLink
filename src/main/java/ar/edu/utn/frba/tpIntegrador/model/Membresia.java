package ar.edu.utn.frba.tpIntegrador.model;

import java.util.Collection;

public class Membresia implements Promocion{
	private Collection<Cliente> cliente;
	private double porcentajeDescuento;
	
	@Override
	public double aplicar(OrdenDeCompra ordenDeCompra) {
		//if()
		return ordenDeCompra.calcularPrecioTotalSinPromociones() * porcentajeDescuento;
	}
}
