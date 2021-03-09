<?php
// src/Controller/ServicioController.php
namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

use Symfony\Component\Routing\Annotation\Route;

use Doctrine\ORM\EntityManagerInterface;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use Doctrine\Common\Collections\ArrayCollection;

use App\Entity\Alumno;
use App\Entity\Asignatura;
use App\Entity\Calificacion;
use App\Entity\Curso;
use App\Repository\CursoRepository;

class CursoController extends AbstractController{
	/**
     * @Route("/alberto/cursos",  name="cursos")
     */
	public function curso(){
        $cursos = $this->getDoctrine()
        ->getRepository(Curso::class)
        ->findAll();

        return $this->render('alberto/cursos.html.twig', [
        'cursos' => $cursos]);
    }

    /*public function __construct(CursoRepository $cursoRepository)
    {
           $this->cursoRepository = $cursoRepository;
    }

    public function asignaturas(Request $request, $id){
        $a = $this->cursoRepository->findCategory($id)
        return $this->render('alberto/asignaturas.html.twig', array('a'=>$a));
    }*/

    /**
     * @Route("alberto/asignaturas/{id}", name="asignaturas")
     */
    public function asignaturas(Request $request, $id){
        $cursos= $this->getDoctrine()
        ->getRepository(Curso::class)
        ->findOneById($id);

        //$a = new ArrayCollection();
        $a = array();
        foreach( $cursos->getAlumnos() as $alumno){
            foreach($alumno->getCalificaciones() as $calificacion){
                /*$a[] = $calificacion->getAsignatura();*/
                foreach($calificacion->getAsignatura() as $asignatura){
                    $a[] = $calificacion->getAsignatura();  
                } 
            }  
		}
        return $this->render('alberto/asignaturas.html.twig', array('a'=>$a));
    }
}
