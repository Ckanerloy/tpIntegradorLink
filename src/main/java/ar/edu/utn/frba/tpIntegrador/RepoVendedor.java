package ar.edu.utn.frba.tpIntegrador;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.frba.tpIntegrador.model.Vendedor;

@RepositoryRestResource(path="vendedores")
public interface RepoVendedor extends PagingAndSortingRepository<Vendedor, Integer> {

}