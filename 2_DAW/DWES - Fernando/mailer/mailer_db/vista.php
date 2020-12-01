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

function displayEntrada(){
	head();
	?>
	<H1>Enviar email</H1>
	<form method=POST action="controlador.php">
		<input type="submit" name="submit" id="submitButton" value="Enviar" onclick="location.href='/mailer.php'">
		<!--<input type="reset" name="reset" id="resetButton"	value="Borrar">-->
	</form>
	<?php
	foot();
}

function displayClientes( $clientes ){
	head();
	?>
	<H1>Enviar email</H1>
	<form method=POST action="controlador.php">
	<?php foreach ($resultados as $resultado) { ?>
		<label>Nombre: </label>
		<label name="nombre"><?php echo $clientes['nombre'] ?></label><br>
		<label>Email: </label>
		<label name="email"><?php echo $clientes['email'] ?></label><br>
		<label>Fecha Cumpleaños: </label>
		<label name="fecha_cumple"><?php echo $clientes['fecha_cumple'] ?></label><br>
	<?php } ?>
		<input type="submit" name="submit" id="submitButton" value="Enviar" onclick="location.href='/mailer.php'">
		<!--<input type="reset" name="reset" id="resetButton"	value="Borrar">-->
	</form>
	<?php
	foot();
}
?>