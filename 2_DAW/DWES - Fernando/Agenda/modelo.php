<?php

require "db.php";
include "usuario.php";

function getCategorias(){ //obtener todas las categtorias
	$sentencia = "SELECT * FROM agenda_categorias";
	$resultado  = $GLOBALS['DB']->prepare($sentencia);
	$resultado->execute();
	$categorias = $resultado->fetchAll();
	return( $categorias );
}

function getEventos(){	//obtener todos los eventos
	$sentencia = "SELECT * FROM agenda_eventos";
	$resultado  = $GLOBALS['DB']->prepare($sentencia);
	$resultado->execute();

	// Recupera todas las filas en un array
	$jornadas = $resultado->fetchAll();
	print_r( $eventos);
	return( $eventos );
}

function getEntidades(){	 //obtener todas las entidades
	$sentencia = "SELECT * FROM agenda_entidades";
	$resultado  = $GLOBALS['DB']->prepare($sentencia);
	$resultado->execute();

	// Recupera todas las filas en un array
	$entidades = $resultado->fetchAll();
	print_r( $entidades);
	return( $entidades );
}

function existe(){ //comprueba si existe un evento devolviendo 0 o 1
	$sentencia = "SELECT * FROM agenda_eventos WHERE evento_id = ?";
	$resultado  = $GLOBALS['DB']->prepare($sentencia);
	$resultado->bindParam(1, $codigo);
	$resultado->execute();
	$rows = $resultado->fetchAll();
	if(  $resultado->rowCount() > 0 ) 
		return 1;
	else 
		return 0;
}
?>