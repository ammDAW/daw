<?php

//datos del arhivo 
$nombre_archivo = $_FILES['userfile']['name']; 
$tipo_archivo = $_FILES['userfile']['type']; 
$tamano_archivo = $_FILES['userfile']['size']; 

//compruebo si las características del archivo son las que deseo 
if (!((strpos($tipo_archivo, "gif") || strpos($tipo_archivo, "jpeg") || strpos($tipo_archivo, "pdf")) && ($tamano_archivo < 100000))) { 
   	echo "La extensión o el tamaño de los archivos no es correcta. <br><br><table><tr><td><li>Se permiten archivos .pdf .gif o .jpg<br><li>se permiten archivos de 100 Kb máximo.</td></tr></table>"; 
}
else{ 
   	if (move_uploaded_file($_FILES['userfile']['tmp_name'], $nombre_archivo)){ 
      	echo "El archivo ha sido cargado correctamente."; 
	}
	else{ 
      	echo "Ocurrió algún error al subir el fichero. No pudo guardarse."; 
   	} 
}

?>