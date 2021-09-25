<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modulo Ventas</title>
<link rel="stylesheet" href="css/estilosUsuarios.css">
</head>
<body>
	<%!String cedula=""; String nombre="", correo="", user="", pass="", estado="";%>

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
		<h1>Gestion de Ventas</h1>
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
</body>
</html>