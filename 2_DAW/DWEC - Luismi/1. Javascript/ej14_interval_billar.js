//variables globales que no entran en el DOM
const alturaTablero = "600px"
const anchuraTablero = "400px"
const medidaBola = "30px"

document.addEventListener("DOMContentLoaded", main)
function main(){
    //tablero
    const tablero = document.querySelector("#tablero")
    tablero.style.width = alturaTablero
    tablero.style.height = anchuraTablero
    
    //bola
    let bola = document.createElement("div")
    bola.classList.add("bola")
    tablero.append(bola)
    bola.style.width = medidaBola
    bola.style.height = medidaBola
    
    //hacer color de la bola sea aleatorio
    let r = Math.floor(Math.random() * 255)
    let g = Math.floor(Math.random() * 255)
    let b = Math.floor(Math.random() * 255)
    let colorAleatorio = `rgb(${r},${g},${b})`
    bola.style.backgroundColor = colorAleatorio
    
    //cambio posicion bola
    let topBola = 0; let leftBola = 0
    function moverBola(){
        bola.style.top = ++topBola + "px"
        bola.style.left = ++leftBola + "px"
        if(topBola > (alturaTablero-medidaBola))
        if(leftBola > (anchuraTablero-medidaBola))
    }
    let intervalBola = setInterval(moverBola, 10)
}