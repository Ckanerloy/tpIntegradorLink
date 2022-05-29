package ar.edu.utn.frba.tpIntegrador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.utn.frba.tpIntegrador.model.CotizadorDolar;
import ar.edu.utn.frba.tpIntegrador.model.Producto;
import ar.edu.utn.frba.tpIntegrador.model.Proveedor;

public class CotizadorDolarTest {
	@Test
	public void precioDolar() {
		Proveedor proveedor = new Proveedor("Proveedor de bebidas","48675678","proveedor@gmail.com",50);
		CotizadorDolar CotizadorDolar = new CotizadorDolar(2.0);
		Producto producto1= new Producto("Bebida" , "Coca cola",CotizadorDolar, true, 5,proveedor);
		assertEquals(producto1.getPrecio(),237.24);
	}

	
}
