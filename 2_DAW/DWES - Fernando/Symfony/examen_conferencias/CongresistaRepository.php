<?php

namespace App\Repository;

use App\Entity\Congresista;
use App\Entity\Conferencia;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Congresista|null find($id, $lockMode = null, $lockVersion = null)
 * @method Congresista|null findOneBy(array $criteria, array $orderBy = null)
 * @method Congresista[]    findAll()
 * @method Congresista[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class CongresistaRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Congresista::class);
    }

    // /**
    //  * @return Congresista[] Returns an array of Congresista objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('a')
            ->andWhere('a.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('a.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Congresista
    {
        return $this->createQueryBuilder('a')
            ->andWhere('a.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
    public function findCongresistaConferencia($nif, $telefono ){		
		$em = $this->getEntityManager();

		
		
		$query = $em->createQuery('SELECT DISTINCT f FROM App:Conferencia f INNER JOIN f.congresistas g WHERE  g.nif = :nif and g.telefono = :telefono');
		//$query = $em->createNativeQuery('SELECT DISTINCT conferencia.* FROM conferencia f, congresista g, conferencia_congresista fg WHERE f.conferencia_id = fg.id and alumno.id = calificacion.alumno_id and calificacion.asignatura_id = asignatura.id and curso.id = ?', $rsm);
		$query->setParameter('nif', $nif);
		$query->setParameter('telefono', $telefono);
		$conferencias = $query->getResult();

		return $conferencias;
    }
   
    public function findCongresistaId($nif, $telefono ){
        $em = $this->getEntityManager();
		$query = $em->createNativeQuery('SELECT id FROM congresista g WHERE g.nif = ? and g.telefono = ?');
		
		$query->setParameter(1, $nif);
		$query->setParameter(2, $telefono);
		$congresista_id = $query->getResult();

		return $congresista_id;
    }
    public function removeConferenciaCongresista($conferencia_id, $congresista_id ){		
		$em = $this->getEntityManager();
		$query = $em->createNativeQuery('DELETE FROM conferencia_congresista WHERE conferencia_id = ? AND congresista_id = ?');
		$query->setParameter(1, $conferencia_id);
		$query->setParameter(2, $congresista_id);
		$conferencias = $query->getResult();

		return $conferencias;
    }
    
}
