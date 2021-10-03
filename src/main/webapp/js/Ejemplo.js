$(document).ready(function(){
	
	alert("Hola Agus")
	console.log("Hola desde la consola");
	
	let n1 = 29
	let n2 = 34
	var suma = n1+n2
	console.log("La suma es: "+suma)
	
	var h2 = document.getElementById("respuesta")
	h2.innerHTML = "La suma por medio del h2 es: "+suma
	//document.write("La suma por medio de la pagina es: "+suma)
});