//asegurarnos de que nuestro código empieza a ejecutrase
//cuando el árbol DOM ya está construido

$(document).ready(main)

function main(){
    idUltimoMensajeRecibido = 0
    //$("#enviar") recupera el botón. Es lo mismo que document.querySelector("#enviar")
    $("#texto").keyup(function(ev){
        if (ev.key === "Enter"){
            //comprobar que el nick es válido
            //comprobar que el tecto es válido
            $.ajax({
                url: "chat_insert_post.php",
                method: "POST",
                data: {
                    nick: $("#nick").val(),
                    texto: $("#texto").val() //value del objeto
                },
                success: function(respuesta){
                    console.log("La inserción se ha hecho bien")
                },
                error: function(error){
                    console.log("Error en la inserción: "+error)
                }
            })
        }
    })
    //cargar el histórico de mensajes
    cargarMensajes(0)

    //programar consultas periódicas al servidor para ver si hay mensajes nuevos
    setInterval(function(){
                cargarMensajes(idUltimoMensajeRecibido)
                }, 2000)
}

function cargarMensajes(inicio){
    $.ajax({
        url: "chat_select_get_json.php",
        method: "GET", //esta línea se podría quitar porque GET es el método por defecto
        data: {
            ultimo: inicio
        },
        success: function(json){
            //cada elemento del json tiene que insertarse en el <div> del chat
            let $json = jQuery.parseJSON(json) //en JavaScript sería JSON.parse(json)
            for(let i=0; i<$json.length; i++){
                let $chat = $("#chat") 
                let $nuevoMensaje = $("<div>").html($json[i].instante + " >> " + $json[i].nick + ":  " + $json[i].texto)
                $chat.append($nuevoMensaje)
                idUltimoMensajeRecibido = $json[i].id
            }    
        },
        error: function(error){
            console.log("Error en la consulta: "+error)
        }
    })
}