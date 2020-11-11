<?php


function print_jornada( $resultados ){

	?>

	<h1>Jornada</h1>
	<form action="controlador.php" >
	<input type="hidden" name="opcion" id="opcion"    value="actualizar" />
			
	<table BORDER="1">
	<tr><th>Local</th><th colspan="2">Resultados</th><th>Visitante</th><th>Estado</th><th>Aforo</th></tr>
	<?php foreach ($resultados as $resultado) { ?>
	<tr>
	<td><?php echo $resultado['local'] ?></td>
	<td><?php printf( "<input type=\"text\" name=\"local%s\" id=\"local%s\"    value=\"%s\" />",$resultado['partido_id'],$resultado['partido_id'],$resultado['marcador_local'] )?></td>
	<td><?php printf( "<input type=\"text\" name=\"visitante%s\" id=\"visitante%s\"    value=\"%s\" />",$resultado['partido_id'],$resultado['partido_id'],$resultado['marcador_visitante'] )?></td>
	<td><?php echo $resultado['visitante'] ?></td>
	
	
	<td>
	<select name= "<?php echo "estado". $resultado['partido_id']; ?>" >
		<option value="P" <?php print(!strcmp("P",$resultado['estado'])? "selected":""); ?>>Pendiente</option>
		<option value="1" <?php print(!strcmp("1",$resultado['estado'])? "selected":""); ?>>Primera parte</option>
		<option value="D" <?php print(!strcmp("D",$resultado['estado'])? "selected":""); ?>>Descanso</option>
		<option value="2" <?php print(!strcmp("2",$resultado['estado'])? "selected":"");  ?>>Segunda parte</option>
		<option value="F" <?php print(!strcmp("F",$resultado['estado'])? "selected":""); ?>>Finalizado</option>
	</select>
	<td><?php printf( "<input type=\"text\" name=\"aforo%s\" id=\"aforo%s\"    value=\"%s\" />",$resultado['partido_id'],$resultado['partido_id'],$resultado['aforo'])?></td>
	</tr>
	<?php } ?>
	</table>
	<input type="submit">
	</form>
	<?php
	
	
	

}

function print_clasificacion( $clasificacion ){
	?>
	<h1>Clasificacion</h1>
	<table BORDER="1">
	<tr><th>Equipo</th><th>P</th><th>Puntos</th></tr>
	<?php  foreach ($clasificacion as $equipo ) {?>
	<tr>
	<td><?php echo $equipo['equipo'] ?></td>
	<td><?php echo $equipo['jugados'] ?></td>
	<td><?php echo $equipo['puntos'] ?></td>
	</tr>
	<?php } ?>
	</table>
	<br>
	<a href="controlador.php">Inicio</a>
	
	<?php
}

function print_inicio( )
{
	?>
	<h1>Inicio</h1>
	<a href="controlador.php?opcion=jornada">Jornada</a><br>
	<a href="controlador.php?opcion=clasificacion">Clasificacion</a><br>
	<a href="controlador.php?opcion=actualizar">Actualizar resultados</a>
	<?php
}

function head()
{
?>	

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<style type="text/css">
.error { background: #d33; color: white; padding: 0.2em; }
</style>
</head>
<body>
<?php
}

function foot()
{
?>	
</body>
</html>
<?php
}

function displayEntrada( $missingFields )
{
	
	head();
	?>
	<H1>Introduce Identificación</H1>
	<FORM METHOD=POST ACTION="controlador.php">
	<INPUT TYPE="hidden" name="opcion" value="entrada">
	<br>
	<label for="usuario" > Usuario</label>
	<INPUT TYPE="text" <?php validateField( "usuario", $missingFields );?> NAME="usuario">
	<br>
	<label for="password" >Password</label>
	<INPUT TYPE="password" <?php validateField( "password", $missingFields );?>  NAME="password">
	<br>
	<input type="submit" name="submit" id="submitButton" value="Enviar" >
	<input type="reset" name="reset" id="resetButton"	value="Borrar" >
	</FORM>
	<?php
	foot();
}

function displayPrivada()
{
		
	head();
	$jornada = ultima_jornada();	
	$partidos = getResultados( $jornada );
	foreach( $partidos as $partido )
	{
		if( isset( $_REQUEST['local' . $partido[ 'partido_id']]) )
			updateLocal( $partido[ 'partido_id'], $_REQUEST['local' . $partido[ 'partido_id']] );
		
		if( isset( $_REQUEST['visitante' . $partido[ 'partido_id']]) )
			updateVisitante( $partido[ 'partido_id'], $_REQUEST['visitante' . $partido[ 'partido_id']] );
		if( isset( $_REQUEST['estado' . $partido[ 'partido_id']]) )
			updateEstado( $partido[ 'partido_id'], $_REQUEST['estado' . $partido[ 'partido_id']] );
		if( isset( $_REQUEST['aforo' . $partido[ 'partido_id']]) )
		updateAforo( $partido[ 'partido_id'], $_REQUEST['aforo' . $partido[ 'partido_id']] );
	}
	$jornada = ultima_jornada();	
	$resultados = getResultados( $jornada );
	print_jornada(  $resultados );
	echo "<br>";
	printf( "<a href='controlador.php?opcion=salir'>Salir</a>");
	foot();

}

function displayError()
{
		
	head();
	printf( "<a href='controlador.php'>Se ha producido un error</a>");
	foot();

}
