<?php		
	for($i = 0; $i<100; $i++){
		echo "<a href='13_referencia_primos.php?numero={$i}'>{$i}</a><br>";
	}
	if(primo($_GET['numero'])) echo 'Es primo';
	else echo 'No es primo';
	
	function primo($num){
		if($num == 1 || $num == 2 || $num == 3 || $num == 5 || $num == 7) return true;
	
		if($num >= 8 ){
			if ($num%2==0 || $num%3==0 || $num%5==0) return false;
			if ($num%2>=1 || $num%3>=1 || $num%5>=1) return true;
		}
	}
?>