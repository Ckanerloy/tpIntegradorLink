package ar.edu.utn.frba.tpIntegrador;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ar.edu.utn.frba.tpIntegrador.model.ApiPrecioDolar;

@Component
public final class CotizadorDolar{
	RestTemplate restTemplate = new RestTemplate();
	private Double precioDolar;
	private static CotizadorDolar cotizadorDolar;
	 
	 public  static CotizadorDolar getConfigurador() {
	 
	 if (cotizadorDolar==null) {
	 
		 cotizadorDolar = new CotizadorDolar();
	 }
	 return cotizadorDolar;
	 }
	/*@Override
	public Double calcularPrecio(){
		//Double valor =this.run(restTemplate).getCompra();
		return valor;
	}*/
	
	public ApiPrecioDolar run(RestTemplate restTemplate) {
		ApiPrecioDolar precioActual = restTemplate.getForObject(
		"http://api-dolar-argentina.herokuapp.com/api/dolaroficial", ApiPrecioDolar.class);
		return precioActual;
	}
	
	public Double getPrecioDolar() {
		return precioDolar;
	}

	@Scheduled(fixedRate = 1000*60*30)
	//@Scheduled(cron = "*/01 * * * *")
	public void actualizarPrecioDolar() {
		this.precioDolar = this.run(restTemplate).getCompra();
		System.out.println("Se actualizo el precio del dolar"); 
	}

	public CotizadorDolar() {
		super();
		this.precioDolar = this.run(restTemplate).getCompra();
	}
	
}
