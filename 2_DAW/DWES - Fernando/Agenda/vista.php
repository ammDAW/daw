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
	<H1>Introduce Identificación</H1>
	<form method=POST action="controlador.php">
		<input type="hidden" name="opcion" value="entrada">
		<br>
		<label for="usuario" > Usuario</label>
		<input type="text" <?php validateField( "usuario", $missingFields );?>" name="usuario">
		<br>
		<label for="password" >Password</label>
		<input type="password" <?php validateField( "password", $missingFields );?> " name="password">
		<br>
		<input type="submit" name="submit" id="submitButton" value="Enviar" >
		<input type="reset" name="reset" id="resetButton"	value="Borrar" >
	</form>
	<?php
	foot();
}

function displayEvento($missingFields, $entidades, $categorias){
	head();?>
	<h1>Introduce Evento</h1>
	<form method=POST action="controlador.php">
		<input type="hidden" name="opcion" value="introducir">
		<!-- eventos-->
		<label for="evento" <?php validateField( "servicio", $missingFields ) ?>>Evento</label>
		<input type="text" name="evento" value="<?php setValue( "evento" ) ?>">
		<br>
		<!--entidades-->
		<label for="entidad" <?php validateField( "entidad", $missingFields ) ?>>Entidad</label>
		<select NAME="entidad"> 
			<?php
			foreach( $entidades as $key => $value ){
				printf( '<option value="%s">%s</option>',$key, $value ); 
			}
			?>
		</select>
		<br>
		<!--categorias-->
		<label for="categoria" <?php validateField("categoria", $missingFields ) ?>>Categoria</label>
		<select name="categoria"> 
			<?php
			foreach( $categorias as $key => $value ){
				printf( '<option value="%s">%s</option>',$key, $value ); 
			}
			?>
		</select>
		<br>
		<!--ubicacion-->
		<label for="ubicacion" <?php validateField( "ubicacion", $missingFields ) ?>>Ubicacion</label>
		<input type="text" name="ubicacion" value="<?php setValue( "ubicacion" ) ?>">
		<br>
		<!--fecha-->
		<label for="fecha" <?php validateField( "fecha", $missingFields ) ?>>Fecha</label>
		<input type="date" name="fecha" value="<?php setValue( "fecha" ) ?>">
		<!--hora-->
		<label for="hora" <?php validateField( "hora", $missingFields ) ?>>hora</label>
		<input type="time" name="hora" value="<?php setValue( "hora" ) ?>">
		<br>
		<!--botones-->
		<input type="submit" name="submit" id="submitButton" value="Enviar" >
		<input type="reset" name="reset" id="resetButton"	value="Borrar" >
	</form>
	<br>
	<!--salir-->
	<a href="controlador.php?opcion=salir">Salir</a><?php
	foot();
}

function displayPrivada(){	
	head();
	printf("Ha entrado en la zona privada<br>");
	printf("<a href='controlador.php?opcion=salir'>Salir</a>");
	foot();

}

function displayInfo(){
	head();
	printf("El parte ha sido registrado<br>");
	printf("<a href='controlador.php?opcion=entrada'>Continuar</a><br>");
	printf("<a href='controlador.php?opcion=salir'>Salir</a>");
	foot();

}

function displayError(){	
	head();
	printf("<a href='controlador.php'>Se ha producido un error</a>");
	foot();
}
?>