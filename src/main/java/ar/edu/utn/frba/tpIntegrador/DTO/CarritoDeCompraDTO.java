package ar.edu.utn.frba.tpIntegrador.DTO;

import java.time.LocalDate;
import java.util.Collection;

import ar.edu.utn.frba.tpIntegrador.model.Cliente;
import ar.edu.utn.frba.tpIntegrador.model.ItemCompra;
import ar.edu.utn.frba.tpIntegrador.model.MedioDePago;
import ar.edu.utn.frba.tpIntegrador.model.Promocion;

public class CarritoDeCompraDTO {
	private Collection<ItemCompra> itemsCompras;
	private Collection<Promocion> promociones;
	private MedioDePago medioDePago;
	private Cliente cliente;
	private double precioTotalSinDescuento;
	private double precioTotalConDescuento;

	public CarritoDeCompraDTO(Collection<ItemCompra> itemsCompras, Collection<Promocion> promociones,
			MedioDePago medioDePago, Cliente cliente,double precioTotalSinDescuento,
			double precioTotalConDescuento) {
		super();
		this.itemsCompras = itemsCompras;
		this.promociones = promociones;
		this.medioDePago = medioDePago;
		this.cliente=cliente;
		this.precioTotalSinDescuento = precioTotalSinDescuento;
		this.precioTotalConDescuento = precioTotalConDescuento;
	}

	public CarritoDeCompraDTO() {
		super();
	}

	public Collection<ItemCompra> getItemsCompras() {
		return itemsCompras;
	}

	public void setItemsCompras(Collection<ItemCompra> itemsCompras) {
		this.itemsCompras = itemsCompras;
	}

	public Collection<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(Collection<Promocion> promociones) {
		this.promociones = promociones;
	}

	public MedioDePago getMedioDePago() {
		return medioDePago;
	}

	public void setMedioDePago(MedioDePago medioDePago) {
		this.medioDePago = medioDePago;
	}

	public double getPrecioTotalSinDescuento() {
		return precioTotalSinDescuento;
	}

	public void setPrecioTotalSinDescuento(double precioTotalSinDescuento) {
		this.precioTotalSinDescuento = precioTotalSinDescuento;
	}

	public double getPrecioTotalConDescuento() {
		return precioTotalConDescuento;
	}

	public void setPrecioTotalConDescuento(double precioTotalConDescuento) {
		this.precioTotalConDescuento = precioTotalConDescuento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
