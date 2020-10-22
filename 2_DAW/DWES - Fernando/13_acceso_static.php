<?php
class car{
	public static function calcMpg($miles, $gallons){
		return($miles/$gallons);
	}
}
echo Car::calcMpg(168,6); //Displays "28"

?>