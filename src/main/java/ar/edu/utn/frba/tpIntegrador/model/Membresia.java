package ar.edu.utn.frba.tpIntegrador.model;

import java.util.ArrayList;
import java.util.Collection;
//FALTA TEST
public class Membresia implements Promocion{
	private Collection<Cliente> clientes;
	private double porcentajeDescuento;
	private Cliente clienteQueCompra;
	
	@Override
	public double aplicar(OrdenDeCompra ordenDeCompra) {
		if(clientes.contains(clienteQueCompra)) {
			return ordenDeCompra.calcularPrecioTotalSinPromociones() * porcentajeDescuento;
		}else {
			return 0.0;
		}
		
	}

	public Membresia(double porcentajeDescuento) {
		super();
		this.clientes = new ArrayList<>();
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public Collection<Cliente> getCliente() {
		return clientes;
	}

	public void setCliente(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}

	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
}
