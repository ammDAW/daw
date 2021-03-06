document.addEventListener("DOMContentLoaded",function(){
	const places = ["Abanilla","Abarán","Águilas","Albudeite","Alcantarilla","Alcázares (Los)","Aledo","Alguazas","Alhama de Murcia","Archena","Beniel","Blanca","Bullas","Calasparra","Campos del Río","Caravaca de la Cruz","Cartagena","Cehegín","Ceutí","Cieza","Fortuna","Fuente Álamo de Murcia","Jumilla","Librilla","Lorca","Lorquí","Mazarrón","Molina de Segura","Moratalla","Mula","Murcia","Ojós","Pliego","Puerto Lumbreras","Ricote","San Javier","San Pedro del Pinatar","Santomera","Torre-Pacheco","Torres de Cotillas (Las)","Totana","Ulea","Unión (La)","Villanueva del Río Segura","Yecla"]
	
	const search1 = document.querySelector("#search1") //caja
	const listaResult1 = document.querySelector("#listaResult1") 
	const placeList = document.querySelector("#placeList") //lista dnd se van a mover los datos
	const form1 = document.querySelector("#solution1 form") //formulario

	search1.focus() //poner foco en la caja

	//impedir que el formulario se envíe al pulsar la tecla intro o clickar en el boton "submit" dentro del "form"
	form1.addEventListener("submit", function(e){
		e.preventDefault()
	})
	
	places.forEach(function(elemento){
		let nuevoOption = document.createElement("OPTION")
		nuevoOption.value = elemento
		listaResult1.appendChild(nuevoOption)
	})

	search1.addEventListener("keyup", e => {
		if(e && e.key=="Enter"){
			addItemToList(search1.value, placeList) //si ponemos la primera opcion tendriamos que quitar el .value
			search1.value = "" //vaciar caja
			search1.focus() //poner foco de nuevo
        }
	})

	/*recuperar el boton ADD que corresponde al input que acabo de programar
	recordatorio: no tiene id, por lo tanto recuperar por parentesco/consanguinidad*/
	//const button = search1.parentElement.nextElementSibling //alternativa
	const button = document.querySelector("#solution1 form button.btn-primary")
	button.addEventListener("click", function(){
		addItemToList(search1.value, placeList)
		search1.value = ""
		search1.focus()	
	})

	//Delegacion de Eventos
	placeList.addEventListener('click', e => {
		//1. quitar la clase active a algún posible <li> que la tenga
		let activo = this.querySelector("li.active")
		if(activo) activo.classList.remove("active")
		//2.dar la clase active
		e.target.classList.add("active")
	})

	document.querySelector("#btnRemove").addEventListener("click", () =>{ //()=> sustituye a function()
		let activo = placeList.querySelector("li.active")
		if(activo) activo.remove()	
	})

	document.querySelector("#btnUp").addEventListener("click", ()=>{
		let activo = placeList.querySelector("li.active")
		if(activo && activo.previousElementSibling){
			//mover-colocar el elemento activo como hermano anterior a su actual anterior
			placeList.insertBefore(activo, activo.previousElementSibling)
		}
	})
	
	document.querySelector("#btnDown").addEventListener("click", ()=>{
		let activo = placeList.querySelector("li.active")
		if(activo && activo.nextElementSibling) placeList.insertBefore(activo.nextElementSibling, activo)
	})

	document.querySelector("#btnFirst").addEventListener("click", () =>{
		let activo = placeList.querySelector("li.active")
		if(activo){
			placeList.prepend(activo) //otra forma de hacerlo: placeList.insertBefore(activo, placeList.firstChild) 
		} 
			
	})

	document.querySelector("#btnLast").addEventListener("click", () =>{
		let activo = placeList.querySelector("li.active")
		if(activo) placeList.append(activo)
	})
})

//así le pasamos toda la caja
/*function addItemToList(input, list){
	if(item.value.trim().length){
		let nuevoLi = document.createElement("li")
		nuevoLi.textContent = item.value.trim() //darle contenido a la variable que es sería un <li>
		list.appendChild(nuevoLi)
	}
}*/

//así le pasamos sólo el valor de la caja	
function addItemToList(item, list){
	if(item.trim().length){
		let nuevoLi = document.createElement("li")
		nuevoLi.textContent = item.trim() //darle contenido a la variable que es sería un <li>
		nuevoLi.classList.add("list-group-item")
		list.appendChild(nuevoLi)
	}
}