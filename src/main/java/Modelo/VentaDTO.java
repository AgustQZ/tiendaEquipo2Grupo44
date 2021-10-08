package Modelo;

public class VentaDTO {
	private int codVenta;
	private UsuarioDTO cUsuario;
	private ClienteDTO cCliente;
	private int valorVenta;
	private int ivaVenta;
	private int totalVenta;
	
	public VentaDTO(UsuarioDTO cUsuario, ClienteDTO cCliente, int valorVenta) {
		this.cUsuario = cUsuario;
		this.cCliente = cCliente;
		this.valorVenta = valorVenta;
	}

	public int getCodVenta() {
		return codVenta;
	}

	public void setCodVenta(int codVenta) {
		this.codVenta = codVenta;
	}

	public UsuarioDTO getcUsuario() {
		return cUsuario;
	}

	public void setcUsuario(UsuarioDTO cUsuario) {
		this.cUsuario = cUsuario;
	}

	public ClienteDTO getcCliente() {
		return cCliente;
	}

	public void setcCliente(ClienteDTO cCliente) {
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
