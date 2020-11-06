<?php
// Incluir el modelo
require_once('modelo2.php');

// Incluir la presentacion
require_once('vista2.php');

if(  isset( $_GET['opcion'] ) && $_GET['opcion'] == 'jornada' ){
	//if(isset($_GET['jornada']) && $_GET['jornada']==1){
		$resultados = getResultados();
		$jornadas = getJornadas();	
	
	$resultados = getResultados();
	print_jornada( $resultados, $jornadas );
}
elseif( isset( $_GET['opcion'] ) && $_GET['opcion'] == 'clasificacion' ){
	$clasificacion = getClasificacion();
	print_clasificacion( $clasificacion );
}
else print_inicio( );
?>