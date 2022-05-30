package ar.edu.utn.frba.tpIntegrador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import ar.edu.utn.frba.tpIntegrador.model.Producto;
import ar.edu.utn.frba.tpIntegrador.model.Proveedor;

@Repository
public class RepoProveedor {
	Collection<Proveedor> proveedores;
	
	public RepoProveedor(Collection<Producto> productos) {
		super();
		List<Proveedor> of = List.of(new Proveedor("Proveedor de bebidas","48675678","proveedor1@gmail.com",50),new Proveedor("Proveedor de Snacks","48585110","proveedor2@gmail.com",100));
		this.proveedores = new ArrayList<Proveedor>(of);
	}

	public Collection<Proveedor> mostrarProveedores() {
		return proveedores;
	}

	public void guardarProveedores(Proveedor proveedor) {
		proveedores.add(proveedor);
	}
	
}
