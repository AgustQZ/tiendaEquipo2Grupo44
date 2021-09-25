package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ClienteDAO {
	Conexion conexion = new Conexion();
	Connection con = conexion.hacerConexion();
	PreparedStatement ps = null;
	ResultSet result = null;
	
	public boolean CrearCliente(ClienteDTO cliente)  {
		boolean bool = false;
		String ingresar = "insert into clientes values (?,?,?,?,?)";
		try {
			ps = con.prepareStatement(ingresar);
			ps.setString(1, cliente.getCedula_cliente());
			ps.setString(2, cliente.getNombre_cliente());
			ps.setString(3, cliente.getEmail_cliente());
			ps.setString(4, cliente.getDireccion_cliente());
			ps.setString(5, cliente.getTelefono_cliente());
			bool = ps.executeUpdate()>0;		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al insertar el cliente "+e);
		}
		return bool;
	}
	
	public ClienteDTO consultarCliente(String cedula) {
		String consultar = "select * from clientes where cedula_cliente=?";
		ClienteDTO cDTO = null;
		try {
			ps = con.prepareStatement(consultar);
			ps.setString(1, cedula);
			result = ps.executeQuery();
			if(result.next()) {
				cDTO = new ClienteDTO(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar el cliente "+e);
		}
		return cDTO;
	}
	
	public boolean actualizarCliente(ClienteDTO cDTO) {
		boolean bool = false;
		try {
			String actualizar = "update usuarios set nombre_cliente=?, email_cliente=?, direccion_cliente=?, telefono_cliente=? where cedula_cliente=?";
			ps = con.prepareStatement(actualizar);
			ps.setString(1, cDTO.getNombre_cliente());
			ps.setString(2, cDTO.getEmail_cliente());
			ps.setString(3, cDTO.getDireccion_cliente());
			ps.setString(4, cDTO.getTelefono_cliente());
			ps.setString(5, cDTO.getCedula_cliente());
			bool = ps.executeUpdate()>0;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al actualizar el cliente "+e);
		}
		return bool;
	}
	
	public boolean eliminarCliente(String cedula) {
		String eliminar = "delete * from clientes where cedula_cliente=?";
		boolean bool = false;
		try {
			ps = con.prepareStatement(eliminar);
			ps.setString(1, cedula);
			bool = ps.executeUpdate()>0;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al eliminar el cliente"+e);;
		}
		return bool;
	}
	
}
