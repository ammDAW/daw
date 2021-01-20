<?php
	class Database extends PDO {
		function __construct(){
			$dsn = "mysql:dbname=test";
			$username = "root";
			$password = "";

			try{  
				parent::__construct($dsn, $username, $password);  
				$this->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);  

			}
			catch(PDOException $e){  
				echo 'ERROR: ' . $e->getMessage();
			}  
		}
	}
	
	class Usuario{
		private $codigo;     // user id
		private $nombre;  
		private $apellidos;
		private $tfMovil;
		private $tfFijo; 

		// initialize a User object
		public function __construct(){
			$this->codigo = null;
		}

		public function setCodigo($value){ $this->codigo = $value;}
		public function getCodigo(){ return $this->codigo;}

		public function setNombre($value){ $this->nombre = $value;}
		public function getNombre(){ return $this->nombre;}

		public function setApellidos($value){ $this->apellidos = $value;}
		public function getApellidos(){ return $this->apellidos;}

		public function setTfMovil($value){ $this->tfMovil=$value;}
		public function getTfMovil(){ return $this->tfMovil;}

		public function setTfFijo($value){ $this->tfFijo=$value;}
		public function getTfFijo(){ return $this->tfFijo;}

		// return an object populated based on the record's user id
		public static function getByCodigo($codigo){
			$u = new Usuario();
			$conexion = new Database();

			$sql = "SELECT * FROM personas where codigo = ?";
			$rs = $conexion->prepare($sql);
			$rs->bindParam(1, $codigo);
			$rs->execute();


			if($row = $rs->fetch()){
				$u = new Usuario();
				$u->nombre = $row['nombre']; //lo que hay dentro de [ ] debe de ser el nombre de la celda que quieres coger
				$u->apellidos = $row['apellidos'];
				$u->codigo = $codigo;
				$u->tfMovil = $row['tfMovil'];
				$u->tfFijo = $row['tfFijo'];
				return $u;
			}
			else return null;
		}

		// return an object populated based on the record's user id
		public static function getAll(){
			$v = array();
			$conexion = new Database();
			$sql ='SELECT * FROM personas';
			$rows = $conexion->query( $sql );

			foreach( $rows as $row ){
				$u = new Usuario();
				$u->nombre = $row['nombre'];
				$u->apellidos = $row['apellidos'];
				$u->codigo = $row['codigo'];
				$u->tfMovil = $row['tfMovil'];
				$u->tfFijo = $row['tfFijo'];
				$v[] = $u;
			}
			return $v;
		}

		// save the record to the database
		public function save(){
			$conexion = new Database();

			if ($this->codigo){
				$sql = 'UPDATE personas SET nombre=? , apellidos=? , tfMovil=? , tfFijo=? WHERE codigo = ?';
				$rs = $conexion->prepare($sql);
				$rs->bindParam(1, $this->nombre);
				$rs->bindParam(2, $this->apellidos);
				$rs->bindParam(3, $this->tfMovil);
				$rs->bindParam(4, $this->tfFijo);
				$rs->bindParam(5, $this->codigo);

				$rs->execute();
			}
			else{
				$sql = 'INSERT INTO personas(nombre, apellidos, tfMovil, tfFijo) VALUES (?, ?, ?, ?)';
				$rs = $conexion->prepare( $sql);
				$rs->bindParam(1, $this->nombre);
				$rs->bindParam(2, $this->apellidos);
				$rs->bindParam(3, $this->tfMovil);
				$rs->bindParam(4, $this->tfFijo);
				$rs->execute();
				$this->codigo = $conexion->lastInsertId();
			}
		}

		// save the record to the database
		public function delete(){
			$conexion = new Database();

			if ($this->codigo){
				$sql = 'DELETE FROM personas WHERE codigo = ?';
				$rs = $conexion->prepare( $sql );
				$rs->bindParam(1 , $this->codigo);
				$rs->execute();
			}
		}
	}
	//prueba crea el usuario 'p' en la bbdd con save() y elimina el usuario 'a' poniendo el codigo con delete()
	function prueba(){
		$p = new Usuario();
		$p->setNombre("pedro");
		$p->setApellidos("morales");
		$p->setTfMovil(55555);
		$p->setTfFijo(44444);
		$p->save();

		$a = Usuario::getByCodigo(2); //coge lo que hay entre parentesis como codigo de la tabla y borra esa fila
		echo "hola";
		echo $a->getNombre();
		echo $a->getApellidos();
		echo $a->getTfMovil();
		echo $a->getTfFijo();

		$a->delete();

		$v = Usuario::getAll();
		print_r($v);
	}
	prueba();
?>