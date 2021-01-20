<?php
$cont=0;
$num=2;
while($cont<100){
	$primo=true;
	for($i=2;$i<$num/2 && $primo; $i++){
		if($num % $i ==0) $primo=false;
	}
	if($primo){
		$cont++;
		echo $num."<br";
	}
	$num++;
}
?>