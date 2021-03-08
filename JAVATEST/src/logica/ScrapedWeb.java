package logica;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapedWeb {
	
	
	private static String url;
	private static String urlProducto;
	private static String nombre;
	private static String brand;
	private static double precio;
	private static String descripcion;
	
	

	public ScrapedWeb(String url) {
		this.url = url;
		scapping();
		
	}

	public static Document getHTMLWeb(String url) {

		Document html = null;
		try {
			html = Jsoup.connect(url).get();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No es posible obtener el codigo html de la pagina solicitada.");
		}

		return html;
	}

	public static void scapping() {

		Elements electrodomesticos = ScrapedWeb
				.getHTMLWeb(url)
				.select("div.dpr_container");

		
		for (Element electrodomestico : electrodomesticos) {
			try {
				urlProducto = electrodomestico.select("a").attr("abs:href");
				System.out.println(urlProducto);

				Elements datosElectrodomesticoSeleccionado = ScrapedWeb
						.getHTMLWeb(urlProducto).select("div.product-content");
				

				for (Element electrodomesticoSeleccionado : datosElectrodomesticoSeleccionado) {
					
					nombre =  electrodomesticoSeleccionado.select("h1").text();
					System.out.println(nombre);
					
					brand =  electrodomesticoSeleccionado.select("div.sku").text().substring(5,12);
					System.out.println(brand);
			
					precio =  Double.parseDouble(electrodomesticoSeleccionado.select("span[itemprop=priceValidUntil]").text().substring(1).replace(",", ""));
					System.out.println(precio);
					
					descripcion = electrodomesticoSeleccionado.select("span[id=itempropdescription]").select("p").text();
					System.out.println(descripcion);
					
					System.out.println(" ");
					System.out.println(" ");
					
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No es posible obtener la infomacion de la pagina solicitada.");
			}

		}

	}

}
