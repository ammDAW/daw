<?php 
/**  
* Template Name: Ofertas  
*/ 
?>

<?php 
get_header(); 
?>
<div id="primary" class="content-area">
 <main id="main" class="site-main" role="main">

 <?php  global $wpdb;  $registros = $wpdb->get_results( "SELECT * from wp_ofertas" );
 foreach( $registros as $item )
 {
   printf("Oferta %d %s Finaliza %s ", $item->oferta_id , $item->oferta, $item->fecha_fin );
   printf("<a href=\"oferta/?id=%d\">Ver</a>",$item->oferta_id );
 }
 ?>

 </main><!– .site-main –></div>

<!– .content-area –>

<?php get_footer(); ?>