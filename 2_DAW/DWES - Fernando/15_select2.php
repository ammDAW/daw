<?php
	#Imprimir todos los resultados sin necesidad de un bucle
	$conexion = new PDO("mysql:host=localhost;dbname=test", "root", "");

	$rs = $conexion->query('SELECT * from personas');

	$rows = $rs->fetchAll();
	print_r($rows);
?>