
<a href="querystring.php?parametro1=1&parametro2=2">Uno</a>
<a href="querystring.php?parametro1=3&parametro2=4">Dos</a>

<?php
	if(isset($_GET['parametro1']) && isset($_GET['parametro2'])){
		echo "<br> parametro " . $_GET['parametro1']; 	//forma 1 de escribir el echo
		echo "<br>".'parametro ' . $_GET['parametro2']; //forma 2 de escribir el echo
	}
?>