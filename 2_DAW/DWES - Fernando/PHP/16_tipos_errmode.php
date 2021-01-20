<?php
#ERRMODE_EXCEPTION
#No continua con la ejecución del código
try {
	$DBH = new PDO("mysql:host=localhost;dbname=test", "root", "");
	$DBH->setAttribute( PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION );
	#UH-OH! Typed DELECT instead of SELECT!
	$STM = $DBH->prepare('DELECT nombre FROM personas');
	$STM->execute();
}catch(PDOException $e) {
	echo "Te has equivocado, pusiste mal la palabra SELECT. Sorry bro.";
	#file_put_contents('PDOErrors.txt', $e->getMessage(), FILE_APPEND); exportar a un fichero
}


#ERRMODE_SILENT
#No muestra el mensaje ni error en pantalla. Continua con la ejecución del código
try {
	$DBH = new PDO("mysql:host=localhost;dbname=test", "root", "");
	$DBH->setAttribute( PDO::ATTR_ERRMODE, PDO::ERRMODE_SILENT );
	#UH-OH! Typed DELECT instead of SELECT!
	$STM = $DBH->prepare('DELECT nombre FROM personas');
	$STM->execute();
}catch(PDOException $e) {
	echo "Te has equivocado, pusiste mal la palabra SELECT. Sorry bro.";
	
}

#ERRMODE_WARNING
#Muestra un error en la pantalla y no muestra el mensaje. Continua con la ejecución del código
try {
	$DBH = new PDO("mysql:host=localhost;dbname=test", "root", "");
	$DBH->setAttribute( PDO::ATTR_ERRMODE, PDO::ERRMODE_WARNING );
	#UH-OH! Typed DELECT instead of SELECT!
	$STM = $DBH->prepare('DELECT nombre FROM personas');
	$STM->execute();
}catch(PDOException $e) {
	echo "Te has equivocado, pusiste mal la palabra SELECT. Sorry bro.";
	
}

?>