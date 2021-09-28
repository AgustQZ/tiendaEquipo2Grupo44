package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.ProveedorDAO;
import Modelo.ProveedorDTO;
import Modelo.UsuarioDTO;

/**
 * Servlet implementation class Proveedores
 */
@WebServlet("/Proveedores")
public class Proveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Proveedores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProveedorDAO pDAO = new ProveedorDAO();
		
		if(request.getParameter("crear")!=null) {
			String nit, nombre, direccion, telefono, ciudad;
			nit = request.getParameter("nit");
			nombre = request.getParameter("nombre");
			direccion = request.getParameter("direccion");
			telefono = request.getParameter("telefono");
			ciudad = request.getParameter("ciudad");
			ProveedorDTO pDTO = new ProveedorDTO(nit, nombre, direccion, telefono, ciudad);
			if(pDAO.crearProveedor(pDTO)) {
				response.sendRedirect("Proveedores.jsp?mensaje=Proveedor creado exitosamente");
			}else {
				response.sendRedirect("Proveedores.jsp?mensaje=Error al crear el proveedor(Servlet)");
			}
		}
		
		else if(request.getParameter("consultar")!= null) {
			String nit = request.getParameter("nit");
			ProveedorDTO pDTO = pDAO.consultarProveedor(nit);
			if(pDTO!=null) {
				String nombre, direccion, telefono, ciudad;
				nit = pDTO.getNit();
				nombre = pDTO.getNombre();
				direccion = pDTO.getDireccion();
				telefono = pDTO.getTelefono();
				ciudad = pDTO.getCiudad();
				response.sendRedirect("Proveedores.jsp?nit="+nit+"&&nombre="+nombre+"&&direccion="+direccion+"&&telefono="+telefono+"&&ciudad="+ciudad);
			}else {
				JOptionPane.showMessageDialog(null, "Error al consultar el proveedor(Servlet)");
				response.sendRedirect("Proveedores.jsp");
			}
		}
		
		else if(request.getParameter("actualizar")!=null) {
			String nit, nombre, direccion, telefono, ciudad;
			nit = request.getParameter("id");//NOTA: se utiliza esta variable ya que se deshabilito el input "cedula" del Usuarios.jsp
			nombre = request.getParameter("nombre");
			direccion = request.getParameter("direccion");
			telefono = request.getParameter("telefono");
			ciudad = request.getParameter("ciudad");
			ProveedorDTO pDTO = new ProveedorDTO(nit, nombre, direccion, telefono, ciudad);
			if(pDAO.actualizarProveedor(pDTO)) {
				response.sendRedirect("Proveedores.jsp?mensaje=Proveedor actualizado exitosamente");
			}else {
				response.sendRedirect("Proveedores.jsp?mensaje=Error al actualizar el proveedor(Servlet)");
			}
		}
		
		else if(request.getParameter("eliminar")!=null) {
			String nit = request.getParameter("id");			
			if(pDAO.eliminarProveedor(nit)) {
				response.sendRedirect("Proveedores.jsp?mensaje=Proveedor eliminado exitosamente");
			}else {
				response.sendRedirect("Proveedores.jsp?mensaje=Error al eliminar el proveedor(Servlet)");
			}
		}
		
		else if(request.getParameter("limpiar") != null) {
			String nit,nombre, direccion, telefono, ciudad;
			nit = "";
			nombre ="";
			direccion ="";
			telefono = "";
			ciudad ="";
			response.sendRedirect("Proveedores.jsp?nit="+nit+"&&nombre="+nombre+"&&direccion="+direccion+"&&telefono="+telefono+"&&ciudad="+ciudad);
		}
	}
}
