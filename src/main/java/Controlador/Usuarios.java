package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;

/**
 * Servlet implementation class Usuarios
 */
@WebServlet("/Usuarios")
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO uDAO = new UsuarioDAO();
		
		if(request.getParameter("crear")!=null) {
			String cedula, nombre, correo, user, pass;
			cedula = request.getParameter("cedula");
			correo = request.getParameter("correo");
			nombre = request.getParameter("nombre");
			pass = request.getParameter("pass");
			user = request.getParameter("user");
			UsuarioDTO uDTO = new UsuarioDTO(cedula, correo,nombre, user, pass);
			if(uDAO.crearUsuario(uDTO)) {
				//JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
				response.sendRedirect("Usuarios.jsp?mensaje=Usuario creado exitosamente");
			}else {
				//JOptionPane.showMessageDialog(null, "No se pudo crear el usuario");
				response.sendRedirect("Usuarios.jsp?mensaje=Error al crear el usuario");
			}
		}
		
		else if(request.getParameter("limpiar") != null) {
			
			String cedula,nombre, correo, user, pass,estado;
			cedula = "";
			correo ="";
			nombre ="";
			user = "";
			pass ="";
			estado = "";
			response.sendRedirect("Usuarios.jsp?cedula="+cedula+"&&correo="+correo+"&&nombre="+nombre+"&&user="+user+"&&pass="+pass);
		}
	}

}
