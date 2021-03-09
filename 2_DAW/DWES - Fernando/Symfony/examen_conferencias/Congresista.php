<?php

namespace App\Entity;

use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass="App\Repository\CongresistaRepository")
 */
class Congresista
{
    /**
     * @ORM\Id()
     * @ORM\GeneratedValue()
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $nombre;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $apellidos;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $nif;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $telefono;

    /**
     * @ORM\ManyToMany(targetEntity="App\Entity\Conferencia", mappedBy="congresistas")
     */
    private $conferencias;

    public function __construct()
    {
        $this->conferencias = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNombre(): ?string
    {
        return $this->nombre;
    }

    public function setNombre(string $nombre): self
    {
        $this->nombre = $nombre;

        return $this;
    }

    public function getApellidos(): ?string
    {
        return $this->apellidos;
    }

    public function setApellidos(string $apellidos): self
    {
        $this->apellidos = $apellidos;

        return $this;
    }

    public function getNif(): ?string
    {
        return $this->nif;
    }

    public function setNif(string $nif): self
    {
        $this->nif = $nif;

        return $this;
    }

    public function getTelefono(): ?string
    {
        return $this->telefono;
    }

    public function setTelefono(string $telefono): self
    {
        $this->telefono = $telefono;

        return $this;
    }

    /**
     * @return Collection|Conferencia[]
     */
    public function getConferencias(): Collection
    {
        return $this->conferencias;
    }

    public function addConferencia(Conferencia $conferencia): self
    {
        if (!$this->conferencias->contains($conferencia)) {
            $this->conferencias[] = $conferencia;
            $conferencia->addCongresista($this);
        }

        return $this;
    }

    public function removeConferencia(Conferencia $conferencia): self
    {
        if ($this->conferencias->contains($conferencia)) {
            $this->conferencias->removeElement($conferencia);
            $conferencia->removeCongresista($this);
        }

        return $this;
    }
}
