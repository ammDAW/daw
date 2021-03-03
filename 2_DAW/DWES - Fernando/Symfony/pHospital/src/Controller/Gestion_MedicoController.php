<?php
// src/Controller/Gestion_MedicoController.php
namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

use Symfony\Component\Routing\Annotation\Route;

use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;

use App\Entity\Especialidad;
use App\Entity\Medico; 

class Gestion_MedicoController extends AbstractController{
	/**
     * @Route("/gestion_medicos",  name="gestion_medicos")
     */
	public function gestion_medico(){
        $medicos = $this->getDoctrine()
        ->getRepository(Medico::class)
        ->findAll();

        return $this->render('menu/gestion_medicos.html.twig',array('medicos'=>$medicos));
    }

    /**
     * @Route("/editar_medico/{id}/search", defaults={"search" = null }, name="editar_medico")
     */
    public function editar_medico( Request $request, $id, $search ){
        $session = $request->getSession();

        $medico = $this->getDoctrine()
        ->getRepository(Medico::class)
        ->findOneById($id);

        if (!$medico) {
            throw $this->createNotFoundException(
                'No medico found for id ');
        }

        if (!$session->get('edit_id') || $session->get('edit_id') != $id) {
            $session->set('edit_id', $id);

            $especialidades = array();
            foreach ($medico->getEspecialidad() as $item) {
                $especialidades[] = array('id' => $item->getId(), 'nombre' => $item->getNombre());
            }
            $session->set('edit_especialidades', $especialidades);
        }

        // Lista de especialidades
        $lista = array();

        foreach ($session->get('edit_especialidades') as $item) {

            $lista[$item['nombre']] = $item['id'];
        }

        if (isset($search)) {
            $cadena = '%' . $search . '%';
            $em = $this->getDoctrine()->getManager();

            $query = $em->createQuery("SELECT n FROM App:Especialidad n WHERE n.nombre LIKE :searchterm ")
            ->setParameter('searchterm', $cadena);

            $especialidades = $query->getResult();
        } else {
            $especialidades = $this->getDoctrine()
            ->getRepository(Especialidad::class)
            ->findAll();
        }

        $list = array();
        foreach ($especialidades as $item) {
            $list[$item->getNombre()] = $item->getId();
        }

        $form = $this->createFormBuilder();
        $form->add('id', TextType::class, ['data' => $medico->getId()]);
        $form->add('medico', TextType::class, ['data' => $medico->getNombre()]);
        $form->add('especialidades', ChoiceType::class, ['choices' => $lista, 'multiple' => true, 'required' => false]);

        //$form->add('Search', TextType::class, ['data' => isset($search) ? $search : '', 'required' => false]);
        
        $form->add('especialidadesRestantes', ChoiceType::class, ['choices' => $list, 'multiple' => true, 'required' => false]);

        $form->add('AddEsp', SubmitType::class);
        $form->add('BorrarEsp', SubmitType::class);
        $form->add('Buscar', SubmitType::class);
        $form->add('Guardar', SubmitType::class);
        $form->add('BorrarMedico', SubmitType::class);
        $form = $form->getForm();

        $form->handleRequest( $request );

        if ($form->isSubmitted() && $form->isValid()) {
            $data = $form->getData();

            $medico->setNombre($data['medico']);

            if ($form->get('AddEsp')->isClicked()) {
                foreach ($data['especialidadesRestantes'] as $item) {
                    $especialidad = $this->getDoctrine()
                    ->getRepository(Especialidad::class)
                    ->findOneById( $item );

                    $especialidades = $session->get('edit_especialidades');
                    $especialidades[] = array('id' => $especialidad->getId(), 'nombre' => $especialidad->getNombre());
                    $session->set('edit_especialidades', $especialidades);
                }
                
                return $this->redirectToRoute('editar_medico', ['id' => $data['id']]);
            
            } elseif ($form->get('BorrarEsp')->isClicked()) {
                
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
                foreach ($medico->getEspecialidad() as $item) {
                    if (!in_array($item->getId(), $session->get('edit_especialidades'))) {
                        $posiciones[] = $pos;
                        $pos++;
                    }
                }

                arsort($posiciones); // orden inverso posiciones
                foreach ($posiciones as $pos) {
                    $medico->getEspecialidad()->remove($pos);
                    $em = $this->getDoctrine()->getManager();
                    $em->persist($medico);
                }

                // Añade las especialidades que estan en sesion
                foreach ($session->get('edit_especialidades') as $item) {
                    $especialidad = $this->getDoctrine()
                        ->getRepository(Especialidad::class)
                        ->findOneById($item['id']);
                    if (!$medico->getEspecialidad()->contains($especialidad)) {
                        $medico->addEspecialidad( $especialidad );
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
            return $this->render('menu/editar.html.twig', array('form' => $form->createView(), "medico" => $medico));
        }
    }    
}