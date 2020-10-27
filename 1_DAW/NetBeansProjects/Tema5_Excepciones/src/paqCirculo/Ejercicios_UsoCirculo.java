package paqCirculo;
import paqCirculo.*;

public class Ejercicios_UsoCirculo {
    public static void main(String[] args) {
    //a) Crear puntos
        Punto p= new Punto();
        Punto q= new Punto(5,4);
        Punto r= new Punto(8,8); //se supone que se introduce por teclado
        Punto s= new Punto(q); //Punto s = new Punto(q.getX(),q.getY());
        
    //b) Crear circulos
        Circulo c1 = new Circulo(); //(0,0),0
        Circulo c2 = new Circulo(q,4); //(5,4),4
        Circulo c3 = new Circulo(7,10,12); //(7,10),12
        Circulo c4 = new Circulo(7); //(0,0),7
        Circulo c5 = new Circulo(c3); //(7,10),12 
        Circulo c6 = new Circulo(c3.getCentro(),c4.getRadio()); //(7,10),7
        Circulo c7 = new Circulo(q.ptoOpuesto(),19); //(-5,-4),19
        Circulo c8 = new Circulo(p.ptoIntermedio(c7.getCentro()),24); //(-2,-2),24
  
    //c) Mostrar las propiedades de todos los circulos.
        System.out.println("Circulo c1: "+c1);
        System.out.println("Circulo c2: "+c2);
        System.out.println("Circulo c3: "+c3);
        System.out.println("Circulo c4: "+c4);
        System.out.println("Circulo c5: "+c5);
        System.out.println("Circulo c6: "+c6);
        System.out.println("Circulo c7: "+c7);
        System.out.println("Circulo c8: "+c8);
        
    //d) Mostrar las coordenadas del centro del circulo c8
        System.out.println("\nd) Coordenadas del centro de c8: "+ c8.getCentro());
        
    //e)
        //Cambiar coordenadas del centro de c5 por las del centro de c7
        c5.setCentro(c7.getCentro()); System.out.println("\ne) c5: "+c5);
        //Cambiar las coordenadas del centro de c4 por las del punto 'r'
        c4.setCentro(r); System.out.println("e) c4: "+c4);
    
    //f) cambiar las coordenadas del centro de c2 por los valores: 4 y 5
        c2.setCentro(new Punto(4,5)); System.out.println("\nf) c2: "+c2);
    
    //g) cambiar las coordenadas del centro de c4 por las coordenadas
    //de punto suma entre el centro de c4 y el punto opuesto de 'r'*/
        c4.setCentro(c4.getCentro().ptoSuma(r.ptoOpuesto())); System.out.println("\ng) c4: "+c4);

    //h) cambiar el radio de c5 por la coordenada 'x' del centro de c4
        c5.setRadio(c4.getCentro().getX()); System.out.println("\nh) c5: "+c5);

    //i) cambiar c6: centro-> centro c5, radio-> 'x' del punto 'r'
        c6.setCirculo(c5.getCentro(), r.getX()); System.out.println("\ni) c6: "+c6);

    //j) cambiar c4: centro-> x='y' de centro c5, y=7, radio->radio de c4
        c4.setCirculo(c5.getCentro().getY(), 7, c4.getRadio()); System.out.println("\ni) c7: "+c7);

    //k)
        //cambiar coordenadas de c7 por las de c4    
        c7.setCirculo(c4.getCentro(),c4.getRadio());System.out.println("\nk) c7: "+c7);
        //calcular longitud de c8
        System.out.println("k) Longitud de c8= "+c8.longitud());
        
    //q)
        /*Calcular la distancia entre el centro de c7 y el punto
        formado por las coordenadas del punto generado por las coordenadas:
        x-> 'x' del centro de c2 y la coordenada 'y' del centro de c3*/
        double d= c7.distancia(c2.getCentro().getX(), c3.getCentro().getY());
        System.out.println("\nq) Distancia: "+d);
    }
}
