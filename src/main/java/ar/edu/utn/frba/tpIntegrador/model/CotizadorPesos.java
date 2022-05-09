package ar.edu.utn.frba.tpIntegrador.model;

public class CotizadorPesos implements Cotizador{
	
	private double precio;
	
	@Override
	public double calcularPrecio(){
		return precio * 1;
	}

	public CotizadorPesos(double precio) {
		super();
		this.precio = precio;
	}
	
}
