/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqCoche;

/**
 *
 * @author Profesor
 */
public class Coche {
    private String marca, modelo, color, combustible, cambio;
    private int numPuertas,precio;

    public Coche(String marca, String modelo, String color, String combustible, String cambio, int numPuertas, int precio) throws IllegalArgumentException {
        this.marca = marca.trim().toUpperCase();
        this.modelo = modelo.trim().toUpperCase();
        this.color = color.toUpperCase().trim();
        combustible=combustible.trim().toUpperCase();
        if (combustible.equals("GASOLINA")  || combustible.equals("DIESEL"))            
              this.combustible = combustible;
        else{
            IllegalArgumentException ex=new IllegalArgumentException("Error en Combustible, debe ser DIESEL o GASOLINA");
            throw ex;
        }
        
        cambio=cambio.trim().toUpperCase();
        if (cambio.equals("MANUAL")  || cambio.equals("AUTOMATICO"))
            this.cambio = cambio;
        else
            throw new IllegalArgumentException("Cambio debe ser MANUAL o AUTOMATICO");
        if (numPuertas < 3 || numPuertas > 5)
            throw new IllegalArgumentException("El número de puertas debe ser 3,4 ó 5");
        this.numPuertas = numPuertas;
        
        if (precio <0 ) throw new IllegalArgumentException("Error, precio ha de ser positivo");
        this.precio=precio;
    }

    public Coche() throws IllegalArgumentException{
        this("FERRARI","458","BLANCO","GASOLINA","MANUAL",3,0);
    }

    public Coche(Coche other)throws IllegalArgumentException{
        this(other.marca, other.modelo, other.color, other.combustible, other.cambio, other.numPuertas, other.precio);
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getColor() {
        return this.color;
    }

    public String getCombustible() {
        return this.combustible;
    }

    public String getCambio() {
        return this.cambio;
    }

    public int getNumPuertas() {
        return this.numPuertas;
    }

    public int getPrecio() {
        return this.precio;
    }

    public void setMarca(String marca) {
        this.marca = marca.trim().toUpperCase();
    }

    public void setModelo(String modelo) {
        this.modelo = modelo.trim().toUpperCase();
    }

    public void setColor(String color) {
        this.color = color.trim().toUpperCase();
    }

    public void setCombustible(String combustible) throws IllegalArgumentException{
        combustible=combustible.trim().toUpperCase();
        if (!combustible.equals("GASOLINA") && !combustible.equals("DIESEL"))
            throw new IllegalArgumentException("Error, debe ser DIESEL o GASOLINA");
        //else    --es opcional
        this.combustible = combustible;
    }

    public void setCambio(String cambio)throws IllegalArgumentException {
        cambio=cambio.trim().toUpperCase();
        //if (!(cambio.equals("MANUAL")  || cambio.equals("AUTOMATICO")))
        if (!cambio.equals("MANUAL")  && !cambio.equals("AUTOMATICO"))    
                throw new IllegalArgumentException("Error, cambio erróneo");
                   
        this.cambio = cambio;
    }

    public void setNumPuertas(int numPuertas)throws IllegalArgumentException {
        //if (!(numPuertas>=3 && numPuertas <=5))
        if (numPuertas<3 || numPuertas >5)
            throw new IllegalArgumentException("Número de puertas incorrecto");
        this.numPuertas = numPuertas;
    }

    public void setPrecio(int precio)throws IllegalArgumentException {
        if (precio<0)
            throw new IllegalArgumentException();
        this.precio = precio;
    }
     
    
    
    @Override
    public String toString() {
        return "Coche{" + "marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", combustible=" + combustible + ", cambio=" + cambio + ", numPuertas=" + numPuertas + ", precio="+precio+'}';
    }
    
    
    
}
