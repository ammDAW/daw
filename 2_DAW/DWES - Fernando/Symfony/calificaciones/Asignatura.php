<?php

namespace App\Entity;

use App\Repository\AsignaturaRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=AsignaturaRepository::class)
 */
class Asignatura
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $asignatura;

    /**
     * @ORM\OneToMany(targetEntity=Calificacion::class, mappedBy="asignatura")
     */
    private $calificaciones;

    public function __construct()
    {
        $this->calificaciones = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getAsignatura(): ?string
    {
        return $this->asignatura;
    }

    public function setAsignatura(string $asignatura): self
    {
        $this->asignatura = $asignatura;

        return $this;
    }

    /**
     * @return Collection|Calificacion[]
     */
    public function getCalificaciones(): Collection
    {
        return $this->calificaciones;
    }

    public function addCalificacione(Calificacion $calificacione): self
    {
        if (!$this->calificaciones->contains($calificacione)) {
            $this->calificaciones[] = $calificacione;
            $calificacione->setAsignatura($this);
        }

        return $this;
    }

    public function removeCalificacione(Calificacion $calificacione): self
    {
        if ($this->calificaciones->removeElement($calificacione)) {
            // set the owning side to null (unless already changed)
            if ($calificacione->getAsignatura() === $this) {
                $calificacione->setAsignatura(null);
            }
        }

        return $this;
    }
}
