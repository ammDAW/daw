//windows.onload=function(){}
document.addEventListener("DOMContentLoaded", function(){
	//CAMINO 1 hacia la funcion "comprobarNumero"
	const textNumero = document.querySelector("#textNumero")
	textNumero.addEventListener("keyup",comprobarNumero)
	
	//CAMINO 2 hacia la funcion "comprobarNumero"
	const botonNumero = document.querySelector("#botonNumero")
	botonNumero.addEventListener("click",comprobarNumero)
})

/*function teclaLevantada(){
	console.log("keyup: " + textNumero.value)}*/

function comprobarNumero(e){ //e es un objeto evento

	/*PARA MOSTRAR EN LA WEB QUE TECLA SE HA PULSADO:
	document.querySelector("#which").textContent = e.which
	document.querySelector("#keyCode").textContent = e.keyCode
	document.querySelector("#key").textContent = e.key*/
	//recupero el label            //acceso al contenido  //lo cambio por el valor a mostrar
	
	/* e.which / e.keycode / e.key para consultar la tecla pulsada (Intro==13)
	if (e.which==13){}
	if(e.keycode==13){}*/
	
	if((e.key && e.key=="Enter") || e.type=="click"){
		//acciones que quieras ejecutar tras el intro
		if(textNumero.value.trim()!=""
			&& !isNaN(textNumero.value.trim())) alert("LOGRO! Has escrito un numero")
		else alert("ERROR! No has introducido un número")
	}
}


