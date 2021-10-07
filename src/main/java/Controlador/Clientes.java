package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
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
			String cedula, nombre, correo, direccion, telefono;
			cedula = request.getParameter("cedula");
			nombre = request.getParameter("nombre");
			correo = request.getParameter("correo");
			direccion = request.getParameter("direccion");
			telefono = request.getParameter("telefono");
			ClienteDTO cDTO = new ClienteDTO(cedula, correo,nombre, direccion, telefono);
			if(cDAO.crearCliente(cDTO)) {
				response.sendRedirect("Clientes.jsp?mensaje=Cliente creado exitosamente");
			}else {
				response.sendRedirect("Clientes.jsp?mensaje=Error al crear el Cliente");
			}
		}
		
		else if(request.getParameter("consultar")!=null) {
			String cedula = request.getParameter("cedula");
			ClienteDTO cDTO = cDAO.consultarCliente(cedula);
			if(cDTO!=null) {
				String nombre, correo, direccion, telefono;
				cedula = cDTO.getCedula_cliente();
				nombre = cDTO.getNombre_cliente();
				correo = cDTO.getEmail_cliente();
				direccion = cDTO.getDireccion_cliente();
				telefono = cDTO.getTelefono_cliente();
				response.sendRedirect("Clientes.jsp?cedula="+cedula+"&&nombre="+nombre+"&&correo="+correo+"&&direccion="+direccion+"&&telefono="+telefono);
			}else {
				JOptionPane.showMessageDialog(null, "Error al consultar el cliente");
				response.sendRedirect("Clientes.jsp");
			}
		}
		
		else if(request.getParameter("actualizar")!=null) {
			String cedula, nombre, correo, direccion, telefono;
			cedula = request.getParameter("id");//NOTA: se utiliza esta variable ya que se deshabilito el input "cedula" del Usuarios.jsp
			nombre = request.getParameter("nombre");
			correo = request.getParameter("correo");
			direccion = request.getParameter("direccion");
			telefono = request.getParameter("telefono");
			ClienteDTO cDTO = new ClienteDTO(cedula, nombre, correo, direccion, telefono);
			if(cDAO.actualizarCliente(cDTO)) {
				response.sendRedirect("Clientes.jsp?mensaje=Cliente actualizado exitosamente");
			}else {
				response.sendRedirect("Clientes.jsp?mensaje=Error al actualizar el cliente(en Servlet)");
			}
		}
		
		else if(request.getParameter("eliminar")!=null) {
			String cedula = request.getParameter("id");			
			if(cDAO.eliminarCliente(cedula)) {
				response.sendRedirect("Clientes.jsp?mensaje=Cliente eliminado exitosamente");
			}else {
				response.sendRedirect("Clientes.jsp?mensaje=Error al eliminar el cliente");
			}
		}
		
else if(request.getParameter("limpiar") != null) {			
			String cedula,nombre, correo, direccion, telefono;
			cedula = "";
			nombre = "";
			correo = "";
			direccion = "";
			telefono = "";
			response.sendRedirect("Clientes.jsp?cedula="+cedula+"&&nombre="+nombre+"&&email="+correo+"&&direccion="+direccion+"&&telefono="+telefono);
			
		}
	}
}
