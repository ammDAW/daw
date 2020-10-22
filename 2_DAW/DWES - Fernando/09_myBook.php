<?php
	$myBook = array();
	$myBook["title"]="The Grapes of Wrath";
	$myBook["author"]="John Steinbeck";
	$myBook["pubYear"]="1939";
	$myBook[]=1939;
	print_r($myBook);
	
	$myarray= array(3,3,3,3,2,12,1);
	for($i=0; $i<count($myarray);$i++)
		echo "<br>".$myarray[$i];
	
	foreach($myarray as $key=>$value)
		echo "<br>key ".$key." => "." value ".$value;
		
	foreach($myarray as $item)
		echo "<br> item ".$item;

?>