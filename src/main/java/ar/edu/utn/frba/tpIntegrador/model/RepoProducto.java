package ar.edu.utn.frba.tpIntegrador.model;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public class RepoProducto {
	private Collection<Producto> productos;

	public RepoProducto(Collection<Producto> productos) {
		super();
		this.productos = productos;
	}

	public Collection<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}
	public void agregarUnProducto(Producto producto) {
		this.productos.add(producto);
	}
}
