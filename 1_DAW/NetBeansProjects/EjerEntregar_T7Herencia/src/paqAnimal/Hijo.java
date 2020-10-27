
package paqAnimal;
import paqFecha.Fecha;

/**
 *
 * @author ALBERTO
 */
public class Hijo{
    protected String nombre;
    protected Fecha fechaNac;

//CONSTRUCTORES    
    public Hijo(String nombre, Fecha f){
        this.nombre=nombre;
        this.fechaNac=f;
    }
    
    public Hijo(Hijo h){
        this(h.nombre,h.fechaNac);
    }
    
    public Hijo(){
        this("",new Fecha(1,1,1900));
    }
    
//GETTERS
    public String getNombre(){
        return nombre;
    }

    public Fecha getFecha(){
        return fechaNac;
    }
//SETTERS
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setFecha(Fecha fechaNac){
        this.fechaNac = fechaNac;
    }
//OTROS METODOS
    @Override
    public String toString(){
        return "[Nombre:" + this.nombre + "\tFechaNac:" + this.fechaNac.toString(2) + ']';
    }
    
    public int edad(Fecha f){
        return (f.getYear()-this.fechaNac.getYear());
    }    
}
