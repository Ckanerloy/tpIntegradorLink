package ar.edu.utn.frba.tpIntegrador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;

import ar.edu.utn.frba.tpIntegrador.model.CarritoDeCompra;
import ar.edu.utn.frba.tpIntegrador.model.Cliente;
import ar.edu.utn.frba.tpIntegrador.model.CuponProveedor;
import ar.edu.utn.frba.tpIntegrador.model.ItemCompra;
import ar.edu.utn.frba.tpIntegrador.model.MedioDePago;
import ar.edu.utn.frba.tpIntegrador.model.Membresia;
import ar.edu.utn.frba.tpIntegrador.model.Producto;
import ar.edu.utn.frba.tpIntegrador.model.PromoMedioDePago;
import ar.edu.utn.frba.tpIntegrador.model.Promocion;
import ar.edu.utn.frba.tpIntegrador.model.Proveedor;
import ar.edu.utn.frba.tpIntegrador.model.Rol;
import ar.edu.utn.frba.tpIntegrador.model.TipoDeDocumento;
import ar.edu.utn.frba.tpIntegrador.model.Usuario;
import ar.edu.utn.frba.tpIntegrador.model.Vendedor;
import ar.edu.utn.frba.tpIntegrador.repo.RepoCliente;
import ar.edu.utn.frba.tpIntegrador.repo.RepoProducto;
import ar.edu.utn.frba.tpIntegrador.repo.RepoPromocion;
import ar.edu.utn.frba.tpIntegrador.repo.RepoProveedor;
import ar.edu.utn.frba.tpIntegrador.repo.RepoUsuario;
import ar.edu.utn.frba.tpIntegrador.repo.RepoVendedor;
import ar.edu.utn.frba.tpIntegrador.repo.RepoCarritoDeCompra;
@Component
public class initData implements CommandLineRunner{
	@Autowired
	RepositoryRestConfiguration config;
	@Autowired
	RepoCliente repoCliente;
	@Autowired
	RepoVendedor repoVendedor;
	@Autowired
	RepoProducto repoProducto;
	@Autowired
	RepoProveedor repoProveedor;
	@Autowired
	RepoUsuario repoUsuario;
	@Autowired
	RepoCarritoDeCompra repoCarritoDeCompra;
	@Autowired
	RepoPromocion repoPromocion;
	
	@Override
	public void run(String... args) throws Exception {
	config.exposeIdsFor(Producto.class,CarritoDeCompra.class,Proveedor.class);
		if(repoUsuario.count() == 0) {
			
			Cliente cliente1=new Cliente("Camila Kaner Loy",LocalDate.now(),TipoDeDocumento.DNI,"40976081","48760011","camilakanerloy@gmail.com");
			Cliente cliente2=new Cliente("Mariana Kaner Loy",LocalDate.now(),TipoDeDocumento.DNI,"28768090","48009911","marianakanerloy@gmail.com");
			List<Cliente> clientesIniciales=List.of(cliente1,cliente2);
			clientesIniciales.stream().forEach(cliente -> {
				repoCliente.save(cliente);
			});	
			
			Proveedor proveedor1=new Proveedor("Samsung oficial","48675678","samsungoficial@gmail.com",100);
			Proveedor proveedor2=new Proveedor("Adidas","48675678","adidas@gmail.com",100);
			List<Proveedor> proveedoresIniciales=List.of(proveedor1,proveedor2);
			proveedoresIniciales.stream().forEach(proveedor -> {
				repoProveedor.save(proveedor);
			});	
			
			Producto producto1=new Producto("Samsung a50" , "Color negro", 15000.0, 30,proveedor1,false,"https://i0.wp.com/m.media-amazon.com/images/I/31hHG7UNszL.jpg?w=640&ssl=1");
			Producto producto2=new Producto("Samsung a50" , "Color blanco", 15000.0, 30,proveedor2,false,"https://static.toiimg.com/thumb/resizemode-4,msid-68254981,imgsize-200,width-1200/68254981.jpg");
			Producto producto3=new Producto("Remera Nike" , "Color naranja", 5000.0, 30,proveedor1,false,"http://cdn.shopify.com/s/files/1/0594/7506/7048/products/63b4422fadd3f231aa2e51d249f707257ebc2604.jpg?v=1641583856");
			Producto producto4=new Producto("Remera" , "Color blanco", 6000.0, 30,proveedor2,false,"https://www.stockcenter.com.ar/on/demandware.static/-/Sites-dabra-catalog/default/dwfa7e643b/products/NI_86F210-001/NI_86F210-001-1.JPG");
			Producto producto5=new Producto("Netbook" , "Memoria RAM", 25000.0, 30,proveedor2,false,"https://static8.depositphotos.com/1007373/810/i/600/depositphotos_8102712-stock-photo-black-netbook-isolated-on-white.jpg");
			Producto producto6=new Producto("Audiculares" , "Inalambricos", 4000.0, 30,proveedor2,false,"https://images.fravega.com/f500/76fc32af6228ab78899056fa0e681431.jpg");
			Producto producto7=new Producto("Audiculares" , "Color celecte", 3500.0, 30,proveedor1,false,"https://m.media-amazon.com/images/I/614q47uoPNL._AC_SY450_.jpg");
			Producto producto8=new Producto("Peugeot 208" , "Año 2012", 100000.0, 30,proveedor2,false,"https://upload.wikimedia.org/wikipedia/commons/a/af/Peugeot_208_95_VTi_Allure_%E2%80%93_Frontansicht%2C_15._September_2012%2C_D%C3%BCsseldorf.jpg");
			Producto producto9=new Producto("Ford Fiesta" , "Año 2015", 150000.0, 30,proveedor2,false,"https://www.megautos.com/wp-content/uploads/2018/04/Ford-FIesta-Van-2018-delantera.jpg");
			Producto producto10=new Producto("Samsung a50" , "Color blanco", 15500.0, 30,proveedor2,false,"https://i0.wp.com/m.media-amazon.com/images/I/31hHG7UNszL.jpg?w=640&ssl=1");
			List<Producto> productosIniciales=List.of(producto1,producto2,producto3,producto4,producto5,producto6,producto7,producto8,producto9,producto10);
			productosIniciales.stream().forEach(producto -> {
			repoProducto.save(producto);
			});	
			
			Vendedor vendedor1=new Vendedor("Fabian Gonzalez", "45298", LocalDate.now(),"gonzalezFabian@gmail.com",
			TipoDeDocumento.DNI,"28706541",Arrays.asList(producto1,producto2,producto3,producto4,producto5),proveedor1);
			Vendedor vendedor2=new Vendedor("Franco Gomez", "67890", LocalDate.now(),"francogomez@gmail.com",
					TipoDeDocumento.DNI,"28706541",Arrays.asList(producto6,producto7,producto8,producto9,producto10),proveedor2);
			List<Vendedor> vendedoresIniciales=List.of(vendedor1,vendedor2);
			vendedoresIniciales.stream().forEach(vendedor -> {
				repoVendedor.save(vendedor);
			});	
			
			Usuario usuario1 = new Usuario("camila", "abc", cliente1);
			Usuario usuario2 = new Usuario("mariana", "abc", cliente2);
			Usuario usuario3 = new Usuario("fabian", "abc", vendedor1);
			Usuario usuario4 = new Usuario("franco", "abc", vendedor2);
			List<Usuario> usuariosIniciales=List.of(usuario1,usuario2,usuario3,usuario4);
			usuariosIniciales.stream().forEach(usuario -> {
				repoUsuario.save(usuario);
			});
			
			PromoMedioDePago promoMedioDePago = new PromoMedioDePago(MedioDePago.EFECTIVO,0.10);
			CuponProveedor cuponProveedor1 = new CuponProveedor(true,0.10,proveedor1);
			CuponProveedor cuponProveedor2 = new CuponProveedor(true,0.05,proveedor2);
			Membresia membresia = new Membresia(Arrays.asList(cliente1),0.10);
			List<Promocion> promocionesIniciales=List.of(promoMedioDePago,cuponProveedor1,cuponProveedor2,membresia);
			promocionesIniciales.stream().forEach(promocion -> {
				repoPromocion.save(promocion);
			});
			
			CarritoDeCompra carritoDeCompra1 = new CarritoDeCompra(Arrays.asList(promoMedioDePago,membresia),LocalDate.now(), MedioDePago.EFECTIVO,cliente1);
			CarritoDeCompra carritoDeCompra2 = new CarritoDeCompra(Arrays.asList(promoMedioDePago,membresia),LocalDate.now(), MedioDePago.TARJETA_CREDITO,cliente2);
			List<CarritoDeCompra> carritosIniciales=List.of(carritoDeCompra1,carritoDeCompra2);
			carritosIniciales.stream().forEach(carrito -> {
				repoCarritoDeCompra.save(carrito);
			});
			
		}
		
		
		
	}
}
	
