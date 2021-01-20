<?php
$cont=0;
$num=2;
$suma=0;
while($cont<3){
	$suma=0;
	for($i=1;$i<$num;$i++){
		if(($num%$i)==0){
			$suma+=$i;
		}
	}
	if($num==$suma) {
		echo $num."<br>";
		$cont++;
	}
	$num++;
}
?>