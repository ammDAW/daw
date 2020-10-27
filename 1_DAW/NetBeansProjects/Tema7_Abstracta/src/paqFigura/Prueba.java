
package paqFigura;

/**
 *
 * @author ALBERTO
 */
public class Prueba {
    public static void main(String[] args) {
        /*  Un objeto NUNCA se puede crear utilizando el operador new  y la clase abstracta
            Figura f= new Figura(); 
            System.out.println("Área de f= "+f.area());
        */
        Figura f;
        
        Circulo c= new Circulo(8);
        System.out.println("Área de c= "+c.area());
        c.setRadio(9);
        System.out.println("Area de c= "+c.area());
        
        Rectangulo r= new Rectangulo(3,5);
        System.out.println("Área de t= "+r);
        
        /*  Polimorfismo
            La figura 'f' se transforma en un círculo
        */
        f=c;
        System.out.println("\nÁrea de 'f' transformado en un círculo 'c'= "+f.area());
        
        //  La figura 'f' se transforma en un rectángulo 'r'
        f=r;
        System.out.println("\nÁrea de 'f' transformada en el rectángfulo 'r'= "+f.area());
        
        System.out.println("\nf (como t)= "+f);
        
        f = new Rectangulo(15,3); //'f' se crea como un rectángulo
        System.out.println("'f' como Rectangulo(15,3)= "+f);
        System.out.println("Área de 'f' como Rectángulo(15,3)= "+f.area());
        
        
        //Se declara una figura 'x' y se crea una zona de memoria pra un rectángulo
        Figura x = new Rectangulo(7,4);
        System.out.println("x= "+x);
        System.out.println("Area de x = "+x.area());
        System.out.println("Perímetro de x = "+x.perimetro());
        
    }
    
}
