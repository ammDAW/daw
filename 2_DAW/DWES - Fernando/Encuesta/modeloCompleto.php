<?php
include "Database.php";
include "db.php";

//faltan los order by

function getEncuestas () {
    $sentencia = "SELECT * FROM poll_encuestas";
	$resultado  = $GLOBALS['DB']->prepare($sentencia);
	$resultado->execute();

	// Recupera todas las filas en un array
	$encuestas = $resultado->fetchAll();
    //print_r( $encuestas);
    //DEVUELVE UN ARRAY!
	return( $encuestas );
}

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
/*putPoll (222);
putResultados (2,1);
putResultados (2,6);*/




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




?>