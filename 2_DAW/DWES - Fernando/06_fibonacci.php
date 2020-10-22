<?php
	$num1 = 1;
	$num2 = 1;
	echo $num1."<br>"; //se puede hacer así
	echo "$num2 <br>"; //o así
	for($i = 3; $i<=100; $i++){
		$num3 = $num1+$num2;
		echo $num3."<br>";
		$num1=$num2;
		$num2=$num3;
	}
?>