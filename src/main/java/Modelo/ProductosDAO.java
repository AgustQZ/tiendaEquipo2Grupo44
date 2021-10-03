package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ProductosDAO {
	Conexion conexion = new Conexion();
	Connection con = conexion.hacerConexion();
	PreparedStatement ps = null;
	ResultSet resultado = null;
	
	public boolean cargarArchivo(String ruta) {
		boolean bool = false;
		try {
			String cargarArchivo = "load data infile '"+ruta+"' into table proveedores fields terminated by ',' lines terminated by '\r\n'";
			ps = con.prepareStatement(cargarArchivo);
			bool = ps.executeUpdate()>0;			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error el insertar  el archivo en la base de datos"+ sqle);
		}
		return bool;
	}
}
