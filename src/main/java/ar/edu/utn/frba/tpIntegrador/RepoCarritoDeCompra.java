package ar.edu.utn.frba.tpIntegrador;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.frba.tpIntegrador.model.CarritoDeCompra;

@RepositoryRestResource(path="carritosDeCompra")
public interface RepoCarritoDeCompra extends PagingAndSortingRepository<CarritoDeCompra, Integer>{

}
