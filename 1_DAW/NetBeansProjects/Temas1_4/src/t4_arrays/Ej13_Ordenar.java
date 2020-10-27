/*Utilizando el vector del Ejercicio 10, ordena el vector en orden ascendente
con el método de la Burbuja (a base de intercambios)*/
package t4_arrays;
import Clases.Vectores;

public class Ej13_Ordenar {
    public static void main(String[] args) {
        int v[]={12,4,5,78,45,67,45,66,77,44};
        int aux;
        
        for(int pasada=1;pasada<v.length;pasada++){
            for(int i=0;i<(v.length-pasada);i++){
                if(v[i]>v[i+1]){
                    aux=v[i];
                    v[i]=v[i+1];
                    v[i+1]=aux;
                }
            }
        }
        Vectores.mostrarVector(v);
    }   
}
