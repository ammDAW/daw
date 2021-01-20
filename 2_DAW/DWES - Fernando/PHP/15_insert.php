<?php
	$conexion = new PDO("mysql:host=localhost;dbname=test", "root", "");
	
	#tabla personas
	$sql = "insert into personas(nombre, apellidos) values(?,?)";
	$rs = $conexion->prepare($sql);
	$rs->bindParam(1, $nombre);
	$rs->bindParam(2, $apellidos);
	$nombre = "javier";
	$apellidos = "lujan";
	$rs->execute();

	$sql = "insert into personas(nombre, apellidos) values(:nombre, :apellidos)";
	$rs = $conexion->prepare($sql);
	$rs->bindParam(":nombre", $nombre);
	$rs->bindParam(":apellidos", $apellidos);
	$nombre = "antonio";
	$apellidos = "lujan";
	$rs->execute();
	
	#tabla cliente
	$sql = "insert into cliente (nombre_emp, telefono) values(?,?)";
	$rs = $conexion->prepare( $sql );
	$rs->bindParam(1, $nombre_emp);
	$rs->bindParam(2, $telefono);
	$nombre_emp = "odiseo";
	$telefono = 968111222;
	$rs->execute();

	$sql = "insert into cliente(nombre_emp, telefono) values(:nombre_emp, :telefono)";
	$rs = $conexion->prepare( $sql );
	$rs->bindParam(":nombre_emp", $nombre_emp);
	$rs->bindParam(":telefono", $telefono);
	$nombre_emp = "activision";
	$telefono = 868000777;
	$rs->execute();
?>