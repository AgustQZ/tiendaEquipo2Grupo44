<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/Reportes.js"></script>
<title>Modulo Reportes</title>
<link rel="stylesheet" href="css/estilosReportes.css">
</head>
<body>
	
	<%! String valorT="";%>
	
	<%
	if(request.getParameter("valorT")!=null){
		valorT = request.getParameter("valorT");
	}
	%>

	<div class="titulo">
		<h1>Gestion de Reportes</h1>
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
		<div class="Botones">
			<button id="listarUsuarios">Listado Usuarios</button>
			<button id="listarClientes">Listado Clientes</button>
			<button id="listarVentas">Listado Ventas por Cliente</button>
		</div>
		<table id="tabla">
		</table>
		<form action="Reportes" method="post" id="total">
			<div class="totalA">
				<label>Total Ventas</label>
				<input type="text" name="totalV" value="<%=valorT%>">
			</div>
		</form>
</body>
</html>