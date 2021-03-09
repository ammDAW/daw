<?php
// src/Controller/Cuadro_MedicoController.php
namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

use Symfony\Component\Routing\Annotation\Route;

use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextType;

use Doctrine\ORM\EntityManagerInterface;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;

use App\Entity\Conferencia;
use App\Entity\Congresista;
use App\Repository\CongresistaRepository;

class ConferenciaController extends AbstractController{
	/**
     * @Route("/conferencias",  name="listar_conferencias")
     */
	public function conferencias(){
        $conferencias = $this->getDoctrine()
        ->getRepository(Conferencia::class)
        ->findAll();

        return $this->render('conferencias/conferencias.html.twig',array('conferencias'=>$conferencias));
    } 
    
    /**
     * @Route("/suscribir_conferencia/{id}",  name="suscribir_conferencia")
     */
    public function suscribir_conferencia(Request $request, $id ){
        $conferencia = $this->getDoctrine()
        ->getRepository(Conferencia::class)
        ->findOneById($id);

        $defaultData = array();
        $form = $this->createFormBuilder( $defaultData )
        ->add('nombre', TextType::class )
        ->add('apellidos', TextType::class)
        ->add('nif', TextType::class)
        ->add('telefono', TextType::class)
        ->add('Send', SubmitType::class)
        ->getForm();

        $form->handleRequest( $request );
        if ($form->isSubmitted() && $form->isValid()) {
            // array con valores form field => value
            $data = $form->getData();
                      
            $congresista = new Congresista();
            $congresista->setNombre($data[ 'nombre' ]);
            $congresista->setApellidos($data[ 'apellidos' ]);
            $congresista->setNif($data[ 'nif' ]);
            $congresista->setTelefono($data[ 'telefono' ]);
            $congresista->addConferencia($conferencia);
           
            $em = $this->getDoctrine()->getManager();
            $em->persist($congresista);
            $em->flush();

            return $this->redirectToRoute('listar_conferencias');
        }
        else
            return $this->render('conferencias/suscribir_conferencia.html.twig', array('form' => $form->createView(),));
    }
    /**
     * @Route("/congresista",  name="listar_congresista")
     */
        public function congresista(Request $request, CongresistaRepository $CongresistaRepository){
            $defaultData = array();
            $form = $this->createFormBuilder( $defaultData )
            ->add('nif', TextType::class)
            ->add('telefono', TextType::class)
            ->add('Send', SubmitType::class)
            ->getForm();

            $form->handleRequest( $request );
            if ($form->isSubmitted() && $form->isValid()) {
                $data = $form->getData();
                $conferencias = $CongresistaRepository->findCongresistaConferencia($data[ 'nif' ], $data[ 'telefono' ] );
                //$congresista_id = $CongresistaRepository->findCongresistaId($data[ 'nif' ], $data[ 'telefono' ] );
                //return $this->render('conferencias/borrar_conferencia.html.twig', array('conferencias'=>$conferencias), $congresista_id);
                return $this->render('conferencias/conferencias_congresista.html.twig', array('conferencias'=>$conferencias));
                
                
            }
            else

            return $this->render('conferencias/congresista.html.twig', array('form' => $form->createView(),));
        }
    /**
     * @Route("/borrar_conferencia/{congresista}/{id}",  name="borrar_conferencia")
     */
    public function borrar_conferencia(Request $request, $congresista, $id ){
        $conferencias = $CongresistaRepository->removeConferenciaCongresista($id, $congresista );
        if ($conferencias > 0){
            return new Response( "El congresista ya no está inscrito en la conferencia");
        }

    }

    
    /*public function conferencias(){
        $conferencias = $this->getDoctrine()
        ->getRepository(Conferencia::class)
        ->findAll();

        $defaultData = array();
        $form = $this->createFormBuilder( $defaultData )
        foreach($conferencias as $conferencia){
        ->add('aforo')

        }
        

        return $this->render('conferencias/conferencias.html.twig',array('conferencias'=>$conferencias));
    }*/  

}