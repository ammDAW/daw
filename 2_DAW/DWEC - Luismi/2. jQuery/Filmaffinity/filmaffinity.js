(function(){
	console.log("Empieza la ejecución");
	$(document).ready(main);

	//capturar el clic de las sugerencias <p> (delegación de eventos)
	$("#divSugerencias").on("click","p",function(){
		consultarPorID($(this).data("id"),$(this).data("tipo"))
	})

	//capturar el clic de los resultados <li> de cada una de las 3 listas (delegación de eventos)
	$("#divResultados").on("click","li",function(){
		consultarPorID($(this).data("id"),$(this).data("tipo"))
	})

	function main(){
		$("#buscador").keyup(function(ev){
			//comprobar si hay algo escrito para buscar en la BBDD
			let patron = $(this).val().trim()
			let $divSugerencias = $("#divSugerencias").empty()
			if(patron.length){
				//consultar este patrón en la BBDD
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
				})// fin ajax
			} //fin if(patron)
			else{
				$divSugerencias.hide()
			}
		})
	} //fin main

	function consultarPorID(id, tipo){
		$.ajax({
			url: "search.php",
			method: "GET",
			data: {
				id: id,
				t: tipo
			},
			success: function(respuestaXML){
				//procesar el XML y colocar cada tipo de dato en su <div> correspondiente
				let $xml = $(respuestaXML)
				let $resultados = $xml.find("resultado")
				
				//localizar las 3 listas: películas=0, directores=1, actores=2
				let $ulPeliculas = $(".listaResultados").first().empty() //eq(0)
				let $ulDirectores = $(".listaResultados").eq(1).empty()	 //$ulPeliculas.next()
				let $ulActores = $(".listaResultados").last().empty() 	 //eq(2)
				
				$resultados.each(function() {
					let tipo = $(this).find("tipo").html()
					switch(tipo) {
						case "0": //es una película
							$("<li>") //crear el objeto <li>
								.html($(this).find("titulo").html())
								.data("id", $(this).find("id").html())
								.data("tipo", "tit")
								.appendTo($ulPeliculas)
						break;
						case "1": //es un director-directora
							$("<li>")
								.html($(this).find("nombre").html())
								.data("id", $(this).find("id").html())
								.data("tipo", "dir")
								.appendTo($ulDirectores)
						break;
						case "2": //es un actor-actiz
							$("<li>")
								.html($(this).find("nombre").html())
								.data("id", $(this).find("id").html())
								.data("tipo", "act")
								.appendTo($ulActores)
						break;
					} //fin switch	
				});// fin each
			},
			error: function(error){
				alert("Error en la llamada AJAX")
			}
		}) //fin ajax
	} //fin consultarPorID
})();