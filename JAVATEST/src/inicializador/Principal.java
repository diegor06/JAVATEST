package inicializador;

import java.sql.Connection;

import conectorBD.ConectorBD;
import logica.ScrapedWeb;

public class Principal {

	public static void main(String[] args) {
		Connection con = ConectorBD.establecerConexion();
		ScrapedWeb scraped = new ScrapedWeb("https://www.la14.com/c/electrodomesticos/pequenos-electrodomesticos/");
	}
	
}
