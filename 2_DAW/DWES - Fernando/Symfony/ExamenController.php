<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;

use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\SearchType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\Extension\Core\Type\MoneyType;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;

use App\Entity\Alumno;
use App\Entity\Asignatura;
use App\Entity\Calificacion;
use App\Entity\Curso;

class ExamenController extends AbstractController
{
    /**
     * @Route("/cursos", name="cursos")
     */
    public function cursos()
    {
        $cursos = $this->getDoctrine()
        ->getRepository(Curso::class)
        ->findAll();

        return $this->render('examen/cursos.html.twig', [
            'cursos' => $cursos,
        ]);
    }

    /**
     * @Route("/asignaturas/{id}", name="asignaturas")
     */
    public function asignaturas( $id )
    {
        $alumnos = $this->getDoctrine()
        ->getRepository(Alumno::class)
        ->findBy( array( 'curso' => $id ) );
        // ->findAll();

        // $calificaciones = $this->getDoctrine()
        // ->getRepository(Calificacion::class)
        // // ->findBy( array( 'curso' => $id ) );
        // ->findAll();

        $asignaturas = array();
        $calificaciones = array();

        foreach( $alumnos as $alumno )
        {
            $calificaciones = $alumno->getCalificacions();
        }

        foreach( $calificaciones as $calificacion )
        {
            $asignaturas = $calificacion->getAsignatura();
        }

        // foreach ( $calificaciones as $calificacion )
        // {
        //     $asignaturas = $calificacion->getAsignatura();
        // }

        return $this->render('examen/asignaturas.html.twig', [
            'asignaturas' => $calificaciones,
        ]);
    }

    /**
     * @Route("/curso/{curso_id}/asignatura/{asignatura_id}", name="calificaciones")
     */
    public function calificaciones( $curso_id, $asignatura_id )
    {
        return $this->render('examen/asignaturas.html.twig', [
            'asignaturas' => 'a',
        ]);
    }

    /**
     * @Route("/curso/calificaciones/{id}", name="calificaciones_2")
     */
    public function calificaciones_2( $id, Request $request )
    {
        $notas = array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        $calificaciones = $this->getDoctrine()
        ->getRepository(Calificacion::class)
        ->findBy( array( 'asignatura' => $id ) );

        $formBuilder = $this->createFormBuilder();

        foreach( $calificaciones as $calificacion)
        {
            $formBuilder->add('evaluacion1' . $calificacion->getId(), TextType::class, [
                'label' => $calificacion->getAlumno()->getNombre() . " evaluacion 1 ",
                'data' => $calificacion->getEvaluacion1()
            ])
            ->add('evaluacion2' . $calificacion->getId(), TextType::class, [
                'label' => $calificacion->getAlumno()->getNombre() . " evaluacion 2 ",
                'data' => $calificacion->getEvaluacion2()
            ])
            ->add('evaluacion3' . $calificacion->getId(), TextType::class, [
                'label' => $calificacion->getAlumno()->getNombre() . " evaluacion 3 ",
                'data' => $calificacion->getEvaluacion3()
            ])
            ;

            
        }

        $formBuilder->add('Actualizar', SubmitType::class);

        $form = $formBuilder ->getForm();

        $form->handleRequest( $request );
        if ($form->isSubmitted() && $form->isValid()) {
            $data = $form->getData();
           
            foreach( $calificaciones as $calificacion )
            {           
                if( isset( $data[ 'evaluacion1' . $calificacion->getId()])) 
                {
                    $calificacion->setEvaluacion1( $data[ 'evaluacion1' . $calificacion->getId()]);
                }
                if( isset( $data[ 'evaluacion2' . $calificacion->getId()])) 
                {
                     $calificacion->setEvaluacion2( $data[ 'evaluacion2' . $calificacion->getId()]);
                }
                if( isset( $data[ 'evaluacion3' . $calificacion->getId()])) 
                {
                     $calificacion->setEvaluacion3( $data[ 'evaluacion3' . $calificacion->getId()]);
                }
                
                $em = $this->getDoctrine()->getManager();
                $em->persist( $calificacion );
                $em->flush();
            }
            
            
            return $this->redirectToRoute('calificaciones_2', array('id' => $id));
        }
        else
        {
            
            return $this->render('examen/calificaciones.html.twig', array('form' => $form->createView()));
            
        }
    }
}
