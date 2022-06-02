package ar.edu.utn.frba.tpIntegrador.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//FALTA TEST
@Entity
public class Membresia extends Promocion{
	@ManyToMany
	private Collection<Cliente> clientes;
	private double porcentajeDescuento;
	@ManyToOne
	private Cliente clienteQueCompra;
	
	@Override
	public double aplicar(CarritoDeCompra carritoDeCompra) {
		if(clientes.contains(clienteQueCompra)) {
			return carritoDeCompra.calcularPrecioTotalSinPromociones() * porcentajeDescuento;
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
