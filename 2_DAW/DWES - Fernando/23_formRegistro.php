<?php
    function formulario(){
        ?>
            <h1>Comprobar datos en BBDD</h1>
            <form method=post action="23_formRegistro.php">
                <input type="hidden" name="opcion" value="entrada">
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre">
                <br>
                <label for="apellidos">Apellido</label>
                <input type="text" name="apellidos">
                <br>  
                <input type="submit" name="submit" id="submitButton" value="Enviar">
            </form>
        <?php
    }

    function conexion(){
        $dao = "mysql:dbname=test";
        $username = "root";
        $password = "";
        $conexion = new PDO($dao, $username, $password);
        $conexion -> setAttribute( PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        return $conexion;
    }

    function registro($nombre, $apellidos){
        $conexion = conexion();
        $sql= "select * from personas where nombre = ? and apellidos = ?";
        $rs = $conexion->prepare($sql);
        $rs->bindParam(1, $nombre);
        $rs->bindParam(2, $apellidos);
        $rs->execute();

        if($row = $rs->fetch()) return true;
        else return false;
    }

    if(!isset($_POST["submit"])){
        formulario();
    }
    else{
        if(isset($_POST["nombre"]) && isset($_POST["apellidos"]) && registro($_POST["nombre"], $_POST["apellidos"])){
            echo ("El usuario existe");
            ?>
                <br><a href="23_formRegistro.php">Volver</a>
            <?php
        }
        else{
            echo ("El usuario NO existe");
            ?>
                <br><a href="23_formRegistro.php">Volver</a>
            <?php    
        } 
    }
?>

