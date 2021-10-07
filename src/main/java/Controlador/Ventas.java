package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.VentaDTO;
import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
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
		if(request.getParameter("consultarCliente")!=null) {
			String cedulaCliente = request.getParameter("cedulaCliente");
			ClienteDTO cDTO = cDAO.consultarCliente(cedulaCliente);
			if(cDTO!=null) {
				String nombreCliente;
				cedulaCliente = cDTO.getCedula_cliente();
				nombreCliente = cDTO.getNombre_cliente();
				response.sendRedirect("Ventas.jsp=?cedulaCliente"+cedulaCliente+"&&nombreCliente"+nombreCliente);
				
			}
		}
	}

}
