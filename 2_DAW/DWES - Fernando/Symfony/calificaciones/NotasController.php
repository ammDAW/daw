<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

use Symfony\Component\Routing\Annotation\Route;

use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;



use App\Entity\Alumno;
use App\Repository\AlumnoRepository;


use App\Entity\Curso;
use App\Repository\CursoRepository;


use App\Entity\Asignatura;
use App\Repository\AsignaturaRepository;

use App\Entity\Calificacion;
use App\Repository\CalificacionRepository;
/**
* @Route("/notas")
*/
class NotasController extends AbstractController
{
   
	/**
     * @Route("/cursos", name="notas_cursos")
     */
    public function cursos( CursoRepository $CursoRepository ): Response
    {
		$cursos =  $CursoRepository->findAll();
		
		
			
        return $this->render('notas/cursos.html.twig', ['cursos' => $cursos ]);
    }
	
	/**
     * @Route("/asignaturas/{id}", name="notas_asignaturas")
     */
    public function asignaturas( CursoRepository $CursoRepository, AsignaturaRepository $AsignaturaRepository, $id , Request $request ): Response
    {
		$curso =  $CursoRepository->find($id);
		
		$asignaturas = $AsignaturaRepository->findAsignaturasCurso($id);
				 
		return $this->render('notas/asignaturas.html.twig' , ['curso' => $curso, 'asignaturas' => $asignaturas ]);
    }
	
	
	/**
     * @Route("/notas/curso/{curso_id}/asignatura/{asignatura_id}", name="notas_alumnos")
     */
    public function notas( CursoRepository $CursoRepository, AsignaturaRepository $AsignaturaRepository, AlumnoRepository $AlumnoRepository, $curso_id, $asignatura_id, Request $request ): Response
    {
		$curso =  $CursoRepository->find($curso_id);
		
		//$asignaturas = $AsignaturaRepository->findAsignaturasCurso($curso_id);
		$asignatura = $AsignaturaRepository->find($asignatura_id);
		$alumnos = $AlumnoRepository->findCursoAsignatura($curso_id, $asignatura_id );
	 
		$builder = $this->createFormBuilder();
        
		$calificaciones = [ '*' => '-1','0' => '0', '1' => '1', '2' =>  '2', '3' =>  '3', '4' =>  '4', '5' =>  '5', '6' => '6', '7' => '7', '8' => '8', '9' => '9','10' => '10' ];
		
		foreach( $alumnos as $alumno )
		{
			// Nombre y Apellidos
			$builder->add('alumno_' . $alumno->getId()  , TextType::class,  
				[
				'data'=> $alumno->getApellidos() . "," .  $alumno->getNombre() , 
				'disabled' =>true,
				]);
				
			foreach( $alumno->getCalificaciones()  as $calificacion )
			{
				
					
					if( $calificacion->getAsignatura() == $asignatura )
					{
						$puntuacion = $calificacion;
						break;
					}
			}
		
			$builder->add('evaluacion1_' . $alumno->getId()  , ChoiceType::class, 
			[
			'choices'  => $calificaciones, 
			'data'=> $puntuacion->getEvaluacion1()==null?'-1': $puntuacion->getEvaluacion1(),
			]);
			$builder->add('evaluacion2_' . $alumno->getId()  , ChoiceType::class, 
			[
			'choices'  => $calificaciones, 
			'data'=> $puntuacion->getEvaluacion2()==null?'-1': $puntuacion->getEvaluacion2(),
			]);
			$builder->add('evaluacion3_' . $alumno->getId()  , ChoiceType::class, 
			[
			'choices'  => $calificaciones, 
			'data'=> $puntuacion->getEvaluacion3()==null?'-1': $puntuacion->getEvaluacion3(),
			]);
			
		}
		$builder->add('save', SubmitType::class, ['label' => 'Save']);
		
		$form = $builder->getForm();
		
		$form->handleRequest( $request );
				        
		if ($form->isSubmitted() && $form->isValid()) {
            
            $data = $form->getData();
			
			$em = $this->getDoctrine()->getManager();
			foreach( $alumnos as $alumno )
			{
				
				foreach( $alumno->getCalificaciones()  as $calificacion )
				{
											
					if( $calificacion->getAsignatura() == $asignatura )
					{
						$puntuacion = $calificacion;
						break;
					}
					
				}
				
				$modificacion = false;	
				if( isset($data['evaluacion1_'. $alumno->getId()]) && $data['evaluacion1_'. $alumno->getId()] == '*' )
				{
					
					$puntuacion->setEvaluacion1(null) ;
					$modificacion = true;
				}
				if( isset($data['evaluacion1_'. $alumno->getId()]) && $data['evaluacion1_'. $alumno->getId()] != '*' )
				{
					
					$puntuacion->setEvaluacion1((int)$data['evaluacion1_'. $alumno->getId()]) ;
					$modificacion = true;
				}
				if( isset($data['evaluacion2_'. $alumno->getId()]) && $data['evaluacion2_'. $alumno->getId()] != '*' )
				{
					$puntuacion->setEvaluacion2((int)$data['evaluacion2_'. $alumno->getId()]) ;
					$modificacion = true;
				}
				if( isset($data['evaluacion3_'. $alumno->getId()]) && $data['evaluacion3_'. $alumno->getId()] != '*' )
				{
					$puntuacion->setEvaluacion3((int)$data['evaluacion3_'. $alumno->getId()]) ;
					$modificacion = true;
				}
				if( $modificacion )
				{
					$em ->persist($puntuacion);
					$em ->flush();	
				}
			}
			
			return $this->redirectToRoute('notas_cursos' );
        }

        		
		
        return $this->render('notas/notas.html.twig', ['form' => $form->createView(), 'curso' => $curso, 'asignatura' => $asignatura, 'alumnos' => $curso->getAlumnos(),  ]);
    }
	
	
}
