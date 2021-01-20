<?php
//src/Controller/ProductoController.php
namespace App\Controller;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

use App\Entity\Product;
use Doctrine\ORM\EntityManagerInterface;


//@Route("/producto")
class ProductoController extends AbstractController{
    //@Route("/listar", name="producto_listar" )
	public function listar() {
        /*
         * Repositorio de la entidad
         * (si no creamos uno y le metemos métodos propios
         * solamente tendrá los métodos de la clase de la entidad)
         */
        $productos = $this->getDoctrine()
						->getRepository(Product::class)
						->findAll();

		if (!$productos) {
			throw $this->createNotFoundException('No product found for id ');
		}
		else{
			return $this->render('producto/listar.html.twig', [
								'productos' => $productos ]);
		}
    }
	
	//@Route("/show/{id}", name="producto_show" )
	public function show($id) {
        $producto = $this->getDoctrine()
						->getRepository(Product::class)
						->find($id);

		if (!$producto) {
			throw $this->createNotFoundException('No product found for id ');
		}
		else{
			return $this->render('producto/show.html.twig', [
								'producto' => $producto ]);
		}
    }
	
    //@Route("/delete/{id}", name="producto_delete" )
	public function delete($id) {
         $producto = $this->getDoctrine()
						->getRepository(Product::class)
						->find( $id );
		
		if (!$producto) {
			throw $this->createNotFoundException('No product found for id ');
		}
		else{
			$entityManager = $this->getDoctrine()->getManager();
            
			$entityManager->remove($producto);
			$entityManager->flush();
			
			return $this->render('msg.html.twig', [
            'msg' => 'El registro ha sido borrado' ]);
		}
    }
	
	//@Route("/update/{id}", name="producto_update" )
	public function update($id) {
         $producto = $this->getDoctrine()
						->getRepository(Product::class)
						->find( $id );
		
		if (!$producto) {
			throw $this->createNotFoundException('No product found for id ');
		}
		else{
			$entityManager = $this->getDoctrine()->getManager();
            
			$producto->setName("tuerca" );
			$producto->setPrice(20);
			$producto->setDescription("tuerca 3mm");
			$entityManager->persist($producto);
			$entityManager->flush();
			
			return $this->render('msg.html.twig', [
            'msg' => 'El registro ha sido actualizado' ]);
		}
    }
}
?>