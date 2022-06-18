package ar.edu.utn.frba.tpIntegrador.repo;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.frba.tpIntegrador.model.Usuario;

@RepositoryRestResource(path="usuarios")
public interface RepoUsuario extends PagingAndSortingRepository<Usuario, UUID> {

}
