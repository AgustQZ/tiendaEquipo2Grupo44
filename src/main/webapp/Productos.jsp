<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modulo Productos</title>
<link rel="stylesheet" href="css/estilosProductos.css">
</head>
<body>
	<%!String cedula="", nombre="", correo="", user="", pass="", estado="";%>

	<%
	if(request.getParameter("cedula")!=null){
		cedula = request.getParameter("cedula");
		nombre = request.getParameter("nombre");
		correo = request.getParameter("correo");
		pass = request.getParameter("pass");
		user = request.getParameter("user");
		estado= "disabled";
	}
	%>

	<div class="titulo">
		<h1>Gestion de Productos</h1>
	</div>
	<header>
		<nav>
			<ul>
				<li><a href="Usuarios.jsp">Usuarios</a></li>
				<li><a href="Clientes.jsp">Clientes</a></li>
				<li><a href="Proveedores.jsp">Proveedores</a></li>
				<li><a href="Productos.jsp">Productos</a></li>
				<li><a href="Ventas.jsp">Ventas</a></li>
				<li><a href="Reportes.jsp">Reportes</a></li>
			</ul>
		</nav>
	</header>
	
	<div class="contendor-fluid">
		<form action="Productos" method="post" enctype="multipart/form-data">
            <h2>Cargar listado de productos .scv</h2>
            <div class="contenedorIN">
                <div>
                    <input id="examinar" type="file" name="archivo" value="Buscar"">
                    <input type="submit" name="cargar" value="Cargar">
                </div>
            </div>
        </form>
	
	<%
	if(request.getParameter("mensaje")!=null){
		String mensaje = request.getParameter("mensaje");
		out.print("<script>alert('"+mensaje+"');</script>");	
	}
	%>
</body>
</html>