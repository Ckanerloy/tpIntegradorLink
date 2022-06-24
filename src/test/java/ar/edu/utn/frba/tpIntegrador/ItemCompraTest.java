package ar.edu.utn.frba.tpIntegrador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.utn.frba.tpIntegrador.model.ItemCompra;
import ar.edu.utn.frba.tpIntegrador.model.Producto;
import ar.edu.utn.frba.tpIntegrador.model.Proveedor;
import ar.edu.utn.frba.tpIntegrador.model.StockInsuficienteException;

public class ItemCompraTest {
	@Test
	public void calcularElTotalDeUnItem() throws StockInsuficienteException{
		Proveedor proveedor = new Proveedor("Proveedor de bebidas","48675678","proveedor@gmail.com",50);
		Producto producto1= new Producto("Bebida" , "Coca cola", 100.0, 5,proveedor,false,"");
		//CotizadorPesos cotizadorPesos = new CotizadorPesos();
		//producto1.setCotizador(cotizadorPesos);
		ItemCompra itemDeCompra1 = new ItemCompra(producto1,2); 
		assertEquals(itemDeCompra1.calcularPrecioItem(),200.0);
	}
	
	@Test
	public void calcularElTotalDeUnItemQueNoTieneStock() throws StockInsuficienteException{
		Proveedor proveedor = new Proveedor("Proveedor de bebidas","48675678","proveedor@gmail.com",50);
		Producto producto1= new Producto("Bebida" , "Coca cola", 100.0, 0,proveedor,false,"");
		//CotizadorPesos cotizadorPesos = new CotizadorPesos();
		//producto1.setCotizador(cotizadorPesos);
		assertThrows(StockInsuficienteException.class, ()-> {new ItemCompra(producto1,2);});
	}
	
}
