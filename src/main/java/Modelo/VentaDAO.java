package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class VentaDAO {
	Conexion conexion = new Conexion();
	Connection con = conexion.hacerConexion();
	PreparedStatement ps = null;
	ResultSet resultado = null;
	
	public boolean crearVenta(VentaDTO vDTO) {
		UsuarioDTO uDTO = new UsuarioDTO();
		ClienteDTO cDTO = new ClienteDTO();
		boolean bool = false;
		try {
			String insertar, ordenar, actualizar;
			insertar = "INSERT INTO ventas (cedula_usuario, cedula_cliente, valor_venta) VALUES (?,?,?);";
			ps = con.prepareStatement(insertar);
			ps.setString(1, uDTO.getCedula_usuario());
			ps.setString(2, cDTO.getCedula_cliente());
			ps.setInt(3, vDTO.getValorVenta());
			bool = ps.executeUpdate()>0;
			if(bool) {
				ordenar = "SELECT codigo_venta FROM ventas ORDER BY codigo_venta DESC LIMIT 1;";
				ps = con.prepareStatement(ordenar);
				resultado = ps.executeQuery();
				while(resultado.next()) {
					int codigo = resultado.getInt(1);
				} actualizar = "UPDATE ventas SET ";
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al insertar la venta. "+sqle);
		}
		return bool;
	}
}
