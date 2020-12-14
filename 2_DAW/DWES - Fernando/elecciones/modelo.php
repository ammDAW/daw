<?php
include "Database.php";
include "db.php";

//faltan los order by

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
/*
function getPreguntas ($encuesta_id) {
    $sentencia = "SELECT * FROM POLL_PREGUNTAS WHERE ENCUESTA_ID = ?";
    $resultado  = $GLOBALS['DB']->prepare($sentencia);
    $resultado->bindParam( 1, $encuesta_id );
	$resultado->execute();

	// Recupera todas las filas en un array
	$preguntas = $resultado->fetchAll();
    //print_r( $encuestas);
    //DEVUELVE UN ARRAY!
    print_r( $preguntas);
	return( $preguntas );
}

function getRespuestas ($pregunta_id) {
    $sentencia = "SELECT * FROM POLL_RESPUESTAS WHERE PREGUNTA_ID = ?";
    $resultado  = $GLOBALS['DB']->prepare($sentencia);
    $resultado->bindParam( 1, $pregunta_id );
	$resultado->execute();

	// Recupera todas las filas en un array
	$respuestas = $resultado->fetchAll();
    //print_r( $encuestas);
    //DEVUELVE UN ARRAY!
    print_r( $respuestas);
	return( $respuestas );
}

function putPoll ($ip) {
    $sentencia = "INSERT INTO POLL_POLLS (IP, FECHA, HORA) VALUES (?, ?, ?)";
    $resultado  = $GLOBALS['DB']->prepare($sentencia);
	$resultado->bindParam( 1, $ip );
    $resultado->bindParam( 2, date('Y-m-d') );
    $resultado->bindParam( 3, date("H:i:s") );
	$resultado->execute();
}

function putResultados ($poll_id, $respuesta_id) {
    $sentencia = "INSERT INTO POLL_RESULTADOS (POLL_ID, RESPUESTA_ID) VALUES (?, ?)";
    $resultado  = $GLOBALS['DB']->prepare($sentencia);
	$resultado->bindParam( 1, $poll_id );
    $resultado->bindParam( 2, $respuesta_id );
	$resultado->execute();
}

function getResultados ($encuesta_id) {
    $sentencia = "SELECT * FROM POLL_ENCUESTAS";
	$resultado  = $GLOBALS['DB']->prepare($sentencia);
	$resultado->execute();

	// Recupera todas las filas en un array
	$encuestas = $resultado->fetchAll();
    //print_r( $encuestas);
    //DEVUELVE UN ARRAY!
	return( $encuestas );
}

// function getEncuestas () {
//     $v = array();
//     $conexion = new Database();
//     $sql = 'SELECT * FROM POLL_ENCUESTAS order by categoria';
//     $rows = $conexion->query( $sql );
    
//     foreach( $rows as $row )
//     {
//         $u = new Categoria();
//         $u->codigo = $row['CATEGORIA_ID'];
//         $u->password = $row['CATEGORIA'];
//         $v[$row['CATEGORIA_ID'] ] = $row['CATEGORIA'];
//     }

//     return $v;
// }
*/



?>