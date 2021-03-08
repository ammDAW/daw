<?php

namespace App\Entity;

use App\Repository\CalificacionRepository;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=CalificacionRepository::class)
 */
class Calificacion
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="integer", nullable=true)
     */
    private $evaluacion1;

    /**
     * @ORM\Column(type="integer", nullable=true)
     */
    private $evaluacion2;

    /**
     * @ORM\Column(type="integer", nullable=true)
     */
    private $evaluacion3;

    /**
     * @ORM\ManyToOne(targetEntity=Alumno::class, inversedBy="calificaciones")
     */
    private $alumno;

    /**
     * @ORM\ManyToOne(targetEntity=Asignatura::class, inversedBy="calificaciones")
     */
    private $asignatura;

    /**
     * @ORM\Column(type="integer", nullable=true)
     */
    private $calificacion;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getEvaluacion1(): ?int
    {
        return $this->evaluacion1;
    }

    public function setEvaluacion1( $evaluacion1): self
    {
        $this->evaluacion1 = $evaluacion1;

        return $this;
    }

    public function getEvaluacion2(): ?int
    {
        return $this->evaluacion2;
    }

    public function setEvaluacion2( $evaluacion2): self
    {
        $this->evaluacion2 = $evaluacion2;

        return $this;
    }

    public function getEvaluacion3(): ?int
    {
        return $this->evaluacion3;
    }

    public function setEvaluacion3( $evaluacion3): self
    {
        $this->evaluacion3 = $evaluacion3;

        return $this;
    }

    public function getAlumno(): ?Alumno
    {
        return $this->alumno;
    }

    public function setAlumno(?Alumno $alumno): self
    {
        $this->alumno = $alumno;

        return $this;
    }

    public function getAsignatura(): ?Asignatura
    {
        return $this->asignatura;
    }

    public function setAsignatura(?Asignatura $asignatura): self
    {
        $this->asignatura = $asignatura;

        return $this;
    }

    public function getCalificacion(): ?int
    {
        return $this->calificacion;
    }

    public function setCalificacion(?int $calificacion): self
    {
        $this->calificacion = $calificacion;

        return $this;
    }
}
