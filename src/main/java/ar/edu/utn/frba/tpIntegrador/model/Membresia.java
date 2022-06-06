package ar.edu.utn.frba.tpIntegrador.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//FALTA TEST
@Entity
@DiscriminatorValue("2")
public class Membresia extends Promocion{
	@ManyToMany
	private Collection<Cliente> clientes;
	private Double porcentajeDescuento;
	@ManyToOne
	private Cliente clienteQueCompra;
	
	@Override
	public Double aplicar(CarritoDeCompra carritoDeCompra) {
		if(clientes.contains(clienteQueCompra)) {
			return carritoDeCompra.calcularPrecioTotalSinPromociones() * porcentajeDescuento;
		}else {
			return 0.0;
		}
		
	}

	protected Membresia() {
		super();
	}
	
	public Membresia(double porcentajeDescuento) {
		super();
		this.clientes = new ArrayList<>();
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public Cliente getClienteQueCompra() {
		return clienteQueCompra;
	}

	public void setClienteQueCompra(Cliente clienteQueCompra) {
		this.clienteQueCompra = clienteQueCompra;
	}

}
