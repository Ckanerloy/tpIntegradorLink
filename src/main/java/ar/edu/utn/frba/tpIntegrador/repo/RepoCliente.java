package ar.edu.utn.frba.tpIntegrador.repo;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ar.edu.utn.frba.tpIntegrador.model.Cliente;

@CrossOrigin
@RepositoryRestResource(path="clientes")
public interface RepoCliente extends PagingAndSortingRepository<Cliente, UUID> {

}
