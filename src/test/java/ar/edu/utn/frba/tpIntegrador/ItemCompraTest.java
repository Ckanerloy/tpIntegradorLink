package ar.edu.utn.frba.tpIntegrador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.utn.frba.tpIntegrador.model.CotizadorPesos;
import ar.edu.utn.frba.tpIntegrador.model.ItemCompra;
import ar.edu.utn.frba.tpIntegrador.model.Producto;
import ar.edu.utn.frba.tpIntegrador.model.Proveedor;
import ar.edu.utn.frba.tpIntegrador.model.StockInsuficienteException;

public class ItemCompraTest {
	@Test
	public void calcularElTotalDeUnItem() throws StockInsuficienteException{
		Proveedor proveedor = new Proveedor("Proveedor de bebidas","48675678","proveedor@gmail.com",50);
		CotizadorPesos cotizadorPesos = new CotizadorPesos(100.0);
		Producto producto1= new Producto("Bebida" , "Coca cola",cotizadorPesos, true, 5,proveedor);
		ItemCompra itemDeCompra1 = new ItemCompra(producto1,2); 
		assertEquals(itemDeCompra1.calcularPrecioItem(),200.0);
	}
	
}
