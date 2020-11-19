document.addEventListener("DOMContentLoaded", main)
let reloj
let alarma
const msIniciales = 1000 //milisegundos inciales de la bola
let clicSobreBola

function main(){
    const tablero = document.querySelector("#tablero")
    const bola = document.querySelector("#bola")
    const btnEmpezar = document.querySelector("#btnEmpezar")

    //dar tamaño al tablero y a la bola
    tablero.style.width = "600px"
    tablero.style.height = "400px"
    bola.style.width = "30px"
    bola.style.height = "30px"
    
    btnEmpezar.addEventListener("click", () => { //evento click para empezar partida e inicializar marcadores
        //anulamos la partida anterior si la hay
        clearInterval(reloj)
        clearInterval(alarma)
        bola.removeEventListener("click", clicSobreBola)
        
        //incializar marcador [puntos, velocidad, tiempo]
        const puntos = document.querySelector("#puntos")
        puntos.textContent = 0
        const velocidad = document.querySelector("#velocidad") //
        velocidad.textContent = msIniciales
        const tiempo = document.querySelector("#tiempo")
        tiempo.textContent = 10

        //intervalo para controlar el tiempo real (los segundos que van pasando)
        reloj = setInterval(actualizaTiempo, 1000)
        //intervalo que actualiza la bola  cada X milisegundos
        alarma = setInterval(cambiaPosicionBola, msIniciales)
        bola.addEventListener("click", clicSobreBola) //evento click en bola par sumar puntos
    })
    
    clicSobreBola = function(){
        //aumentar puntuacion
        puntos.textContent = Number(puntos.textContent) + 1;

        //que la posición se refresque inmediatamente (para evitar que se hagan múltiples clicks sobre la misma posición)
        cambiaPosicionBola()

        //aumentar la velocidad a la que cambia la bola al darle click
        clearInterval(alarma)
        alarma = setInterval(cambiaPosicionBola, msIniciales - 25 * puntos.textContent)
        velocidad.textContent = msIniciales - 25 * puntos.textContent
    }   
}

function cambiaPosicionBola(){
    let nuevoTop = Math.floor(Math.random()*370)
    bola.style.top = nuevoTop + "px"
    let nuevoLeft = Math.floor(Math.random()*570)
    bola.style.left = nuevoLeft + "px"
}

function actualizaTiempo(){
    //mostar que el tiempo restante ha bajado un segundo
    tiempo.textContent = tiempo.textContent - 1

    //si el tiempo se ha agotado, para el juego (para el tiempo y el click)
    if (tiempo.textContent == 0){
        clearInterval(reloj)
        clearInterval(alarma)
        bola.removeEventListener("click", clicSobreBola)
    }
}