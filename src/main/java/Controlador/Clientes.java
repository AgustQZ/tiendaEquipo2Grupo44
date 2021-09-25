package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;

/**
 * Servlet implementation class Clientes
 */
@WebServlet("/Clientes")
public class Clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Clientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteDAO cDAO = new ClienteDAO();
		
		if(request.getParameter("crear")!=null) {
			String nombre, cedula, email, direccion, telefono;			
			cedula = request.getParameter("cedula");
			nombre = request.getParameter("nombre");
			email =  request.getParameter("email");
			telefono = request.getParameter("direccion");
			direccion = request.getParameter("telefono");
			ClienteDTO cDTO = new ClienteDTO(cedula, nombre, email, direccion, telefono);
			if(cDAO.CrearCliente(cDTO)) {
				response.sendRedirect("Clientes.jsp?mensaje=Cliente creado exitosamente");
			}else {
				response.sendRedirect("Clientes.jsp?mensaje=Error al crear el cliente");
			}
		}
		
		else if(request.getParameter("consultar")!=null) {
			String cedula = request.getParameter("cedula");
			ClienteDTO cDTO = cDAO.consultarCliente(cedula);
			if(cDTO!=null) {
				String nombre, email, direccion, telefono;
				cedula = cDTO.getCedula_cliente();
				nombre = cDTO.getNombre_cliente();
				email = cDTO.getEmail_cliente();
				direccion = cDTO.getDireccion_cliente();
				telefono = cDTO.getTelefono_cliente();
				response.sendRedirect("Clientes.jsp?cedula="+cedula+"&&nombre="+nombre+"&&email="+email+"&&direccion="+direccion+"&&telefono="+telefono);
			}else {
				response.sendRedirect("Clientes.jsp?mensaje=Error al consultar el cliente");
			}
			
		}
		
		else if(request.getParameter("actualizar")!=null) {
			String cedula, nombre, email, direccion, telefono;
			cedula = request.getParameter("id");
			nombre = request.getParameter("nombre");
			email = request.getParameter("email");
			direccion = request.getParameter("direccion");
			telefono = request.getParameter("telefono");
			ClienteDTO cDTO = new ClienteDTO(cedula, nombre, email, direccion, telefono);
			if(cDAO.actualizarCliente(cDTO)) {
				response.sendRedirect("Clientes.jsp?mensaje=Cliente actualizado exitosamente");
			}else {
				response.sendRedirect("Clientes.jsp?mensaje=Error al actualizar el cliente");
				response.sendRedirect("Clientes.jsp");
			}
			
		}
		
		else if(request.getParameter("eliminar")!=null) {
			String cedula = request.getParameter("id");
			if(cDAO.eliminarCliente(cedula)) {
				response.sendRedirect("Clientes.jsp?mensaje=Cliente eliminado exitosamente");
			}else {
				response.sendRedirect("Clientes.jsp?mensaje=Error al eliminar el cliente");
				response.sendRedirect("Clientes.jsp");
			}
		}
		
else if(request.getParameter("limpiar") != null) {			
			String cedula,nombre, correo, direccion, telefono,estado;
			cedula = "";
			nombre = "";
			correo = "";
			direccion = "";
			telefono = "";
			response.sendRedirect("Cliente.jsp?cedula="+cedula+"&&direccion="+direccion+"&&email="+correo+"&&nombre="+nombre+"&&telefono="+telefono);
			
		}
	}
}
