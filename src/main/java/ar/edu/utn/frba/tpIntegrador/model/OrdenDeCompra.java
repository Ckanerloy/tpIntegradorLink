package ar.edu.utn.frba.tpIntegrador.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class OrdenDeCompra {
	private Collection<ItemCompra> itemsCompras;
	private Collection<Promocion> promociones;
	private LocalDate fechaDeNacimiento;
	private MedioDePago medioDePago;
	
	public OrdenDeCompra(Collection<Promocion> promociones,
			LocalDate fechaDeNacimiento, MedioDePago medioDePago) {
		super();
		this.itemsCompras = new ArrayList<>();
		this.promociones = promociones;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.medioDePago = medioDePago;
	}
	public OrdenDeCompra(Collection<ItemCompra> itemsCompras) {
		super();
		this.itemsCompras = new ArrayList<>();
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

	public double calcularPrecioTotalSinPromociones() {
		return itemsCompras.stream().mapToDouble(x->x.calcularPrecioItem()).sum();
	}
	
	public double calcularPrecioTotalConPromociones() {
		return promociones.stream().mapToDouble(x->x.aplicar(this)).sum();
	}
}
