package conectorBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import logica.Electrodomestico;


/**
 * Clase encargada de persistir o guardar los datos en la Database en MYSQL
 * @author Diego Andres Riveros Lopez
 *
 */
public class PersistenciaBD {

	Connection con;


	/*
	 * Constructor
	 */
	public PersistenciaBD(Connection con) {
		super();
		this.con = con;
	}

	/**
	 * Metodo encargado de insertar la informacion en la tabla de la database de MYSQL
	 * @param electrodomestico Objeto electrodomestico
	 */
	public void insertarInformacion(Electrodomestico electrodomestico) {

		try {

			String SQL = "INSERT INTO household_appliance (product_URL, product_Name, product_Brand, "
					+ "product_Price, product_Description) values (?,?, ?, ?, ?)";

			PreparedStatement pst1 = con.prepareStatement(SQL);

			pst1.setString(1, electrodomestico.getUrl());
			pst1.setString(2, electrodomestico.getNombre());
			pst1.setString(3, electrodomestico.getBrand());
			pst1.setDouble(4, electrodomestico.getPrecio());
			pst1.setString(5, electrodomestico.getDescripcion());
			pst1.execute();

		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "No se pueden persisitir los datos, revise la base de datos.");
			
		}


	}

}
