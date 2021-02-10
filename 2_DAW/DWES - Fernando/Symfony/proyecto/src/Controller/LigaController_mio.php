<?php
namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

use App\Entity\Jornada;
use App\Entity\Equipo;
use App\Entity\Partido;

/**
 * @Route("/liga")
 */
class LigaController extends AbstractController{
    /**
     * @Route("/clasificacion", name="liga_clasificacion")
     */
    public function clasificacion(){
			$equipos = $this->getDoctrine()
			->getRepository(Equipo::class)
			->findAll();
			
			$puntos = array();
			foreach ($equipos as $item){
				$puntos[$item->getId()]=0;
			}
			
			$partidos = $this->getDoctrine()
			->getRepository(Partido::class)
			->findAll();
		
		return $this->render('liga/index.html.twig', [
            'controller_name' => 'LigaController',
        ]);
    }
}
?>
