$(document).ready(function(){
	//alert("Hola Agus desde una alerta")
	//console.log("Hola Agus desde la consola")
	
	function Sumar(){
		var n1 = parseInt(document.getElementById("n1").value)
		var n2 = parseInt(document.getElementById("n2").value)
		var suma = n1 + n2
		console.log("La suma es: "+suma)	
		var h2=document.getElementById("suma")
		h2.innerHTML = "La suma usando el h2 es: "+suma
	}
	
	$('.suma').on('click', function(){
		Sumar()
	})
	
})