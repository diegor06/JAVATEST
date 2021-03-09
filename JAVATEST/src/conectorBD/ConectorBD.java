package conectorBD;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

/**
 * Clase encargada de conectar MYSQL con el proyecto en JAVA
 * @author Diego Andres Riveros Lopez
 *
 */
public class ConectorBD {
	public static final String URL = "jdbc:mysql://localhost:3306/javatest";
	public static final String USER = "root";
	public static final String PASSWORD = "1234";

	/**
	 * Metodo que conecta la database con el proyecto JAVA
	 * @return conexion
	 */
	public static Connection establecerConexion() {
		Connection c = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			c = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conexion exitosa con la base de datos.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Conexion no exitosa con la base de datos, verifique. error: " + e.getMessage());
		}

		return c;

	}
}
