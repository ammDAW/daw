<?php
	#tercera forma de introducir valores en una BBDD
	$conexion = new PDO("mysql:host=localhost;dbname=test", "root", "");
	
	class Persona{
		public $nombre;
		public $apellidos;
		
		function __construct($nombre, $apellidos){
			$this->nombre = $nombre;
			$this->apellidos = $apellidos;
		}
	}

	$sql = "insert into personas (nombre, apellidos) values (:nombre, :apellidos)";
	$rs = $conexion->prepare($sql);
	$p = new Persona("jaimito","vega");
	$rs->execute((array) $p);

	#de esta forma los ?,? no funcionan
	/*$sql = "insert into personas (nombre, apellidos) values (?,?)";
	$rs = $conexion->prepare($sql);
	$p = new Persona("jaimito","vegano");
	$rs->execute((array) $p);*/
?>