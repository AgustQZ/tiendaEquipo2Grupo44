package Controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;
import Modelo.ProductoDAO;
import Modelo.ProductoDTO;

/**
 * Servlet implementation class Productos
 */
@WebServlet("/Productos")
@MultipartConfig
public class Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Productos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoDAO pdDAO = new ProductoDAO();
		
		if(request.getParameter("cargar")!=null) {
			Part archivo = request.getPart("archivo");
			//String rutaDestino = "C:\\Users\\sanei\\eclipse-workspace\\tiendaEquipo2Grupo44\\src\\main\\webapp\\documentos\\";
			String rutaDestino = "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/";
			try {
				InputStream is = archivo.getInputStream();
				File archivoCopia = new File(rutaDestino+"ProductosPC.csv");
				FileOutputStream fos = new FileOutputStream(archivoCopia);
				int lectura = is.read();
				while(lectura!=-1) {
					fos.write(lectura);
					lectura = is.read();					
				}
				is.close();
				fos.close();
				if(pdDAO.cargarArchivo(rutaDestino+"ProductosPC.csv")) {
					response.sendRedirect("Productos.jsp?mensaje=Se insertaron los productos correctamente");
				}else {
					response.sendRedirect("Productos.jsp?mensaje=Error al insertar los productos en el servlet. ");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al cargar. "+e);
			}
		}
		
		if (request.getParameter("consultar")!=null) {
			String codigo = request.getParameter("codigo");
			ProductoDTO pdDTO = pdDAO.consultarProducto(codigo);
			if(pdDTO!=null) {
				String nombre;
				int precio;
				codigo = pdDTO.getCodigo();
				nombre = pdDTO.getNombre();
				precio = pdDTO.getPrecioVenta();
				response.sendRedirect("Productos.jsp?codigo="+codigo+"&&nombre="+nombre+"&&precio="+precio);
			}else {
				JOptionPane.showMessageDialog(null, "Error al consultar consultar el producto en el servlet. ");
				response.sendRedirect("Productos.jsp");
			}
		}
		
		else if(request.getParameter("actualizar")!=null) {
			String codigo, nombre;
			int precio;
			codigo = request.getParameter("code");
			nombre = request.getParameter("nombre");
			precio = Integer.parseInt(request.getParameter("precio"));
			ProductoDTO pdDTO = new ProductoDTO(codigo, nombre, precio);
			if(pdDAO.actualizarProducto(pdDTO)) {
				response.sendRedirect("Productos.jsp?mensaje=Producto actualizado exitosamente.");
			}else {
				response.sendRedirect("Productos.jsp?mensaje=Error al actualizar el producto.");
			}
		}
		
		else if(request.getParameter("cancelar") != null) {
			response.sendRedirect("Productos.jsp?mensaje=Proceso cancelado");
		}
	}

}



















