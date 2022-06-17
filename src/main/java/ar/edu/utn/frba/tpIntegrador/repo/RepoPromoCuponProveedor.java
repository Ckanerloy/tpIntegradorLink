package ar.edu.utn.frba.tpIntegrador.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.frba.tpIntegrador.model.CuponProveedor;

@RepositoryRestResource(path="cuponesProveedor")
public interface RepoPromoCuponProveedor extends PagingAndSortingRepository<CuponProveedor, Integer> {

}
