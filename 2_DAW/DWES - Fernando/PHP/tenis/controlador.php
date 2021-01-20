<?php
include "vista.php";
include "modelo.php";

if (!isset($_REQUEST["opcion"])){
    $torneos = getTorneos();
    displayTorneos($torneos);
}
elseif(isset($_REQUEST["opcion"]) && $_REQUEST["opcion"]=="ver"){
        //$datos = getPartidosTorneo($_REQUEST["id_torneo"]);
        //displayResultados($datos);
        $cuartos = getCuartos($_REQUEST["id_torneo"]);
        $semis = getSemifinal($_REQUEST["id_torneo"]);
        $final = getFinal($_REQUEST["id_torneo"]);
        displayResultados($cuartos, $semis, $final);  
}

?>