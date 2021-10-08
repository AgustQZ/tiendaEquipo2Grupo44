<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modulo Clientes</title>
<link rel="stylesheet" href="css/estilosUsuarios.css">
</head>
<body>
	<%!String cedula="", nombre="", correo="", direccion="", telefono="", estado="";%>

	<%
	if(request.getParameter("cedula")!=null){
		cedula = request.getParameter("cedula");
		nombre = request.getParameter("nombre");
		correo = request.getParameter("correo");
		direccion = request.getParameter("direccion");
		telefono = request.getParameter("telefono");
		estado= "disabled";
	}
	%>
	
	<%
	if(request.getParameter("mensaje")!=null){
		String mensaje = request.getParameter("mensaje");
		out.print("<script>alert('"+mensaje+"');</script>");
		cedula = "";
		nombre = "";
		correo = "";
		direccion = "";
		telefono = "";
		estado = "";
	}
	%>

	<div class="titulo">
        <h1>Gestion de Clientes</h1>
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
        <form action="Clientes" method="post">
            <div class="contenedorIN">
                <div>
					<label>Cedula</label>
					<label>Nombre Completo</label>
					<label>Correo Electronico</label>
				</div>
				<div>
					<input type="text" name="cedula" value="<%=cedula%>" <%=estado%>>
					<input type="hidden" name="id" value="<%=cedula%>"> 
					<input type="text" name="nombre" value="<%=nombre%>">
					<input type="email" name="correo" value="<%=correo%>">
				</div>
                <div>
					<label>Direccion</label>
					<label>Telefono</label>
				</div>
				<div>
					<input type="text" name="direccion" value="<%=direccion%>">
					<input type="text" name="telefono" value="<%=telefono%>">
				</div>
            </div>
            <div class="contenedorBotones">
                <input type="submit" name="crear" value="Crear">
                <input type="submit" name="consultar" value="Consultar">
                <input type="submit" name="actualizar" value="Actualizar">
                <input type="submit" name="eliminar" value="Eliminar">
                <input type="submit" name="limpiar" value="Limpiar">
            </div>
        </form>
    </div>
	
</body>
</html>