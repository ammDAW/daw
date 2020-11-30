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

class Usuario{
    private $codigo;    // user id
    private $fields;    // other record fields

    // initialize a User object
    public function __construct(){
        $this->codigo = null;
        $this->fields = array('usuario' => '',
                              'email' => '',
                              'dia_cumple' =>'');
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

    // return if usuario is valid format
    public static function validateUsuario($usuario){
        return preg_match('/^[A-Z0-9]{2,20}$/i', $usuario);
    }
    
    // return an object populated based on the record's user id
    public static function getByCodigo($codigo){
        $u = new Usuario();

		$conexion = new Database();
		$sql = sprintf( "SELECT * FROM mail_usuarios where codigo = %d", $codigo );
		$rows = $conexion->query( $sql );
		
		if( $rows->rowCount()  == 0  )
			return null;
		else{
			$u = new Usuario();
			$row = $rows->fetch();
			$u->usuario = $row['usuario'];
            $u->email = $row['email'];
            $u->dia_cumple = $row['dia_cumple'];
            $u->codigo = $codigo;
			return $u;
		}
	}
	
	public static function checkUsuario($usuario){
		$conexion = new Database();
		$sql = sprintf( "SELECT * FROM mail_usuarios where usuario = '%s'", $usuario );
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
        $sql = sprintf('SELECT * FROM mail_usuarios' );
        $rows = $conexion->query( $sql );

        foreach( $rows as $row ){
			$u = new Usuario();
			$u->usuario = $row['usuario'];
            $u->email = $row['email'];
            $u->dia_cumple = $row['dia_cumple'];
            $u->codigo = $row['codigo'];
			$v[] = $u;
		}
        return $v;
    }
	
    // save the record to the database
    public function save(){
		$conexion = new Database();
		
        if ($this->codigo){
            $query = sprintf('UPDATE mail_usuarios SET usuario = "%s" email = "%s" dia_cumple = "%s" WHERE codigo = %d',
                $this->usuario,
                $this->email,
                $this->dia_cumple,
                $this->codigo);
            $rows = $conexion->exec( $query );
        }
        else{
            $query = sprintf('INSERT INTO mail_usuarios ( usuario, email, dia_cumple) VALUES ("%s", "%s", "%s")',
                $this->usuario,
                $this->email,
                $this->dia_cumple);
			$rows = $conexion->exec( $query );
            $this->codigo = $conexion->lastInsertId();
        }
    }
	
	// save the record to the database
    public function delete(){
        $conexion = new Database();
		
		if ($this->codigo){
            $sql = sprintf('DELETE FROM mail_usuarios WHERE codigo = %d',
                     $this->codigo);
            $conexion->exec( $sql );
        }
    }

}
?>
