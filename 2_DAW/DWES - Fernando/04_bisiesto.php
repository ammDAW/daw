<?php
$anyo = 1992;
if(($anyo % 4==0)&&(($anyo % 100!=0)||($anyo % 400==0)))
	echo "$anyo es bisiesto";
else 
	echo "$anyo no es bisiesto";
?>