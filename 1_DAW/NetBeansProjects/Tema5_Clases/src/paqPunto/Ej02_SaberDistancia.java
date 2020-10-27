/*Se desea saber la distancia entre el punto suma de 'p' y el opuesto del punto
intermedio entre 'q' y 'nuevo' con el origen. p=(4,6), q=(8,8), nuevo=(4,5)*/
package paqPunto;

public class Ej02_SaberDistancia {
    public static void main(String[] args) {
        Punto p=new Punto(4,6);
        Punto q=new Punto(8,8);
        Punto nuevo=new Punto(4,5);
        
        //dos formas de hacerlo
        System.out.println("Resultado Forma1: "+p.ptoSuma(q.ptoIntermedio(nuevo).ptoOpuesto()).distancia());
        System.out.println("Resultado Forma2: "+q.ptoIntermedio(nuevo).ptoOpuesto().ptoSuma(p).distancia());    
    }
}
