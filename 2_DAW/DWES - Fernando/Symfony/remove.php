<?php

/**
 * @Route("/editar_medico/{id}/search", defaults={"search" = null }, name="editar_medico")
 */
public function editar_medico( $id) {
    $medico = $this->getDoctrine()
    ->getRepository(Medico::class)
    ->findOneById($id);

    $form->add('BorrarMedico', SubmitType::class);

    if ($form->get('BorrarMedico')->isClicked()) {
        $em = $this->getDoctrine()->getManager();
        $em->remove($medico);
        $em->flush();
    }
    return $this->redirectToRoute('gestion_medicos');
}
?>