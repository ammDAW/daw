<?php
// database connection and schema constants
define('DB_HOST', 'localhost');
define('DB_USER', 'root');
define('DB_PASSWORD', '');
define('DB_SCHEMA', 'test');
define('DB_TBL_PREFIX', 'WROX_');

global $DB;

$dsn = "mysql:host=" . DB_HOST . ";dbname=" . DB_SCHEMA;

// establish a connection to the database server
try{
	$DB =  new PDO( $dsn, DB_USER, DB_PASSWORD );
}catch(PDOExecption $e) {
        print "Error!: " . $e->getMessage() . "</br>";
}

function SQLexecute( $sql, $parametros = null){	
	try{
		$result = $GLOBALS[ 'DB' ]->prepare( $sql );
		$result->execute($parametros);
		$lastId = $GLOBALS[ 'DB' ]->lastInsertId();
		return( $lastId );
	}catch(PDOExecption $e) {
                print "Error!: " . $e->getMessage() . "</br>";
	}
}

function SQLquery( $sql, $parametros = null ){	
	$datos = array();
	try{
	        $result = $GLOBALS[ 'DB' ]->prepare( $sql );
		$result->execute($parametros);
		while ($row = $result->fetch()){
			$datos[] = $row; 
		}
		return( $datos );
	}catch(PDOExecption $e) {
                print "Error!: " . $e->getMessage() . "</br>";
	}
}

?>
