
package paqFiguraAbstracta;

/**
 *
 * @author ALBERTO
 */
public class Ppal {
    public static void main(String[] args) {
        Figura f;
        //Rectangulo r= new Rectangulo(6,4); no se puede porque Rectangulo es abstracto
        Rectangulo r;
        Circulo cir = new Circulo(5);
        f=cir; //Figura 'f' apunta a Circulo 'cir'
        System.out.println("Area cir= "+cir.area());
        System.out.println("Area f= "+f.area());
        
        Cuadrado cua= new Cuadrado(8);
        System.out.println("Cuadrado cua= "+cua);
        System.out.println("Area de cua= "+cua.area());
        System.out.println("Altura de cua= "+cua.getAltura());    
    }
    
}
