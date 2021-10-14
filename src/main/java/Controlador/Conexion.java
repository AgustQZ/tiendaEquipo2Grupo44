package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {
	private String url = "jdbc:mariadb://prestamosvf.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/Grupo44_Equipo_2";
	private String user = "admin";
	private String pass = "Ciclo3_admi123";
	
	Connection conexion= null;
	
	public Connection hacerConexion(){
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conexion = DriverManager.getConnection(url, user, pass);		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al realizar la conexion"+e);
		}
		return conexion;		
	}

}
