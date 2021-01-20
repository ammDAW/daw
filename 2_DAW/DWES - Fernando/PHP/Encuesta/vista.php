<?php

function displayEncuestas($datos){
    foreach($datos as $item){
        printf("<a href='controlador.php?opcion=encuesta&encuesta_id=%s'>%s</a><br>", $item['ENCUESTA_ID'], $item['ENCUESTA']);    
    }
}

/*function displayPreguntas($datos){
    foreach($datos as $item){
        echo $item["pregunta"]   
    }    
}

function displayRespuestas($datos){
    foreach($datos as $item){
        echo $item["respuesta"]   
    } 
}

function displayResultados($datos){
    foreach($datos as $item){
        echo $item["respuesta"]   
    } 
}
*/

?>