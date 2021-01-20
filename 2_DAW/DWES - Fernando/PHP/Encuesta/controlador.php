<?php
include "vista.php";
include "modelo.php";

if (!isset($_REQUEST["opcion"])){
    $datos = getEncuestas();
    displayEncuestas($datos);
}
elseif(isset($_REQUEST["opcion"]) && $_REQUEST["opcion"]=="encuesta"){
    if(isset($_REQUEST["encuesta_id"]) && getPreguntasRespuestas($_REQUEST["encuesta_id"])){
        $datos = getPreguntasRespuestas($_REQUEST["encuesta_id"]);
        displayPreguntasRespuestas($datos);
    }

}

?>