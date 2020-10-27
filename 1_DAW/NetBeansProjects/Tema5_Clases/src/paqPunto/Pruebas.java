
package paqPunto;

public class Pruebas {

    public static void main(String[] args) {
        Punto p=new Punto(4,6);
        System.out.println("p= "+p);
       
        Punto q=new Punto(8,8);
        System.out.println("q= "+q);
       
        //Calcular la distancia enter dos puntos
        System.out.println("Distancia entre 'p' y 'q': "+p.distancia(q));
        
        //Crear un punto usando las coordenadas de dos puntos distintos
        Punto t=new Punto(p.getY(),q.getY()); //t=(6,8)
        System.out.println("t= "+t);
        
        //Calcular la distancia creando a su vez un nuevo Punto
        System.out.println("Distancia entre 'p' y (5,6): "+p.distancia(new Punto(5,6))); //el Punto(5,6) se crea aquí y muere aquí
        
        //Calcular el punto intermedio entre p y q
        Punto ptoInt=p.ptoIntermedio(q);
        System.out.println("El punto intermedio entre 'p' y 'q' es: "+ptoInt);
        //Calcular el punto intermedio entre p y ptoInt
        System.out.println("El punto intermedio entre 'p' y 'ptoInt' es: "+p.ptoIntermedio(ptoInt));
        
        //Calcular la suma de dos puntos
        Punto suma=p.ptoSuma(q);
        System.out.println("La suma de los puntos 'p' y 'q' es: "+suma);
        
        //Calcular el punto opuesto de p
        Punto op=p.ptoOpuesto();
        System.out.println("El punto opuesto de 'p' es: "+op);
        
        //Comprobar si p y q son iguales
        if (p.equals(q))System.out.println("Son iguales");
        else System.out.println("Son distintos");
        
        
/*--USO METODOS SOBRECARGADOS--*/
        double d=p.distancia(6,2); //pasandole dos enteros
        System.out.println("Distancia entre el punto 'p' y la coordenada (6,2)= "+d);
        Punto nuevo=new Punto(6,2);
        System.out.println("Dintancia de 'p' y 'nuevo'= "+p.distancia(nuevo)); //pasandole un objeto
        
        //LAS TRES FORMAS DE USAR EL METODO DISTANCIA QUE ESTÁ SOBRECARGADO
        System.out.println("Distancia entre 'p' y el punto origen (0,0)= "+p.distancia()); //sin entrada
        System.out.println("Distancia entre 'p' y el punto origen (0,0)= "+p.distancia(0,0)); //entrada= enteros
        System.out.println("Distancia entre 'p' y el punto origen (0,0)= "+p.distancia(new Punto(0,0))); //entrada= objeto Punto
        
        
/*--USO SOBRECARGA CONSTRUCTORES--*/
        Punto u= new Punto();
        Punto v= new Punto(u);
        Punto w=new Punto(0,0);
        System.out.println("u= "+u);
        System.out.println("v= "+v);
        System.out.println("w= "+w);
        
        Punto copiaW=new Punto(w);

    }    
}
