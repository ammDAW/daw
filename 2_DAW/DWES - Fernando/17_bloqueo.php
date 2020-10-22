<?php
$conexion = new PDO( "mysql:host=localhost;dbname=test", "root", "");
$conexion -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_WARNING);

try {
    $conexion -> beginTransaction();
    $conexion -> exec('LOCK TABLES personas write');

    $sql = "insert into personas (nombre, apellidos) values (?,?)";
    $rs = $conexion -> prepare( $sql );
    $rs -> bindParam(1, $nombre);
    $rs -> bindParam(2, $apellidos);
    $nomrbe = "victor";
    $apellidos = "martinez";
    $rs -> execute();

    $conexion -> commit();
    $conexion -> exec('UNLOCK TABLES');
    print "Transaccion Realizada";
} catch(PDOException $e) {
    $conexion -> rollback();
    print "Error!:" . $e->getMessage(). "<br/>";
}
?>