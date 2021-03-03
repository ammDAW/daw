<?php
// src/Controller/ServicioController.php
namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

use Symfony\Component\Routing\Annotation\Route;

use Doctrine\ORM\EntityManagerInterface;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;

use App\Entity\Servicios;

// Include paginator interface
use Knp\Component\Pager\PaginatorInterface;

class ServiciosController extends AbstractController{
	/**
     * @Route("/servicios",  name="servicios")
     */
public function servicio(Request $request, PaginatorInterface $paginator){
        $servicios = $this->getDoctrine()
        ->getRepository(Servicios::class)
        ->findAll();

        $servicio_especialidad = array();

        foreach($servicios as $servicio){
            $especialidad = $servicio->getEspecialidad();
            $servicio_especialidad[$servicio->getNombre()] = $especialidad->getMedicos();
        }

        $servicio_especialidad = $paginator->paginate(
            $servicio_especialidad,
            $request->query->getInt('page', 1), 
            2
        );

        return $this->render('menu/servicios.html.twig',array('servicio_especialidad'=>$servicio_especialidad));
    }    
}