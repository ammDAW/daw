<?php
require_once("Database.php" );
require_once("db.php" );

//Da baja a un usuario
function putBaja( $id ){
	$sql ="SELECT * FROM newsletter_usuarios WHERE usuario_id = ? AND estatus = 1";
	$parametros = array( $id );
	$datos = SQLquery( $sql, $parametros );
	
	if( $datos = NULL ){
		return FALSE;
	}
	else{
		$sql ="UPDATE newsletter_usuarios SET estatus = false WHERE usuario_id = ?";
		$parametros = array( $id );
		SQLexecute( $sql, $parametros );
		$sql ="INSERT INTO  newsletter_baja ( fecha, hora , usuario_id ) VALUES (  ?, ? ,  ? )";
		$fecha = date("Y-m-d");  
		$hora =  date("H:i:s");  
		$parametros = array( $fecha, $hora,  $id );
		SQLexecute( $sql, $parametros );
		return true;
	}
}