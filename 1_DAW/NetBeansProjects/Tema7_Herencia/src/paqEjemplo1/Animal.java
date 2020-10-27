
package paqEjemplo1;

/**
 *
 * @author ALBERTO
 */
public class Animal {
    protected String nombre;

//CONSTRUCTORES
    public Animal(String nombre) {
        this.nombre = nombre;
    }
    public Animal(){
        this("");
    }
    public Animal(Animal other){
        this.nombre=other.nombre;
    }
//GETTER
    public String getNombre() {
        return this.nombre;
    }
//SETTER
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
//TOSTRING
    @Override
    public String toString() {
        return "[Nombre: " + nombre + ']';
    }
    
    
}
