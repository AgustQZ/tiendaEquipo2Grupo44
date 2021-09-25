package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {
	private String url = "jdbc:mysql://localhost:3306/tiendagenerica";
	private String user = "root";
	private String pass = "SanagustinSQL.";
	
	Connection conexion= null;
	
	public Connection hacerConexion(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, user, pass);		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al realizar la conexion"+e);
		}
		return conexion;		
	}

}
