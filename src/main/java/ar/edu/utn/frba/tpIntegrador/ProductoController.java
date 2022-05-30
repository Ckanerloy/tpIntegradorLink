package ar.edu.utn.frba.tpIntegrador;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.frba.tpIntegrador.model.Producto;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	private RepoProducto repoProducto;
	
	@GetMapping("")
	public Collection<Producto> allProducto() {
		return repoProducto.mostrarProductos();
	}
	
	@PostMapping("")
	public void save(@RequestBody Producto producto) {
		repoProducto.guardarProducto(producto);
	}
}