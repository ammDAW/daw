<?php
// src/Controller/MenuController.php
namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

use Symfony\Component\Routing\Annotation\Route;

use Doctrine\ORM\EntityManagerInterface;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;


use App\Entity\Menu;

class MenuController extends AbstractController
{
    
	/**
     * @Route("/menu",  name="menu_menu")
     */
	public function menu()
    {
        $menus = $this->getDoctrine()
        ->getRepository(Menu::class)
        ->findAll();
        /*   $repository = $this->getDoctrine()
                ->getRepository('Menu::class');
        $query = $repository->createQueryBuilder('m')
                ->orderBy('m.orden', 'ASC')
                ->getQuery();

        $menus = $query->getResult();
        */


        return $this->render('menu/menu.html.twig',array("menus"=>$menus));
    }   
	 
	/**
     * @Route("/inicio",  name="menu_inicio")
     */
	public function test()
    {
        
        return $this->render('menu/inicio.html.twig');
    }   
	
   

}