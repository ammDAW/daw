
package paqFigura;

/**
 *
 * @author ALBERTO
 */
public abstract class Figura {  //Una clase que tenga al menos 1 método abstract --> debe de contener la palabra abstract en su declaración
    /*public double area(){
        return 0;
    }*/
    public abstract double area(); //es un método que NO tiene código y debe ser redefinido en subclases
    public abstract double perimetro();
    
}
