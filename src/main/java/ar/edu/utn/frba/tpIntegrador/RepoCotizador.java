package ar.edu.utn.frba.tpIntegrador;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="cotizadores")
public interface RepoCotizador extends PagingAndSortingRepository<CotizadorDolar, Integer> {

}
