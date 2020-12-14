//Esto no lo vamos a poner (no es necesario) porque hemos puesto el atributo DEFER en <script> de .html
//document.addEventListener("DOMContentLoaded", main);

const tablero = document.querySelector("#tablero");
const inputFila = document.querySelector("#inputFila");
const inputColumna = document.querySelector("#inputColumna");

for (let i=0; i<121; i++){
    let nuevaCelda = document.createElement("div");
    nuevaCelda.classList.add("celda");
    tablero.append(nuevaCelda);
    nuevaCelda.dataset.fila = Math.floor(i / 11);
    nuevaCelda.dataset.columna = i%11;
    nuevaCelda.dataset.clicado = false;

    nuevaCelda.addEventListener("mouseover", (ev)=>{
        inputFila.value = ev.target.dataset.fila;
        inputColumna.value = ev.target.dataset.columna;
    })   
}