<?php
function displayMesas($mesas, $votos, $sindicatos){  
 ?>       
    <form action="controlador.php" >
	    <input type="hidden" name="opcion" id="opcion" value="mesa"/>-->
        <table>
            <tr>
                <td>Mesa</td>
                <td>Centro</td>
                <td>Localidad</td>
                <?php foreach($sindicatos as $sindicato){ ?>
                <td><?php echo $sindicato['sindicato'] ?></td>
                <?php } ?>
                <td>Blancos</td>
                <td>Nulos</td>
                <td>Activa</td>
            </tr>
            <?php foreach($mesas as $mesa){?>
            <tr>            
                <td><?php echo $mesa['mesa_id'] ?></td>
                <td><?php echo $mesa['centro'] ?></td>
                <td><?php echo $mesa['localidad'] ?></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><?php echo $mesa['blancos'] ?></td>
                <td><?php echo $mesa['nulos'] ?></td>
                <td><?php echo $mesa['activa'] ?></td>
                <td><?php printf("<a href='controlador.php?opcion=editar&mesa_id=%s'>Editar</a><br>", $mesa['mesa_id']);?></td>
            </tr>
            <?php } ?>
        </table>
    </form>
        <?php 
}

function displayActualizar($sindicatos, $datos){
    foreach($sindicatos as $sindicato){?>
    <label><?php echo $sindicato['sindicato'] ?></label>
    <input type="text" name="<?php $sindicato['sindicato']?>">
<?php        
    }
}  

?>