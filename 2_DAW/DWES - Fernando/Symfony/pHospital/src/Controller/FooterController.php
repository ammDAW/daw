<?php
// src/Controller/MenuController.php
namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

use Symfony\Component\Routing\Annotation\Route;

use Doctrine\ORM\EntityManagerInterface;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;


use App\Entity\Footer;

class FooterController extends AbstractController{
	/**
     * @Route("/menu",  name="footer")
     */
	public function footer(){
        $footers = $this->getDoctrine()
        ->getRepository(Footer::class)
        ->findAll();
  
        return $this->render('menu/footer.html.twig',array("footers"=>$footers));
    }    
}