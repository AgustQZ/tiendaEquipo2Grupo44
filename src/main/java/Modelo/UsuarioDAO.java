package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import Controlador.Conexion;

public class UsuarioDAO {
	Conexion conexion = new Conexion();
	Connection con = conexion.hacerConexion();
	PreparedStatement ps = null;
	ResultSet resultado = null;
	
	public boolean crearUsuario(UsuarioDTO uDTO) {
		boolean bool = false;
		try {
			String insertar = "insert into usuarios values (?,?,?,?,?)";
			ps = con.prepareStatement(insertar);
			ps.setString(1, uDTO.getCedula_usuario());			
			ps.setString(2, uDTO.getEmail_usuario());
			ps.setString(3, uDTO.getNombre_usuario());
			ps.setString(4, uDTO.getUsuario());
			ps.setString(5, uDTO.getPassword());
			bool = ps.executeUpdate()>0;			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al insertar el usuario. "+sqle);
		}
		return bool;	
	}
	
	public UsuarioDTO consultarUsuario(String cedula) {
		UsuarioDTO uDTO = null;
		try {
			String buscar = "select * from usuarios where cedula_usuario=?";
			ps = con.prepareStatement(buscar);
			ps.setString(1, cedula);
			resultado = ps.executeQuery();
			while(resultado.next()) {
				uDTO = new UsuarioDTO(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5));
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al consultar el usuario. "+sqle);
		}
		return uDTO;
	}
	
	public boolean actualizarUsuario(UsuarioDTO uDTO) {
		boolean bool = false;
		try {
			String insertar = "update usuarios set nombre_usuario=?, email_usuario=?, usuario=?, password=? where cedula_usuario=?";
			ps = con.prepareStatement(insertar);
			ps.setString(1, uDTO.getNombre_usuario());
			ps.setString(2, uDTO.getEmail_usuario());
			ps.setString(3, uDTO.getUsuario());
			ps.setString(4, uDTO.getPassword());
			ps.setString(5, uDTO.getCedula_usuario());
			bool = ps.executeUpdate()>0;			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al actualizar el usuario. "+sqle);
		}
		return bool;
	}
	
	public boolean eliminarUsuario(String cedula) {
		boolean bool = false;
		try {
			String eliminar = "DELETE FROM usuarios WHERE cedula_usuario=?";
			ps = con.prepareStatement(eliminar);
			ps.setString(1, cedula);
			bool = ps.executeUpdate()>0;
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al eliminar el usuario. "+sqle);
		}
		return bool;	
	}
	
	public ArrayList<UsuarioDTO> listarUsuarios(){
		UsuarioDTO uDTO = null;
		ArrayList<UsuarioDTO> lista = new ArrayList<>();
		try {
			String seleccionar = "SELECT * FROM usuarios";
			ps = con.prepareStatement(seleccionar);
			resultado = ps.executeQuery();
			while(resultado.next()) {
				uDTO = new UsuarioDTO(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5));
				lista.add(uDTO);
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al listar los usuarios en dao. "+sqle);
		}
		return lista;
	}
}
