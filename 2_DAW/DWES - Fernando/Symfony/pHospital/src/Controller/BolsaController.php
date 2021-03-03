<?php
// src/Controller/BolsaController.php
namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;

use Symfony\Component\Routing\Annotation\Route;

use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;

use Doctrine\ORM\EntityManagerInterface;

use App\Entity\Bolsa;
use App\Entity\Puesto;

class BolsaController extends AbstractController{ 
    /**
     * @Route("/bolsa", name="bolsa")
     */
    public function bolsa(Request $request){     
        $defaultData = array();
        $form = $this->createFormBuilder( $defaultData )
        ->add('puesto', EntityType::class, [
            'class' => Puesto::class,
            'choice_label' => function($puesto) {
                return $puesto->getNombre();
            }
        ])
        ->add('dni', TextType::class)
        ->add('nombre', TextType::class )
        ->add('direccion', TextType::class)
        ->add('telefono', TextType::class)
        ->add('email', TextType::class)
        ->add('Send', SubmitType::class)
        ->getForm();

        //$form = $builder->getForm();
        $form->handleRequest( $request );
        if ($form->isSubmitted() && $form->isValid()) {
            // array con valores form field => value
            $data = $form->getData();
                      
            $bolsa = new Bolsa();
            $bolsa->setPuesto($data[ 'puesto']);
            $bolsa->setDni($data[ 'dni' ]);
            $bolsa->setNombre($data[ 'nombre' ]);
            $bolsa->setDireccion($data[ 'direccion' ]);
            $bolsa->setTelefono($data[ 'telefono' ]);
            $bolsa->setEmail($data[ 'email' ]);
           
            $em = $this->getDoctrine()->getManager();
            $em->persist($bolsa);
            $em->flush();
         
            return new Response("Bolsa guardada");
        }
        else
            return $this->render('/menu/bolsa.html.twig', array('form' => $form->createView(),));
    }
}