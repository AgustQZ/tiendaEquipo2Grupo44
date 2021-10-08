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
	<%!String 	cedulaCliente="", nombreCliente="", codigo1="", codigo2="", codigo3="",
				nombrePd1="", nombrePd2="", nombrePd3="",		
				estado="";
		int 	cant1, cant2, cant3,
				precioPd1, precioPd2, precioPd3,
				ivaPd1, ivaPd2, ivaPd3, totalIva,
		    	valorT1, valorT2, valorT3, totalVenta, totalPagar;
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
		ivaPd1 = Integer.parseInt(request.getParameter("ivaPd1"));
	}
	%>
	
	<%
	if(request.getParameter("codigo2")!=null){
		codigo2 = request.getParameter("codigo2");
		nombrePd2 = request.getParameter("nombrePd2");
		precioPd2 = Integer.parseInt(request.getParameter("precioPd2"));
	}
	%>
	
	<%
	if(request.getParameter("codigo3")!=null){
		codigo3 = request.getParameter("codigo3");
		nombrePd3 = request.getParameter("nombrePd3");
		precioPd3 = Integer.parseInt(request.getParameter("precioPd3"));
	}
	%>
	
	<%
	if(request.getParameter("totalVenta")!=null){
		cant1 = Integer.parseInt(request.getParameter("cant1"));
		valorT1 = Integer.parseInt(request.getParameter("valorT1"));
		cant2 = Integer.parseInt(request.getParameter("cant2"));
		valorT2 = Integer.parseInt(request.getParameter("valorT2"));
		cant3 = Integer.parseInt(request.getParameter("cant3"));
		valorT3 = Integer.parseInt(request.getParameter("valorT3"));
		totalVenta = Integer.parseInt(request.getParameter("totalVenta"));
		totalIva = Integer.parseInt(request.getParameter("totalIva"));
		totalPagar = Integer.parseInt(request.getParameter("totalPagar"));
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
                <input type="text" name="cant1" value="<%=cant1%>">
                <input type="text" name="cant2" value="<%=cant2%>">
                <input type="text" name="cant3" value="<%=cant3%>">
            </div>
            <div class="valorT">
                <input type="text" name="valorT1" value="<%=valorT1%>">
                <input type="hidden" name="precio1" value="<%=precioPd1%>">
                <input type="hidden" name="iva1" value="<%=ivaPd1%>">
                <input type="text" name="valorT2" value="<%=valorT2%>">
                <input type="hidden" name="precio2" value="<%=precioPd2%>">
                <input type="hidden" name="iva2" value="<%=ivaPd2%>">
                <input type="text" name="valorT3" value="<%=valorT3%>">
                <input type="hidden" name="precio3" value="<%=precioPd3%>">
                <input type="hidden" name="iva3" value="<%=ivaPd3%>">
            </div>
        </div>
        <div class="totalesPadre">
            <div class="totales">
                <div class="confirmar">
                    <button type="submit" name="confirmar">Confirmar</button>
                </div>
                <div class="totalesLabels">
                    <label for="">Total Venta =</label>
                    <label for="">Total IVA =</label>
                    <label for="">Total a Pagar =</label>
                </div>
                <div class="totalesInputs">
                    <input type="text" name="totalVenta" value="<%=totalVenta%>">
                    <input type="text" name="totalIVA" value="<%=totalIva%>">
                    <input type="text" name="totalPagar" value="<%=totalPagar%>">
                </div>
            </div>
        </div>
    </form>
</body>
</html>