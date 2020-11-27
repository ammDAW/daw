<?php

class Database extends PDO {
	function __construct(){
		$dsn = "mysql:dbname=test";
		$username = "root";
		$password = "";

		try {  
			parent::__construct( $dsn, $username, $password );  
			$this->setAttribute( PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION );  
		}
		catch(PDOException $e) {  
		    echo 'ERROR: ' . $e->getMessage();
		}   
	}
}

class Entidad{
    private $codigo;     // user id
    private $fields;  // other record fields

    // initialize a User object
    public function __construct(){
        $this->codigo = null;
        $this->fields = array('entidad' => '');
    }

    // override magic method to retrieve properties
    public function __get($field){
        if ($field == 'ENTIDAD_ID'){
            return $this->codigo;
        }
        else{
            return $this->fields;
        }
    }

    // override magic method to set properties
    public function __set($field, $value){
        if (array_key_exists($field, $this->fields)){
            $this->fields[$field] = $value;
        }
    }

    // return if usuario is valid format
    public static function validateEntidad($entidad){
        return preg_match('/^[A-Z0-9]{2,20}$/i', $entidad);
    }
    
    // return an object populated based on the record's user id
    public static function getByCodigoEntidad($codigo){
        $e = new Entidad();
		$conexion = new Database();
		$sql = sprintf( "SELECT * FROM agenda_entidades where entidad_id = %d", $codigo );
		$rows = $conexion->query( $sql );
		
		if( $rows->rowCount()  == 0  )
			return null;
		else{
			$e = new Entidad();
			$row = $rows->fetch();
			$e->entidad = $row['ENTIDAD'];
            $e->codigo = $codigo;
			return $e;
		}
	}
	
	public static function checkEntidad($entidad){
		$conexion = new Database();
		$sql = sprintf( "SELECT * FROM  agenda_entidades where entidad = '%s'", $entidad );
		$rows = $conexion->query( $sql );
		
		if( $rows->rowCount()  == 0  )
			$resultado = false;
		else
			$resultado = true;
		return $resultado;	
	}
	
    public static function getAllEntidad(){
        $v = array();
		$conexion = new Database();
        $sql = sprintf('SELECT * FROM agenda_entidades' );
        $rows = $conexion->query( $sql );

        foreach( $rows as $row ){
			$e = new Entidad();
			$e->entidad = $row['ENTIDAD'];
            $e->codigo = $row['ENTIDAD_ID'];
			$v[] = $e;
		}
        return $v;
    }
	
    // save the record to the database
    public function saveEntidad(){
		$conexion = new Database();
        if ($this->codigo){
            $query = sprintf('UPDATE agenda_entidades SET entidad = "%s" WHERE entidad_id = %d',
                $this->entidad,
                $this->codigo);
            $rows = $conexion->exec( $query );
        }
        else{
            $query = sprintf('INSERT INTO agenda_entidades(entidad) VALUES ("%s")',
                $this->usuario);
			$rows = $conexion->exec( $query );
            $this->codigo = $conexion->lastInsertId();
        }
    }
	
	// save the record to the database
    public function deleteEntidad(){
        $conexion = new Database();
		if ($this->codigo){
            $sql = sprintf('DELETE FROM agenda_entidades WHERE entidad_id = %d',
                $this->codigo);
            $conexion->exec( $sql );
        }
    }
}
?>
