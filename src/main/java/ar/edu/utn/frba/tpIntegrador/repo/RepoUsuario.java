package ar.edu.utn.frba.tpIntegrador.repo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ar.edu.utn.frba.tpIntegrador.model.Usuario;

@CrossOrigin
@RepositoryRestResource(path="usuarios")
public interface RepoUsuario extends PagingAndSortingRepository<Usuario, UUID> {
	Optional<Usuario> findByUserAndContra(String user,String contra);
	Optional<Usuario> findByUser(String user);
}
