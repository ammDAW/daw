document.addEventListener("DOMContentLoaded", function(){
	const equipo1 = document.querySelector("#equipo1")
	const equipo2 = document.querySelector("#equipo2")
	//const jugIniciales = document.querySelectorAll("#equipo1 li")
	const jugIniciales = equipo1.querySelectorAll("li")
	
	
	for(let i=0;i<jugIniciales.length;i++){
		jugIniciales[i].addEventListener("click", function(){
			if(this.parentNode.id =="equipo1")
				equipo2.appendChild(this)
				//appendChild agrega lo que hay dentro del parentesis como hijo a equipo2
				//en este caso al poner this está apuntando al li actual
			else 
				equipo1.appendChild(this)
		})
	}
})



