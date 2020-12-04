<?php
function getPreguntasRespuestas($encuesta_id){
    $sql = "SELECT * FROM encuestas, preguntas, respuestas WHERE ?" ;
    $parametros = array($encuesta_id);
    $datos = SQLquery ($sql, $parametros);
    //$datos = array_shift($datos); //quita el primer valor del array
    //return ($datos["ENCUESTA"];
    //return ($datos[0]);
    return($datos);
}

function putResultado($poll_id, $respuesta_id){
    $sql = "INSERT INTO Poll($poll_id, $respuesta_id) VALUES(?, ?)";

}

?>