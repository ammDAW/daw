<?php
// Especificar correctamente el path al archivo class.phpmailer.php
require_once('./PHPMailer/class.SMTP.php');
require_once('./PHPMailer/class.phpmailer.php');

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
 
 
$body = "Texto del mensaje";
	
$mail->SetFrom('usuario', 'Nombre y Apellidos, etc.');
$mail->Subject = "Asunto del mensaje";
$mail->MsgHTML($body); // Fija el cuerpo del mensaje

$address = "frm666@gmail.com"; // Dirección del destinatario
$mail->AddAddress($address, "Nombre del destinatario");
$mail->AddAttachment( 'factura.pdf' , 'factura.pdf' );

if(!$mail->Send())
	echo "Error: " . $mail->ErrorInfo;
else
	echo "¡Mensaje enviado!";
?>