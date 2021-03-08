<?php

namespace App\Repository;

use App\Entity\Asignatura;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

use Doctrine\ORM\Query\ResultSetMapping;

/**
 * @method Asignatura|null find($id, $lockMode = null, $lockVersion = null)
 * @method Asignatura|null findOneBy(array $criteria, array $orderBy = null)
 * @method Asignatura[]    findAll()
 * @method Asignatura[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class AsignaturaRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Asignatura::class);
    }

    // /**
    //  * @return Asignatura[] Returns an array of Asignatura objects
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
    public function findOneBySomeField($value): ?Asignatura
    {
        return $this->createQueryBuilder('a')
            ->andWhere('a.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
	
	 public function findAsignaturasCurso($value)
    {
        

		/*$rsm = new ResultSetMapping();
		$em = $this->getEntityManager();

		$query = $em->createNativeQuery('SELECT DISTINCT ASIGNATURA.* FROM ASIGNATURA, ALUMNO, CURSO, calificacion  WHERE curso.id = alumno.curso_id and alumno.id = calificacion.alumno_id and calificacion.asignatura_id = asignatura.id and curso.id = ?', $rsm);
		
		$query->setParameter('1', $value);

		$asignaturas = $query->getResult();

		return $asignaturas;
		*/
		
		
		
		$em = $this->getEntityManager();

		$query = $em->createQuery('SELECT DISTINCT asg FROM App:Asignatura asg INNER JOIN asg.calificaciones ca INNER JOIN ca.alumno al INNER JOIN al.curso cu WHERE  cu.id = :id');
		
		
		$query->setParameter('id', $value);

		$asignaturas = $query->getResult();

		return $asignaturas;
		
		
		
    }
}
