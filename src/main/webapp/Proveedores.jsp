<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Modulo Proveedores</title>
	<link rel="stylesheet" href="css/estilosUsuarios.css">
</head>
<body>
	<%!String nit="", nombre="", direccion="", telefono="", ciudad="", estado="";%>

	<%
	if(request.getParameter("nit")!=null){
		nit = request.getParameter("nit");
		nombre = request.getParameter("nombre");
		direccion = request.getParameter("direccion");
		telefono = request.getParameter("telefono");
		ciudad = request.getParameter("ciudad");
		estado= "disabled";
	}
	%>

	<div class="titulo">
		<h1>Gestion de Proveedores</h1>
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
		<form action="Proveedores" method="post">
			<div class="contenedorIN">
				<div>
					<label>NIT</label>
					<label>Nombre</label>
					<label>Direccion</label>
				</div>
				<div>
					<input type="text" name="nit" value="<%=nit%>" <%=estado%>>
					<input type="hidden" name="id" value="<%=nit%>"> 
					<input type="text" name="nombre" value="<%=nombre%>">
					<input type="text" name="direccion" value="<%=direccion%>">
				</div>
				<div>
					<label>Telefono</label>
					<label>Ciudad</label>
				</div>
				<div>
					<input type="text" name="telefono" value="<%=telefono%>">
					<input type="text" name="ciudad" value="<%=ciudad%>">
				</div>
			</div>
			<div class="contenedorBotones">
				<input type="submit" name="crear" value="Crear"> 
				<input type="submit" name="consultar" value="Consultar"> 
				<input type="submit" name="actualizar" value="Actualizar"> 
				<input	type="submit" name="eliminar" value="Eliminar">
				<input type="submit" name="limpiar" value="Limpiar">
			</div>
		</form>
	</div>
	<%
	if(request.getParameter("mensaje")!=null){
		String mensaje = request.getParameter("mensaje");
		out.print("<script>alert('"+mensaje+"');</script>");	
	}
	%>
</body>
</html>