document.addEventListener("DOMContentLoaded", main)

function main(){
    const form1 = document.querySelector("form")   
    let todoOK = true
    form1.addEventListener("submit", function(e){
        e.preventDefault() //impedir que el formulario se envíe al pulsar Intro o hacer click dentro del form
        let todoOK = true
        if (!campoNombreOK()){
            todoOK=false
            const nombreError = document.querySelector("#conductorError")
            nombreError.textContent = "No ha escrito un nombre válido"
        }
        //if (!campoDniOK()) todoOK=false
        if (!campoEdadOK()){
            todoOK=false
            const edadError = document.querySelector("#edadError")
            edadError.textContent = "No ha escrito una edad correcta"
        }
        if (!campoTipoCarneOK()){
            todoOK=false
            const tipoCarneError = document.querySelector("#tipoCarneError")
            tipoCarneError.textContent = "No ha seleccionado un tipo de carné"
        }
        if (!campoTipoInfraccionOK()){
            todoOK=false
            const tipoInfraccionError = document.querySelector("#tipoInfraccionError")
            tipoInfraccionError.textContent = "No ha seleccionado un tipo de infraccion"
        }
        
        if(todoOK) //si todos los campos están OK entonbces forzamos el envío
            form1.submit()   
    })
}

function campoNombreOK(){
    const nombre = document.querySelector("#conductor").value
    if(nombre.trim().length > 0)
        return true
    else return false
}

function campoDniOK(){
    /*const dni = document.querySelector("#dni").value
    if(dni.trim().length == 9)
        return true
    else return false*/
}

function campoEdadOK(){
    const edad = document.querySelector("#edad").value
    if(isNaN(edad) && edad >= 18)
        return true
    else return false  
}

function campoTipoCarneOK(){
    const radios = document.querySelectorAll("input[name=tc]")
    let tipoCarneOK = false
    radios.forEach(element => {
        if (element.checked) tipoCarneOK=true
    })
    return tipoCarneOK    
}

function campoTipoInfraccionOK(){
    const tipoInfraccion = document.querySelector("#tipo")
    /*if(tipoInfraccion.value.length == 0)
        return false
    else return true*/
    return(tipoInfraccion.value.length ? true : false)
    
}