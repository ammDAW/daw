<?php
// Especificar correctamente el path al archivo class.phpmailer.php
require('./PHPMailer/class.SMTP.php');
require('./PHPMailer/class.phpmailer.php');
require("Database.php" );
require("db.php" );

function enviarCorreo($clientes){
	$mail = new PHPMailer();
	$body = "Prueba de envio"; // Cuerpo del mensaje
	$mail->IsSMTP(); // Usar SMTP para enviar
	$mail->SMTPDebug = 0; // habilita información de depuración SMTP (para pruebas)
	// 1 = errores y mensajes
	// 2 = sólo mensajes
	$mail->SMTPAuth = true; // habilitar autenticación SMTP
	$mail->Host = "smtp.1and1.es"; // establece el servidor SMTP
	$mail->Port = 587; // configura el puerto SMTP utilizado 25
	$mail->Username = "prueba@iesjoseplanes.es"; // nombre de usuario UGR
	$mail->Password = "mypassword"; // contraseña del usuario UGR

	foreach($clientes as $cliente){
		$body = "¡Feliz 2021!";
			
		$mail->SetFrom('usuario', 'Nombre y Apellidos, etc.');
		$mail->Subject = "Newsletter";
		$mail->MsgHTML($body); // Fija el cuerpo del mensaje
		$address = $cliente["EMAIL"]; // Dirección del destinatario
		$mail->AddAddress($address, $cliente["USUARIO"]);
		//$mail->AddAttachment( 'factura.pdf' , 'factura.pdf' );

		if(!$mail->Send())
			echo "Error: " . $mail->ErrorInfo;
		else
			echo "¡Mensaje enviado!";	
	}
}

$sql = "SELECT * FROM newsletter_usuarios WHERE estatus = 1";
$datos = SQLquery($sql);
enviarCorreo($datos)
?>