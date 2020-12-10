//NOMBRE DEL ALUMNO: ALBERTO MARTINEZ MARTINEZ

//RESOLUCIÓN DEL EJERCICIO 2 DEL EXAMEN
(function() {
    //todo tu codigo js aqui
    document.addEventListener("DOMContentLoaded", main)
    let reloj
    let cambioI
    let i
    

    function main(){ 
        agregarFila()        
        const btnEmpezar = document.querySelector("#empezar")
        btnEmpezar.addEventListener("click", function(){
            //clearInterval(reloj)
            i=0

            const col = document.querySelectorAll("td")
            reloj = setInterval(cambiarClase(col), 1000)
        })
    }

    /*function addCeldas(){
        const segundos = document.querySelector("#segundos>tbody")
        let newTR = document.createElement("tr")
        let newTD = document.createElement("td")
        let contador = 1
        while (contador <= 60){
            newTR.append(newTD)
            contador++
        }
        segundos.append(newTR)
    }*/

    function cambiarClase(col){
        col[i].classList.add('coloreado')
        i++
    }

    function agregarFila(){
        const segundos = document.querySelector("#segundos>tbody")
        let contador = 1
        var newRow = segundos.insertRow(0)
        var newCell = newRow.insertCell(0)
        while (contador<=60){
            newRow.insertCell(0)
            contador++
        }
    }

})();





