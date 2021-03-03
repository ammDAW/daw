<?php

namespace App\Entity;

use App\Repository\CitasRepository;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=CitasRepository::class)
 */
class Citas
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
    private $dni;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $nombre;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $direccion;

    /**
     * @ORM\Column(type="integer")
     */
    private $telefono;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $email;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $info_adicional;

    /**
     * @ORM\ManyToOne(targetEntity=Especialidad::class, inversedBy="citas")
     */
    private $esp_medica;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getDni(): ?string
    {
        return $this->dni;
    }

    public function setDni(string $dni): self
    {
        $this->dni = $dni;

        return $this;
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

    public function getDireccion(): ?string
    {
        return $this->direccion;
    }

    public function setDireccion(string $direccion): self
    {
        $this->direccion = $direccion;

        return $this;
    }

    public function getTelefono(): ?int
    {
        return $this->telefono;
    }

    public function setTelefono(int $telefono): self
    {
        $this->telefono = $telefono;

        return $this;
    }

    public function getEmail(): ?string
    {
        return $this->email;
    }

    public function setEmail(string $email): self
    {
        $this->email = $email;

        return $this;
    }

    public function getInfoAdicional(): ?string
    {
        return $this->info_adicional;
    }

    public function setInfoAdicional(string $info_adicional): self
    {
        $this->info_adicional = $info_adicional;

        return $this;
    }

    public function getEspMedica(): ?Especialidad
    {
        return $this->esp_medica;
    }

    public function setEspMedica(?Especialidad $esp_medica): self
    {
        $this->esp_medica = $esp_medica;

        return $this;
    }
}
