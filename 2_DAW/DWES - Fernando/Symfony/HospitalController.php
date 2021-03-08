<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Security\Http\Authentication\AuthenticationUtils;
use Doctrine\Common\Collections\ArrayCollection;

use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\SearchType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\Extension\Core\Type\MoneyType;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;

use App\Entity\Bolsa;
use App\Entity\Citas;
use App\Entity\Especialidades;
use App\Entity\Medicos;
use App\Entity\Puesto;
use App\Entity\Encuesta;
use App\Entity\Pregunta;
use App\Entity\Respuesta;
use App\Entity\Resultado;
use App\Entity\Servicios;
use App\Entity\Menu;
use App\Entity\MenuLogueado;
use App\Entity\Footer;

use Knp\Component\Pager\PaginatorInterface;

class HospitalController extends AbstractController
{
    /**
     * @Route("/hospital", name="hospital")
     */
    public function index()
    {
        return $this->render('contenido/inicio.html.twig', [
            'controller_name' => 'HospitalController',
        ]);
    }
    /**
     * @Route("/hospital/cuadro_medico", name="cuadro_medico")
     */
    public function cuadro_medico( Request $request, PaginatorInterface $paginator )
    {
        $especialidades = $this->getDoctrine()
        ->getRepository(Especialidades::class)
        ->findAll();

        $especialidades_medicos = array();

        foreach( $especialidades as $especialidad )
        {
            $especialidades_medicos[ $especialidad->getEspecialidad() ] = $especialidad->getMedicos();
        }

        $especialidades_medicos = $paginator->paginate(
            $especialidades_medicos,
            $request->query->getInt('page', 1), 
            1
        );

        return $this->render('contenido/cuadro_medico.html.twig', [
            'especialidades_medicos' => $especialidades_medicos,
        ]);
    }

    /**
     * @Route("/hospital/servicios", name="servicios")
     */
    public function servicios( Request $request, PaginatorInterface $paginator )
    {
        $servicios = $this->getDoctrine()
        ->getRepository(Servicios::class)
        ->findAll();

        $servicios_especialidades = array();

        foreach( $servicios as $servicio )
        {
            $especialidad = $servicio->getEspecialidad();
            $servicios_especialidades[ $servicio->getServicio() ] = $especialidad->getMedicos();
        }

        $servicios_especialidades = $paginator->paginate(
            $servicios_especialidades,
            $request->query->getInt('page', 1), 
            2
        );

        return $this->render('contenido/servicios.html.twig', [
            'servicios_especialidades' => $servicios_especialidades,
        ]);
    }
    /**
     * @Route("/hospital/citas", name="citas")
     */
    public function citas( Request $request ): Response
    {
        $defaultData = array();

        $form = $this->createFormBuilder( $defaultData )
            ->add('especialidad', EntityType::class, [
                'class' => Especialidades::class,
                'choice_label' => function($especialidad) {
                    return $especialidad->getEspecialidad();
                }
            ])
            ->add('dni', TextType::class)
            ->add('nombre', TextType::class)
            ->add('direccion', TextType::class)
            ->add('telefono', TextType::class)
            ->add('email', TextType::class)
            ->add('texto', TextareaType::class)
            ->add('Enviar', SubmitType::class)
            ->getForm();

        $form->handleRequest( $request );
        if ($form->isSubmitted() && $form->isValid()) {
            $data = $form->getData();
            
            $cita = new Citas();
            $cita->setEspecialidad( $data['especialidad'] );
            $cita->setDni( $data['dni'] );
            $cita->setNombre( $data['nombre'] );
            $cita->setDireccion( $data['direccion'] );
            $cita->setTelefono( $data['telefono'] );
            $cita->setEmail( $data['email'] );
            $cita->setTexto( $data['texto'] );

            $em = $this->getDoctrine()->getManager();
            $em->persist( $cita );
            $em->flush();
            
            return $this->redirectToRoute('hospital');
        }
        else
            return $this->render('contenido/citas.html.twig',
            array('form' => $form->createView()));
    }
    /**
     * @Route("/hospital/encuestas", name="encuestas")
     */
    public function encuestas()
    {
        $encuestas = $this->getDoctrine()
        ->getRepository(Encuesta::class)
        ->findAll();

        return $this->render('contenido/encuestas.html.twig', [
        'encuestas' => $encuestas]);
    }

    /**
     * @Route("/hospital/bolsa", name="bolsa")
     */
    public function bolsa( Request $request ): Response
    {
        $defaultData = array();

        $form = $this->createFormBuilder( $defaultData )
            ->add('puesto', EntityType::class, [
                'class' => Puesto::class,
                'choice_label' => function($especialidad) {
                    return $especialidad->getPuesto();
                }
            ])
            ->add('dni', TextType::class)
            ->add('nombre', TextType::class)
            ->add('direccion', TextType::class)
            ->add('telefono', TextType::class)
            ->add('email', TextType::class)
            ->add('Enviar', SubmitType::class)
            ->getForm();

        $form->handleRequest( $request );
        if ($form->isSubmitted() && $form->isValid()) {
            $data = $form->getData();
            
            $bolsa = new Bolsa();
            $bolsa->setPuesto( $data['puesto'] );
            $bolsa->setDni( $data['dni'] );
            $bolsa->setNombre( $data['nombre'] );
            $bolsa->setDireccion( $data['direccion'] );
            $bolsa->setTelefono( $data['telefono'] );
            $bolsa->setEmail( $data['email'] );

            $em = $this->getDoctrine()->getManager();
            $em->persist( $bolsa );
            $em->flush();
            
            return $this->redirectToRoute('hospital');
        }
        else
            return $this->render('contenido/bolsa.html.twig',
            array('form' => $form->createView()));
    }

    /**
     * @Route("/hospital/encuestas/{id}", name="preguntas")
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
				'expanded' => true)
			);		
		}

        $builder->add('Send', SubmitType::class);
		$form= $builder->getForm();
	 	$form->handleRequest( $request );

        if ($form->isSubmitted() && $form->isValid()) {
        $data = $form->getData();
        foreach( $data as $key => $value )
        {
            // data ['pregunta'] = 'respuesta_id'
    
            if( strpos($key, "pregunta") !== false )
            {
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
        
        return $this->redirectToRoute('hospital');
    }
    else
        return $this->render('contenido/preguntas_respuestas.html.twig', 
            array('form' => $form->createView()));
    }

    /**
     * @Route("/privado/hospital/gestion_medicos", name="gestion_medicos")
     */
    public function gestion_medicos()
    {
        $medicos = $this->getDoctrine()
        ->getRepository(Medicos::class)
        ->findAll();
        
        return $this->render('contenido/gestion_medicos.html.twig', [
            'medicos' => $medicos
            ]);
    }
    /**
     * @Route("/privado/hospital/editar_medico/{id}/{search}", defaults={"search" = null }, name="editar_medico")
     */
    public function editar_medico( Request $request, $id, $search )
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
        
        $form->add('especialidadesRestantes', ChoiceType::class, ['choices' => $list, 'multiple' => true, 'required' => false]);

        $form->add('Add', SubmitType::class);
        $form->add('Borrar', SubmitType::class);
        $form->add('Buscar', SubmitType::class);
        $form->add('Guardar', SubmitType::class);
        $form->add('BorrarMedico', SubmitType::class);
        $form = $form->getForm();

        $form->handleRequest( $request );

        if ($form->isSubmitted() && $form->isValid()) {
            $data = $form->getData();

            $medico->setNombre($data['medico']);

            if ($form->get('Add')->isClicked()) {
                foreach ($data['especialidadesRestantes'] as $item) {
                    $especialidad = $this->getDoctrine()
                    ->getRepository(Especialidades::class)
                    ->findOneById( $item );

                    $especialidades = $session->get('edit_especialidades');
                    $especialidades[] = array('id' => $especialidad->getId(), 'especialidad' => $especialidad->getEspecialidad());
                    $session->set('edit_especialidades', $especialidades);
                }
                
                return $this->redirectToRoute('editar_medico', ['id' => $data['id']]);
            
            } elseif ($form->get('Borrar')->isClicked()) {
                
                $posiciones = array();
                foreach ($data['especialidades'] as $item) {
                    $pos = 0;
                    foreach ($session->get('edit_especialidades') as $elemento) {
                        printf("</br> %s [%s] [%s]</br> ", $pos, $elemento['id'], $item);
                         if ($elemento['id'] == $item) {
                            printf("</br> %s [%s] [%s] ok</br> ", $pos, $elemento['id'], $item);
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
                return $this->redirectToRoute('editar_medico', ['id' => $data['id']]);
            
            } elseif ($form->get('Buscar')->isClicked()) {
                return $this->redirectToRoute('editar_medico', ['id' => $data['id'], 'search' => $data['Search']]);
            
            } elseif ($form->get('BorrarMedico')->isClicked()) {
                $em = $this->getDoctrine()->getManager();
                $em->remove($medico);
                $em->flush();
                
                return $this->redirectToRoute('gestion_medicos');
            
            } elseif ($form->get('Guardar')->isClicked()) {
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
                        $medico->addEspecialidade( $especialidad );
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

                return $this->redirectToRoute('gestion_medicos');
            }
        } else {
            return $this->render('contenido/gestion_medico.html.twig', array('form' => $form->createView(), "medico" => $medico));
        }
    }

    /**
     * @Route("/new_medico/{search}", defaults={"search" = null }, name="new_medico")
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

        // lista de especialidadesRestantes
        if (isset($search)) {
            $cadena = '%' . $search . '%';
            $em = $this->getDoctrine()->getManager();
            $query = $em->createQuery("SELECT n FROM App:Especialidades n WHERE n.especialidad LIKE :searchterm ")
            ->setParameter('searchterm', $cadena);
            $especialidadesRestantes = $query->getResult();
        } else {
            $especialidadesRestantes = $this->getDoctrine()
            ->getRepository(Especialidades::class)
            ->findAll();
        }

        $list = array();
        foreach ($especialidadesRestantes as $item) {
            $list[$item->getEspecialidad()] = $item->getId();
        }

        $form = $this->createFormBuilder();
        $form->add('id', TextType::class, ['required' => false]);
        $form->add('medico', TextType::class, ['data' => $medico->getNombre()]);
        $form->add('especialidades', ChoiceType::class, ['choices' => $lista, 'multiple' => true, 'required' => false]);
        $form->add('especialidadesRestantes', ChoiceType::class, ['choices' => $list, 'multiple' => true, 'required' => false]);

        $form->add('Search', TextType::class, ['data' => isset($search) ? $search : '', 'required' => false]);

        $form->add('Add', SubmitType::class);
        $form->add('Borrar', SubmitType::class);
        $form->add('Buscar', SubmitType::class);
        $form->add('Guardar', SubmitType::class);
        $form = $form->getForm();

        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $data = $form->getData();
            $medico->setMedicoId($data['id']);
            $medico->setNombre($data['medico']);
            if ($form->get('Add')->isClicked()) {
                foreach ($data['especialidadesRestantes'] as $item) {
                    $especialidad = $this->getDoctrine()
                    ->getRepository(Especialidades::class)
                    ->findOneById($item);

                    $especialidades = $session->get('new_especialidades');
                    $especialidades[] = array('id' => $especialidad->getId(), 'especialidad' => $especialidad->getEspecialidad());
                    $session->set('new_especialidades', $especialidades);
                }
                $session->set('medico', $medico);
                return $this->redirectToRoute('new_medico');

            } elseif ($form->get('Borrar')->isClicked()) {
                
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
                return $this->redirectToRoute('new_medico');

            } elseif ($form->get('Buscar')->isClicked()) {
                $session->set('new_medico', $medico);
                return $this->redirectToRoute('new_medico', ['search' => $data['Search']]);
            } elseif ($form->get('Guardar')->isClicked()) {
                // Añade los autores que estan en sesion
                foreach ($session->get('new_especialidades') as $item) {
                    $especialidad = $this->getDoctrine()
                    ->getRepository(Especialidades::class)
                    ->findOneById($item['id']);

                    $medico->addEspecialidade($especialidad);
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

            return $this->redirectToRoute('gestion_medicos');

        } else {
            return $this->render('contenido/gestion_medico.html.twig', array( 'medico' => $medico, 'form' => $form->createView()));
        }
    }

    /**
     * @Route("/login", name="app_login")
     */
    function login(AuthenticationUtils $authenticationUtils): Response
    {
        // if ($this->getUser()) {
        //     return $this->redirectToRoute('target_path');
        // }

        // get the login error if there is one
        $error = $authenticationUtils->getLastAuthenticationError();
        // last username entered by the user
        $lastUsername = $authenticationUtils->getLastUsername();

        return $this->render('contenido/login.html.twig', ['last_username' => $lastUsername, 'error' => $error]);
    }

    /**
     * @Route("/logout", name="app_logout")
     */
    function logout()
    {
        throw new \LogicException('This method can be blank - it will be intercepted by the logout key on your firewall.');
    }

	function menu()
    {
        $menus = $this->getDoctrine()
        ->getRepository(Menu::class)
        ->findAll();

        return $this->render('hospital/menu.html.twig', array( "menus" => $menus ));
    }

    function menu_logueado()
    {
        $menus = $this->getDoctrine()
        ->getRepository(MenuLogueado::class)
        ->findAll();

        return $this->render('hospital/menu.html.twig', array( "menus" => $menus ));
    }

    function footer()
    {
        $footer = $this->getDoctrine()
        ->getRepository(Footer::class)
        ->findAll();

        return $this->render('hospital/footer.html.twig', array( "footer" => $footer ));
    }
}