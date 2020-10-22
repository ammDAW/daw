<?php
    $conexion = new PDO("mysql:host=localhost;dbname=test","root","");

    $sql = "update personas set nombre = 'alfredo' where codigo=2";

    $rs = $conexion->prepare($sql);
    $rs->execute();
?>