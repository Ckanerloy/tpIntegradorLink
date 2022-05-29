package ar.edu.utn.frba.tpIntegrador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import ar.edu.utn.frba.tpIntegrador.model.CotizadorPesos;
import ar.edu.utn.frba.tpIntegrador.model.Producto;
import ar.edu.utn.frba.tpIntegrador.model.*;

@Repository
public class RepoProducto {
	private Collection<Producto> productos;

	public RepoProducto(Collection<Producto> productos) {
		super();
		CotizadorPesos cotizadorPesos = new CotizadorPesos(100.0);
		List<Producto> of = List.of(new Producto("Bebida" , "Coca cola",cotizadorPesos, true, 5,new Proveedor("Proveedor de bebidas","48675678","proveedor@gmail.com",50)));
		this.productos = new ArrayList<Producto>(of);
	}
	
	public Collection<Producto> mostrarProductos() {
		return productos;
	}
	
	public void guardarProducto(Producto producto) {
		productos.add(producto);
	}
}
