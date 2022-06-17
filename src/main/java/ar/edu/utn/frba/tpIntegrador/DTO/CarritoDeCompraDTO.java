package ar.edu.utn.frba.tpIntegrador.DTO;

import java.time.LocalDate;
import java.util.Collection;

import ar.edu.utn.frba.tpIntegrador.model.ItemCompra;
import ar.edu.utn.frba.tpIntegrador.model.MedioDePago;
import ar.edu.utn.frba.tpIntegrador.model.Promocion;

public class CarritoDeCompraDTO {
	private Collection<ItemCompra> itemsCompras;
	private Collection<Promocion> promociones;
	private LocalDate fechaDeCompra;
	private MedioDePago medioDePago;
	private double precioTotalSinDescuento;
	private double precioTotalConDescuento;

	public CarritoDeCompraDTO(Collection<ItemCompra> itemsCompras, Collection<Promocion> promociones,
			LocalDate fechaDeCompra, MedioDePago medioDePago, double precioTotalSinDescuento,
			double precioTotalConDescuento) {
		super();
		this.itemsCompras = itemsCompras;
		this.promociones = promociones;
		this.fechaDeCompra = fechaDeCompra;
		this.medioDePago = medioDePago;
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

	public LocalDate getFechaDeCompra() {
		return fechaDeCompra;
	}

	public void setFechaDeCompra(LocalDate fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
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
	
}
