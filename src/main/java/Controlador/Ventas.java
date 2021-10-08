package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.VentaDTO;
import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.ProductoDAO;
import Modelo.ProductoDTO;
/**
 * Servlet implementation class Ventas
 */
@WebServlet("/Ventas")
public class Ventas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ventas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteDAO cDAO = new ClienteDAO();
		ProductoDAO pdDAO = new ProductoDAO();
		
		if(request.getParameter("consultarCliente")!=null) {
			String cedulaCliente = request.getParameter("cedulaCliente");
			ClienteDTO cDTO = cDAO.consultarCliente(cedulaCliente);
			if(cDTO!=null) {
				String nombreCliente;
				cedulaCliente = cDTO.getCedula_cliente();
				nombreCliente = cDTO.getNombre_cliente();
				response.sendRedirect("Ventas.jsp?cedulaCliente="+cedulaCliente+"&&nombreCliente="+nombreCliente);				
			}else {
				JOptionPane.showMessageDialog(null, "Error al consultar el cliente");
				response.sendRedirect("Ventas.jsp");
			}
		}
		
		if(request.getParameter("agregarPd1")!=null) {
			int cant1 = Integer.parseInt(request.getParameter("cant1"));
			int vOculto1 = Integer.parseInt(request.getParameter("vt1"));
			int valorTotal1 = cant1 * vOculto1;
			response.sendRedirect("Ventas.jsp?valorTotal1="+valorTotal1);
		}
		
		if(request.getParameter("consultarPd1")!=null) {
			String codigo1 = request.getParameter("codigo1");
			ProductoDTO pdDTO = pdDAO.consultarProducto(codigo1);
			if(pdDTO!=null) {
				String nombrePd1;
				int precioPd1;
				codigo1 = pdDTO.getCodigo();
				nombrePd1 = pdDTO.getNombre();
				precioPd1 = pdDTO.getPrecioVenta();
				response.sendRedirect("Ventas.jsp?codigo1="+codigo1+"&&nombrePd1="+nombrePd1+"&&precioPd1="+precioPd1);				
			}else {
				response.sendRedirect("Ventas.jsp?mensaje=Error al consultar el producto");
				//JOptionPane.showMessageDialog(null, "Error al consultar el Producto");
				//response.sendRedirect("Ventas.jsp");
			}
		}
		
		if(request.getParameter("consultarPd2")!=null) {
			String codigo2 = request.getParameter("codigo2");
			ProductoDTO pdDTO = pdDAO.consultarProducto(codigo2);
			if(pdDTO!=null) {
				String nombrePd2;
				codigo2 = pdDTO.getCodigo();
				nombrePd2 = pdDTO.getNombre();
				response.sendRedirect("Ventas.jsp?codigo2="+codigo2+"&&nombrePd2="+nombrePd2);				
			}else {
				response.sendRedirect("Ventas.jsp?mensaje=Error al consultar el producto");
			}
		}
		
		if(request.getParameter("consultarPd3")!=null) {
			String codigo3 = request.getParameter("codigo3");
			ProductoDTO pdDTO = pdDAO.consultarProducto(codigo3);
			if(pdDTO!=null) {
				String nombrePd3;
				codigo3 = pdDTO.getCodigo();
				nombrePd3 = pdDTO.getNombre();
				response.sendRedirect("Ventas.jsp?codigo3="+codigo3+"&&nombrePd3="+nombrePd3);				
			}else {
				response.sendRedirect("Ventas.jsp?mensaje=Error al consultar el producto");
			}
		}
	}

}
