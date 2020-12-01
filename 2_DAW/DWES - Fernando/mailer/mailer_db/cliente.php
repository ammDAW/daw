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

class Cliente{
    private $codigo;    // user id
    private $fields;    // other record fields

    // initialize a User object
    public function __construct(){
        $this->codigo = null;
        $this->fields = array('nombre' => '',
                              'email' => '',
                              'fecha_cumple' =>'');
    }

    // override magic method to retrieve properties
    public function __get($field){
        if ($field == 'codigo')
            return $this->codigo;
        else 
            return $this->fields[$field];
    }

    // override magic method to set properties
    public function __set($field, $value){
        if (array_key_exists($field, $this->fields))
            $this->fields[$field] = $value;
    }
    
    // return an object populated based on the record's user id
    public static function getByCodigo($codigo){
        $u = new Cliente();

		$conexion = new Database();
		$sql = sprintf( "SELECT * FROM email_usuarios where codigo = %d", $codigo );
		$rows = $conexion->query( $sql );
		
		if( $rows->rowCount()  == 0  )
			return null;
		else{
			$u = new Cliente();
			$row = $rows->fetch();
			$u->nombre = $row['nombre'];
            $u->email = $row['email'];
            $u->fecha_cumple = $row['fecha_cumple'];
            $u->codigo = $codigo;
			return $u;
		}
	}
	
	public static function checkCliente($usuario){
		$conexion = new Database();
		$sql = sprintf( "SELECT * FROM email_usuarios where usuario = '%s'", $usuario );
		$rows = $conexion->query( $sql );
		if( $rows->rowCount()  == 0  )
			$resultado = false;
		else
			$resultado = true;
		return $resultado;
	}
	
	// return an object populated based on the record's user id
    public static function getAll(){
        $v = array();
		$conexion = new Database();
        $sql = sprintf('SELECT * FROM email_usuarios' );
        $rows = $conexion->query( $sql );

        foreach( $rows as $row ){
			$u = new Cliente();
			$u->nombre = $row['nombre'];
            $u->email = $row['email'];
            $u->dia_cumple = $row['fecha_cumple'];
            $u->codigo = $row['codigo'];
			$v[] = $u;
		}
        return $v;
    }
	
    // save the record to the database
    public function save(){
		$conexion = new Database();
		
        if ($this->codigo){
            $query = sprintf('UPDATE email_usuarios SET nombre = "%s" email = "%s" fecha_cumple = "%s" WHERE codigo = %d',
                $this->nombre,
                $this->email,
                $this->fecha_cumple,
                $this->codigo);
            $rows = $conexion->exec( $query );
        }
        else{
            $query = sprintf('INSERT INTO email_usuarios ( nombre, email, fecha_cumple) VALUES ("%s", "%s", "%s")',
                $this->nombre,
                $this->email,
                $this->fecha_cumple);
			$rows = $conexion->exec( $query );
            $this->codigo = $conexion->lastInsertId();
        }
    }
	
	// save the record to the database
    public function delete(){
        $conexion = new Database();
		
		if ($this->codigo){
            $sql = sprintf('DELETE FROM email_usuarios WHERE codigo = %d',
                     $this->codigo);
            $conexion->exec( $sql );
        }
    }
}
?>
