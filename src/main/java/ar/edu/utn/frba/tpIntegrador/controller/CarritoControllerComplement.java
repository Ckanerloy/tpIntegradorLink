package ar.edu.utn.frba.tpIntegrador.controller;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.utn.frba.tpIntegrador.model.CarritoDeCompra;
import ar.edu.utn.frba.tpIntegrador.model.Cliente;
import ar.edu.utn.frba.tpIntegrador.repo.RepoCarritoDeCompra;
import ar.edu.utn.frba.tpIntegrador.repo.RepoCliente;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class CarritoControllerComplement {
	
	@Autowired
	private RepoCarritoDeCompra repoCarritoDeCompra;
	@Autowired
	private RepoCliente repoCliente;

	@GetMapping("/{clienteID}/carritoDeCompras")
	public CarritoDeCompra get(@PathVariable("clienteID") UUID clienteID) {
		
		Optional<Cliente> opcionalCliente= repoCliente.findById(clienteID);
		
		Cliente cliente= opcionalCliente.get();
		
		Optional<CarritoDeCompra> opcionalCarritoDeCompra= repoCarritoDeCompra.findByCliente(cliente);
		
		CarritoDeCompra carritoDeCompra=opcionalCarritoDeCompra.get();

		//Collection<ItemCompra> itemsDeCompra = carritoDeCompra.getItemsCompras();
		
		return carritoDeCompra;
	}
	
}
