package ar.edu.utn.frba.tpIntegrador.repo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ar.edu.utn.frba.tpIntegrador.model.CarritoDeCompra;
import ar.edu.utn.frba.tpIntegrador.model.Cliente;

@CrossOrigin
@RepositoryRestResource(path="carritosDeCompras")
public interface RepoCarritoDeCompra extends PagingAndSortingRepository<CarritoDeCompra, Integer>{
	Optional<CarritoDeCompra> findByCliente(Cliente cliente);
}
