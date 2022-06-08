package ar.edu.utn.frba.tpIntegrador.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.frba.tpIntegrador.model.Proveedor;

@RepositoryRestResource(path="proveedores")
public interface RepoProveedor extends PagingAndSortingRepository<Proveedor, Integer> {

}
