<?php
    $conexion = new PDO("mysql:host=localhost;dbname=test","root","");

    $sql = "delete from where nombre = 'javier'";

    $rs = $conexion->prepare($sql);
    $rs->execute();
?>