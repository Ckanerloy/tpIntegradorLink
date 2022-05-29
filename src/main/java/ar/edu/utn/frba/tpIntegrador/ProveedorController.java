package ar.edu.utn.frba.tpIntegrador;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.frba.tpIntegrador.model.Proveedor;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {
	@Autowired
	private RepoProveedor RepoProveedor;
	
	@GetMapping("")
	public Collection<Proveedor> allProducto() {
		return RepoProveedor.mostrarProveedores();
	}
	
	@PostMapping("")
	public void save(@RequestBody Proveedor proveedor) {
		RepoProveedor.guardarProveedores(proveedor);
	}
}
