<?php
    if(isset($_POST["textNum1"]) && isset($_POST["textNum2"]) && $_POST["textNum1"]<$_POST["textNum2"])
        $num1=$_GET['textNum1'];
        $num2=$_GET['textNum2'];
        for($i=$num1; $i<=$num2; $i++){
            if(esPrimo($i)) echo $i."<br>";
        }
    }
    else echo "Error!"

    function esPrimo($num){
        if($num == 1 || $num == 2 || $num == 3 || $num == 5 || $num == 7) return true;
        if($num >= 8){
            if ($num%2==0 || $num%3==0 || $num%5==0) return false;
        }
        if($num >= 8){
                if ($num%2>=1 || $num%3>=1 || $num%5>=1) return true;
        }
    }
?>