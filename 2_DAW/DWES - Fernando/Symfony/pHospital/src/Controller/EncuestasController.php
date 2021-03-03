<?php
// src/Controller/ServicioController.php
namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;

use Symfony\Component\Routing\Annotation\Route;

use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;

use Doctrine\ORM\EntityManagerInterface;

use App\Entity\Encuesta;
use App\Entity\Pregunta;
use App\Entity\Respuesta;
use App\Entity\Resultado;

class EncuestasController extends AbstractController{
	/**
     * @Route("/encuestas",  name="encuestas")
     */
	public function encuestas(){
        $encuestas = $this->getDoctrine()
        ->getRepository(Encuesta::class)
        ->findAll();

        return $this->render('menu/encuestas.html.twig', [
        'encuestas' => $encuestas]);
    }
    
    /**
     * @Route("/encuestas/{id}", name="preguntas")
     */
    public function preguntas( Request $request, $id ){
        $builder = $this->createFormBuilder();

        $encuesta= $this->getDoctrine()
        ->getRepository(Encuesta::class)
        ->findOneById( $id );

        foreach( $encuesta->getPreguntas() as $pregunta ){
			$respuestas = array();
			foreach( $pregunta->getRespuestas() as $respuesta   ){
				$respuestas[$respuesta->getRespuesta()] =  $respuesta->getId();
			}
			
			$builder->add("pregunta"  . $pregunta->getId(), ChoiceType::class, array( 
				'choices'  => $respuestas,
				'label' => $pregunta->getPregunta(),
				'expanded' => true) //esto es para convertirlo en desplegable
			);	
		}

        $builder->add('Send', SubmitType::class);
		$form = $builder->getForm();
	 	$form->handleRequest( $request );

        if ($form->isSubmitted() && $form->isValid()) {
        $data = $form->getData();
        foreach( $data as $key => $value ){    
            if( strpos($key, "pregunta") !== false ){
                $respuesta= $this->getDoctrine()
                            ->getRepository(Respuesta::class)
                            ->findOneById( $value );
                $resultado = new Resultado();
                $resultado->setRespuesta( $respuesta );
                $em = $this->getDoctrine()->getManager();
                $em->persist( $resultado );
                $em->flush();
            }                           
        }
        return $this->redirectToRoute('menu_inicio');
    }
    else
        return $this->render('menu/pregunta_respuesta.html.twig', 
            array('form' => $form->createView()));
    }
}