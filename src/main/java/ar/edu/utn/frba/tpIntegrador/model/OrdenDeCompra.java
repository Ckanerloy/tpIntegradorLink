package ar.edu.utn.frba.tpIntegrador.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class OrdenDeCompra {
	private Collection<ItemCompra> itemsCompras;
	private Collection<Promocion> promociones;
	private LocalDate fechaDeNacimiento;
	private MedioDePago medioDePago;
	//Una vez que se termina de hacer la ordenDeCompra en el carrito y se la paga (Aceptandola). Se hace un new a OrdenDeCompra con todos los atributos que tenga el carrito y se agrega el precioTotalConDescuento y precioTotalSinDescuento de los métodos de carrito
	private double precioTotalSinDescuento;
	private double precioTotalConDescuento;
	
	public OrdenDeCompra(Collection<Promocion> promociones,
			LocalDate fechaDeNacimiento, MedioDePago medioDePago,double precioTotalSinDescuento ,double precioTotalConDescuento) {
		super();
		this.itemsCompras = new ArrayList<>();
		this.promociones = promociones;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.medioDePago = medioDePago;
		this.precioTotalSinDescuento=precioTotalSinDescuento;
		this.precioTotalConDescuento=precioTotalConDescuento;
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

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
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
	
	
/*
	public double calcularPrecioTotalSinPromociones() {
		return itemsCompras.stream().mapToDouble(x->x.calcularPrecioItem()).sum();
	}
	
	public double calcularPrecioTotalConPromociones() {
		return this.calcularPrecioTotalSinPromociones()-promociones.stream().mapToDouble(x->x.aplicar(this)).sum();
	}
*/
}