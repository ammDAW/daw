document.addEventListener("DOMContentLoaded", function(){
	//evento click del button
	const btnAdd = document.querySelector("#btnAdd")
	btnAdd.addEventListener("click", addItemToList)
	
	
	//evento "intro" del input
	//document.querySelector("#inputText").addEventListener("keyup", addItemToList)
	document.querySelector("#inputText").addEventListener("keyup", function(e){
		if(e && e.key==="Enter") addItemToList()
	})
})

function addItemToList(){
	let texto = document.querySelector("#inputText").value //recoge el valor de la caja de texto en una variable
	if(texto.trim().length){  // 0 devuelve false, cualquier otro = true, por eso no hace falta poner length>0
		//1. crear un nuevo elemento html <li>
		let nuevoLI = document.createElement("LI")
		
		//2. insertar el texto dentro del <li>
		nuevoLI.textContent = texto
		
		//3. hacer el <li> creado se añada al árbol DOM como hijo de <ul> 
		const lista = document.querySelector("#todoList")
		lista.appendChild(nuevoLI)
		
		//4. hacer que el <li> sea clicable para quie se elimine
		nuevoLI.addEventListener("click", function(){
			this.remove()
		})
		
		//EXTRA: volver a colocar el foco en al caja de texto y vaciar la caja
		document.querySelector("#inputText").focus()
		document.querySelector("#inputText").value = ""
	}
}


