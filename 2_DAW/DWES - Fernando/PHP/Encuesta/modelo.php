<?php
include "Database.php";
include "db.php";

function getEncuestas(){
    $sql = "SELECT * FROM poll_encuestas";
    $datos = SQLquery ($sql);
    return($datos);
}

function getPreguntas($encuesta_id){
    $sql = "SELECT * FROM preguntas";
    $parametros = array($encuesta_id);
    $datos = SQLquery ($sql, $parametros);
}

/*
function getPolls(){
    $sql = "SELECT * FROM poll_polls";
    $rows = SQLquery ($sql, $parametros);
}

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
*/
?>