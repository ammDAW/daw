document.addEventListener("DOMContentLoaded", function(){
	const botonCalcular = document.querySelector("#botonCalcular")
	botonCalcular.addEventListener("click",calcularEdad)
})

function calcularEdad(){
	const dia = document.querySelector("#inputDia").value
	const mes = document.querySelector("#inputMes").value
	const anyo = document.querySelector("#inputAnyo").value
	const salida = document.querySelector("#errores")
	
	const hoy = new Date();
	let edad = hoy.getFullYear() - anyo
	
	//si este año todavía no los he cumplido, restar 1
	if(mes>hoy.getMonth()+1) edad--
	else if(mes==hoy.getMonth()+1 && dia>hoy.getDate()) edad--
	
	salida.textContent = "Tienes "+edad+" años"	
	
	
	/*const salida = document.querySelector("#errores") //por ID
	  const salida = document.querySelector(".cajaTextoNormal") //por CLASS
	  const salida = document.querySelector("H1") //por ETIQUETA HTML
	*/

	//prueba para aprender a seleccionar todos los nodos con la misma etiqueta
	const todosLosImputs = document.querySelectorAll("input")
	console.log("length = "+todosLosImputs.length)
	console.log(`length = ${todosLosImputs.length}`)
}