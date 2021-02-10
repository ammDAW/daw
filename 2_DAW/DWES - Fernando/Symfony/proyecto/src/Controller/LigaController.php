<?php
// src/Controller/LigaController.php
namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;


//clases
use App\Entity\Jornada;
use App\Entity\Equipo;
use App\Entity\Partido;

/**
 * @Route("/liga")
 */

class LigaController extends AbstractController
{
	/**
	 * @Route("/clasificacion", name="liga_clasificacion")
	 */
	public function clasificacion(): Response
	{
		$equipos = $this->getDoctrine()
		->getRepository(Equipo::class)
		->findAll();

		$partidos = $this->getDoctrine()
		->getRepository(Partido::class)
		->findAll();


		foreach ($equipos as $item) {
			$puntos[ $item->getId() ] = 0;
			$teams[ $item->getId() ] = $item->getEquipo();
		}

		foreach ($partidos as $item) {
			if ($item->getMarcadorLocal() > $item->getMarcadorVisitante()) {
				$puntos [ $item->getLocal()->getId() ] += 3;
			}
			elseif ( $item->getMarcadorVisitante() > $item->getMarcadorLocal()) {
				$puntos [ $item->getVisitante()->getId() ] += 3;
			}
			else {
				$puntos [ $item->getLocal()->getId() ] += 1;
				$puntos [ $item->getVisitante()->getId() ] += 1;
			}
		}

		array_multisort ( $puntos, SORT_DESC, $teams);
		for ( $i = 0; $i < count( $puntos ); $i++) {
			$clasificacion[] = array(
				'equipos' => $teams[$i],
				'puntos' => $puntos[$i] );
		}

		return $this->render('liga/clasificacion.html.twig', [ 'clasificacion' => $clasificacion ]);
	}
}