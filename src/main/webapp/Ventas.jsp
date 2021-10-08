<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modulo Ventas</title>
<link rel="stylesheet" href="css/estilosVentas.css">
</head>
<body>
	<%!String cedulaCliente="", nombreCliente="", codigo1="", codigo2="", codigo3="",
		nombrePd1="", nombrePd2="", nombrePd3="",		
		estado="";
		int consecutivo=0, precioPd1=0, valorTotal1=0;
	%>

	<%
	if(request.getParameter("cedulaCliente")!=null){
		cedulaCliente = request.getParameter("cedulaCliente");
		nombreCliente = request.getParameter("nombreCliente");
		estado= "disabled";
	}
	%>
	
	<%
	if(request.getParameter("codigo1")!=null){
		codigo1 = request.getParameter("codigo1");
		nombrePd1 = request.getParameter("nombrePd1");
		precioPd1 = Integer.parseInt(request.getParameter("precioPd1"));
		valorTotal1 = Integer.parseInt(request.getParameter("valorTotal1"));
	}
	%>
	
	<%
	if(request.getParameter("codigo2")!=null){
		codigo2 = request.getParameter("codigo2");
		nombrePd2 = request.getParameter("nombrePd2");
	}
	%>
	
	<%
	if(request.getParameter("codigo3")!=null){
		codigo3 = request.getParameter("codigo3");
		nombrePd3 = request.getParameter("nombrePd3");
	}
	%>
	
	<%
	if(request.getParameter("mensaje")!=null){
		String mensaje = request.getParameter("mensaje");
		out.print("<script>alert('"+mensaje+"');</script>");
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

    <form action="Ventas" method="post">
        <div class="consultaC">
            <label for="">Cedula</label>
            <input type="text" name="cedulaCliente" value="<%=cedulaCliente%>" <%=estado%>>
            <button type="submit" name="consultarCliente">Consultar</button>
            <label for="">Cliente</label>
            <input type="text" name="nombreCliente" value="<%=nombreCliente%>" <%=estado%>>
            <label for="">Consecutivo</label>
            <input type="text" name="consecutivoVenta">
        </div>

        <div class="productos">
            <div class="codigos">
                <input type="text" name="codigo1" value="<%=codigo1%>" placeholder="Codigo del Producto 1">
                <input type="text" name="codigo2" value="<%=codigo2%>" placeholder="Codigo del Producto 2">
                <input type="text" name="codigo3" value="<%=codigo3%>" placeholder="Codigo del Producto 3">
            </div>
            <div class="consultarP">
                <button type="submit" name="consultarPd1">Consultar</button>
                <button type="submit" name="consultarPd2">Consultar</button>
                <button type="submit" name="consultarPd3">Consultar</button>
            </div>
            <div class="nombreP">
                <input type="text" name="nombrePd1" value="<%=nombrePd1%>" placeholder="Nombre del Producto 1">
                <input type="text" name="nombrePd2" value="<%=nombrePd2%>" placeholder="Nombre del Producto 2">
                <input type="text" name="nombrePd3" value="<%=nombrePd3%>" placeholder="Nombre del Producto 3">
            </div>
            <div class="cant">
                <input type="text" name="cant1" placeholder="Cant">
                <button type="submit" name="agregarPd1">Añadir P1</button>
                <input type="text" name="cant2" placeholder="Cant">
                <input type="text" name="cant3" placeholder="Cant">
            </div>
            <div class="valorT">
                <input type="text" name="valorT1" value="<%=valorTotal1%>" placeholder="Valor Total">
                <input type="hidden" name="vt1" value="<%=precioPd1%>">
                <input type="text" name="valorT2" placeholder="Valor Total">
                <input type="text" name="valorT3" placeholder="Valor Total">
            </div>
        </div>
        <div class="totalesPadre">
            <div class="totales">
                <div class="confirmar">
                    <button type="submit" name="confirmar">Confirmar</button>
                </div>
                <div class="totalesLabels">
                    <label for="">Total Venta $</label>
                    <label for="">Total IVA $</label>
                    <label for="">Total a Pagar $</label>
                </div>
                <div class="totalesInputs">
                    <input type="text" name="totalVenta">
                    <input type="text" name="totalIVA">
                    <input type="text" name="totalPagar" ">
                </div>
            </div>
        </div>
    </form>
</body>
</html>