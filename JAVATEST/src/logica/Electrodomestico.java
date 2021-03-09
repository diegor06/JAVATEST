package logica;

/**
 * Clase encargada objeto Electrodomestico
 * @author Diego Andres Riveros Lopez
 *
 */
public class Electrodomestico {

	/*
	 * Atributos
	 */
	private String url;
	private String nombre;
	private String brand;
	private double precio;
	private String descripcion;
	
	/*
	 * Constructor
	 */
	public Electrodomestico(String url, String nombre, String brand, double precio, String descripcion) {
		super();
		this.url = url;
		this.nombre = nombre;
		this.brand = brand;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	/*
	 * Get URL
	 */
	public String getUrl() {
		return url;
	}

	/*
	 * Set URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/*
	 * Get nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/*
	 * Set nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	 * Get brand
	 */
	public String getBrand() {
		return brand;
	}

	/*
	 * Set brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/*
	 * Get precio
	 */
	public double getPrecio() {
		return precio;
	}

	/*
	 * Set precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/*
	 * Get descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/*
	 * Set descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
