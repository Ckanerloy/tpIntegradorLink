package ar.edu.utn.frba.tpIntegrador;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import ar.edu.utn.frba.tpIntegrador.model.Producto;

public interface RepoProducto extends PagingAndSortingRepository<Producto, Integer> {
	
	@Override
	@RestResource(exported = false)
	void deleteById(Integer id) ;
	
	@Override
	@RestResource(exported = false)
	void delete(Producto entity) ;


}