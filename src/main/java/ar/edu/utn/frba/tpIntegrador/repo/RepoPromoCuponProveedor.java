package ar.edu.utn.frba.tpIntegrador.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ar.edu.utn.frba.tpIntegrador.model.CuponProveedor;

@CrossOrigin
@RepositoryRestResource(path="cuponesProveedor")
public interface RepoPromoCuponProveedor extends PagingAndSortingRepository<CuponProveedor, Integer> {

}
