package ar.edu.utn.frba.tpIntegrador;
/*
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import ar.edu.utn.frba.tpIntegrador.model.CarritoDeCompra;
import ar.edu.utn.frba.tpIntegrador.model.Cliente;
import ar.edu.utn.frba.tpIntegrador.model.ItemCompra;
import ar.edu.utn.frba.tpIntegrador.model.Producto;
import ar.edu.utn.frba.tpIntegrador.model.Rol;
import ar.edu.utn.frba.tpIntegrador.model.TipoDeDocumento;

public class initData implements CommandLineRunner{
	@Autowired
	RepoUsuario repousuario; 
	@Autowired
	RepoRol repoRol;
	@Autowired
	RepoCarritoDeCompra carritoDeCompras; 
	@Autowired
	RepoItemCompra repoItemCompra; 
	@Autowired
	RepoProducto repoProducto; 
	
	@Override
	public void run(String... args) throws Exception {
		if(repoItemCompra.count() == 0) {
			List<ItemCompra> itemsIniciales = List.of(new ItemCompra(Producto producto, int cantidad));
		}
		if(repoRol.count() == 0) {
			List<CarritoDeCompra> carritosIniciales = List.of(new CarritoDeCompra());
		}
		if(repoRol.count() == 0) {
			List<CarritoDeCompra> carritosIniciales = List.of(new CarritoDeCompra());
		}
		
		if(repoRol.count() == 0) {
			List<Rol> rolesIniciales = List.of( new Cliente("Juan Perez",CarritoDeCompra carritoDeCompra, LocalDate fechaDeNacimiento,
					TipoDeDocumento tipoDeDocumento, String nroDeDocumento, String telefono, String mail));
			
			rolesIniciales.stream().forEach(materia -> {
				repo.save(materia);
			});	
		}
		

	}

}
*/