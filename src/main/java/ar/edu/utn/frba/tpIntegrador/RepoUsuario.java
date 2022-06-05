package ar.edu.utn.frba.tpIntegrador;

import org.springframework.data.repository.PagingAndSortingRepository;

import ar.edu.utn.frba.tpIntegrador.model.Usuario;

public interface RepoUsuario extends PagingAndSortingRepository<Usuario, Integer> {

}
