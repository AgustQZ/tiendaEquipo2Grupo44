package Modelo;

public class VentaDTO {
	private int codVenta;
	private String cUsuario;
	private String cCliente;
	private int valorVenta;
	private int ivaVenta;
	private int totalVenta;
	
	public VentaDTO(int codVenta, String cUsuario, String cCliente, int valorVenta, int ivaVenta, int totalVenta) {
		super();
		this.codVenta = codVenta;
		this.cUsuario = cUsuario;
		this.cCliente = cCliente;
		this.valorVenta = valorVenta;
		this.ivaVenta = ivaVenta;
		this.totalVenta = totalVenta;
	}

	public VentaDTO(String cUsuario, String cCliente, int valorVenta, int ivaVenta, int totalVenta) {
		this.cUsuario = cUsuario;
		this.cCliente = cCliente;
		this.valorVenta = valorVenta;
		this.ivaVenta = ivaVenta;
		this.totalVenta = totalVenta;
	}

	public int getCodVenta() {
		return codVenta;
	}
	public void setCodVenta(int codVenta) {
		this.codVenta = codVenta;
	}
	public String getcUsuario() {
		return cUsuario;
	}
	public void setcUsuario(String cUsuario) {
		this.cUsuario = cUsuario;
	}
	public String getcCliente() {
		return cCliente;
	}
	public void setcCliente(String cCliente) {
		this.cCliente = cCliente;
	}
	public int getValorVenta() {
		return valorVenta;
	}
	public void setValorVenta(int valorVenta) {
		this.valorVenta = valorVenta;
	}
	public int getIvaVenta() {
		return ivaVenta;
	}
	public void setIvaVenta(int ivaVenta) {
		this.ivaVenta = ivaVenta;
	}
	public int getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(int totalVenta) {
		this.totalVenta = totalVenta;
	}
	
	
}