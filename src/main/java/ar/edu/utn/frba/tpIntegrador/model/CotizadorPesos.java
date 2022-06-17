package ar.edu.utn.frba.tpIntegrador.model;


//@Entity
///@DiscriminatorValue("1")
public class CotizadorPesos{
	
	public Double calcularPrecio(Double precio){
		return precio * 1;
	}

	public CotizadorPesos() {
		super();
	}
	
}
