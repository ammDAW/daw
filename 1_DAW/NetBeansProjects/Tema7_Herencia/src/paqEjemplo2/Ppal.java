
package paqEjemplo2;
import paqEjemplo1.Animal;
import paqEjemplo1.Vertebrado;
import paqEjemplo3.Hombre;
/**
 *
 * @author ALBERTO
 */
public class Ppal {
    public static void main(String[] args) {
        Animal a2 = new Animal("gatito");
        a2.setNombre("Gato");
        //a2 sólo puede accdedes a propiedad y métodos públicos
        
        Vertebrado b2=new Vertebrado(23, "raton");
        Hombre h1= new Hombre(23,45,"Alberto");
        //System.out.println("h1: "+h1);
        
        Hombre h2=new Hombre(23, b2);
        //System.out.println("h2= "+h2);
        
        a2=b2;
        a2.setNombre("RATON");
        //System.out.println("b2="+b2);
        b2.setNumVertebras(56);
        System.out.println("b2="+b2);
        System.out.println("a2="+a2);
        
        
        
    }
    
}
