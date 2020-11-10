<?php
// Incluir el modelo
require_once('modelo2.php');

// Incluir la presentacion
require_once('vista2.php');

if(  isset( $_GET['opcion'] ) && $_GET['opcion'] == 'jornada' ){
	if(!isset($_GET['jornada'])){
		$ultima_jornada = getUltimaJornada();
		$resultados = getResultados($ultima_jornada);
		$jornadas = getJornadas();	
		print_jornada( $resultados, $jornadas );
	}
	else{
		$resultados = getResultados($_GET['jornada']);
		$jornadas = getJornadas();	
		print_jornada( $resultados, $jornadas);
	}
}
elseif( isset( $_GET['opcion'] ) && $_GET['opcion'] == 'clasificacion' ){
	$clasificacion = getClasificacion();
	print_clasificacion( $clasificacion );
}
elseif(isset($_GET['accion']) && $_GET['accion']=='update'){
	$resultados = getResultados($_GET['jornada']);
	foreach($resultados as $resultado)
		updateEspectadores($resultado['partido_id'],$_POST['espectadores']);
}
else print_inicio();
?>