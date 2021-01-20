<?php
#ERRMODE_EXCEPTION
	$DBH = new PDO("mysql:host=localhost;dbname=test", "root", "");
	$DBH->setAttribute( PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION );
	#UH-OH! Typed DELECT instead of SELECT!
	$STM = $DBH->prepare('DELECT nombre FROM personas');
	$STM->execute();

	echo "LLego a fin.";
?>