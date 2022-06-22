package ar.edu.utn.frba.tpIntegrador.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.utn.frba.tpIntegrador.DTO.CarritoDeCompraDTO;
import ar.edu.utn.frba.tpIntegrador.model.CarritoDeCompra;
import ar.edu.utn.frba.tpIntegrador.model.Cliente;
import ar.edu.utn.frba.tpIntegrador.model.OrdenDeCompra;
import ar.edu.utn.frba.tpIntegrador.repo.RepoCliente;
import ar.edu.utn.frba.tpIntegrador.repo.RepoItemCompra;
import ar.edu.utn.frba.tpIntegrador.repo.RepoOrdenDeCompra;

@RepositoryRestController
public class OrdenDeCompraController {
	/*@Autowired
	RepoItemCompra repoItemCompra;
	@Autowired
	RepoCliente repoCliente;
	@Autowired
	RepoOrdenDeCompra repoOrdenDeCompra;
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST,value="/clientes/{clienteID}/ordenesDeCompras")
	public @ResponseBody String registrarrProducto(@PathVariable("clienteID") Integer clienteID,
													@RequestBody CarritoDeCompraDTO carritoDeCompraDTO) {
		
		Optional<Cliente> opcionalCliente = repoCliente.findById(clienteID);
		if(opcionalCliente.isEmpty()) {
			return "proveedor no encontrado";
		}
		Cliente cliente = opcionalCliente.get();
		
		OrdenDeCompra ordenDeCompra = new OrdenDeCompra();
		
		ordenDeCompra.setItemsCompras(carritoDeCompraDTO.getItemsCompras());
		ordenDeCompra.setPromociones(carritoDeCompraDTO.getPromociones());
		ordenDeCompra.setFechaDeCompra(carritoDeCompraDTO.getFechaDeCompra());
		ordenDeCompra.setMedioDePago(carritoDeCompraDTO.getMedioDePago());
		ordenDeCompra.setPrecioTotalSinDescuento(carritoDeCompraDTO.getPrecioTotalSinDescuento());
		ordenDeCompra.setPrecioTotalConDescuento(carritoDeCompraDTO.getPrecioTotalConDescuento());
		
		cliente.realizarComprar(ordenDeCompra);
		
		repoOrdenDeCompra.save(ordenDeCompra);
		
		
		/*
		if(opcionalCotizador.isEmpty()) {
			return "alumno no encontrado";
		}
		

		return "ok";
	}*/
}
