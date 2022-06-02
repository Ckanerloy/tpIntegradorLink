package ar.edu.utn.frba.tpIntegrador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;

import ar.edu.utn.frba.tpIntegrador.model.CarritoDeCompra;
import ar.edu.utn.frba.tpIntegrador.model.CotizadorDolar;
import ar.edu.utn.frba.tpIntegrador.model.CotizadorPesos;
import ar.edu.utn.frba.tpIntegrador.model.CuponProveedor;
import ar.edu.utn.frba.tpIntegrador.model.ItemCompra;
import ar.edu.utn.frba.tpIntegrador.model.MedioDePago;
import ar.edu.utn.frba.tpIntegrador.model.Producto;
import ar.edu.utn.frba.tpIntegrador.model.PromoMedioDePago;
import ar.edu.utn.frba.tpIntegrador.model.Promocion;
import ar.edu.utn.frba.tpIntegrador.model.Proveedor;
import ar.edu.utn.frba.tpIntegrador.model.StockInsuficienteException;

public class CarritoDeCompraTest {
	@Test
	public void CalcularPrecioDeOrdenDeCompraSinPromocion() throws StockInsuficienteException {
		Proveedor proveedor1 = new Proveedor("Proveedor de bebidas","48675678","proveedor1@gmail.com",50);
		CotizadorPesos cotizadorPesos1 = new CotizadorPesos(150.0);
		Producto producto1= new Producto("Bebida" , "Coca cola",cotizadorPesos1, true, 5,proveedor1);
		ItemCompra itemDeCompra1 = new ItemCompra(producto1,2); 
		Proveedor proveedor2 = new Proveedor("Proveedor de Snacks","48585110","proveedor2@gmail.com",100);
		CotizadorPesos cotizadorPesos2 = new CotizadorPesos(50.0);
		Producto producto2= new Producto("Snacks" , "chetos",cotizadorPesos2, true, 5,proveedor2);
		ItemCompra itemDeCompra2 = new ItemCompra(producto2,4); 
		Collection<ItemCompra> itemsCompras = Arrays.asList(itemDeCompra1,itemDeCompra2);
		PromoMedioDePago promoMedioDePago = new PromoMedioDePago(MedioDePago.EFECTIVO,0.10);
		Collection<Promocion> promociones = Arrays.asList(promoMedioDePago);
		CarritoDeCompra carritoDeCompra = new CarritoDeCompra(promociones,LocalDate.now(), MedioDePago.EFECTIVO);
		carritoDeCompra.setItemsCompras(itemsCompras);
		assertEquals(carritoDeCompra.calcularPrecioTotalSinPromociones(),500.0);
	}
	@Test
	public void CalcularPrecioDeOrdenDeCompraConUnaPromocionDeMedioDePago() throws StockInsuficienteException{
		Proveedor proveedor1 = new Proveedor("Proveedor de bebidas","48675678","proveedor1@gmail.com",50);
		CotizadorPesos cotizadorPesos1 = new CotizadorPesos(150.0);
		Producto producto1= new Producto("Bebida" , "Coca cola",cotizadorPesos1, true, 5,proveedor1);
		ItemCompra itemDeCompra1 = new ItemCompra(producto1,2); 
		Proveedor proveedor2 = new Proveedor("Proveedor de Snacks","48585110","proveedor2@gmail.com",100);
		CotizadorPesos cotizadorPesos2 = new CotizadorPesos(50.0);
		Producto producto2= new Producto("Snacks" , "chetos",cotizadorPesos2, true, 5,proveedor2);
		ItemCompra itemDeCompra2 = new ItemCompra(producto2,4); 
		Collection<ItemCompra> itemsCompras = Arrays.asList(itemDeCompra1,itemDeCompra2);
		PromoMedioDePago promoMedioDePago = new PromoMedioDePago(MedioDePago.EFECTIVO,0.10);
		Collection<Promocion> promociones = Arrays.asList(promoMedioDePago);
		CarritoDeCompra carritoDeCompra = new CarritoDeCompra(promociones,LocalDate.now(), MedioDePago.EFECTIVO);
		carritoDeCompra.setItemsCompras(itemsCompras);
		assertEquals(carritoDeCompra.calcularPrecioTotalConPromociones(),450.0);
	}
	
	@Test
	public void CalcularPrecioDeOrdenDeCompraConUnaPromocionCuponProveedor() throws StockInsuficienteException{
		Proveedor proveedor1 = new Proveedor("Proveedor de bebidas","48675678","proveedor1@gmail.com",50);
		CotizadorPesos cotizadorPesos1 = new CotizadorPesos(150.0);
		Producto producto1= new Producto("Bebida" , "Coca cola",cotizadorPesos1, true, 5,proveedor1);
		ItemCompra itemDeCompra1 = new ItemCompra(producto1,2); 
		Proveedor proveedor2 = new Proveedor("Proveedor de Snacks","48585110","proveedor2@gmail.com",100);
		CotizadorPesos cotizadorPesos2 = new CotizadorPesos(50.0);
		Producto producto2= new Producto("Snacks" , "chetos",cotizadorPesos2, true, 5,proveedor2);
		ItemCompra itemDeCompra2 = new ItemCompra(producto2,4); 
		Collection<ItemCompra> itemsCompras = Arrays.asList(itemDeCompra1,itemDeCompra2);
		CuponProveedor cuponProveedor = new CuponProveedor(true,0.10,proveedor1);
		Collection<Promocion> promociones = Arrays.asList(cuponProveedor);
		CarritoDeCompra carritoDeCompra = new CarritoDeCompra(promociones,LocalDate.now(), MedioDePago.EFECTIVO);
		carritoDeCompra.setItemsCompras(itemsCompras);
		assertEquals(carritoDeCompra.calcularPrecioTotalConPromociones(),470.0);
	}
	
	@Test void CalcularPrecioDeOrdenDeCompraSinPromocionEnDolares() throws StockInsuficienteException{
		Proveedor proveedor1 = new Proveedor("Proveedor de bebidas","48675678","proveedor1@gmail.com",50);
		CotizadorDolar cotizadorDolar1 = new CotizadorDolar(150.0);
		Producto producto1= new Producto("Bebida" , "Coca cola",cotizadorDolar1, true, 5,proveedor1);
		ItemCompra itemDeCompra1 = new ItemCompra(producto1,2); 
		Proveedor proveedor2 = new Proveedor("Proveedor de Snacks","48585110","proveedor2@gmail.com",100);
		CotizadorDolar cotizadorDolar2 = new CotizadorDolar(50.0);
		Producto producto2= new Producto("Snacks" , "chetos",cotizadorDolar2, true, 5,proveedor2);
		ItemCompra itemDeCompra2 = new ItemCompra(producto2,4); 
		Collection<ItemCompra> itemsCompras = Arrays.asList(itemDeCompra1,itemDeCompra2);
		PromoMedioDePago promoMedioDePago = new PromoMedioDePago(MedioDePago.EFECTIVO,0.10);
		Collection<Promocion> promociones = Arrays.asList(promoMedioDePago);
		CarritoDeCompra carritoDeCompra = new CarritoDeCompra(promociones,LocalDate.now(), MedioDePago.EFECTIVO);
		carritoDeCompra.setItemsCompras(itemsCompras);
		assertEquals(carritoDeCompra.calcularPrecioTotalSinPromociones(),59935);
	}
}
