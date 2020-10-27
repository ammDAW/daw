
package paqClases;
import paqExcepciones.AlquilarException;
import paqInterfaces.*;

/**
 *
 * @author ALBERTO
 */
public abstract class Producto implements Alquilable, Retirable{
    protected int id;
    protected String nombre;
    protected double precio;
    protected static int contProductos=0;
    protected boolean alquilado= false, retirado=false; //se añaden por la implementación de interfaces
//CONSTRUCTOR    
    public Producto (String nombre){
        this.nombre = nombre;
    }
//GETTERS
    public int getId() {return this.id;}
    public String getNombre() {return this.nombre;}
    public abstract double getPrecio();
    public static int getContProductos(){return Producto.contProductos;}
//SETTER    
    public void setNombre(String nombre){this.nombre=nombre;}
//TO_STRING    
    @Override
    public String toString() {
        return "[ID: "+this.id+"\tNombre: "+this.nombre+"\tPrecio: "+this.precio;
    }
//OTROS METODOS  
    public boolean equals(Producto other){
        //if(this.id != other.id) return false; se qwuita porque pueden es para saber si hay más copias, ya que tiene un ID distinto
        if(this.nombre != other.nombre) return false;
        if(this.precio != other.precio) return false;
        return true;
    }  
//INTERFACES
    //public void alquilar() throws AlquilarException; es abstracto, por lo que no se implementa en la clase
    @Override
    public void devolver(){
        this.alquilado=false;
    }
    
    @Override
    public boolean isAlquilado(){
        return this.alquilado;
    }
    
    public void retirar(){
        if(!(this.alquilado || this.retirado)){
            this.retirado=true;
            Producto.contProductos--;
        }
        else if(this.alquilado)
            System.out.println("El producto ya está alquilado");
        else if(this.retirado)
            System.out.println("El producto ya está retirado");   
    }
    
    public boolean isRetirado(){
        return this.retirado;
    }
    
    
}
