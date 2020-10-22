<?php
	#Otra forma de introducir valores en una BBDD
	$conexion = new PDO("mysql:host=localhost;dbname=test", "root", "");

	$sql = "insert into personas(nombre, apellidos) values (:nombre, :apellidos)";
	$rs = $conexion ->prepare($sql);
	$parametros = array("nombre"=>"pepe", "apellidos"=>"lopez");
	$rs->execute($parametros);
	
	$sql = "insert into personas(nombre, apellidos) values (?,?)";
	$rs = $conexion ->prepare($sql);
	$parametros = array("pepe", "lopez");
	$rs->execute($parametros);

	#habrá que hacer un array por cada fila que vayamos a introducir en la BBDD
	$parametros = array("nombre"=>"juanito", "apellidos"=>"carrasco");
	$rs->execute($parametros);
?>