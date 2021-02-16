<?php
namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;


use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;


use App\Entity\User;



class HospitalController extends AbstractController
{
    
    /**
     * @Route("/publico/pagina_publica", name="pagina_publica")
     */
    public function pagina_publica()
    {
        return new Response( "Esta en la zona publica" );
    }
    
    /**
     * @Route("/privado/pagina_privada", name="pagina_privada")
     */
    public function pagina_privada()
    {
        return new Response( "<a href=\"/logout\">Logout</a></br>Esta es la zona segura" );
    }
}
