﻿<?php
#ERRMODE_SILENT
	$DBH = new PDO("mysql:host=localhost;dbname=test", "root", "");
	$DBH->setAttribute( PDO::ATTR_ERRMODE, PDO::ERRMODE_WARNING );
	#UH-OH! Typed DELECT instead of SELECT!
	$STM = $DBH->prepare('DELECT nombre FROM personas');
	$STM->execute();

	echo "Llego a fin.";
	

?>