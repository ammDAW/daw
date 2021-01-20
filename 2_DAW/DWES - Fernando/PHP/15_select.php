<?php
	$conexion = new PDO("mysql:host=localhost;dbname=test", "root", "");

	$rs = $conexion->query('SELECT * from personas');

	while($row = $rs->fetch()) {
		echo $row['nombre']."<br/>";
		echo $row['apellidos']."<br/>";
		/*echo "codigo: ".$row['codigo']."<br/>";
		echo "nombre: ".$row['nombre']."<br/>";
		echo "apellido: ".$row['apellidos']."<br/>";*/
	}
?>