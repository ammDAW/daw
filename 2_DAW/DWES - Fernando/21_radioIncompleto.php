<?php
function formGenero(){
    ?>
    <form action="21_radio.php" method="POST" >
        <input type="hidden" name="opcion" value="paso2">
        <input type="radio" id="male" name="gender" value="male">
        <label for="male">Male</label><br>
        <input type="radio" id="female" name="gender" value="female">
        <label for="female">Female</label><br>
        <input type="radio" id="other" name="gender" value="other">
        <label for="other">Other</label>
        <input type="submit" name="submitButton" id="submitButton" value="Enviar"/>
    </form>
    <?php
}
function formEdad(){
    ?>
    <form action="21_radio.php" method="POST" >
        <input type="radio" id="joven" name="edad" value="Joven">
        <label for="joven">Joven</label><br>
        <input type="radio" id="adulto" name="edad" value="Adulto">
        <label for="adulto">Adulto</label><br>
        <input type="radio" id="Viejo" name="edad" value="Viejo">
        <label for="viejo">Viejo</label>
        <input type="submit" name="submitButton" id="submitButton" value="Enviar"/>
    </form>
    <?php
}

?>

<?php
if( isset( $_POST["gender"] ) )
  echo "el valor seleccionado es {$_POST["gender"]} <br>";
?>