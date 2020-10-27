/*Utilizando el vector del Ejercicio 10, llevar el mayor elemento al 
último a base de intercambios*/
package t4_arrays;

public class Ej12_PasarMayorUltimo {
    public static void main(String[] args) {
        int v[]={12,4,5,78,45,67,45,66,77,44};
        int aux;
        
        for(int i=0;i<(v.length-1);i++){
            if(v[i]>v[i+1]){
                aux=v[i];
                v[i]=v[i+1];
                v[i+1]=aux;
            }
        }
        System.out.println(v[9]);
    }
}
