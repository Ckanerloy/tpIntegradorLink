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
import javax.persistence.OneToOne;

@Entity
public class CarritoDeCompra {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToMany
	@JoinColumn(name = "carritoDeCompra_id")
	private Collection<ItemCompra> itemsCompras;
	@ManyToMany
	private Collection<Promocion> promociones;
	@Enumerated(EnumType.STRING)
	@Column(name = "medioDePago")
	private MedioDePago medioDePago;
	@OneToOne
	private Cliente cliente;
	
	public CarritoDeCompra() {
		super();
	}
	
	public CarritoDeCompra(Collection<Promocion> promociones,
			LocalDate fechaDeCompra, MedioDePago medioDePago,Cliente cliente) {
		super();
		this.itemsCompras = new ArrayList<>();
		this.promociones = promociones;
		this.medioDePago = medioDePago;
		this.cliente=cliente;
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double calcularPrecioTotalSinPromociones(){
		return itemsCompras.stream().mapToDouble(x->x.calcularPrecioItem()).sum();
	}
	
	public double calcularPrecioTotalConPromociones(){
		return this.calcularPrecioTotalSinPromociones()-promociones.stream().mapToDouble(x->x.aplicar(this)).sum();
	}
	
	public void agregarItem(ItemCompra itemCompra) {
		this.itemsCompras.add(itemCompra);
	}
	
	public void agregarPromocion(Promocion promocion) {
		this.promociones.add(promocion);
	}
}
