<?php
function getPreguntasRespuestas($encuesta_id){
    $sql = "SELECT * FROM encuestas, preguntas, respuestas WHERE ?" ;
    $parametros = array($encuesta_id);
    $datos = SQLquery ($sql, $parametros);
    //$datos = array_shift
    return($datos);
}

function putResultado($poll_id, $respuesta_id){
    $sql = "INSERT into Poll($poll_id, $respuesta_id) VALUES(?, ?)";

}

?>