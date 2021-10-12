$(document).ready(function(){
	
	function listarUsuarios(){
		$.ajax({
			type:"post",
			url:"Reportes",
			dataType:"json",
			data:{opcionjs:"Usuarios"},
			success: function(resultado){
				console.log(resultado)
				var tabla=document.getElementById("tabla")
				tabla.innerHTML=''
				tabla.innerHTML+=`<tr class="cssss">
				<th>Cedula</th>
				<th>Nombre</th>
				<th>Correo</th>
				<th>Usuario</th>
				<th>Password</th>
				</tr>`
				for(let fila of resultado){
					tabla.innerHTML+=`<tr>
					<td>${fila.cedula_usuario}</td>
					<td>${fila.nombre_usuario}</td>
					<td>${fila.email_usuario}</td>
					<td>${fila.usuario}</td>
					<td>${fila.password}</td>
					</tr>`
				}
			}
		})
	}
	
	function listarClientes(){
		$.ajax({
			type:"post",
			url:"Reportes",
			dataType:"json",
			data:{opcionjs:"Clientes"},
			success: function(resultado){
				console.log(resultado)
				var tabla=document.getElementById("tabla")
				tabla.innerHTML=''
				tabla.innerHTML+=`<tr class="cssss">
				<th>Cedula</th>
				<th>Nombre</th>
				<th>Correo</th>
				<th>Direccion</th>
				<th>Telefono</th>
				</tr>`
				for(let fila of resultado){
					tabla.innerHTML+=`<tr>
					<td>${fila.cedula_cliente}</td>
					<td>${fila.nombre_cliente}</td>
					<td>${fila.email_cliente}</td>
					<td>${fila.direccion_cliente}</td>
					<td>${fila.telefono_cliente}</td>
					</tr>`
				}
			}
		})
	}
	
	function listarVentas(){
		$.ajax({
			type:"post",
			url:"Reportes",
			dataType:"json",
			data:{opcionjs:"Ventas"},
			success: function(resultado){
				console.log(resultado)
				var tabla=document.getElementById("tabla")
				tabla.innerHTML=''
				tabla.innerHTML+=`<tr class="cssss">
				<th>Codigo Venta</th>
				<th>Cedula Usuario</th>
				<th>Cedula Cliente</th>
				<th>Valor Venta</th>
				<th>Iva Venta</th>
				<th>Total Venta</th>
				</tr>`
				for(let fila of resultado){
					tabla.innerHTML+=`<tr>
					<td>${fila.codVenta}</td>
					<td>${fila.cUsuario}</td>
					<td>${fila.cCliente}</td>
					<td>${fila.valorVenta}</td>
					<td>${fila.ivaVenta}</td>
					<td>${fila.totalVenta}</td>
					</tr>`
				}
			}
		})
	}
	
	$('#listarUsuarios').on('click',function(){
			listarUsuarios();
		})
	
	$('#listarClientes').on('click',function(){
			listarClientes();
		})
	
	$('#listarVentas').on('click',function(){
			listarVentas();
		})
	
})