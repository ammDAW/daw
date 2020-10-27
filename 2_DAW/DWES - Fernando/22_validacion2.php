<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<style type="text/css">
		.error{ background: #d33; color: white; padding: 0.2em; }
	</style>
</head>
<body>

<?php
	function checkPassword($password){	
		if( strlen( $password ) < 5 ) 
			$resultado = 0;
		else 
			$resultado = 1;
		return $resultado;
	}

	function checkUsuario($usuario){	
		if( strlen( $usuario ) < 5 ) 
			$resultado = 0;
		else 
			$resultado = 1;
		return $resultado;
	}

	function checkTelefono($telefono){
		if(strlen($telefono)!=9 || $telefono[0]!=6)
			$resultado=0;
		else
			$resultado=1;
		return $resultado;
	}

	function validateField( $fieldName, $missingFields ){
		if( in_array( $fieldName, $missingFields ) ) {
			echo ' class="error"'; //cambia su clase a 'error' para mostrar los rojos en las etiquetas
		}
	}

	function setValue( $fieldName ){
		if( isset( $_POST[$fieldName] ) ){
			echo $_POST[$fieldName];
		}
	}

	function processForm( $campos ){
		foreach( $campos as $campo ){
			//echo $campo['nombre'] . $campo['funcion'];
			if( !isset( $_POST[$campo['nombre']] ) or !$_POST[$campo['nombre']] ) {
				$missingFields[] = $campo['nombre'];
			}
			elseif( ! call_user_func( $campo['funcion'],  $_POST[$campo['nombre']] ) ){
				$missingFields[] = $campo['nombre'];
			}
		}
		if( isset ( $missingFields ) )
			return( $missingFields );
		else
			return null;
	}

	function displayEntrada( $missingFields ){
		?>
			<H1>Introduce Identificación</H1>
			<FORM METHOD=POST ACTION="22_validacion2.php">
			<INPUT TYPE="hidden" name="opcion" value ="entrada">
			<br>
			<label for="usuario" <?php validateField( "usuario",	$missingFields ) ?>>Usuario</label>
			<INPUT TYPE="text" NAME="usuario">
			<br>
			<label for="password" <?php validateField( "password",	$missingFields ) ?>>Password</label>
			<INPUT TYPE="password" NAME="password">
			<br>
			<label for="telefono" <?php validateField( "telefono",	$missingFields ) ?>>Telefono</label>
			<INPUT TYPE="telefono" NAME="telefono">
			<br>
			<input type="submit" name="submit" id="submitButton" value="Enviar" >
			<input type="reset" name="reset" id="resetButton"	value="Borrar" >
			</FORM>
		<?php
	}

	if( ! isset( $_POST["submit"] ) ){
		displayEntrada( array() );
	}	
	elseif( isset( $_POST["opcion"]  ) &&  $_POST["opcion"] == "entrada" ){
		// campo_requerido funcion_validacion
		$campos = array( 
					array('nombre' => 'usuario', 'funcion' => 'checkUsuario'), 
					array('nombre' => 'password', 'funcion' => 'checkPassword'),
					array('nombre' => 'telefono', 'funcion' => 'checkTelefono')
				);
		$missingFields = processForm( $campos );

		if( $missingFields ){
			displayEntrada( $missingFields );
		} 
		else{
			echo ("Su informacion ha sido procesada");
		}
	}
?>
</body>
</html>