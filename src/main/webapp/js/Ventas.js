$(document).ready(function(){
	listarLibros();
	
	function listarLibros(){
		$.ajax({
			type: "post",
			url: "Ventas",
			dataType: "Json",
			success: function(resultado){
				console.log(resultado)
			}
		})
	}
	
	
})