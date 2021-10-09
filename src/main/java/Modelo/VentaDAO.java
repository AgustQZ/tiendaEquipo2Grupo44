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
		boolean bool = false;
		try {
			String insertar = "INSERT INTO ventas (cedula_usuario, cedula_cliente, valor_venta, ivaventa, total_venta) VALUES (?,?,?,?,?)";
			ps = con.prepareStatement(insertar);
			ps.setString(1, vDTO.getcUsuario());
			ps.setString(2, vDTO.getcCliente());
			ps.setInt(3, vDTO.getValorVenta());
			ps.setInt(4, vDTO.getIvaVenta());
			ps.setInt(5, vDTO.getTotalVenta());
			bool = ps.executeUpdate()>0;
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al insertar la venta en dao. "+sqle);
		}
		return bool;
	}
	
	public boolean crearDetalleVenta(DetalleVentaDTO dvDTO) {
		boolean bool = false;
		try {			
			String insertar = "INSERT INTO detalle_ventas (cantidad_producto, codigo_producto, codigo_venta, valor_total, valor_venta, valoriva) VALUES (?,?,?,?,?,?)";
			ps = con.prepareStatement(insertar);
			ps.setInt(1, dvDTO.getCantidad());
			ps.setInt(2, dvDTO.getCodigoProducto());
			ps.setInt(3, dvDTO.getCodigoVenta());
			ps.setInt(4, dvDTO.getValorTotal());
			ps.setInt(5, dvDTO.getValorVenta());
			ps.setInt(6, dvDTO.getValorIva());
			bool = ps.executeUpdate()>0;			
			} catch (Exception sqle) {
			JOptionPane.showMessageDialog(null, "Error al insertar el detalle de venta en dao. "+sqle);
		}
		return bool;
	}
	
	public int consultarCodigoVenta() {
		int codigo=0;
		try {
			String ordenar = "SELECT codigo_venta FROM ventas ORDER BY codigo_venta DESC LIMIT 1;";
			
			ps = con.prepareStatement(ordenar);
			resultado = ps.executeQuery();
			while(resultado.next()) {
				codigo = resultado.getInt(1);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar el codigo en la base de datos. "+e);
		}
		return codigo;
	}
}
