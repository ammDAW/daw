
package paqEjemplo3;
import paqEjemplo1.Vertebrado;
/**
 *
 * @author ALBERTO
 */
public class Hombre extends Vertebrado{
    protected int edad;

    public Hombre(int edad, int numVertebras, String nombre) {
        super(numVertebras, nombre);
        this.edad = edad;
    }
    
    public Hombre(int edad, int numVertebras){
        super(numVertebras);
        this.edad=edad;
    }
    
    public Hombre(int edad, Vertebrado other){
        super(other);
        this.edad=edad;
    }
    
    public Hombre(Hombre other){
        //this.(other.edad, other.numVertebras, other.nombre);
        super(other.numVertebras, other.nombre);
        this.edad=other.edad;
    }

    @Override
    public String toString() {
        return '['+super.toString()+"\tEdad: "+edad+']';
    }
    
    
    
    
}
