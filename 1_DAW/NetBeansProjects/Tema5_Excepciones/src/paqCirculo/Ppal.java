
package paqCirculo;

public class Ppal {
    public static void main(String[] args) {
        Punto p = new Punto(6,7);
        
        Circulo c1 = new Circulo(p,4); System.out.println("Circulo c1 "+c1);
        Circulo c2 = new Circulo(); System.out.println("Circulo c2 "+c2);
        Circulo c3 = new Circulo(8); System.out.println("Circulo c3 "+c3);
        Circulo c4 = new Circulo(3,4,9); System.out.println("Circulo c4 "+c4);
        Circulo c5 = new Circulo(c3); System.out.println("Circulo c5 "+c5);
        
        
//-- CREAR PUNTO USANDO EXCEPCIONES --        
        Circulo cEx = null;
        try{//todas las lineas dentro del try se ejecutan si no lanza la excepcion
            cEx = new Circulo(new Punto(12,4),-4);
            System.out.println("*try ejecutado porque el radio es positivo*");
        }catch(IllegalArgumentException ex){//todas las lineas dentro del catch se ejecutan si se lanza la excepcion
            System.out.println(ex.getMessage());
            System.out.println("*catch ejecutado porque el radio es negativo");
        }       
        System.out.println("Cirulo c3 "+cEx);
      
 //-- USO DE OTROS METODOS --
        System.out.println("\nDistancia entre los circulos c1 y c4: "+c1.distancia(c2));
        
        System.out.println("Distancia entre el circulo c4 y el punto 'p': "+c4.distancia(p));
        
        System.out.println("Area del círculo c1: "+c1.area());
        
        System.out.println("Longitud de la circunferencia de c1: "+c1.longitud());

//-- USO AMPLIAR CIRCULO CON EXCEPCION --        
        try{
            c1.ampliaCirculo(-7); //aplia el radio del circulo en -7 unidades
        } catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        System.out.print("c1 ampliado: "+c1);
    }
    
}
