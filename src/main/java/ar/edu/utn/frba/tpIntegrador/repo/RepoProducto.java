package ar.edu.utn.frba.tpIntegrador.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ar.edu.utn.frba.tpIntegrador.model.Producto;

@CrossOrigin
@RepositoryRestResource(path="productos")
public interface RepoProducto extends PagingAndSortingRepository<Producto, Integer> {
	/*
	@Override
	@RestResource(exported = false)
	void deleteById(Integer id) ;
	
	@Override
	@RestResource(exported = false)
	void delete(Producto entity) ;
*/
}