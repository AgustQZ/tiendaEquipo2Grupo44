package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ProductoDAO {
	Conexion conexion = new Conexion();
	Connection con = conexion.hacerConexion();
	PreparedStatement ps = null;
	ResultSet resultado = null;
	
	public boolean cargarArchivo(String ruta) {
		boolean bool = false;
		try {
			String cargarArchivo = "load data infile '"+ruta+"' into table productos fields terminated by ',' lines terminated by '\r\n'";
			ps = con.prepareStatement(cargarArchivo);
			bool = ps.executeUpdate()>0;			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error el insertar  el archivo en la base de datos"+ sqle);
		}
		return bool;
	}
	
	public ProductoDTO consultarProducto(String codigo) {
		ProductoDTO pdDTO = null;
		try {
			String consultar = "SELECT codigo_producto, nombre_producto, precio_venta FROM productos WHERE codigo_producto=?";
			ps = con.prepareStatement(consultar);
			ps.setString(1, codigo);
			resultado = ps.executeQuery();
			while(resultado.next()) {
				pdDTO = new ProductoDTO(resultado.getString(1), resultado.getString(2), resultado.getInt(3));
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al consultar el producto en DAO. ");
		}
		return pdDTO;
	}
	
	public ProductoDTO consultarProductoV(String codigo) {
		ProductoDTO pdDTO = null;
		try {
			String consultar = "SELECT codigo_producto, nombre_producto, precio_venta, ivacompra FROM productos WHERE codigo_producto=?";
			ps = con.prepareStatement(consultar);
			ps.setString(1, codigo);
			resultado = ps.executeQuery();
			while(resultado.next()) {
				pdDTO = new ProductoDTO(resultado.getString(1), resultado.getString(2), resultado.getInt(3), resultado.getInt(4));
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al consultar el producto en DAO. ");
		}
		return pdDTO;
	}
	
	public boolean actualizarProducto(ProductoDTO pdDTO) {
		boolean bool = false;
		try {
			String actualizar = "UPDATE productos SET nombre_producto=?, precio_venta=? WHERE codigo_producto=?";
			ps = con.prepareStatement(actualizar);
			ps.setString(1, pdDTO.getNombre());
			ps.setInt(2, pdDTO.getPrecioVenta());
			ps.setString(3, pdDTO.getCodigo());
			bool = ps.executeUpdate()>0;
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al actualizar el producto en la base de datos). "+sqle);
		}
		return bool ;
	}
}


















