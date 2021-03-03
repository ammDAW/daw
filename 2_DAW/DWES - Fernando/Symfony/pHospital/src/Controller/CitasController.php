<?php
// src/Controller/CitasController.php
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

use App\Entity\Citas;
use App\Entity\Especialidad;

class CitasController extends AbstractController{ 
    /**
     * @Route("/citas", name="citas")
     */
    public function citas(Request $request){     
        //PREGUNTAR A FERNANDO COMO HACER SIN EL ENTITYPE
        
        /*$especialidades = $this->getDoctrine()
        ->getRepository(Especialidad::class)
        ->findAll();
        
        $defaultData = array();   
        $form = $this->createFormBuilder($defaultData)
        ->add("esp_medica", ChoiceType::class, array( 
            'choices'  => $especialidades->getNombre(),
            'label' => $especialidades,
            'expanded' => false)  
        )*/ 
        $defaultData = array();
        $form = $this->createFormBuilder( $defaultData )
            ->add('esp_medica', EntityType::class, [
                'class' => Especialidad::class,
                'choice_label' => function($especialidad) {
                    return $especialidad->getNombre();
                }
            ])
        ->add('dni', TextType::class)
        ->add('nombre', TextType::class )
        ->add('direccion', TextType::class)
        ->add('telefono', TextType::class)
        ->add('email', TextType::class)
        ->add('info_adicional', TextType::class)
        ->add('Send', SubmitType::class)
        ->getForm();

        //$form = $builder->getForm();
        $form->handleRequest( $request );
        if ($form->isSubmitted() && $form->isValid()) {
            // array con valores form field => value
            $data = $form->getData();
                      
            $cita = new Citas();
            $cita->setEspMedica($data[ 'esp_medica']);
            $cita->setDni($data[ 'dni' ]);
            $cita->setNombre($data[ 'nombre' ]);
            $cita->setDireccion($data[ 'direccion' ]);
            $cita->setTelefono($data[ 'telefono' ]);
            $cita->setEmail($data[ 'email' ]);
            $cita->setInfoAdicional($data[ 'info_adicional' ]);
           
            $em = $this->getDoctrine()->getManager();
            $em->persist($cita);
            $em->flush();
         
            return new Response( "Cita guardada");
        }
        else
            return $this->render('/menu/citas.html.twig', array('form' => $form->createView(),));
    }
}