//NOMBRE DEL ALUMNO: ALBERTO MARTINEZ MARTINEZ

//RESOLUCIÓN DEL EXAMEN
(function() {
    //todo tu codigo js aqui
    document.addEventListener("DOMContentLoaded", main)

    function main(){
        const formulario = document.querySelector("#formMovimientos")
        formulario.action = "formOK.html"
        formulario.addEventListener("submit", function(ev){
            ev.preventDefault()
            if(checkTodo())
                this.submit()
        })
        
        formulario.addEventListener("reset", function(){
            this.reset()
        })

        const anyadir = document.querySelector("#anyadir")
        anyadir.addEventListener("click", function(){
            if(checkTodo())
                addTabla()
        })
        
         
    }


    function checkTodo(){       
        document.querySelector("#conceptoError").textContent = ""
        document.querySelector("#cantidadError").textContent = ""
        document.querySelector("#tipoError").textContent = ""
        
        let todoOK = true
        if (!checkConcepto()){
            todoOK=false
            const conceptoError = document.querySelector("#conceptoError")
            conceptoError.textContent = "Concepto erroneo"
        }

        if (!checkCantidad()){
            todoOK=false
            const cantidadError = document.querySelector("#cantidadError")
            cantidadError.textContent = "Cantidad erronea"
        }

        if (!checkTipo()){
            todoOK=false
            const tipooError = document.querySelector("#tipoError")
            tipoError.textContent = "Tipo no seleccionado"
        }
        return todoOK
    }

    function checkConcepto(){
        const concepto = document.querySelector("#concepto")
        if(concepto.value.length >= 4 && concepto.value.length <= 30)
            return true
    }

    function checkCantidad(){
        const cantidad = document.querySelector("#cantidad")
        let cant = cantidad.value.trim()
        const expReg = /[0-9]{1,2}[,][0-9]{2}$/
        return expReg.test(cant)         
    }

    function checkTipo(){
        const tipo = document.querySelector("#tipo")
        return (tipo.value.length ? true : false) 
    }

    function addTabla(){
        const concepto = document.querySelector("#concepto")
        let conc = concepto.value
        const cantidad = document.querySelector("#cantidad")
        let cant = cantidad.value
        const tipo = document.querySelector("#tipo")
        const tablaMovs = document.querySelector("#tablaMovs>tbody")
        

        let newTR = document.createElement("tr")
        let newTDConcepto = document.createElement("td")
        newTDConcepto.textContent = conc
        
        let newTDCantidad = document.createElement("td")
        newTDCantidad.textContent = cant
    
        let newTDTipo = document.createElement("td")
        if (tipo.value == "p")
            newTDTipo.textContent = "Pago"
        else
            newTDTipo.textContent = "Ingreso"
    
        let nuevoBoton = document.createElement("button")
        nuevoBoton.textContent = "X"

        newTR.append(newTDConcepto, newTDCantidad, newTDTipo, nuevoBoton)
        tablaMovs.append(newTR)
    }

})();





