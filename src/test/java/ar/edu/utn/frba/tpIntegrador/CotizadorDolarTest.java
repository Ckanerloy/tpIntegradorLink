package ar.edu.utn.frba.tpIntegrador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.utn.frba.tpIntegrador.model.Producto;
import ar.edu.utn.frba.tpIntegrador.model.Proveedor;

public class CotizadorDolarTest {
	@Test
	public void precioDolar() {
		Proveedor proveedor = new Proveedor("Proveedor de bebidas","48675678","proveedor@gmail.com",50);
		Producto producto1= new Producto("Bebida" , "Coca cola",2.0, 5,proveedor,true,"");
		//CotizadorDolar cotizadorDolar = new CotizadorDolar();	
		//producto1.setCotizadorDolar(cotizadorDolar);
		assertEquals(producto1.getPrecio(),246.1);
	}

	
}
