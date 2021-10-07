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
	<%!String codigo="", nombre="", estado="";
	int precio=0;
	%>

	<%
	if(request.getParameter("codigo")!=null){
		codigo = request.getParameter("codigo");
		nombre = request.getParameter("nombre");
		precio = Integer.parseInt(request.getParameter("precio"));
		estado = "disabled";
	}
	%>

	<%
	if(request.getParameter("mensaje")!=null){
		String mensaje = request.getParameter("mensaje");
		out.print("<script>alert('"+mensaje+"');</script>");
		codigo="";
		nombre="";
		precio=0;
		estado="";
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
            <h2>Cargar listado de productos</h2>
            <div class="contenedorIN">
                <div>
                    <input id="examinar" type="file" name="archivo" value="Buscar" ">
                    <button type="submit " name="cargar ">Cargar</button>
                </div>
            </div>
		</form>
		<form action="Productos" method="post">
            <div class="Down ">
            	<h2>Actualizar Productos</h2>
            	<div class="contenedorDown ">
            		<div>
            			<label>Codigo</label>
            			<input type="text" name="codigo" value="<%=codigo%>" <%=estado%>>
            			<input type="hidden" name="code" value="<%=codigo%>">
            			<button type="submit" name="consultar"">Consultar</button>
            		</div>
            		<div>
            			<label>Nombre</label> <input type="text" name="nombre" value="<%=nombre%>">
            		</div>
            		<div>
            			<label>Precio</label> <input type="number" name="precio" value="<%=precio%>">
            		</div>
            	</div>
                <div  class="botones ">
                    <div>
                        <button type="submit" name="actualizar"">Actualizar</button>
                    </div>
                    <div>
                    	<button type="submit" name="cancelar"">Cancelar</button>
                    </div>
                </div>
            </div>
        </form>

</body>
</html>