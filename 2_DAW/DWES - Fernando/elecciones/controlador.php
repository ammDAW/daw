<?php
include "vista.php";
include "modelo.php";

if (!isset($_REQUEST["opcion"])){
    $mesas = getMesas();
    $votos = getVotos();
    $sindicatos = getSindicatos();
    displayMesas($mesas, $votos, $sindicatos);
}
/*elseif(isset($_REQUEST["opcion"]) && $_REQUEST["opcion"]=="editar"){
    if(isset($_REQUEST["mesa_id"])){
        $datos = getVotosMesa($_REQUEST["encuesta_id"]);
        $sindicatos = getSindicatos();
        displayActualizar($sindicatos, $datos,);
    }

}*/

?>