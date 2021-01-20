<?php
	//metodo de la burbuja
	//$lista = array(3,4,1,5,2,6);
	$a=[3,4,1,5,2,6];
	$longA=count($a);
	for($i=1;$i<$longA;$i++){
		for($j=0;$j<$longA;$j++){
			if($a[$i]<$a[$j]){
				$aux=$a[$j];
				$a[$j]=$a[$i];
				$a[$i]=$aux;
			}
		}
	}
	for($i=0;$i<$longA;$i++){
		echo $a[$i];
	}
?>