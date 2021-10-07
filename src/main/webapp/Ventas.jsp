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
	<%!String cedula="", cliente="", codigoPd="", estado="";
	int consecutivo=0;
	%>

	<%
	if(request.getParameter("cedula")!=null){
		cedula = request.getParameter("cedula");
		cliente = request.getParameter("cliente");
		consecutivo = Integer.parseInt(request.getParameter("consecutivo"));
		codigoPd = request.getParameter("codigo");
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

    <form action="Ventas" method="post">
        <div class="consultaC">
            <label for="">Cedula</label>
            <input type="text" name="cedulaCliente">
            <button type="submit" name="consultarCliente">Consultar</button>
            <label for="">Cliente</label>
            <input type="text" name="nombreC">
            <label for="">Consecutivo</label>
            <input type="text" name="consecutivoVenta">
        </div>

        <div class="productos">
            <div class="codigos">
                <input type="text" name="codigo1" placeholder="Codigo del Producto">
                <input type="text" name="codigo2" placeholder="Codigo del Producto">
                <input type="text" name="codigo3" placeholder="Codigo del Producto">
            </div>
            <div class="consultarP">
                <button type="submit" name="consultarP">Consultar</button>
                <button type="submit" name="consultarP">Consultar</button>
                <button type="submit" name="consultarP">Consultar</button>
            </div>
            <div class="nombreP">
                <input type="text" name="nombreP1" placeholder="Nombre del Producto">
                <input type="text" name="nombreP2" placeholder="Nombre del Producto">
                <input type="text" name="nombreP3" placeholder="Nombre del Producto">
            </div>
            <div class="cant">
                <input type="text" name="cant1" placeholder="Cant">
                <input type="text" name="cant2" placeholder="Cant">
                <input type="text" name="cant3" placeholder="Cant">
            </div>
            <div class="valorT">
                <input type="text" name="valorT1" placeholder="Valor Total">
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