<?php
include "Database.php";
include "db.php";

function getMesas () {
    $sentencia = "SELECT * FROM elecciones_mesas";
	$resultado  = $GLOBALS['DB']->prepare($sentencia);
	$resultado->execute();

	// Recupera todas las filas en un array
	$mesas = $resultado->fetchAll();
    //print_r( $mesas);
    //DEVUELVE UN ARRAY!
	return($mesas);
}

function getSindicatos(){
    $sentencia = "SELECT sindicato_id, sindicato, logo, votos_real, delegados_real FROM elecciones_sindicatos";
    $resultado  = $GLOBALS['DB']->prepare($sentencia);
	$resultado->execute();

	$sindicatos = $resultado->fetchAll();
	return( $sindicatos );
}

function getVotos(){
    $sentencia = "SELECT * FROM elecciones_votos";
    $resultado  = $GLOBALS['DB']->prepare($sentencia);
	$resultado->execute();

	$votos = $resultado->fetchAll();
	return( $votos );
}

function getVotosMesa($mesa_id, $sindicato_id){
    $sentencia = "SELECT v.* FROM elecciones_votos v WHERE mesa_id = ? AND sindicato_id = ?";
    $resultado  = $GLOBALS['DB']->prepare($sentencia);
    $resultado->bindParam(1, $mesa_id );
    $resultado->bindParam(2, $sindicato_id);
	$resultado->execute();

	$vm = $resultado->fetchAll();
	return( $vm );    
}
?>