<?php

$a = 5;
$b = 2;
$c = 3;

//incompleto
if($a==0){
	if($b==0){
		echo "No hay solucion";
	}
	else{
		$solucion = -$c/$b;
	}
}
else{
	if($b ==0){
		$solucion = sqrt($c/$a);
		echo $solucion;
		echo -$solucion;
	}
	else{
		if($c == 0){
			echo 0;
			echo -$b/$a;
		}
		else{
			//esto es la ecuacion
			$discriminante = pow($b,2)-4*$a*$c;
			if($discriminante){
				$resultado1 = (-$b+(sqrt($discriminante)))/(2*$a);
				$resultado2 = (-$b-(sqrt($discriminante)))/(2*$a);
			}
		}
	}	
}

$discriminante = pow($b,2)-4*$a*$c;
$resultado1 = (-$b+(sqrt($discriminante)))/(2*$a);
$resultado2 = (-$b-(sqrt($discriminante)))/(2*$a);

echo "Resultado 1 = ".$resultado1;
echo "Resultado 2 = ".$resultado2;
?>