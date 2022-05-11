package ar.edu.utn.frba.tpIntegrador.model;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class CotizadorDolar implements Cotizador{
private double precio;
	
	@Override
	public double calcularPrecio(){
		RestTemplate nuevo = new RestTemplate();
		try {
			double valor =this.run(nuevo).getCompra();
			return valor*precio;
		}catch(Exception e){
			//TODO Auto-generated
			e.printStackTrace();
		}
		return 0.0;
	}
	
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public ApiPrecioDolar run(RestTemplate restTemplate) throws Exception {
		ApiPrecioDolar precioActual = restTemplate.getForObject(
		"http://api-dolar-argentina.herokuapp.com/api/dolaroficial", ApiPrecioDolar.class);
		return precioActual;
		}
	
	public CotizadorDolar(double precio) {
		super();
		this.precio = precio;
	}
}
