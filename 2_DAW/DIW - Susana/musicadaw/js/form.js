$("#formBoletin").submit(function(evento){
    evento.preventDefault();
    $("#nombre").val("");
    $("#apellidos").val("");
    $("#email").val("");
    $("#consentimiento").prop("checked", false);

    alert ("Formulario enviado. Gracias por suscribirse");
});


