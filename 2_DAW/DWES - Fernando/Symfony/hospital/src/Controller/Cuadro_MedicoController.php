<?php
// src/Controller/Cuadro_MedicoController.php
namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

use Symfony\Component\Routing\Annotation\Route;

use Doctrine\ORM\EntityManagerInterface;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;

use App\Entity\Especialidad;

class Cuadro_MedicoController extends AbstractController
{
	/**
     * @Route("/cuadro_medico",  name="cuadro_medico")
     */
	public function cuadro_medico()
    {
        $especialidades = $this->getDoctrine()
        ->getRepository(Especialidad::class)
        ->findAll();

        $medico_especialidad = array();

        foreach($especialidades as $especialidad){
            $medico_especialidad[$especialidad->getNombre()] = $especialidad->getMedicos();
        }

        return $this->render('menu/cuadro_medico.html.twig',array('medico_especialidad'=>$medico_especialidad));
    }    
}