/*Crear una matriz de enteros con 3 filas, usando el array del edificio
a. Se desea calcular la suma total de todos los valores de los elementos de la matriz.
b. Se desea calcular la suma de cada una de las filas.
c. Se desea guardar un vector, la suma de cada una de las filas de la matriz.
    Mostrar posteriormente el valor de los elementos del vector.*/
package t4_matrices;

public class Ej26_CalcularYCrear {
    public static void main(String[] args) {
        int m[][]={{3,2,1,6,2},{12,3,6},{5,6,9,10}};
        
        int v[]=new int[3];
        int sumTotal=0; //suma total de valores
        int sumFila;//suma de cada fila
        
        for(int x=0;x<m.length;x++){
            sumFila=0;
            for(int y=0;y<m[x].length;y++){
                sumTotal+=m[x][y];
                sumFila+=m[x][y];
            }
            v[x]=sumFila;
            System.out.print(v[x]+" ");
        }
        System.out.println("\nLa cantidad total es "+sumTotal);
    }
}
