package ar.edu.utn.frba.tpIntegrador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;

import ar.edu.utn.frba.tpIntegrador.model.CotizadorPesos;
import ar.edu.utn.frba.tpIntegrador.model.ItemCompra;
import ar.edu.utn.frba.tpIntegrador.model.MedioDePago;
import ar.edu.utn.frba.tpIntegrador.model.OrdenDeCompra;
import ar.edu.utn.frba.tpIntegrador.model.Producto;
import ar.edu.utn.frba.tpIntegrador.model.PromoMedioDePago;
import ar.edu.utn.frba.tpIntegrador.model.Promocion;
import ar.edu.utn.frba.tpIntegrador.model.Proveedor;

public class OrdenDeCompraTest {
	@Test
	public void CalcularPrecioDeOrdenDeCompraSinPromocion() {
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
		OrdenDeCompra ordenDeCompra = new OrdenDeCompra(promociones,LocalDate.now(), MedioDePago.EFECTIVO);
		ordenDeCompra.setItemsCompras(itemsCompras);
		assertEquals(ordenDeCompra.calcularPrecioTotalSinPromociones(),500.0);
	}
}
