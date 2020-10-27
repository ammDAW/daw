
package paqVehiculo;

import paqExcepciones.PrecioIncorrecto;

/**
 *
 * @author ALBERTO
 */
public class Vehiculo {
    protected int precio;
    
    public Vehiculo(int precio)throws PrecioIncorrecto{
        if(precio<0)
            throw new PrecioIncorrecto("PrecioIncorrecto personalizado en Vehículo"); //mensaje personalizado entre los parentesis            
            /*PrecioIncorrecto e = new PrecioIncorrrecto();
              throw e*/
        this.precio=precio;
    }
    
    public int getPrecio(){
        return this.precio;
    }
    
    public void setPrecio(int precio){
        if(precio<0)
            throw new PrecioIncorrecto(); //mensaje del constructor
        this.precio=precio;
    }
    @Override
    public String toString(){
        return "Precio: "+this.precio;
    }
}
