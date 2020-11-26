document.addEventListener("DOMContentLoaded", main)

function main(){
    const form1 = document.querySelector("form")   
    form1.addEventListener("submit", function(e){
        e.preventDefault() //impedir que el formulario se envíe al pulsar Intro o hacer click dentro del form
        const nombreError = document.querySelector("#conductorError")
        const dniError = document.querySelector("#dniError")
        const edadError = document.querySelector("#edadError")
        const tipoCarneError = document.querySelector("#tipoCarneError")
        const tipoInfraccionError = document.querySelector("#tipoCarneError")
        
        let todoOK = true
        if (!campoNombreOK()){
            todoOK=false
            nombreError.textContent = "No ha escrito un nombre válido"
        }

        if (!campoDniOK()){
            todoOK=false
            dniError.textContent = "No ha escrito un DNI válido"
        }

        if (!campoEdadOK()){
            todoOK=false
            edadError.textContent = "No ha escrito una edad correcta"
        }

        if (!campoTipoCarneOK()){
            todoOK=false
            tipoCarneError.textContent = "No ha seleccionado un tipo de carné"
        }

        if (!campoTipoInfraccionOK()){
            todoOK=false
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
    const dni = document.querySelector("#dni").value
    const patronDNI = /^\d{8}-{0,1}[a-zA-Z]$/
    if(patronDNI.test(dni))
        return true
    else return false
}

function campoEdadOK(){
    const edad = document.querySelector("#edad").value
    if (isNaN(edad) || edad < 18) 
        return false
    return true 
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
    return (tipoInfraccion.value.length ? true : false) 
}