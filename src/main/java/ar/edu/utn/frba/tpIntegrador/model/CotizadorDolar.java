package ar.edu.utn.frba.tpIntegrador.model;

import org.springframework.web.client.RestTemplate;

public class CotizadorDolar implements Cotizador{
	private double precio;
	RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public double calcularPrecio(){
		double valor =this.run(restTemplate).getCompra();
		return valor*precio;
	}
	
	public ApiPrecioDolar run(RestTemplate restTemplate) {
		ApiPrecioDolar precioActual = restTemplate.getForObject(
		"http://api-dolar-argentina.herokuapp.com/api/dolaroficial", ApiPrecioDolar.class);
		return precioActual;
	}
	
	public CotizadorDolar(double precio) {
		super();
		this.precio = precio;
	}
}
