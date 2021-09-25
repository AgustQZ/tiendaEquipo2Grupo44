package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class UsuarioDAO {
	Conexion conexion = new Conexion();
	Connection con = conexion.hacerConexion();
	PreparedStatement ps = null;
	ResultSet resultado = null;
	
	public boolean crearUsuario(UsuarioDTO uDTO) {
		boolean resultado = false;
		try {
			String insertar = "insert into usuarios values (?,?,?,?,?)";
			ps = con.prepareStatement(insertar);
			ps.setString(1, uDTO.getCedula_usuario());			
			ps.setString(2, uDTO.getEmail_usuario());
			ps.setString(3, uDTO.getNombre_usuario());
			ps.setString(4, uDTO.getUsuario());
			ps.setString(5, uDTO.getPassword());
			resultado = ps.executeUpdate()>0;			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al insertar el usuario"+sqle);
		}
		return resultado;
		
	}
}
