
package paqEjemplo1;

/**
 *
 * @author ALBERTO
 */
public class UsoAnimal {
    public static void main(String[] args) {
        Animal a1 = new Animal("perrito");
        System.out.println("a1= "+a1);
        /*a1 tiene acceso a las propiedades y métodos protected
        Porque la clase Uso Animal está en el mismo paquete que Animal*/
        
        Vertebrado b1= new Vertebrado(89,"elefante");
        //b1.toString();
        System.out.println("b1= "+b1.toString());
        b1.setNombre("gorila");
        b1.nombre="elefante";
    }
    
}
