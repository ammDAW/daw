<?php

namespace App\Entity;

use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass="App\Repository\ConferenciaRepository")
 */
class Conferencia
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
    private $titulo;

    /**
     * @ORM\Column(type="date")
     */
    private $fecha;

    /**
     * @ORM\Column(type="time")
     */
    private $hora;

    /**
     * @ORM\Column(type="integer")
     */
    private $aforo;

    /**
     * @ORM\ManyToMany(targetEntity="App\Entity\Congresista", inversedBy="conferencias")
     */
    private $congresistas;

    public function __construct()
    {
        $this->congresistas = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getTitulo(): ?string
    {
        return $this->titulo;
    }

    public function setTitulo(string $titulo): self
    {
        $this->titulo = $titulo;

        return $this;
    }

    public function getFecha(): ?\DateTimeInterface
    {
        return $this->fecha;
    }

    public function setFecha(\DateTimeInterface $fecha): self
    {
        $this->fecha = $fecha;

        return $this;
    }

    public function getHora(): ?\DateTimeInterface
    {
        return $this->hora;
    }

    public function setHora(\DateTimeInterface $hora): self
    {
        $this->hora = $hora;

        return $this;
    }

    public function getAforo(): ?int
    {
        return $this->aforo;
    }

    public function setAforo(int $aforo): self
    {
        $this->aforo = $aforo;

        return $this;
    }

    /**
     * @return Collection|Congresista[]
     */
    public function getCongresistas(): Collection
    {
        return $this->congresistas;
    }

    public function addCongresista(Congresista $congresista): self
    {
        if (!$this->congresistas->contains($congresista)) {
            $this->congresistas[] = $congresista;
        }

        return $this;
    }

    public function removeCongresista(Congresista $congresista): self
    {
        if ($this->congresistas->contains($congresista)) {
            $this->congresistas->removeElement($congresista);
        }

        return $this;
    }
}
