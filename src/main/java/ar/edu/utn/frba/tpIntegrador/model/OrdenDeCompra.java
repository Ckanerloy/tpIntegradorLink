package ar.edu.utn.frba.tpIntegrador.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class OrdenDeCompra {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToMany
	@JoinColumn(name = "ordenDeCompra_id")
	private Collection<ItemCompra> itemsCompras;
	@Enumerated(EnumType.STRING)
	@Column(name = "medioDePago")
	private MedioDePago medioDePago;
	//Una vez que se termina de hacer la ordenDeCompra en el carrito y se la paga (Aceptandola). Se hace un new a OrdenDeCompra con todos los atributos que tenga el carrito y se agrega el precioTotalConDescuento y precioTotalSinDescuento de los métodos de carrito
	private double precioTotalSinDescuento;
	private double precioTotalConDescuento;
	
	public OrdenDeCompra() {
		super();
	}
	
	public OrdenDeCompra(
			LocalDate fechaDeCompra, MedioDePago medioDePago,double precioTotalSinDescuento ,double precioTotalConDescuento) {
		super();
		this.itemsCompras = new ArrayList<>();
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
