<?php

namespace App\Entity;

use App\Repository\EspecialidadRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=EspecialidadRepository::class)
 */
class Especialidad
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
     * @ORM\ManyToMany(targetEntity=Medico::class, mappedBy="especialidad")
     */
    private $medicos;

    /**
     * @ORM\OneToMany(targetEntity=Servicios::class, mappedBy="especialidad")
     */
    private $especialidad_id;

    /**
     * @ORM\OneToMany(targetEntity=Citas::class, mappedBy="esp_medica")
     */
    private $citas;

    public function __construct()
    {
        $this->medicos = new ArrayCollection();
        $this->especialidad_id = new ArrayCollection();
        $this->citas = new ArrayCollection();
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
     * @return Collection|Medico[]
     */
    public function getMedicos(): Collection
    {
        return $this->medicos;
    }

    public function addMedico(Medico $medico): self
    {
        if (!$this->medicos->contains($medico)) {
            $this->medicos[] = $medico;
            $medico->addEspecialidad($this);
        }

        return $this;
    }

    public function removeMedico(Medico $medico): self
    {
        if ($this->medicos->removeElement($medico)) {
            $medico->removeEspecialidad($this);
        }

        return $this;
    }

    /**
     * @return Collection|Servicios[]
     */
    public function getEspecialidadId(): Collection
    {
        return $this->especialidad_id;
    }

    public function addEspecialidadId(Servicios $especialidadId): self
    {
        if (!$this->especialidad_id->contains($especialidadId)) {
            $this->especialidad_id[] = $especialidadId;
            $especialidadId->setEspecialidad($this);
        }

        return $this;
    }

    public function removeEspecialidadId(Servicios $especialidadId): self
    {
        if ($this->especialidad_id->removeElement($especialidadId)) {
            // set the owning side to null (unless already changed)
            if ($especialidadId->getEspecialidad() === $this) {
                $especialidadId->setEspecialidad(null);
            }
        }

        return $this;
    }

    /**
     * @return Collection|Citas[]
     */
    public function getCitas(): Collection
    {
        return $this->citas;
    }

    public function addCita(Citas $cita): self
    {
        if (!$this->citas->contains($cita)) {
            $this->citas[] = $cita;
            $cita->setEspMedica($this);
        }

        return $this;
    }

    public function removeCita(Citas $cita): self
    {
        if ($this->citas->removeElement($cita)) {
            // set the owning side to null (unless already changed)
            if ($cita->getEspMedica() === $this) {
                $cita->setEspMedica(null);
            }
        }

        return $this;
    }
}
