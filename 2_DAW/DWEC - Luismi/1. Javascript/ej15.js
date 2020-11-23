document.addEventListener("DOMContentLoaded", main)

function main(){
    //asignar a cada uno de los 8 botones el listener para el evento "click"
    let todosLosBotones = document.querySelectorAll(".botonBit")
    todosLosBotones.forEach(element => {
        element.addEventListener("click", ev => {
            if(ev.target.value == 0)
                ev.target.value = 1
            else 
                ev.target.value = 0
            binToDec(todosLosBotones)
        })    
    })
    //alternativa - se podría resolver con 1 solo listener por delegacion de eventos   
}
    
function binToDec(todosLosBotones){ //calcular equivalente en decimal
    let decimal = 0
    todosLosBotones.forEach(element => {
        if(element.value == 1)
            decimal += Math.pow(2, element.id)
    })
    document.querySelector("#decimal").value = decimal
}