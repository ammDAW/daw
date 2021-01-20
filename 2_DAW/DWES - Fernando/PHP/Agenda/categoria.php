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

class Categoria{
    private $codigo;     // user id
    private $fields;  // other record fields

    // initialize a User object
    public function __construct(){
        $this->codigo = null;
        $this->fields = array('categoria' => '');
    }

    // override magic method to retrieve properties
    public function __get($field){
        if ($field == 'CATEGORIA_ID'){
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
    public static function validateCategoria($categoria){
        return preg_match('/^[A-Z0-9]{2,20}$/i', $categoria);
    }
    
    // return an object populated based on the record's user id
    public static function getByCodigoCategoria($codigo){
        $c = new Categoria();
		$conexion = new Database();
		$sql = sprintf( "SELECT * FROM agenda_categorias where categoria_id = %d", $codigo );
		$rows = $conexion->query( $sql );
		
		if( $rows->rowCount()  == 0  )
			return null;
		else{
			$c = new Categoria();
			$row = $rows->fetch();
			$c->categoria = $row['CATEGORIA'];
            $c->codigo = $codigo;
			return $c;
		}
	}
	
	public static function checkCategoria($categoria){
		$conexion = new Database();
		$sql = sprintf( "SELECT * FROM  agenda_categorias where categoria = '%s'", $categoria );
		$rows = $conexion->query( $sql );
		
		if( $rows->rowCount()  == 0  )
			$resultado = false;
		else
			$resultado = true;
		return $resultado;	
	}
	
    public static function getAllCategoria(){
        $v = array();
		$conexion = new Database();
        $sql = sprintf('SELECT * FROM agenda_categorias' );
        $rows = $conexion->query( $sql );

        foreach( $rows as $row ){
			$c = new Cateroria();
			$c->categoria = $row['CATEGORIA'];
            $c->codigo = $row['CATEGORIA_ID'];
			$v[] = $c;
		}
        return $v;
    }
	
    // save the record to the database
    public function saveCategoria(){
		$conexion = new Database();
        if ($this->codigo){
            $query = sprintf('UPDATE agenda_categorias SET categoria = "%s" WHERE categoria_id = %d',
                $this->categoria,
                $this->codigo);
            $rows = $conexion->exec( $query );
        }
        else{
            $query = sprintf('INSERT INTO agenda_categorias(categoria) VALUES ("%s")',
                $this->usuario);
			$rows = $conexion->exec( $query );
            $this->codigo = $conexion->lastInsertId();
        }
    }
	
	// save the record to the database
    public function deleteCategoria(){
        $conexion = new Database();
		if ($this->codigo){
            $sql = sprintf('DELETE FROM agenda_categorias WHERE categoria_id = %d',
                $this->codigo);
            $conexion->exec( $sql );
        }
    }
}
?>
