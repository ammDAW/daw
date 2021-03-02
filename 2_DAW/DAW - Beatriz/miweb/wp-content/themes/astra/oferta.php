<?php 
/**  
* Template Name: Oferta  
*/ ?>

<?php get_header(); ?>
<div id="primary" class="content-area">
		<main id="main" class="site-main" role="main">

		<?php
    global $wpdb;
    // $_GET['id']
    $id = $wp_query->query_vars['id'];
		$sql = sprintf( "SELECT * from wp_ofertas where oferta_id= %d", $id );
		//printf( $sql );
		$registros = $wpdb->get_results( $sql );

		printf("Oferta %d", $registros[0]->oferta_id );
		printf("Descripcion %s", $registros[0]->oferta );
		printf("Finaliza %s", $registros[0]->fecha_fin );

		?>
		</main><!– .site-main –></div>
<!– .content-area –>
<?php get_footer(); ?>