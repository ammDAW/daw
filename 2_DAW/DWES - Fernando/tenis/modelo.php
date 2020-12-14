<?php
include "Database.php";
include "db.php";

//obtener torneos
function getTorneos() {
    $sentencia = "SELECT * FROM tenis_torneo";
	$resultado  = $GLOBALS['DB']->prepare($sentencia);
	$resultado->execute();

	// Recupera todas las filas en un array
	$torneo = $resultado->fetchAll();
    //print_r( $mesas);
    //DEVUELVE UN ARRAY!
	return($torneo);
}

//obtener todos los partidos
function getPartidos(){
    $sentencia = "SELECT * FROM tenis_partidos";
    $resultado  = $GLOBALS['DB']->prepare($sentencia);
	$resultado->execute();

	$sindicatos = $resultado->fetchAll();
	return( $sindicatos );
}

//obtener todos partidos de un torneo
function getPartidosTorneo($id_torneo){
    $sentencia = "SELECT * FROM tenis_partido WHERE id_torneo = ?";
    $resultado  = $GLOBALS['DB']->prepare($sentencia);
    $resultado->bindParam(1, $id_torneo );
	$resultado->execute();

	$pt = $resultado->fetchAll();
	return( $pt );    
}

 //obtener partido de cuartos
function getCuartos($id_torneo){
    $sentencia = "SELECT * FROM tenis_partido WHERE id_torneo = ? AND tipo_partido='cuartos'";
    $resultado  = $GLOBALS['DB']->prepare($sentencia);
    $resultado->bindParam(1, $id_torneo );
	$resultado->execute();

	$cuartos = $resultado->fetchAll();
	return( $cuartos );    
}

//obtener partidos de semis
function getSemifinal($id_torneo){
    $sentencia = "SELECT * FROM tenis_partido WHERE id_torneo = ? AND tipo_partido='semifinal'";
    $resultado  = $GLOBALS['DB']->prepare($sentencia);
    $resultado->bindParam(1, $id_torneo );
	$resultado->execute();

	$semifinal = $resultado->fetchAll();
	return( $semifinal );    
}
//obtener partido de final
function getFinal($id_torneo){
    $sentencia = "SELECT * FROM tenis_partido WHERE id_torneo = ? AND tipo_partido='final'";
    $resultado  = $GLOBALS['DB']->prepare($sentencia);
    $resultado->bindParam(1, $id_torneo );
	$resultado->execute();

	$final = $resultado->fetchAll();
	return( $final );    
}
?>