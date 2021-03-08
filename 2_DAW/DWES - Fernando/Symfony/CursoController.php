<?php

namespace App\Controller;

use App\Entity\Alumno;
use App\Entity\Asignatura;
use App\Entity\Calificacion;
use App\Entity\Cita;
use App\Entity\Curso;
use App\Entity\Encuesta;
use App\Entity\Pregunta;
use App\Entity\Respuesta;
use App\Entity\RespuestaPersona;
use App\Entity\Puesto;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\DateType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\EmailType;
use Symfony\Component\Form\FormBuilder;
use Symfony\Component\Form\Test\TypeTestCase;
use Symfony\Component\Validator\Constraints\Choice;

class cursoController extends AbstractController
{
  /**
   * @Route("/curso", name="curso")
   */
  public function curso()
  {
    $cursos = $this->getDoctrine()
        ->getRepository(Curso::class)
        ->findAll();

    return $this->render('curso.html.twig', [
        'cursos' => $cursos,
    ]);
  }

    /**
   * @Route("/cursoInfo/{id}", name="cursoInfo")
   */
  public function cursoInfo($id)
  {
    $cursos = $this->getDoctrine()
    ->getRepository(Curso::class)
    ->find($id);
    

    $alumnosCurso = $cursos->getAlumnos();
    $x = array();

    foreach ($alumnosCurso as $alumno) {
        foreach ($alumno->getCalificaciones() as $calificacion) {
        $x[$calificacion->getAsignatura()->getId()] = $calificacion->getAsignatura()->getAsignatura();
        }
    }

    //aqui se pasa al twig y se muestran
    return $this->render('cursoInfo.html.twig', [
        'x'=>$x
    ]);
  }

      /**
   * @Route("/asginaturaEdit/{id}", name="asginaturaEdit")
   */
  public function asginaturaEdit(Request $request,$id)
  {
    $asignaturas = $this->getDoctrine()
        ->getRepository(Asignatura::class)
        ->find($id);

      
        $formBuilder = $this->createFormBuilder();
        $infoAlumno = array();
        $infoAsignaturas1 = array(1,2,3,4,5,6,7,8,9,10);

        $calificaciones = $asignaturas->getCalificaciones();

        foreach ($calificaciones as $calificacion) {
            $infoAlumno[$calificacion->getAlumno()->getNombre()] = $calificacion->getAlumno()->getId();
        }

        foreach ($calificaciones as $calificacion) {
            $infoEv1[$calificacion->getEvaluacion1()] = $calificacion->getAlumno()->getId();
            $infoEv2[$calificacion->getEvaluacion2()] = $calificacion->getAlumno()->getId();
            $infoEv3[$calificacion->getEvaluacion3()] = $calificacion->getAlumno()->getId();
        }



        //var_dump($infoNotas);

        foreach ($calificaciones as $calificacion) {
        $formBuilder->add('Nombre:' . $calificacion->getAlumno()->getId(), ChoiceType::class, [
            'choices'  => 
                $infoAsignaturas1, 'data'=>$calificacion->getEvaluacion1(),
        ]);
        }
          
          $formBuilder->add('anhadirPregunta', SubmitType::class,  ['label' => 'Actualizar nota']);
      
          $form = $formBuilder->getForm();
          $form->handleRequest($request);

          if ($form->isSubmitted() && $form->isValid()) {
            $data = $form->getData();
            $asingatura = $this->getDoctrine()->getRepository(Asignatura::class)->find($data['asignatura']);
            $alumno = $this->getDoctrine()->getRepository(Alumno::class)->find($data['alumno']);
            $calificacionPersona = new Asignatura();
            $calificacionPersona->setEvaluacion1($data['ev1']);
            $calificacionPersona->setEvaluacion2($data['ev2']);
            $calificacionPersona->setEvaluacion3($data['ev3']);
            $calificacionPersona->setAlumno($alumno);
            $calificacionPersona->setAsignatura($asingatura);
            $calificacionPersona->setCalificacion($data['calificacion']);
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($calificacionPersona);
            $entityManager->flush();
        }
    
    //aqui se pasa al twig y se muestran
    return $this->render('asginaturaEdit.html.twig', [
        'form' => $form->createView()
    ]);

}
}
