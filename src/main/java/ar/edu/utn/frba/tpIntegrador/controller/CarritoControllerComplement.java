package ar.edu.utn.frba.tpIntegrador.controller;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.frba.tpIntegrador.DTO.CarritoDeCompraDTO;
import ar.edu.utn.frba.tpIntegrador.model.CarritoDeCompra;
import ar.edu.utn.frba.tpIntegrador.model.Cliente;
import ar.edu.utn.frba.tpIntegrador.model.ItemCompra;
import ar.edu.utn.frba.tpIntegrador.model.Producto;
import ar.edu.utn.frba.tpIntegrador.model.StockInsuficienteException;
import ar.edu.utn.frba.tpIntegrador.repo.RepoCarritoDeCompra;
import ar.edu.utn.frba.tpIntegrador.repo.RepoCliente;
import ar.edu.utn.frba.tpIntegrador.repo.RepoItemCompra;
import ar.edu.utn.frba.tpIntegrador.repo.RepoProducto;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class CarritoControllerComplement {
	
	@Autowired
	private RepoCarritoDeCompra repoCarritoDeCompra;
	@Autowired
	private RepoCliente repoCliente;
	@Autowired
	private RepoProducto repoProducto;
	@Autowired
	private RepoItemCompra repoItemCompra;

	@GetMapping("/{clienteID}/carritoDeCompras")
	public CarritoDeCompraDTO get(@PathVariable("clienteID") UUID clienteID) {
		
		Optional<Cliente> opcionalCliente= repoCliente.findById(clienteID);
		
		Cliente cliente= opcionalCliente.get();
		
		Optional<CarritoDeCompra> opcionalCarritoDeCompra= repoCarritoDeCompra.findByCliente(cliente);
		
		CarritoDeCompra carritoDeCompra=opcionalCarritoDeCompra.get();
		
		CarritoDeCompraDTO carritoDeCompraDTO = new CarritoDeCompraDTO();
		
		carritoDeCompraDTO.setItemsCompras(carritoDeCompra.getItemsCompras());
		carritoDeCompraDTO.setPromociones(carritoDeCompra.getPromociones());
		carritoDeCompraDTO.setMedioDePago(carritoDeCompra.getMedioDePago());
		carritoDeCompraDTO.setCliente(carritoDeCompra.getCliente());
		carritoDeCompraDTO.setPrecioTotalSinDescuento(carritoDeCompra.calcularPrecioTotalSinPromociones());
		carritoDeCompraDTO.setPrecioTotalConDescuento(carritoDeCompra.calcularPrecioTotalConPromociones());

		//Collection<ItemCompra> itemsDeCompra = carritoDeCompra.getItemsCompras();
		
		return carritoDeCompraDTO;
	}
	
	@Transactional
	@PostMapping("/{clienteID}/carritoDeCompras/items/{productoID}/{cantidad}")
	public void agregarItem(@PathVariable("clienteID") UUID clienteID,@PathVariable("productoID") Integer productoID,@PathVariable("cantidad") int cantidad) throws StockInsuficienteException {
		Optional<Cliente> opcionalCliente= repoCliente.findById(clienteID);
		
		Cliente cliente= opcionalCliente.get();
		
		Optional<CarritoDeCompra> opcionalCarritoDeCompra= repoCarritoDeCompra.findByCliente(cliente);
		
		CarritoDeCompra carritoDeCompra=opcionalCarritoDeCompra.get();
		
		Optional<Producto> opcionalProducto= repoProducto.findById(productoID);
		
		Producto producto= opcionalProducto.get();
		
		ItemCompra itemCompra= new ItemCompra(producto,cantidad);
		
		carritoDeCompra.agregarItem(itemCompra);
		
		repoItemCompra.save(itemCompra);
	}
	
}
