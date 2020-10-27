
package paqComplejo;

import java.util.Scanner;

/**
 *
 * @author ALBERTO
 */
public class Ppal_Complejo {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int real, imaginaria;
        
        Complejo w = new Complejo(12,3);
        Complejo x = new Complejo(); 
        Complejo y = new Complejo(w); 
        
        System.out.print("Introduce la parte real del Complejo z: ");
        real=teclado.nextInt();
        System.out.print("Introduce la parte imaginaria del Complejo z: ");
        imaginaria=teclado.nextInt();
        Complejo z = new Complejo(real,imaginaria);
        
        System.out.println("\nComplejo w: "+w);
        System.out.println("Complejo x: "+x);
        System.out.println("Complejo y: "+y);
        System.out.println("Complejo z: "+z);
        z.setComplejo(y.getImaginaria(),w.getReal());
        w.setComplejo(y);
        
        Complejo v = new Complejo();
        v.setComplejo(w.complejoSuma(z));
        System.out.println("\nComplejo v: "+v);
        
        Complejo u= new Complejo(w.complejoSuma(8,5));
        System.out.println("Complejo u: "+u);
        
        //Suma entre 'z' y 'u' 
        System.out.println("Suma de 'z' y 'u': "+z.complejoSuma(u));
        
        Complejo t = new Complejo();
        t.setComplejo(w.complejorResta(y.complejoSuma(8, 5)));
        System.out.println("\nComplejo t: "+t);
        
        Complejo s = new Complejo(w.complejoProducto(y.complejoSuma(t)));
        System.out.println("Complejo s: "+s);
        
       
        Complejo r = new Complejo((y.complejoCociente(t)).getImaginaria(), 10);
        System.out.println("Complejo r: "+r);
        
        //Comprobar si 'r' y 't' son iguales
        if(t.equals(r)) System.out.println("\n'r' y 't' son iguales");
        else System.out.println("'r' y 't' son distintos");
        //Comprobar si 'w' y {5+6i} son iguales
        if(w.equals(5,6)) System.out.println("'w' y {5+6i} son iguales");
        else System.out.println("'w' y {5+6i} son distintos");
        

    }    
}
