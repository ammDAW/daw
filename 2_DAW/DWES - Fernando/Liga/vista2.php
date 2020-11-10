<?php
function print_jornada( $resultados, $jornadas ){
	?>
	<h1>Jornadas</h1>
	
	<?php foreach ($jornadas as $jornada){ 
		//--echo $jornada['jornada_id']." "-->
		printf("<a href=\"controlador2.php?opcion=jornada&jornada=%s\">%s</a>&nbsp;", $jornada['jornada_id'], $jornada['jornada_id']);
		//<a href="controlador2.php?jornada="echo $jornada['jornada_id']> echo $jornada['jornada_id']</a> 
	} ?>
	<table BORDER="1">
		<tr><th>L</th><th>V</th><th colspan=2>Marcador</th><th>Estado</th><th>Espectadores</th></tr>
		<?php foreach ($resultados as $resultado) { ?>
			<tr>
			<td><?php echo $resultado['local'] ?></td>
			<td><?php echo $resultado['visitante'] ?></td>
			<td><?php echo $resultado['marcador_local'] ?></td>
			<td><?php echo $resultado['marcador_visitante'] ?></td>
			<td><?php echo $resultado['estado'] ?></td>
			<td><form method=post action="controlador2.php">
					<input type="hidden" name="accion" value="update">
					<input type="text" name="espectadores" value="<?php echo $resultado['espectadores']?>">
			</td>
			</tr>
		<?php } ?>
	</table>
	<br>
	<input type="submit" name="submit" id="submitButton" value="Actualizar">
	<a href="controlador2.php">Inicio</a>
	<?php
}

function print_clasificacion( $clasificacion ){
	?>
	<h1>Clasificacion</h1>
	<table BORDER="1">
		<tr><th>Equipo</th><th>Puntos</th><th>Puntos Local</th><th>Puntos Visitante</th></tr>
		<?php foreach ($clasificacion as $equipo ) {?>
		<tr>
		<td><?php echo $equipo['equipo'] ?></td>
		<td><?php echo $equipo['puntos'] ?></td>
		<td><?php echo $equipo['puntos_local'] ?></td>
		<td><?php echo $equipo['puntos_visitante'] ?></td>
		</tr>
		<?php } ?>
	</table>
	<br>
	<a href="controlador2.php">Inicio</a>
	
	<?php
}

function print_inicio( ){
	?>
	<h1>Inicio</h1>
	<a href="controlador2.php?opcion=jornada">Jornada</a>
	<a href="controlador2.php?opcion=clasificacion">Clasificacion</a>
<?php } ?>