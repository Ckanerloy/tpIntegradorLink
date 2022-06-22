package ar.edu.utn.frba.tpIntegrador.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.utn.frba.tpIntegrador.DTO.LoginDTO;
import ar.edu.utn.frba.tpIntegrador.model.Usuario;
import ar.edu.utn.frba.tpIntegrador.repo.RepoUsuario;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginComplement {
	@Autowired
	private RepoUsuario repoUsuario;
	
	@GetMapping("")
	public LoginDTO get(@RequestParam(value = "user", required = false) String user,@RequestParam(value = "contra", required = false) String contra) {
		Optional<Usuario> opcionalUsuario= repoUsuario.findByUserAndContra(user,contra);
		/*if(opcionalUsuario.isEmpty()) {
			return "usuario no encontrado";
		}*/
		
		Usuario usuario=opcionalUsuario.get();

		LoginDTO loginDto = new LoginDTO();
		
		loginDto.setTipoDeRol(usuario.getRol().getTipoDeRol());
		loginDto.setId(usuario.getRol().getID());
		
		return loginDto;
	}
	
}
