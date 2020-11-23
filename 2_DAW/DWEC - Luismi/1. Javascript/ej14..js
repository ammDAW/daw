//variables globales que no entran en el DOM
const anchuraTablero = 600
const alturaTablero = 400
const medidaBola = 30

document.addEventListener("DOMContentLoaded", main)
function main(){
    //tablero
    const tablero = document.querySelector("#tablero")
    tablero.style.width = anchuraTablero + "px"
    tablero.style.height = alturaTablero + "px"
    
    //bola
    let bola = document.createElement("div")
    bola.classList.add("bola")
    bola.style.width = medidaBola + "px"
    bola.style.height = medidaBola + "px"
    tablero.append(bola)
    
    //hacer color de la bola sea aleatorio
    function cambioColorBola(){
        let r = Math.floor(Math.random() * 255)
        let g = Math.floor(Math.random() * 255)
        let b = Math.floor(Math.random() * 255)
        let colorAleatorio = `rgb(${r},${g},${b})`
        bola.style.backgroundColor = colorAleatorio    
    }
    
    //definir el movimiento de la bola
    let topBola = Math.floor(Math.random() * (alturaTablero - medidaBola))
    let leftBola = Math.floor(Math.random() * (anchuraTablero - medidaBola))
    let velLeftBola = 1
    let velTopBola = 1
    bola.style.top = topBola + "px"
    bola.style.left = leftBola + "px"
    
    function moverBola(){ //ambio posicion bola
        topBola = topBola + velTopBola 
        bola.style.top = topBola + "px"
        leftBola = leftBola + velLeftBola
        bola.style.left = leftBola + "px"

        if(topBola >= (alturaTablero-medidaBola) || topBola <= 0)
            velTopBola *= -1
        if(leftBola >= (anchuraTablero-medidaBola) || leftBola <= 0)
            velLeftBola *= -1
    }
    
    let intervalBola = setInterval(moverBola, 10)
    let intervalColor = setInterval(cambioColorBola, 800)
}