package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Controlador.Conexion;

public class ProveedorDAO {
	Conexion conexion = new Conexion();
	Connection con = conexion.hacerConexion();
	PreparedStatement ps = null;
	ResultSet resultado = null;
	
	public boolean crearProveedor(ProveedorDTO pDTO) {
		boolean resultado = false;
		try {
			String insertar = "insert into proveedores values (?,?,?,?,?)";
			ps = con.prepareStatement(insertar);
			ps.setString(1, pDTO.getNit());			
			ps.setString(2, pDTO.getNombre());
			ps.setString(3, pDTO.getDireccion());
			ps.setString(4, pDTO.getTelefono());
			ps.setString(5, pDTO.getCiudad());
			resultado = ps.executeUpdate()>0;			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al insertar el proveedor(DAO). "+sqle);
		}
		return resultado;	
	}
	
	public ProveedorDTO consultarProveedor(String nit) {
		ProveedorDTO pDTO = null;
		try {
			String buscar = "SELECT nitproveedor, nombre_proveedor, direccion_proveedor, telefono_proveedor, ciudad_proveedor FROM proveedores WHERE nitproveedor=?";
			ps = con.prepareStatement(buscar);
			ps.setString(1, nit);
			resultado = ps.executeQuery();
			while(resultado.next()) {
				pDTO = new ProveedorDTO(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5));
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al consultar el proveedor(DAO). "+sqle);
		}
		return pDTO;
	}
	
	public boolean actualizarProveedor(ProveedorDTO pDTO) {
		boolean bool = false;
		try {
			String insertar = "UPDATE proveedores SET nombre_proveedor=?, direccion_proveedor=?, telefono_proveedor=?, ciudad_proveedor=? WHERE nitproveedor=?";
			ps = con.prepareStatement(insertar);
			ps.setString(5, pDTO.getNit());
			ps.setString(1, pDTO.getNombre());
			ps.setString(2, pDTO.getDireccion());
			ps.setString(3, pDTO.getTelefono());
			ps.setString(4, pDTO.getCiudad());
			bool = ps.executeUpdate()>0;			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al actualizar el proveedor(en DAO). "+sqle);
		}
		return bool;
	}
	
	public boolean eliminarProveedor(String nit) {
		boolean resultado = false;
		try {
			String eliminar = "DELETE FROM proveedores WHERE nitproveedor=?";
			ps = con.prepareStatement(eliminar);
			ps.setString(1, nit);
			resultado = ps.executeUpdate()>0;
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor(en DAO). "+sqle);
		}
		return resultado;	
	}
}
