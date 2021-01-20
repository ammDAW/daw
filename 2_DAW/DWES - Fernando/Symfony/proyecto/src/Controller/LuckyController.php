<?php
// src/Controller/LuckyController.php
namespace App\Controller;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;

class LuckyController extends AbstractController
{
	//@Route("/lucky/number")
    public function number()
    {
        $number = random_int(0, 100);

        return new Response(
            '<html><body>Lucky number: '.$number.'</body></html>'
        );
    }
	
	public function number2(): Response
    {
        $number = random_int(0, 100);

        return $this->render('lucky/number.html.twig', [
            'number' => $number,
        ]);
    }
	
	public function espar($number)
	{
		$par = $number % 2;
		
		return $this->render('lucky/espar.html.twig', [
			'number' => $number, 'par' => $par,
		]);
	}
}
?>