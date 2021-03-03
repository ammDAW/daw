<?php

namespace App\Entity;

use App\Repository\PuestoRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=PuestoRepository::class)
 */
class Puesto
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
    private $nombre;

    /**
     * @ORM\OneToMany(targetEntity=Bolsa::class, mappedBy="puesto")
     */
    private $bolsas;

    public function __construct()
    {
        $this->bolsas = new ArrayCollection();
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

    /**
     * @return Collection|Bolsa[]
     */
    public function getBolsas(): Collection
    {
        return $this->bolsas;
    }

    public function addBolsa(Bolsa $bolsa): self
    {
        if (!$this->bolsas->contains($bolsa)) {
            $this->bolsas[] = $bolsa;
            $bolsa->setPuesto($this);
        }

        return $this;
    }

    public function removeBolsa(Bolsa $bolsa): self
    {
        if ($this->bolsas->removeElement($bolsa)) {
            // set the owning side to null (unless already changed)
            if ($bolsa->getPuesto() === $this) {
                $bolsa->setPuesto(null);
            }
        }

        return $this;
    }
}
