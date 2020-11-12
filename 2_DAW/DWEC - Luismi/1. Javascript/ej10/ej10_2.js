document.addEventListener("DOMContentLoaded",function(){
	const places = ["Abanilla","Abarán","Águilas","Albudeite","Alcantarilla","Alcázares (Los)","Aledo","Alguazas","Alhama de Murcia","Archena","Beniel","Blanca","Bullas","Calasparra","Campos del Río","Caravaca de la Cruz","Cartagena","Cehegín","Ceutí","Cieza","Fortuna","Fuente Álamo de Murcia","Jumilla","Librilla","Lorca","Lorquí","Mazarrón","Molina de Segura","Moratalla","Mula","Murcia","Ojós","Pliego","Puerto Lumbreras","Ricote","San Javier","San Pedro del Pinatar","Santomera","Torre-Pacheco","Torres de Cotillas (Las)","Totana","Ulea","Unión (La)","Villanueva del Río Segura","Yecla"]
	
	const search2 = document.querySelector("#search2") //caja
	const listaResult2 = document.querySelector("#listaResult2") 
	const placeTable = document.querySelector("#solution2 table.table") //tablla dnd se van a mover los datos
	const form2 = document.querySelector("#solution2 form") //formulario

	search2.focus() //poner foco en la caja

	form2.addEventListener("submit", function(e){
		e.preventDefault()
	})
	
	places.forEach(function(elemento){
		let nuevoOption = document.createElement("OPTION")
		nuevoOption.value = elemento
		listaResult2.appendChild(nuevoOption)
	})
	
	//tecla intro para añadir
	search2.addEventListener("keyup", e => {
		if(e && e.key=="Enter"){
			addItemToTable(search2.value, placeTable)
			search2.value = ""
			search2.focus() 
        }
	})
	
	//boton añadir
	const button = document.querySelector("#solution2 form button.btn-primary")
	button.addEventListener("click", function(){
		addItemToTable(search2.value, placeTable)
		search2.value = ""
		search2.focus()	
	})

	placeTable.addEventListener('click', e => {
	})

	document.querySelector("#btnRemove").addEventListener("click", () =>{
	})

	document.querySelector("#btnUp").addEventListener("click", ()=>{
	})
	
	document.querySelector("#btnDown").addEventListener("click", ()=>{
	})

	document.querySelector("#btnFirst").addEventListener("click", () =>{		
	})

	document.querySelector("#btnLast").addEventListener("click", () =>{
	})
}) //FIN DOMContentLoaded

function addItemToTable(item, table){
	if(item.trim().length){
		//crear un nuevo <tr> e insertarlo como último hijo del <tbody>
		let nuevoTR = document.createElement("tr")
		let nuevoTD1 = document.createElement("td")

		totalFilasActual=table.querySelectorAll("tbody tr").length //all para que coja todos los tr
		nuevoTD1.textContent = totalFilasActual + 1
		
		let nuevoTD2 = document.createElement("td")
		nuevoTD2.textContent = item
		
		let nuevoTD3 = document.createElement("td")
		nuevoTD3.innerHTML = '<div class="row"> \
			<button type="button" class="btn btn-secondary btn-sm">&#8593;</button> \
			<button type="button" class="btn btn-secondary btn-sm">&#8595;</button> \
			<button type="button" class="btn btn-danger btn-sm">X</button> \ </div>'
		nuevoTD3.lastElementChild.addEventListener("click", () =>{
			nuevoTR.remove() //otra forma: this.parentElement.parentElement.remove()
		})
		nuevoTR.append(nuevoTD1, nuevoTD2, nuevoTD3)
		table.querySelector("tbody").append(nuevoTR)		
	}
}