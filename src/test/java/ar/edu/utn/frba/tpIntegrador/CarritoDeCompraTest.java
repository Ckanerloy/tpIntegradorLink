package ar.edu.utn.frba.tpIntegrador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;

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
import ar.edu.utn.frba.tpIntegrador.model.StockInsuficienteException;
import ar.edu.utn.frba.tpIntegrador.model.TipoDeDocumento;

public class CarritoDeCompraTest {
	@Test
	public void CalcularPrecioDeOrdenDeCompraSinPromocion() throws StockInsuficienteException {
		Proveedor proveedor1 = new Proveedor("Proveedor de bebidas","48675678","proveedor1@gmail.com",50);
		Producto producto1= new Producto("Bebida" , "Coca cola", 150.0, 5,proveedor1,false,"");
		//CotizadorPesos cotizadorPesos1 = new CotizadorPesos();
		//producto1.setCotizadorDolar(cotizadorPesos1);
		ItemCompra itemDeCompra1 = new ItemCompra(producto1,2); 
		Proveedor proveedor2 = new Proveedor("Proveedor de Snacks","48585110","proveedor2@gmail.com",100);
		Producto producto2= new Producto("Snacks" , "chetos", 50.0, 5,proveedor2,false,"");
		//producto2.setCotizador(cotizadorPesos1);
		ItemCompra itemDeCompra2 = new ItemCompra(producto2,4); 
		Collection<ItemCompra> itemsCompras = Arrays.asList(itemDeCompra1,itemDeCompra2);
		PromoMedioDePago promoMedioDePago = new PromoMedioDePago(MedioDePago.EFECTIVO,0.10);
		Collection<Promocion> promociones = Arrays.asList(promoMedioDePago);
		Cliente cliente=new Cliente("Camila Kaner Loy",LocalDate.now(),TipoDeDocumento.DNI,"40976081","48760011","camilakanerloy@gmail.com");
		CarritoDeCompra carritoDeCompra = new CarritoDeCompra(promociones,LocalDate.now(), MedioDePago.EFECTIVO,cliente);
		carritoDeCompra.setItemsCompras(itemsCompras);
		assertEquals(carritoDeCompra.calcularPrecioTotalSinPromociones(),500.0);
	}
	@Test
	public void CalcularPrecioDeOrdenDeCompraConUnaPromocionDeMedioDePago() throws StockInsuficienteException{
		Proveedor proveedor1 = new Proveedor("Proveedor de bebidas","48675678","proveedor1@gmail.com",50);
		Producto producto1= new Producto("Bebida" , "Coca cola", 150.0, 5,proveedor1,false,"");
		//CotizadorPesos cotizadorPesos1 = new CotizadorPesos();
		//producto1.setCotizador(cotizadorPesos1);
		ItemCompra itemDeCompra1 = new ItemCompra(producto1,2); 
		Proveedor proveedor2 = new Proveedor("Proveedor de Snacks","48585110","proveedor2@gmail.com",100);
		Producto producto2= new Producto("Snacks" , "chetos", 50.0, 5,proveedor2,false,"");
		//producto2.setCotizador(cotizadorPesos1);
		ItemCompra itemDeCompra2 = new ItemCompra(producto2,4); 
		Collection<ItemCompra> itemsCompras = Arrays.asList(itemDeCompra1,itemDeCompra2);
		PromoMedioDePago promoMedioDePago = new PromoMedioDePago(MedioDePago.EFECTIVO,0.10);
		Collection<Promocion> promociones = Arrays.asList(promoMedioDePago);
		Cliente cliente=new Cliente("Camila Kaner Loy",LocalDate.now(),TipoDeDocumento.DNI,"40976081","48760011","camilakanerloy@gmail.com");
		CarritoDeCompra carritoDeCompra = new CarritoDeCompra(promociones,LocalDate.now(), MedioDePago.EFECTIVO,cliente);
		carritoDeCompra.setItemsCompras(itemsCompras);
		assertEquals(carritoDeCompra.calcularPrecioTotalConPromociones(),450.0);
	}
	
	@Test
	public void CalcularPrecioDeOrdenDeCompraConUnaPromocionCuponProveedor() throws StockInsuficienteException{
		Proveedor proveedor1 = new Proveedor("Proveedor de bebidas","48675678","proveedor1@gmail.com",50);
		Producto producto1= new Producto("Bebida" , "Coca cola", 150.0, 5,proveedor1,false,"");
		//CotizadorPesos cotizadorPesos1 = new CotizadorPesos();
		//producto1.setCotizador(cotizadorPesos1);
		ItemCompra itemDeCompra1 = new ItemCompra(producto1,2); 
		Proveedor proveedor2 = new Proveedor("Proveedor de Snacks","48585110","proveedor2@gmail.com",100);
		Producto producto2= new Producto("Snacks" , "chetos", 50.0, 5,proveedor2,false,"");
		//producto2.setCotizador(cotizadorPesos1);
		ItemCompra itemDeCompra2 = new ItemCompra(producto2,4); 
		Collection<ItemCompra> itemsCompras = Arrays.asList(itemDeCompra1,itemDeCompra2);
		CuponProveedor cuponProveedor = new CuponProveedor(true,0.10,proveedor1);
		Collection<Promocion> promociones = Arrays.asList(cuponProveedor);
		Cliente cliente=new Cliente("Camila Kaner Loy",LocalDate.now(),TipoDeDocumento.DNI,"40976081","48760011","camilakanerloy@gmail.com");
		CarritoDeCompra carritoDeCompra = new CarritoDeCompra(promociones,LocalDate.now(), MedioDePago.EFECTIVO,cliente);
		carritoDeCompra.setItemsCompras(itemsCompras);
		assertEquals(carritoDeCompra.calcularPrecioTotalConPromociones(),470.0);
	}
	
	@Test
	public void CalcularPrecioDeOrdenDeCompraConMembresia() throws StockInsuficienteException{
		Proveedor proveedor1 = new Proveedor("Proveedor de bebidas","48675678","proveedor1@gmail.com",50);
		Producto producto1= new Producto("Bebida" , "Coca cola", 150.0, 5,proveedor1,false,"");
		//CotizadorPesos cotizadorPesos1 = new CotizadorPesos();
		//producto1.setCotizador(cotizadorPesos1);
		ItemCompra itemDeCompra1 = new ItemCompra(producto1,2); 
		Proveedor proveedor2 = new Proveedor("Proveedor de Snacks","48585110","proveedor2@gmail.com",100);
		Producto producto2= new Producto("Snacks" , "chetos", 50.0, 5,proveedor2,false,"");
		//producto2.setCotizador(cotizadorPesos1);
		ItemCompra itemDeCompra2 = new ItemCompra(producto2,4); 
		Collection<ItemCompra> itemsCompras = Arrays.asList(itemDeCompra1,itemDeCompra2);
		Cliente cliente=new Cliente("Camila Kaner Loy",LocalDate.now(),TipoDeDocumento.DNI,"40976081","48760011","camilakanerloy@gmail.com");
		Membresia membresia = new Membresia(Arrays.asList(cliente),0.10);
		Collection<Promocion> promociones = Arrays.asList(membresia);
		CarritoDeCompra carritoDeCompra = new CarritoDeCompra(promociones,LocalDate.now(), MedioDePago.EFECTIVO,cliente);
		carritoDeCompra.setItemsCompras(itemsCompras);
		assertEquals(carritoDeCompra.calcularPrecioTotalConPromociones(),450.0);
	}
	
	@Test 
	public void CalcularPrecioDeOrdenDeCompraSinPromocionEnDolares() throws StockInsuficienteException{
		Proveedor proveedor1 = new Proveedor("Proveedor de bebidas","48675678","proveedor1@gmail.com",50);
		Producto producto1= new Producto("Bebida" , "Coca cola", 150.0, 5,proveedor1,true,"");
		//CotizadorDolar cotizadorDolar1 = new CotizadorDolar();
		//producto1.setCotizadorDolar(cotizadorDolar1);
		ItemCompra itemDeCompra1 = new ItemCompra(producto1,2); 
		Proveedor proveedor2 = new Proveedor("Proveedor de Snacks","48585110","proveedor2@gmail.com",100);
		//CotizadorDolar cotizadorDolar2 = new CotizadorDolar();
		Producto producto2= new Producto("Snacks" , "chetos", 50.0, 5,proveedor2,true,"");
		//producto2.setCotizadorDolar(cotizadorDolar1);
		ItemCompra itemDeCompra2 = new ItemCompra(producto2,4); 
		Collection<ItemCompra> itemsCompras = Arrays.asList(itemDeCompra1,itemDeCompra2);
		PromoMedioDePago promoMedioDePago = new PromoMedioDePago(MedioDePago.EFECTIVO,0.10);
		Collection<Promocion> promociones = Arrays.asList(promoMedioDePago);
		Cliente cliente=new Cliente("Camila Kaner Loy",LocalDate.now(),TipoDeDocumento.DNI,"40976081","48760011","camilakanerloy@gmail.com");
		CarritoDeCompra carritoDeCompra = new CarritoDeCompra(promociones,LocalDate.now(), MedioDePago.EFECTIVO,cliente);
		carritoDeCompra.setItemsCompras(itemsCompras);
		assertEquals(carritoDeCompra.calcularPrecioTotalSinPromociones(),61525);
	}
	
}
