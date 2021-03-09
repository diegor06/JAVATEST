package inicializador;

import java.sql.Connection;
import java.util.ArrayList;

import conectorBD.ConectorBD;
import logica.Electrodomestico;
import logica.ScrapedWeb;

/**
 * Clase principal encargada de inicializar el proyecto JAVA
 * 
 * @author Diego Andres Riveros Lopez
 *
 */
public class Principal {

	/**
	 * Metodo principal MAIN
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Connection con = ConectorBD.establecerConexion();
		ScrapedWeb scraped = new ScrapedWeb("https://www.la14.com/c/electrodomesticos/pequenos-electrodomesticos/",
				con);
		ArrayList<Electrodomestico> lstElectrodomesticos = scraped.obtenerElectrodomesticos();

		for (Electrodomestico electrodomestico : lstElectrodomesticos) {
			System.out.println("URL:" + electrodomestico.getUrl() + "\nNombre:" + electrodomestico.getNombre()
					+ "\nPrecio: " + electrodomestico.getPrecio() + "\nDescripion: " + electrodomestico.getDescripcion()
					+ "\n\n");
		}

	}

}
