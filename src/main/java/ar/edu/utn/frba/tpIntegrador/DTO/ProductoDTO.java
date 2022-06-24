package ar.edu.utn.frba.tpIntegrador.DTO;

public class ProductoDTO {
	private Double precio;
	private String descripcion;
	private String nombre;
	private int stock;
	private Integer proveedorID;
	private Boolean estaEnDolares;
	private String imagen;
	
	public ProductoDTO() {
		super();
	}
	
	public ProductoDTO(Double precio, String descripcion, String nombre, int stock, Integer proveedorID,
			Boolean estaEnDolares) {
		super();
		this.precio = precio;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.stock = stock;
		this.proveedorID = proveedorID;
		this.estaEnDolares = estaEnDolares;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Integer getProveedorID() {
		return proveedorID;
	}

	public void setProveedorID(Integer proveedor) {
		this.proveedorID = proveedor;
	}

	public Boolean getEstaEnDolares() {
		return estaEnDolares;
	}

	public void setEstaEnDolares(Boolean estaEnDolares) {
		this.estaEnDolares = estaEnDolares;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
}
