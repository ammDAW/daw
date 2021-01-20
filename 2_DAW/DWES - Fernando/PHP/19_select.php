<?php
    $cervezas=$_GET["cerveza"];
    for($i=0; $i<count($cervezas); $i++){
        echo "<br>Cerveza ".$i.": ".$cervezas[$i];
    }
    echo "<br>".$_GET["beer"];
?>