package Modelo;

public class DetalleVentaDTO {
	private int codigoDetalleVenta;
	private int cantidad;
	private int codigoProducto;
	private int codigoVenta;
	private int valorVenta;
	private int valorIva;
	private int valorTotal;
	
	public DetalleVentaDTO(int cantidad, int codigoProducto, int codigoVenta, int valorVenta, int valorIva, int valorTotal) {
		this.cantidad = cantidad;
		this.codigoProducto = codigoProducto;
		this.codigoVenta = codigoVenta;
		this.valorVenta = valorVenta;
		this.valorIva = valorIva;
		this.valorTotal = valorTotal;
	}



	public int getCodigoDetalleVenta() {
		return codigoDetalleVenta;
	}
	public void setCodigoDetalleVenta(int codigoDetalleVenta) {
		this.codigoDetalleVenta = codigoDetalleVenta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public int getCodigoVenta() {
		return codigoVenta;
	}
	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}
	public int getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}
	public int getValorVenta() {
		return valorVenta;
	}
	public void setValorVenta(int valorVenta) {
		this.valorVenta = valorVenta;
	}
	public int getValorIva() {
		return valorIva;
	}
	public void setValorIva(int valorIva) {
		this.valorIva = valorIva;
	}
	
	
	
}
