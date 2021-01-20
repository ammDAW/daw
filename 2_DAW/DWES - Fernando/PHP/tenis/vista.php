<?php

function displayTorneos($torneos){?>
    <form action="controlador.php" >
	<input type="hidden" name="opcion" id="opcion" value="torneos"/>
    
    <table>
        <tr>
            <td>Fecha</td>
            <td>Torneo</td>
        </tr>
    <?php foreach($torneos as $torneo){ ?>
        <tr>
            <td><?php echo $torneo['fecha'] ?></td>
            <td><?php echo $torneo['nombre'] ?></td>
            <td><td><?php printf("<a href='controlador.php?opcion=ver&id_torneo=%s'>Resultado</a><br>", $torneo['id_torneo']);?></td>      
        </tr>
<?php }
}

function displayResultados($cuartos, $semis, $final){ ?>
    <table border>
        <tr>
            <td>Final</td>
        <tr>
            <td>Jugador</td>
            <td>Jugador</td>
            <td>Marcador</td>

        </tr>
        <tr>
        <?php foreach($final as $f){ ?>
            <td><?php echo $f['jugador1'] ?></td>
            <td><?php echo $f['jugador2'] ?></td>
            <td><?php echo $f['resultado'] ?></td>
        </tr>
        <?php } ?>
    </table>
    <br><br>

    <table border>
        <tr>
            <td>Semis</td>
        <tr>
            <td>Jugador</td>
            <td>Jugador</td>
            <td>Marcador</td>
        </tr>
        <tr>
        <?php foreach($semis as $s){ ?>
            <td><?php echo $s['jugador1'] ?></td>
            <td><?php echo $s['jugador2'] ?></td>
            <td><?php echo $s['resultado'] ?></td>
        </tr>
        <?php } ?>
    </table>
    <br><br>

    <table border>
        <tr>
            <td>Cuartos</td>
        <tr>
            <td>Jugador</td>
            <td>Jugador</td>
            <td>Marcador</td>
        </tr>
        <tr>
        <?php foreach($cuartos as $c){ ?>
            <td><?php echo $c['jugador1'] ?></td>
            <td><?php echo $c['jugador2'] ?></td>
            <td><?php echo $c['resultado'] ?></td>
        </tr>
        <?php } ?>
    </table>
    <br><br>

    <?php printf("<a href='controlador.php'>Volver</a><br>");?>

<?php
}

/*function displayResultados($torneos){ ?>
    <table>
        <tr>
            <td>Jugador</td>
            <td>Jugador</td>
            <td>Marcador</td>
            <td>Tipo</td>
        </tr>
        <tr>
        <?php foreach($torneos as $torneo){ ?>
            <td><?php echo $torneo['jugador1'] ?></td>
            <td><?php echo $torneo['jugador2'] ?></td>
            <td><?php echo $torneo['resultado'] ?></td>
            <td><?php echo $torneo['tipo_partido'] ?></td>
        </tr>
        <?php } ?>
    </table>
    <?php printf("<a href='controlador.php'>Volver</a><br>");?>

<?php
}*/

?>