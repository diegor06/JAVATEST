package logica;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import conectorBD.ConectorBD;
import conectorBD.PersistenciaBD;

/**
 * Clase encargada obtener los datos del html
 * 
 * @author Diego Andres Riveros Lopez
 */
public class ScrapedWeb {

	/*
	 * Atributos
	 */
	private static Connection conector;
	private static String url;
	private static String urlProducto;
	private static String nombre;
	private static String brand;
	private static double precio;
	private static String descripcion;
	private static ArrayList<Electrodomestico> lstElectrodomesticos;

	/*
	 * Constructor
	 */
	public ScrapedWeb(String url, Connection con) {
		this.url = url;
		this.conector = con;
		lstElectrodomesticos = new ArrayList<Electrodomestico>();
		scapping();
	}

	/**
	 * Metodo encargado de obtener el html de la pagina web
	 * @param url direccion URL de la pagina web
	 * @return documento html
	 */
	public static Document getHTMLWeb(String url) {

		Document html = null;
		try {
			html = Jsoup.connect(url).get();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No es posible obtener el codigo html de la pagina solicitada.");
		}

		return html;
	}

	/**
	 * Metodo encargado de obtener los datos especificos del documento html
	 */
	public static void scapping() {

		Elements electrodomesticos = ScrapedWeb.getHTMLWeb(url).select("div.dpr_container");

		for (Element electrodomestico : electrodomesticos) {
			try {
				urlProducto = electrodomestico.select("a").attr("abs:href");

				Elements datosElectrodomesticoSeleccionado = ScrapedWeb.getHTMLWeb(urlProducto)
						.select("div.product-content");

				for (Element electrodomesticoSeleccionado : datosElectrodomesticoSeleccionado) {

					nombre = electrodomesticoSeleccionado.select("h1").text();
					brand = electrodomesticoSeleccionado.select("div.sku").text().substring(5, 12);
					precio = Double.parseDouble(electrodomesticoSeleccionado.select("span[itemprop=priceValidUntil]")
							.text().substring(1).replace(",", ""));
					descripcion = electrodomesticoSeleccionado.select("span[id=itempropdescription]").select("p")
							.text();

					Electrodomestico e = new Electrodomestico(urlProducto, nombre, brand, precio, descripcion);
					lstElectrodomesticos.add(e);

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No es posible obtener la infomacion de la pagina solicitada.");
			}

		}

		PersistenciaBD p = new PersistenciaBD(conector);

		for (Electrodomestico electrodomestico : lstElectrodomesticos) {
			p.insertarInformacion(electrodomestico);
		}

	}

	/*
	 * getElectrodomesticos
	 */
	public ArrayList<Electrodomestico> obtenerElectrodomesticos() {
		return lstElectrodomesticos;
	}

}
