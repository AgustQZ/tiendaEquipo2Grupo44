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

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;
import Modelo.VentaDAO;
import Modelo.VentaDTO;

/**
 * Servlet implementation class Reportes
 */
@WebServlet("/Reportes")
public class Reportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reportes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionjs");
		PrintWriter escribir = response.getWriter();
		Gson datos = new Gson();
		
		if(opcion.equals("Usuarios")) {
			UsuarioDAO uDAO = new UsuarioDAO();
			ArrayList<UsuarioDTO> listaU = new ArrayList<>();
			listaU = uDAO.listarUsuarios();
			escribir.println(datos.toJson(listaU));
		}
		
		if(opcion.equals("Clientes")) {
			ClienteDAO cDAO = new ClienteDAO();
			ArrayList<ClienteDTO> listaC = new ArrayList<>();
			listaC = cDAO.listarClientes();
			escribir.println(datos.toJson(listaC));
		}
		
		if(opcion.equals("Ventas")) {
			VentaDAO vDAO = new VentaDAO();
			ArrayList<VentaDTO> listaV = new ArrayList<>();
			listaV = vDAO.listarVentas();
			escribir.println(datos.toJson(listaV));
		}
	}

}
