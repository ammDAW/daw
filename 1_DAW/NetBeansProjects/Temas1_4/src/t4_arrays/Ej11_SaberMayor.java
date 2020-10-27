/*Utilizando el vector del Ejercicio 10, calcular cuál es el mayor elemento e
intercambiarlo por el elemento que ocupa la última posición*/
package t4_arrays;
import Clases.Vectores;

public class Ej11_SaberMayor {
    public static void main(String[] args) {
        int v[]={12,4,5,78,45,67,45,66,77,44};
        int mayor=v[0], posicion=0;
        for(int i=1;i<v.length;i++){
            if(mayor<v[i]){
                mayor=v[i];
                posicion=i;
            }
        }
        int aux=v[9];
        v[posicion]=aux;
        v[9]=mayor;
        Vectores.mostrarVector(v);
    }   
}
