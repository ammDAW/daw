
package paqMetodosFinales;
import paqJeraquiaClases.A;
import paqJeraquiaClases.B;

/**
 *
 * @author ALBERTO
 */
public class Proyecto {
    public static void main(String[] args) {
        A a=new A(7);
        a.mostrar();
        a.setX(5);
        System.out.println(a.getX());
        System.out.println("a: "+a);
        
        B b=new B(5,4);
        b.mostrar(); //siempre será el de la clase A
    }
}
