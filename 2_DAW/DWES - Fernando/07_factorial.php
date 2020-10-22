<?php
	$result=1;
	for($i=100;$i>0;$i--){
		$result=$result*$i;
	}
	echo $result."<br>";
	
	for($i=0; $i<=100;$i++){
		if($i==0) $factorial=1;
		else
			$factorial=$i*$factorial;
	}
	echo $factorial."<br>";	
?>