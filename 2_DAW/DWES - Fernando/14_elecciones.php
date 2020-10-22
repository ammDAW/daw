<?php
$elecciones = array( 
	"andalucia" => array( "almeria" => array("psoe" => 10,"pp" => 10), "jaen" => array( "psoe" => 10,"pp" => 10)),
	"valencia" => array( "castellon" => array("vox" => 10,"pp" => 10), "valencia" => array( "podemos"=> 10,"pp" => 10))
);

$resultados = array();

if( isset( $_GET["opcion"]) && $_GET["opcion"]=='autonomia' && isset( $_GET["autonomia"]) && isset( $elecciones[$_GET["autonomia"]])){
	foreach( $elecciones[$_GET["autonomia"]] as $provincia => $partidos){
		foreach( $partidos as $partido => $escaños){
			if( isset( $resultados[$partido])) $resultados[$partido]+=$escaños;
			else $resultados[$partido] = $escaños;
		}
		foreach( $resultados as $partido => $escaños){
			echo $partido."  ".$escaños."<br>";
		}
	
		foreach( $elecciones[$_GET["autonomia"]] as $provincia=>$partidos){
			echo "<a href='elecciones.php?opcion=provincia&autonomia={$_GET["autonomia"]}&provincia={$provincia}'>{$provincia}</a><br>";
		}
	}
}
else{ //Global results. Apararece la priemra vez que ejecutas el archivo porque no existen parámetros de entrada al principio 
	foreach( $elecciones as $autonomia => $provincias){
		foreach( $provincias as $provincia => $partidos){
			foreach( $partidos as $partido => $escaños){
				if( isset( $resultados[$partido])) $resultados[$partido] += $escaños;
				else $resultados[$partido] = $escaños;		
			}
		}	
	}

	foreach( $resultados as $partido => $escaños){
		echo  $partido ."  " .  $escaños . "<br>";
	}

	foreach( $elecciones as $autonomia => $provincias){
		echo  "<a href='elecciones.php?opcion=autonomia&autonomia={$autonomia}'>{$autonomia}</a><br>";
	}
}
?>