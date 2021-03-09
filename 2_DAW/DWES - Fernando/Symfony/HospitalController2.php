<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;


use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;
use Symfony\Component\HttpFoundation\RedirectResponse;

// Include paginator interface
use Knp\Component\Pager\PaginatorInterface;



//clases
use App\Entity\Especialidades;
use App\Entity\Medicos;
use App\Entity\Puesto;
use App\Entity\Citas;
use App\Entity\Encuesta;
use App\Entity\Pregunta;
use App\Entity\Respuesta;
use App\Entity\Resultado;
use App\Entity\Servicios;
use App\Entity\Bolsa;
use App\Entity\Menu;
use App\Entity\MenuLogeado;
use App\Entity\Footer;
use App\Entity\User;

/**
 * @Route("/")
 */
class HospitalController extends AbstractController
{
    /**
     * @Route("/hospital", name="hospital")
     */
    public function index(): Response
    {
        return $this->render('contenido/inicio.html.twig', [
            'controller_name' => 'HospitalController',
        ]);
    }

    /**
     * @Route("/cuadroMedico", name="hospital_cuadroMedico")
     */
    public function cuadroMedico(Request $request, PaginatorInterface $paginator)
    {
        $especialidades = $this->getDoctrine()
		->getRepository(Especialidades::class)
		->findAll();
        
        //Aquí estamos juntando los médicos de una tabla, 
        // Con las especialidades de otra, como eso está en una tabla en la DB
        // Symfony lo une solo con el foreach de abajo, pasandole el nombre y asignandole la especialidad
        $medicos_especialidades = array();
        foreach ($especialidades as $especialidad) {
            $medicos_especialidades [$especialidad->getEspecialidad()] = $especialidad->getMedicos();
        }

        // Paginate the results of the query
        $medicos_especialidades = $paginator->paginate(
            // Doctrine Query, not results
            $medicos_especialidades,
            // Define the page parameter
            $request->query->getInt('page', 1),
            // Items per page
            2
        );

        return $this->render('contenido/cuadroMedico.html.twig', [
            'medicos_especialidades' => $medicos_especialidades 
        ]);
    }


    /**
     * @Route("/citas", name="hospital_citas")
     */
    public function citas(Request $request)
    {
        $defaultData = array();
        $form = $this->createFormBuilder($defaultData)
            ->add('especialidad', EntityType::Class, [
                'class' => Especialidades::Class,
                'choice_label' => function($especialidad) {
                    return $especialidad->getEspecialidad();
                }
            ])
            ->add('dni', TextType::Class)
            ->add('nombre', TextType::Class)
            ->add('direccion', TextType::Class)
            ->add('telefono', TextType::Class)
            ->add('email', TextType::Class)
            ->add('texto', TextareaType::Class)
            ->add('send', SubmitType::Class, [
                'attr' => ['type' => 'button','class' => 'btn btn-primary']])
            ->getForm();
            
        $form->handleRequest( $request);
        if ($form->isSubmitted() && $form->isValid()) {
            $data = $form->getData();

            $cita = new Citas();

            $cita->setEspecialidad($data['especialidad']);
            $cita->setDni($data['dni']);
            $cita->setNombre($data['nombre']);
            $cita->setDireccion($data['direccion']);
            $cita->setTelefono($data['telefono']);
            $cita->setEmail($data['email']);
            $cita->setTexto($data['texto']);

            $em = $this->getDoctrine()->getManager();
            $em->persist( $cita );
            $em->flush();
            return $this->redirectToRoute('hospital');
        }else{
            return $this->render('contenido/citas.html.twig', 
                array('form' => $form->createView()));
        }
    }

    /**
     * @Route("/encuestas", name="hospital_encuestas")
     */
    public function encuestas()
    {
        $encuestas = $this->getDoctrine()
		->getRepository(Encuesta::class)
		->findAll();
        
        
        return $this->render('contenido/encuestas.html.twig', [
            'encuestas' => $encuestas 
        ]);
    }


    /**
     * @Route("/resultadoEncuestas/{id}", name="hospital_resultadoEncuestas")
     */
    public function resultadoEncuestas( $id )
    {
        $encuesta= $this->getDoctrine()
        ->getRepository(Encuesta::class)
        ->findOneById( $id );

        $preguntas = $encuesta->getPreguntas();
        $preguntasRespuestas = array();

        foreach($preguntas as $pregunta) {
            $preguntasRespuestas[ $pregunta->getPregunta() ] = $pregunta->getRespuestas();
        }
        
        return $this->render('contenido/resultadoEncuestas.html.twig', [
            'encuestas' => $encuestas 
        ]);
    }


    /**
     * @Route("/encuestas/{id}", name="hospital_preguntas")
     */
    public function preguntas( Request $request, $id )
    {
        $builder = $this->createFormBuilder();

        $encuesta= $this->getDoctrine()
        ->getRepository(Encuesta::class)
        ->findOneById( $id );

        foreach( $encuesta->getPreguntas() as $pregunta )
        {
            $respuestas = array();
            foreach( $pregunta->getRespuestas() as $respuesta   )
            {
                $respuestas[$respuesta->getRespuesta()] =  $respuesta->getId();
    
            }
            
            $builder->add("pregunta"  . $pregunta->getId(), ChoiceType::class, array( 
                'choices'  => $respuestas,
                'label' => $pregunta->getPregunta(),
                'expanded' => true
                )
            );        
        }
        $builder->add('send', SubmitType::Class, [
            'attr' => ['type' => 'button','class' => 'btn btn-primary']]);
        $form= $builder->getForm();
        $form->handleRequest( $request );
        if ($form->isSubmitted() && $form->isValid()) {
			$data = $form->getData();
			foreach( $data as $key => $value )
			{
				
		
				if(  strpos($key, "pregunta" ) !== false )
				{
					$respuesta= $this->getDoctrine()
								->getRepository(Respuesta::class)
								->findOneById( $value );
					$resultado = new Resultado();
					$resultado->setRespuesta( $respuesta );
					$em = $this->getDoctrine()->getManager();
					$em->persist($resultado);
					$em->flush();
				}
								
			}
			return $this->redirectToRoute('hospital');
			
		}else{
            return $this->render('contenido/preguntasRespuestas.html.twig', 
                array('form' => $form->createView()));
        }
    }


    

    


     /**
     * @Route("/servicios", name="hospital_servicios")
     */
    public function servicios()
    {
        $servicios = $this->getDoctrine()
		->getRepository(Servicios::class)
		->findAll();
        
        // Aquí estamos juntando los médicos de una tabla, 
        // Con las especialidades de otra, como eso está en una tabla en la DB
        // Symfony lo une solo con el foreach de abajo, pasandole el nombre y asignandole la especialidad
        $servicios_especialidades = array();
        foreach ($servicios as $servicio) {
            $especialidad = $servicio->getEspecialidad();
            $servicios_especialidades[$servicio->getServicio()] = $especialidad->getMedicos();
        }
        return $this->render('contenido/servicios.html.twig', [
            'servicios_especialidades' => $servicios_especialidades 
        ]);
    }

    
     /**
     * @Route("/bolsa", name="hospital_bolsa")
     */
    public function bolsa(Request $request)
    {
        $defaultData = array();
        $form = $this->createFormBuilder($defaultData)
            
            ->add('dni', TextType::Class)
            ->add('nombre', TextType::Class)
            ->add('direccion', TextType::Class)
            ->add('telefono', TextType::Class)
            ->add('email', TextType::Class)
            ->add('puesto', EntityType::Class, [
                'class' => Puesto::Class,
                'choice_label' => function($puesto) {
                    return $puesto->getPuesto();
                }
            ])
            ->add('send', SubmitType::Class, [
                'attr' => ['type' => 'button','class' => 'btn btn-primary']])
            ->getForm();
            
        $form->handleRequest( $request);
        if ($form->isSubmitted() && $form->isValid()) {
            $data = $form->getData();

            $bolsa = new Bolsa();

            $bolsa->setPuesto($data['puesto']);
            $bolsa->setDni($data['dni']);
            $bolsa->setNombre($data['nombre']);
            $bolsa->setDireccion($data['direccion']);
            $bolsa->setTelefono($data['telefono']);
            $bolsa->setEmail($data['email']);
            

            $em = $this->getDoctrine()->getManager();
            $em->persist( $bolsa );
            $em->flush();
            return $this->redirectToRoute('hospital');
        }else{
            return $this->render('contenido/bolsa.html.twig', 
                array('form' => $form->createView()));
        }
    }

    /**
     * @Route("/menu",  name="menu")
     */
	public function menu()
    {
     
        $menus = $this->getDoctrine()
            ->getRepository(Menu::class)
            ->findAll();


        return $this->render('hospital/menu.html.twig',[
            "menus" => $menus] );
    } 

    /**
     * @Route("/menuLogeado",  name="menuLogeado")
     */
	public function menuLogeado()
    {
        $menuLogeado = $this->getDoctrine()
            ->getRepository(MenuLogeado::Class)
            ->findAll();


        return $this->render('hospital/menuLogeado.html.twig',[
            "menuLogeado" => $menuLogeado] );
    } 

    /**
     * @Route("/footer",  name="footer")
     */
	public function footer()
    {
        $footer = $this->getDoctrine()
            ->getRepository(Footer::Class)
            ->findAll();


        return $this->render('hospital/footer.html.twig',[
            "footer" => $footer ] );
    } 

    
    

    //gestion de los mediocos

     /**
     * @Route("/privado/gestionMedicos",  name="hospital_gestionMedicos")
     */
    public function listarMedicos()
    {
        $medicos = $this->getDoctrine()
            ->getRepository(Medicos::class)
            ->findAll();

        if (!$medicos) {
            throw $this->createNotFoundException(
                'No product found for id ');
        }

        return $this->render('contenido/gestionMedicos.html.twig', array('medicos' => $medicos));
    }

    /**
     * @Route("/privado/editMedico/{id}/{search}", defaults={"search" = null }, name="editMedico")
     */
    public function editMedico(Request $request, $id, $search)
    {

        $session = $request->getSession();

        $medico = $this->getDoctrine()
        ->getRepository(Medicos::class)
        ->findOneById($id);

        if (!$medico) {
            throw $this->createNotFoundException(
                'No item found for id ');
        }

        if (!$session->get('edit_id') || $session->get('edit_id') != $id) {
            $session->set('edit_id', $id);

            $especialidades = array();
            foreach ($medico->getEspecialidades() as $item) {
                $especialidades[] = array('id' => $item->getId(), 'especialidad' => $item->getEspecialidad());
            }
            $session->set('edit_especialidades', $especialidades);
        }

        $lista = array();
       
        // Lista de especialidades
        $lista = array();

        foreach ($session->get('edit_especialidades') as $item) {
            $lista[$item['especialidad']] = $item['id'];
        }

        if (isset($search)) {
           
            $cadena = '%' . $search . '%';
            $em = $this->getDoctrine()->getManager();

            $query = $em->createQuery("SELECT n FROM App:Especialidades n WHERE n.especialidad LIKE :searchterm ")
            ->setParameter('searchterm', $cadena);

            $especialidades = $query->getResult();
        } else {
            $especialidades = $this->getDoctrine()
            ->getRepository(Especialidades::class)
            ->findAll();
        }

        $list = array();
        foreach ($especialidades as $item) {
            $list[$item->getEspecialidad()] = $item->getId();
        }

        $form = $this->createFormBuilder();
        $form->add('id', TextType::class, ['data' => $medico->getId()]);
        $form->add('medico', TextType::class, ['data' => $medico->getNombre()]);
        $form->add('especialidades', ChoiceType::class, ['choices' => $lista, 'multiple' => true, 'required' => false]);

        $form->add('Search', TextType::class, ['data' => isset($search) ? $search : '', 'required' => false]);
        
        $form->add('EspecialidadesNoAsignadas', ChoiceType::class, ['choices' => $list, 'multiple' => true, 'required' => false]);

        $form->add('Add', SubmitType::class);
        $form->add('Remove', SubmitType::class);
        $form->add('Buscar', SubmitType::class);
        $form->add('Save', SubmitType::class);
        $form->add('Delete', SubmitType::class);
        $form = $form->getForm();

        $form->handleRequest( $request );

        if ($form->isSubmitted() && $form->isValid()) {
            $data = $form->getData();
            
            $medico->setNombre($data['medico']);
        

            if ($form->get('Add')->isClicked()) {
                foreach ($data['EspecialidadesNoAsignadas'] as $item) {
                    $especialidad = $this->getDoctrine()
                    ->getRepository(Especialidades::class)
                    ->findOneById( $item );

                    $especialidades = $session->get('edit_especialidades');
                    $especialidades[] = array('id' => $especialidad->getId(), 'especialidad' => $especialidad->getEspecialidad());
                    $session->set('edit_especialidades', $especialidades);
                }


                
                return $this->redirectToRoute('editMedico', ['id' => $data['id']]);
            
            } elseif ($form->get('Remove')->isClicked()) {
                
                $posiciones = array();
                foreach ($data['especialidades'] as $item) {
                    $pos = 0;
                    foreach ($session->get('edit_especialidades') as $elemento) {
                        // printf("</br> %s [%s] [%s]</br> ", $pos, $elemento['id'], $item);
                         if ($elemento['id'] == $item) {
                            // printf("</br> %s [%s] [%s] ok</br> ", $pos, $elemento['id'], $item);
                            $posiciones[] = $pos;
                        }
                        $pos++;
                    }
                }

                //die();
                $especialidades = $session->get('edit_especialidades');
                foreach ($posiciones as $pos) {
                    unset($especialidades[$pos]);
                }
                
                $session->set('edit_especialidades', $especialidades);
                return $this->redirectToRoute('editMedico', ['id' => $data['id']]);
            
            } elseif ($form->get('Buscar')->isClicked()) {
                return $this->redirectToRoute('editMedico', ['id' => $data['id'], 'search' => $data['Search']]);
            
            } elseif ($form->get('Delete')->isClicked()) {
                $em = $this->getDoctrine()->getManager();
                $em->remove($medico);
                $em->flush();
                
                return $this->redirectToRoute('hospital_gestionMedicos');
            
            } elseif ($form->get('Save')->isClicked()) {
                $posiciones = array();
                $pos = 0;
                // Borra las especialidades que no estan en sesion
                foreach ($medico->getEspecialidades() as $item) {
                    if (!in_array($item->getId(), $session->get('edit_especialidades'))) {
                        $posiciones[] = $pos;
                        $pos++;
                    }
                }

                arsort($posiciones); // orden inverso posiciones
                foreach ($posiciones as $pos) {
                    $medico->getEspecialidades()->remove($pos);
                    $em = $this->getDoctrine()->getManager();
                    $em->persist($medico);
                }

                // Añade las especialidades que estan en sesion
                foreach ($session->get('edit_especialidades') as $item) {
                    $especialidad = $this->getDoctrine()
                        ->getRepository(Especialidades::class)
                        ->findOneById($item['id']);
                    if (!$medico->getEspecialidades()->contains($especialidad)) {
                        $medico->addEspecialidades( $especialidad );
                        $em = $this->getDoctrine()->getManager();
                        $em->persist($medico);
                    }
                }

                // Borro Sesion
                //$session->clear();
                $session->remove('edit_especialidades');
                $session->remove('edit_id');

                $em = $this->getDoctrine()->getManager();
                $em->persist($medico);

                $em->flush();
                return $this->redirectToRoute('hospital_gestionMedicos');

            }
        } else {
            return $this->render('contenido/medico.html.twig', array('form' => $form->createView(), "medico" => $medico));
        }

    }

    /**
     * @Route("/privado/newMedico/{search}", defaults={"search" = null }, name="newMedico")
     */
    public function newMedico(Request $request, $search)
    {

        $session = $request->getSession();

        if ($session->get('new_medico') == null) {
            $medico = new Medicos();
            $session->set('new_medico', $medico);
            $session->set('new_especialidades', array());
        } else {
            $medico = $session->get('new_medico');
        }

        $lista = array();
        // Lista de especialidades
        if ($session->get('new_especialidades') != null) {
            foreach ($session->get('new_especialidades') as $item) {
                $lista[$item['especialidad']] = $item['id'];
            }
        }

        // lista de EspecialidadesNoAsignadas
        if (isset($search)) {
            $cadena = '%' . $search . '%';
            $em = $this->getDoctrine()->getManager();
            $query = $em->createQuery("SELECT n FROM App:Especialidades n WHERE n.especialidad LIKE :searchterm ")
                ->setParameter('searchterm', $cadena);
            $EspecialidadesNoAsignadas = $query->getResult();
        } else {
            $EspecialidadesNoAsignadas = $this->getDoctrine()
                ->getRepository(Especialidades::class)
                ->findAll();
        }

        $list = array();
        foreach ($EspecialidadesNoAsignadas as $item) {
            $list[$item->getEspecialidad()] = $item->getId();
        }

        $form = $this->createFormBuilder();
        $form->add('id', TextType::class, ['required' => false]);
        $form->add('medico', TextType::class, ['data' => $medico->getNombre()]);
        $form->add('especialidades', ChoiceType::class, ['choices' => $lista, 'multiple' => true, 'required' => false]);
        $form->add('EspecialidadesNoAsignadas', ChoiceType::class, ['choices' => $list, 'multiple' => true, 'required' => false]);

        $form->add('Search', TextType::class, ['data' => isset($search) ? $search : '', 'required' => false]);

        $form->add('Add', SubmitType::class);
        $form->add('Remove', SubmitType::class);
        $form->add('Buscar', SubmitType::class);
        $form->add('Save', SubmitType::class);
        $form = $form->getForm();

        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $data = $form->getData();
            //AÑADIDO POR MI JEJEJEJEEEEE
            $medico->setMedicoId($data['id']);
            $medico->setNombre($data['medico']);
            if ($form->get('Add')->isClicked()) {
                foreach ($data['EspecialidadesNoAsignadas'] as $item) {
                    $especialidad = $this->getDoctrine()
                        ->getRepository(Especialidades::class)
                        ->findOneById($item);
                    $especialidades = $session->get('new_especialidades');
                    $especialidades[] = array('id' => $especialidad->getId(), 'especialidad' => $especialidad->getEspecialidad());
                    $session->set('new_especialidades', $especialidades);
                }
                $session->set('medico', $medico);
                return $this->redirectToRoute('newMedico');
            } elseif ($form->get('Remove')->isClicked()) {
                
                $posiciones = array();
                foreach ($data['especialidades'] as $item) {

                    $pos = 0;
                    foreach ($session->get('new_especialidades') as $elemento) {
                       
                        if ($item == $elemento['id']) {
                            $posiciones[] = $pos;
                        }
                        $pos++;
                    }
                }
                $especialidades = $session->get('new_especialidades');
                foreach ($posiciones as $pos) {
                    unset($especialidades[$pos]);
                }
                $session->set('new_especialidades', $especialidades);
                $session->set('new_medico', $medico);
                return $this->redirectToRoute('newMedico');
            } elseif ($form->get('Buscar')->isClicked()) {
                $session->set('new_medico', $medico);
                return $this->redirectToRoute('newMedico', ['search' => $data['Search']]);
            } elseif ($form->get('Save')->isClicked()) {

                // Añade los especialidades que estan en sesion
                foreach ($session->get('new_especialidades') as $item) {
                    $especialidad = $this->getDoctrine()
                        ->getRepository(Especialidades::class)
                        ->findOneById($item['id']);
                    $medico->addEspecialidades($especialidad);
                    $em = $this->getDoctrine()->getManager();
                    $em->persist($especialidad);
                    $em->persist($medico);
                }
            }

            // Borro Sesion
            //$session->clear();
            $session->remove('new_especialidades');
            $session->remove('new_medico');

     
            $em = $this->getDoctrine()->getManager();
            $em->persist($medico);
            $em->flush();

            return $this->redirectToRoute('hospital_gestionMedicos');

        } else {
            
            return $this->render('contenido/nuevoMedico.html.twig', array( 'medico' => $medico, 'form' => $form->createView()));
        }

    }

    /**
     * @Route("/error/{error}", defaults={"error" = null }, name="medico_error")
     */
    public function error($error)
    {
      
        return $this->render('contenido/error.html.twig');
    }


}
