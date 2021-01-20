<?php
require "db.php";

function updateEspectadores($partido_id, $espectadores)
{
	$sentencia = "update liga_partidos set espectadores = ? where partido_id = ?";
	$resultado  = $GLOBALS['DB']->prepare($sentencia);
	$resultado->bindParam(1, $espectadores);
	$resultado->bindParam(2, $partido_id);
	$resultado->execute();
}

function getResultados($jornada){
	$sentencia = "SELECT a.equipo as local , b.equipo as visitante, marcador_local , marcador_visitante, estado, espectadores FROM liga_partidos, liga_equipos as a, liga_equipos as b WHERE liga_partidos.local_id = a.equipo_id and liga_partidos.visitante_id = b.equipo_id and jornada_id = ? order by partido_id";
	$resultado  = $GLOBALS['DB']->prepare($sentencia);
	$resultado->bindParam( 1, $jornada );
	$resultado->execute();

	// Recupera todas las filas en un array
	$resultados = $resultado->fetchAll();
	
	return( $resultados );
}
function getJornadas(){
	$sentencia = "select jornada_id from liga_jornadas";
	$resultado = $GLOBALS['DB']->prepare($sentencia);
	$resultado->execute();
	$jornadas = $resultado->fetchAll();
	return ($jornadas);
}

function getUltimaJornada(){
	$sentencia = "select max(jornada_id) from liga_jornadas";
	$resultado = $GLOBALS['DB']->prepare($sentencia);
	$resultado->execute();
	$row = $resultado->fetch();
	$ultima_jornada = $row[0];
	return ($ultima_jornada);
}

function getClasificacion(){
	$sentencia = "select * from liga_equipos";
	$resultado  = $GLOBALS['DB']->prepare($sentencia);
	$resultado->execute();
	
	$cont = 0;
	
	while( $row = $resultado->fetch() ){
		$equipos_id[$row[ 'EQUIPO_ID' ]] = $cont;
		$equipos[] = $row[ 'EQUIPO' ];
		$puntos[] = 0;
		$puntos_local[]=0;
		$puntos_visitante[]=0;
		$cont++;
	}
	
	$sentencia = "select * from liga_partidos";
	$resultado  = $GLOBALS['DB']->prepare($sentencia);
	$resultado->execute();

	// Recupera todas las filas en un array
	$partidos = $resultado->fetchAll();
	
	echo "<br>";
	foreach( $partidos as $partido ){
		if( $partido[ "MARCADOR_LOCAL" ] > $partido[ "MARCADOR_VISITANTE" ] ){
			$puntos[ $equipos_id[ $partido["LOCAL_ID" ] ] ] +=3;
			$puntos_local[$equipos_id[$partido["LOCAL_ID"]]] +=3;
		}
		elseif ( $partido[ "MARCADOR_LOCAL" ] == $partido[ "MARCADOR_VISITANTE" ] ){
			$puntos[ $equipos_id[ $partido["LOCAL_ID" ] ] ] +=1;
			$puntos[ $equipos_id[ $partido["VISITANTE_ID" ] ] ] +=1;
			$puntos_local[$equipos_id[$partido["LOCAL_ID"]]] +=1;
			$puntos_visitante[$equipos_id[$partido["VISITANTE_ID"]]]+=1;
		}
		else{
			$puntos[ $equipos_id[ $partido["VISITANTE_ID" ] ] ] +=3;
			$puntos_visitante[$equipos_id[$partido["VISITANTE_ID"]]]+=3;			
		}
	}

	array_multisort($puntos, SORT_DESC, $equipos, $puntos_local, $puntos_visitante);
	
	for( $i = 0; $i < count( $puntos ); $i++ ){
		$clasificacion[] = array(
								'equipo' => $equipos[ $i ],
								'puntos' => $puntos[ $i ],
								'puntos_local' => $puntos_local[$i],
								'puntos_visitante' => $puntos_visitante[$i]
								);
	}
	
	return( $clasificacion );
}
//print_r( getClasificacion() );
?>