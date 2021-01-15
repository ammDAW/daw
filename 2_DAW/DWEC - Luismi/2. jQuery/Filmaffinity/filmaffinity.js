(function(){
	console.log("Empieza la ejecución");
	$(document).ready(main);
	
	//capturar el clic de las sugerencias (delegación de eventos)
	$("#divSugerencias").on("click","p",function(){
		$(this).toggleClass("selected")
		$.ajax({
			url: "search.php",
			method: "GET",
			data: {
				id: $(this).data("id"),
				t: $(this).data("tipo")
			},
			success: function(xml){
				//procesar el xml y colocar cada tipo de dato en su <div> correspondiente
				let xml = $(respuestaXML)
				$xml.find()
			},
			error: function(error){
				alert("Error en la llamada AJAX")
			}
		})
	})

	function main(){
		$("#buscador").keyup(function(ev){
			//comprobar si hay algo escrito para buscar en la BBDD
			let patron = $(this).val().trim()
			let $divSugerencias = $("#divSugerencias").empty()
			if(patron.length){
				//consultar este praton en la BBDD
				$.ajax({
					url: "search.php",
					method: "GET",
					data: {
						p: patron
					},
					success: function(json){
						//crear los <p> e integrarlos
						let $json = jQuery.parseJSON(json)
						for(let i=0; i<$json.length; i++){
							let texto = $json[i].texto
                        	let $nuevoP = $("<p>")
								.html(texto) // .html() es para añadir contenido al <p>
								.data("id", $json[i].id)
								.data("tipo", $json[i].tipo)
								.appendTo($divSugerencias)
						}
						if ($json.length)
							$divSugerencias.show()
						else
							$divSugerencias.hide() 
					},
					error: function(error){
						alert("Error en la llamada AJAX")
					}
				})
			}
			else{
				$divSugerencias.hide()
			}
		})
	}
})();