<?php

function displayGrabar( $etiquetas ){
	?>
	<form enctype="multipart/form-data" action="controlador.php" method="post">
		<input type="hidden" name="opcion" value="upload"> 
		Descripción <input type="text" name="titulo" size="30">
		Ubicación <input type="file" name="archivito">
		<input type="submit" value="Enviar archivo">
		<br>
	
	<?php 
		foreach( $etiquetas as $etiqueta ) {
			print( "{$etiqueta["etiqueta"]}<input type=\"checkbox\" name=\"etiquetas[]\" value=\"{$etiqueta["id"]}\"/> " );
		}
	?>
	</form>
	<?php
	displayMenu();
}

function displayListar( $datos ){
	$i = 1;
	while($i < count($datos)){
		print "{$datos['titulo']}
		<br>
		{$datos['nombre']} ({$datos['tipo']})
		<br>
		<a href='controlador.php?opcion=mostrar_fichero&id={$datos['id']}'>Descargar</a>
		<br>
		<br>";
		$j = 1;
		while ($id == $datos[$i][$j] && $j < count($datos)){
			print "{$datos['etiqueta']}";
			$j++;
		}
		$i++;
	}
	
	foreach( $datos as $item ){
		print" {$item['titulo']}
		<br>
		{$item['nombre']} ({$item['tipo']})
		<br>
		<a href='controlador.php?opcion=mostrar_fichero&id={$item['id']}'>Descargar</a>
		<br>
		<br>";
	}
	displayMenu( );
}

function displayFichero( $contenido, $tipo ){
	header("Content-type: {$tipo}");
	print "{$contenido}";
}

function displayMensaje( $msg ){
	print "{$msg}";
	displayMenu( );
}

function displayMenu( ){
	print "<br>";
	print "<br><a href=\"controlador.php?opcion=inicio\">Inicio</a> ";
	print "<a href=\"controlador.php?opcion=listado\">Listado</a> ";
	print "<a href=\"controlador.php?opcion=grabar\">Grabar</a> ";
}
?>