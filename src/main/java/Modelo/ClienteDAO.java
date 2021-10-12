package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import Controlador.Conexion;

public class ClienteDAO {
	Conexion conexion = new Conexion();
	Connection con = conexion.hacerConexion();
	PreparedStatement ps = null;
	ResultSet resultado = null;
	
	public boolean crearCliente(ClienteDTO cDTO)  {
		boolean resultado = false;
		try {
			String insertar = "insert into clientes values (?,?,?,?,?)";
			ps = con.prepareStatement(insertar);
			ps.setString(1, cDTO.getCedula_cliente());			
			ps.setString(2, cDTO.getNombre_cliente());
			ps.setString(3, cDTO.getEmail_cliente());
			ps.setString(4, cDTO.getDireccion_cliente());
			ps.setString(5, cDTO.getTelefono_cliente());
			resultado = ps.executeUpdate()>0;			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al insertar el cliente(en DAO). "+sqle);
		}
		return resultado;	
	}
	
	public ClienteDTO consultarCliente(String cedula) {
		ClienteDTO cDTO = null;
		try {
			String buscar = "SELECT cedula_cliente, nombre_cliente, email_cliente, direccion_cliente, telefono_cliente FROM clientes WHERE cedula_cliente=?";
			ps = con.prepareStatement(buscar);
			ps.setString(1, cedula);
			resultado = ps.executeQuery();
			while(resultado.next()) {
				cDTO = new ClienteDTO(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5));
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al consultar el cliente(en DAO). "+sqle);
		}
		return cDTO;
	}
	
	public boolean actualizarCliente(ClienteDTO cDTO) {
		boolean bool = false;
		try {
			String insertar = "update clientes set nombre_cliente=?, email_cliente=?, direccion_cliente=?, telefono_cliente=? where cedula_cliente=?";
			ps = con.prepareStatement(insertar);
			ps.setString(1, cDTO.getNombre_cliente());
			ps.setString(2, cDTO.getEmail_cliente());
			ps.setString(3, cDTO.getDireccion_cliente());
			ps.setString(4, cDTO.getTelefono_cliente());
			ps.setString(5, cDTO.getCedula_cliente());
			bool = ps.executeUpdate()>0;			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al actualizar el cliente(en DAO). "+sqle);
		}
		return bool;
	}
	
	public boolean eliminarCliente(String cedula) {
		boolean resultado = false;
		try {
			String eliminar = "delete from clientes where cedula_cliente=?";
			ps = con.prepareStatement(eliminar);
			ps.setString(1, cedula);
			resultado = ps.executeUpdate()>0;
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al eliminar el cliente(en DAO). "+sqle);
		}
		return resultado;	
	}
	
	public ArrayList<ClienteDTO> listarClientes(){
		ClienteDTO cDTO = null;
		ArrayList<ClienteDTO> lista = new ArrayList<>();
		try {
			String seleccionar = "SELECT * FROM clientes";
			ps = con.prepareStatement(seleccionar);
			resultado = ps.executeQuery();
			while(resultado.next()) {
				cDTO = new ClienteDTO(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5));
				lista.add(cDTO);
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al listar los clientes en dao. "+sqle);
		}
		return lista;
	}
	
}
