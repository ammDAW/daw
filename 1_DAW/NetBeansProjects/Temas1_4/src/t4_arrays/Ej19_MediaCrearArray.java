/*Calcular la media aritmética de una lista de x elementos del vector, donde x 
se introduce previamente por teclado*/
package t4_arrays;
import Clases.Pedir;
import Clases.Vectores;

        
public class Ej19_MediaCrearArray {
    public static void main(String[] args) {
        int x=Pedir.entero("Dime el número de elementento del array: ");
        int v[]=new int[4];
        
        System.out.println("INTRODUCCIÓN DE DATOS");
        v=Vectores.introducirVector(x);
        int suma=0;
        for(int i=0;i<v.length;i++){
            suma+=v[i];
        }
        System.out.println("La media de los datos del array es: "+(float)suma/x);
        
        //Ejercicio 21, saber el mayor
        int mayor=v[0];
        for(int a:v){ //for each - para cada valor de v (a=dato de cada posicion del array)
            if(a>mayor)mayor=a;
            System.out.println("Valor de a: "+a);
        }
        System.out.println("El mayor es "+mayor);
        
        //Ejercicio 22, saber el menor y su posicion
        int menor=v[0];
        int posicion=0;
        for (int i=1;i<v.length;i++){
            if(v[i]<menor){menor=v[i];posicion=i;}
        }
        System.out.println("El menor es "+menor+" y está en la posicion "+posicion);
    }  
}
