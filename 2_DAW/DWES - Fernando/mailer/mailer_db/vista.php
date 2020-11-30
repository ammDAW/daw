<?php
function head(){
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

function foot(){
?>	
	</body>
	</html>
<?php
}

function displayEntrada( $missingFields ){
	head();
	?>
	<H1>Clientes</H1>
	<form method=POST action="controlador.php">
		<input type="hidden" name="opcion" value="entrada">
		<br>
		<label for="usuario">Usuario</label>
		<input type="text" name="usuario">
		<br>
		<label for="correo">Correo</label>
		<input type="text" name="correo">
		<br>
		<label for="dia_cumple">Cumpleaños</label>
		<input type="date" name="dia_cumple">
		<br>
		<input type="submit" name="submit" id="submitButton" value="Enviar">
		<input type="reset" name="reset" id="resetButton"	value="Borrar">
	</form>
	<?php
	foot();
}
?>