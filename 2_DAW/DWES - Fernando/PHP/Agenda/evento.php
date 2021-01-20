<?php
class Evento{
    private $codigo;     // user id
    private $fields;  // other record fields

    // initialize a User object
    public function __construct(){
        $this->codigo = null;
        $this->fields = array('evento' => '',
							  'entidad_id' => '',
							  'categoria_id' => '',
							  'ubicacion' => '',
							  'fecha' => '',
							  'hora' => '');
    }

    // override magic method to retrieve properties
    public function __get($field){
        if ($field == 'EVENTO_ID')
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
    public static function validateEvento($evento){
        return preg_match('/^[A-Z0-9]{2,20}$/i', $evento);
    }
    
    // return an object populated based on the record's user id
    public static function getByCodigoEvento($codigo){
        $e = new Evento();

		$conexion = new Database();
		$sql = sprintf( "SELECT * FROM agenda_eventos where evento_id = %d", $codigo );
		$rows = $conexion->query( $sql );
		
		if( $rows->rowCount()  == 0  )
			return null;
		else{
			$e = new Evento();
			$row = $rows->fetch();
			$e->evento = $row['EVENTO'];
			$e->entidad_id = $row['ENTIDAD_ID'];
			$e->categoria_id = $row['CATEGORIA_ID'];
			$e->ubicacion = $row['UBICACION'];
			$e->fecha = $row['FECHA'];
			$e->hora = $row['HORA'];
            $e->codigo = $codigo;
			return $e;
		}
	}
	
	public static function checkEvento($evento){
		$conexion = new Database();
		$sql =  "SELECT * FROM agenda_eventos where evento = ?";
		$query = $conexion->prepare( $sql );
		$query->bindParam( 1, $evento );
		$rows = $query->execute();
		
		if($query->rowCount()  == 0 )
			$resultado = false;
		else
			$resultado = true;

		return $resultado;
	}
	
	public static function getCodigoEvento($evento){
		$conexion = new Database();
		$sql =  "SELECT * FROM agenda_eventos where evento = ?";
		$query = $conexion->prepare( $sql );
		$query->bindParam( 1, $evento );
		$rows = $query->execute();
		
		if( $row = $query->fetch() )
			$resultado = $row['EVENTO_ID'];
		else
			$resultado = false;

		return $resultado;
		
	}
	
	// return an object populated based on the record's user id
    public static function getAllEvento(){
        $v = array();
		$conexion = new Database();
        $sql = sprintf('SELECT * FROM agenda_eventos' );
        $rows = $conexion->query( $sql );
		
        foreach( $rows as $row ){
			$e = new Evento();
			$e->evento = $row['EVENTO'];
			$e->entidad_id = $row['ENTIDAD_ID'];
			$e->categoria_id = $row['CATEGORIA_ID'];
			$e->ubicacion = $row['UBICACION'];
			$e->fecha = $row['FECHA'];
			$e->hora = $row['HORA'];
            $e->codigo = $row['EVENTO_ID'];
			$v[] = $E;
		}
        return $v;
    }
	
    // save the record to the database
    public function saveEvento(){
		$conexion = new Database();
		
        if ($this->codigo){
            $sql = 'UPDATE agenda_eventos SET evento = ? entidad_id = ? categoria_id = ? ubicacion = ? fecha = ? hora = ? WHERE evento_id = ?';
			$conexion->prepare( $sql );
			$conexion->bindParam( 1, $this->evento );
			$conexion->bindParam( 2, $this->entidad_id );
			$conexion->bindParam( 3, $this->categoria_id );
			$conexion->bindParam( 4, $this->ubicacion );
			$conexion->bindParam( 5, $this->fecha );
			$conexion->bindParam( 6, $this->hora );
			$conexion->bindParam( 7, $this->codigo );
			$conexion->execute();
        }
        else{
            $sql = 'INSERT INTO agenda_eventos (evento, entidad_id, categoria_id, ubicacion, fecha, hora) VALUES (?, ?, ?, ?, ?, ?)';
			$conexion->prepare( $sql );
			$conexion->bindParam( 1, $this->evento );
			$conexion->bindParam( 2, $this->entidad_id );
			$conexion->bindParam( 3, $this->categoria_id );
			$conexion->bindParam( 4, $this->ubicacion );
			$conexion->bindParam( 5, $this->fecha );
			$conexion->bindParam( 6, $this->hora );
			$conexion->execute();
			$this->codigo = $conexion->lastInsertId();
        }
    }
	
	// save the record to the database
    public function deleteEvento(){
        $conexion = new Database();
		if ($this->codigo){
            $sql = 'DELETE FROM agenda_eventos WHERE evento_id = ?';
			$conexion->prepare( $sql );
			$conexion->bindParam( 1, $this->codigo );
			$conexion->execute();
        }
    }
}
?>
