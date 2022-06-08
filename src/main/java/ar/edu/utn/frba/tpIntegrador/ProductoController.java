package ar.edu.utn.frba.tpIntegrador;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.utn.frba.tpIntegrador.model.Producto;

//@RepositoryRestController
public class ProductoController {
/*	@Autowired
	RepoProducto repoProducto;
	@Autowired
	RepoCotizador repoCotizador;
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST,value="/productos")
	public @ResponseBody String agregar(@RequestBody Producto producto) {
		repoProducto.save(producto);
		Optional<CotizadorDolar> opcionalCotizador = repoCotizador.findById(1);
		if(opcionalCotizador.isEmpty()) {
			return "alumno no encontrado";
		}
		CotizadorDolar cotizadorDolar = opcionalCotizador.get();
		
		if(producto.getEstaEnDolares()) {	
			producto.setCotizadorDolar(cotizadorDolar);
		}
		return "ok";
	}*/
}
