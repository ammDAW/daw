/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqCoche;

/**
 *
 * @author alumno
 */
public class Coche {
    private String marca, modelo, color, combustible, tipo_cambio;
    private int numPuertas, precio;
    
    public Coche(String marca, String modelo, String color, String combustible, String tipo_cambio, int numPuertas, int precio)  throws IllegalArgumentException {
        this.marca = marca.trim().toUpperCase();
        this.modelo = modelo.trim().toUpperCase();
        this.color = color.trim().toUpperCase();
        
        combustible=combustible.trim().toUpperCase();
            if(combustible.equalsIgnoreCase("GASOLINA") || combustible.equalsIgnoreCase("DIESEL")){
                this.combustible = combustible;
            }
            else{
                IllegalArgumentException ex=new IllegalArgumentException("Error en Combustible, debe ser DIESEL o GASOLINA");
                throw ex;
            }
        
        tipo_cambio=tipo_cambio.trim().toUpperCase();
            if (tipo_cambio.equals("MANUAL") || tipo_cambio.equals("AUTOMATICO")){
                this.tipo_cambio = tipo_cambio;
            }
            else{
                throw new IllegalArgumentException("Cambio debe ser MANUAL o AUTOMATICO");
            }
        
        
            if (numPuertas < 3 || numPuertas > 5){
                throw new IllegalArgumentException("El número de puertas debe ser 3,4 ó 5");
            } this.numPuertas = numPuertas;
            
            if (precio < 0){
                throw new IllegalArgumentException("El precio debe ser positivo");
            } this.precio = precio;
      
    }
    
    public Coche() throws IllegalArgumentException{
       this("FERRARI","458","BLANCO","GASOLINA","MANUAL",3,0); 
    }

    @Override
    public String toString() {
        return "Coche{" + "marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", combustible=" + combustible + ", tipo_cambio=" + tipo_cambio + ", numPuertas=" + numPuertas + ", precio=" + precio + '}';
    }
    
    public Coche(Coche other) throws IllegalArgumentException{
        this(other.marca, other.modelo, other.color, other.combustible, other.tipo_cambio, other.numPuertas, other.precio);
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getCombustible() {
        return combustible;
    }

    public String getTipo_cambio() {
        return tipo_cambio;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public int getPrecio() {
        return precio;
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

    public void setCombustible(String combustible) throws IllegalArgumentException {
        combustible=combustible.trim().toUpperCase();
        if(!combustible.equals("GASOLINA") && !combustible.equals("DIESEL"))
            throw new IllegalArgumentException("Error, debe ser gasolina o diesel");
        //else  ----es opcional porque el momento que lo lanza se sale del metodo
        this.combustible = combustible;
    }

    public void setTipo_cambio(String tipo_cambio) {
        this.tipo_cambio = tipo_cambio;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    /*if (cambo.equals("MANUAL") || cambio.equals("AUTOMATICO"))
        this.cambio=cambio;
    else
        throw new IllegalArgumenException("Cabio dede ser MANUAL o AUTOMATICO");*/
    
    public void setCambio (String cambio) throws IllegalArgumentException{
        cambio=cambio.trim().toUpperCase();
        //if (!(cambio.equals("MANUAL") || cambio.equals("AUTOMATICO")))
        if (!cambio.equals("MANUAL") && !cambio.equals("AUTOMATICO"))
            throw new IllegalArgumentException("Error, cambio erróneo");
        this.tipo_cambio = cambio;
    }
       
}
