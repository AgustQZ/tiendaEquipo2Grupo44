package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import Modelo.VentaDTO;
import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.DetalleVentaDTO;
import Modelo.ProductoDAO;
import Modelo.ProductoDTO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;
import Modelo.VentaDAO;
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
		VentaDAO vDAO = new VentaDAO();
		
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
		
		if(request.getParameter("consultarPd1")!=null) {
			String codigo1 = request.getParameter("codigo1");
			ProductoDTO pdDTO = pdDAO.consultarProductoV(codigo1);
			if(pdDTO!=null) {
				String nombrePd1;
				int precioPd1, ivaPd1;
				codigo1 = pdDTO.getCodigo();
				nombrePd1 = pdDTO.getNombre();
				precioPd1 = pdDTO.getPrecioVenta();
				ivaPd1 = pdDTO.getIva();
				response.sendRedirect("Ventas.jsp?codigo1="+codigo1+"&&nombrePd1="+nombrePd1+"&&precioPd1="+precioPd1+"&&ivaPd1="+ivaPd1);				
			}else {
				response.sendRedirect("Ventas.jsp?mensaje=Error al consultar el producto");
				//JOptionPane.showMessageDialog(null, "Error al consultar el Producto");
				//response.sendRedirect("Ventas.jsp");
			}
		}
		
		if(request.getParameter("consultarPd2")!=null) {
			String codigo2 = request.getParameter("codigo2");
			ProductoDTO pdDTO = pdDAO.consultarProductoV(codigo2);
			if(pdDTO!=null) {
				String nombrePd2;
				int precioPd2, ivaPd2;
				codigo2 = pdDTO.getCodigo();
				nombrePd2 = pdDTO.getNombre();
				precioPd2 = pdDTO.getPrecioVenta();
				ivaPd2 = pdDTO.getIva();
				response.sendRedirect("Ventas.jsp?codigo2="+codigo2+"&&nombrePd2="+nombrePd2+"&&precioPd2="+precioPd2+"&&ivaPd2="+ivaPd2);				
			}else {
				response.sendRedirect("Ventas.jsp?mensaje=Error al consultar el producto");
			}
		}
		
		if(request.getParameter("consultarPd3")!=null) {
			String codigo3 = request.getParameter("codigo3");
			ProductoDTO pdDTO = pdDAO.consultarProductoV(codigo3);
			if(pdDTO!=null) {
				String nombrePd3;
				int precioPd3, ivaPd3;
				codigo3 = pdDTO.getCodigo();
				nombrePd3 = pdDTO.getNombre();
				precioPd3 = pdDTO.getPrecioVenta();
				ivaPd3 = pdDTO.getIva();
				response.sendRedirect("Ventas.jsp?codigo3="+codigo3+"&&nombrePd3="+nombrePd3+"&&precioPd3="+precioPd3+"&&ivaPd3="+ivaPd3);				
			}else {
				response.sendRedirect("Ventas.jsp?mensaje=Error al consultar el producto");
			}
		}
		
		if(request.getParameter("confirmar")!=null) {
			int cant1=0, cant2=0, cant3=0,
				precio1=0, precio2=0, precio3=0,
				ivaPd1=0, ivaPd2=0, ivaPd3=0, totalIva=0,
				valorT1=0, valorT2=0, valorT3=0,
				totalVenta, totalPagar=0,
				codigoPd1=0, codigoPd2=0, codigoPd3=0;
			codigoPd1 = Integer.parseInt(request.getParameter("codigo1"));
			cant1 = Integer.parseInt(request.getParameter("cant1"));
			precio1 = Integer.parseInt(request.getParameter("precio1"));
			valorT1 = cant1 * precio1;
			ivaPd1 = valorT1 / 100 * Integer.parseInt(request.getParameter("iva1"));
			
			cant2 = Integer.parseInt(request.getParameter("cant2"));
			precio2 = Integer.parseInt(request.getParameter("precio2"));
			valorT2 = cant2 * precio2;
			ivaPd2 = valorT2 / 100 * Integer.parseInt(request.getParameter("iva2"));
			
			cant3 = Integer.parseInt(request.getParameter("cant3"));
			precio3 = Integer.parseInt(request.getParameter("precio3"));
			valorT3 = cant3 * precio3;
			ivaPd3 = valorT3 / 100 * Integer.parseInt(request.getParameter("iva3"));
			
			totalVenta = valorT1 + valorT2 + valorT3;
			totalIva = ivaPd1+ivaPd2+ivaPd3;
			totalPagar = totalVenta + totalIva;
			
			//insertar la venta en la base de datos
			String cCliente; 
			String cUsuario = "1032";
			cCliente = request.getParameter("cCliente");
			VentaDTO vDTO = new VentaDTO(cUsuario, cCliente, totalVenta, totalIva, totalPagar);
			if(vDAO.crearVenta(vDTO)) {
				//insertar el detalle de venta en la base de datos
				int cant, codigoV, vTotal, vVenta, vIva;
				codigoV = vDAO.consultarCodigoVenta();
				//DetalleVentaDTO dvDTO = new DetalleVentaDTO("cant"+i, "codigoPd"+i, codigoV, "valorT"+i, "ivaPd"+i, ("valorT"+i)+("ivaPd"+i));
				DetalleVentaDTO dvDTO1 = new DetalleVentaDTO(cant1, codigoPd1, codigoV, valorT1, ivaPd1, valorT1+ivaPd1);
				DetalleVentaDTO dvDTO2 = new DetalleVentaDTO(cant2, codigoPd2, codigoV, valorT2, ivaPd2, valorT2+ivaPd2);
				DetalleVentaDTO dvDTO3 = new DetalleVentaDTO(cant3, codigoPd3, codigoV, valorT3, ivaPd3, valorT1+ivaPd3);
				vDAO.crearDetalleVenta(dvDTO1);
				JOptionPane.showMessageDialog(null, "no pudimos llegar al 2 :(");
				vDAO.crearDetalleVenta(dvDTO2);
				vDAO.crearDetalleVenta(dvDTO3);
				response.sendRedirect("Ventas.jsp?mensaje=Venta y detalle insertados exitosamente"+
						"&&cant1="+cant1+"&&valorT1="+valorT1+"&&cant2="+cant2+"&&valorT2="+valorT2+"&&cant3="+cant3+
						"&&valorT3="+valorT3+"&&totalVenta="+totalVenta+"&&totalIva="+totalIva+"&&totalPagar="+totalPagar+"&&codigoV="+codigoV);
				//if(vDAO.crearDetalleVenta(dvDTO1) && vDAO.crearDetalleVenta(dvDTO2) && vDAO.crearDetalleVenta(dvDTO3)) {
				//}
				
			}else {
				response.sendRedirect("Ventas.jsp?mensaje=Error al crear la venta en servlet");
			}
		}
		//Formato Json con Gson
		ArrayList<UsuarioDTO> lista = new ArrayList<>();
		UsuarioDAO uDAO = new UsuarioDAO();
		lista = uDAO.listarUsuarios();
		PrintWriter escribir = response.getWriter();
		Gson datos = new Gson();
		escribir.println(datos.toJson(lista));
	}
}
