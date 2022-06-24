package ar.edu.utn.frba.tpIntegrador.controller;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.frba.tpIntegrador.DTO.ProductoDTO;
import ar.edu.utn.frba.tpIntegrador.model.Producto;
import ar.edu.utn.frba.tpIntegrador.model.Proveedor;
import ar.edu.utn.frba.tpIntegrador.model.Vendedor;
import ar.edu.utn.frba.tpIntegrador.repo.RepoProducto;
import ar.edu.utn.frba.tpIntegrador.repo.RepoProveedor;
import ar.edu.utn.frba.tpIntegrador.repo.RepoVendedor;

@CrossOrigin
@RestController
@RequestMapping("")
public class VendedorController {
	@Autowired
	RepoProducto repoProducto;
	@Autowired
	RepoProveedor repoProveedor;
	@Autowired
	RepoVendedor repoVendedor;
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST,value="/vendedor/{vendedorID}/productos")
	public @ResponseBody void registrarrProducto(@PathVariable("vendedorID") UUID vendedorID,
													@RequestBody ProductoDTO productoDto) {
		
		Optional<Vendedor> opcionalVendedor = repoVendedor.findById(vendedorID);
		
		
		Vendedor vendedor = opcionalVendedor.get();
		
		Optional<Proveedor> opcionalProveedor = repoProveedor.findById(productoDto.getProveedorID());
		
		Proveedor proveedor = opcionalProveedor.get();
		
		Producto producto=new Producto();
		producto.setPrecio(productoDto.getPrecio());
		producto.setDescripcion(productoDto.getDescripcion());
		producto.setNombre(productoDto.getNombre());
		producto.setStock(productoDto.getStock());
		producto.setEstaEnDolares(productoDto.getEstaEnDolares());
		producto.setProveedor(proveedor);
		producto.setImagen(productoDto.getImagen());
		
		vendedor.agregarProducto(producto);
		
		repoProducto.save(producto);
		
		
		/*
		if(opcionalCotizador.isEmpty()) {
			return "alumno no encontrado";
		}
		*/

		
	}
}
