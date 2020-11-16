//Desarrolla aquí la solución al ejercicio 11
document.addEventListener("DOMContentLoaded",function(){
    const tablaContacto = document.querySelector("#tablaContacto")
    const selectNuevoAtrib = document.querySelector("#selectNuevoAtrib")
    
    selectNuevoAtrib.addEventListener('change', () => {
        if (selectNuevoAtrib.value==1 || selectNuevoAtrib.value==2){
            addItemToTable(selectNuevoAtrib, tablaContacto)    
        }
    })

    /*selectNuevoAtrib.addEventListener('change', () => {
        let opcion= ev.target.value
        if (opcion!=0{
            addItemToTable(opcion, tablaContacto)
        }
    })*/

    //Boton borrar por delegacion de eventos
    tablaContacto.addEventListener("click", e =>{
        if(e.target.classList.contains("btnBorrar")){ //se usa el contains por si contiene más de una clase
            e.target.parentElement.parentElement.remove()
        }
    })
})

function addItemToTable(item, table){
    if(item.value.trim().length){
        let nuevoTR = document.createElement("tr")
        let nuevoTD1 = document.createElement("td")
        let nuevoTD2 = document.createElement("td")
        /*let nuevoIMG = docuemnt.createElement("img")
            nuevoIMG.srv = "img/tlfn.png"
        let nuevoINPUT = docuemnt.createElement("input")
            nuevoINPUT.type = "tel"
        let nuevoBUTTON = docuemnt.createElement("button")
            nuevoBUTTON.textContent = "X"*/

        if (selectNuevoAtrib.value==1){
            nuevoTD1.innerHTML = '<img class="small-icon" src="img/tlfn.png">'
            nuevoTD2.innerHTML = '<input type="tel">'
        }
        else{
            nuevoTD1.innerHTML = '<img class="small-icon" src="img/email.png">'
            nuevoTD2.innerHTML = '<input type="email">'
        }
        
        //nuevoTD1.classList.add("small-icon")
        let nuevoTD3 = document.createElement("td")
        nuevoTD3.innerHTML = '<button type="button" class="btnBorrar">X</button>'
        nuevoTR.append(nuevoTD1, nuevoTD2, nuevoTD3)
        table.querySelector("tbody").append(nuevoTR)
    }
}
