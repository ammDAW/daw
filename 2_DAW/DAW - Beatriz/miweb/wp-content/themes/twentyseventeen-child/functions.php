<?
function mis_estilos()
{
     wp_enqueue_style( 'child-theme-css', '../twentyseventeen/style.css' );
}
add_action( 'wp_enqueue_scripts', 'mis_estilos' );
php ?>