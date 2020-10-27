/*Ejercicio 1: Se desea crear un punto: 
    #Coordenada X: La coordenada Y del punto opuesto del punto suma de 'q' y 'z'
    #Coordenada Y: La coordenada X del punto intermedio de 'p' con el punto opuesto de 'z'*/
/*Ejercicio 2: Crear otro punto:
    #Coordenada X= coordenada y del punto suma de 'p' y 'nuevo'
    #Coordenada Y= coordenada x del punto opuesto del punto suma de 'p' y 'nuevo'*/

package paqPunto;

public class Ej01_CrearPunto {
    public static void main(String[] args) {
        Punto p = new Punto(4,6);
        Punto q = new Punto(8,8);
        Punto y = new Punto(2,1);
        Punto z = new Punto(3,5);
        Punto nuevo=new Punto(4,5);
        
        Punto ej1 = new Punto(q.ptoSuma(z).ptoOpuesto().getY(), z.ptoOpuesto().ptoIntermedio(p).getX());
        System.out.println("El punto requerido en el ejercicio 1 es: "+ej1);
        
        Punto ej2=new Punto(p.ptoSuma(nuevo).getY(), p.ptoSuma(nuevo).ptoOpuesto().getX());
        System.out.println("El punto requerido en el ejercicio 2 es= "+ej2);
    }
    
}
