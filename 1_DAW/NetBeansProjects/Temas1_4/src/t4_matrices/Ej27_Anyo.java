
package t4_matrices;
import java.util.Scanner;

public class Ej27_Anyo {
    public static void main(String[] args) {
        int a[][] = {
            {1, 12, 6, 5, 8, 7, 9, 4, 5, 3, 6, 12, 5, 4, 9, 10, 11, 15, 2, 6, 8, 12, 11, 13, 12, 14, 10, 11, 10, 21, 10},
            {1, 12, 6, 5, 8, 7, 9, 4, 5, 3, 4, 9, 10, 11, 15, 2, 6, 8, 12, 11, 13, 12, 14, 10, 11, 10, 21, 10},
            {11, 12, 6, 5, 18, 17, 9, 14, 5, 13, 6, 12, 15, 4, 9, 10, 11, 15, 2, 6, 8, 12, 11, 13, 12, 14, 10, 11, 10, 21, 10},
            {11, 12, 6, 5, 18, 17, 14, 5, 13, 6, 12, 15, 4, 9, 10, 11, 15, 2, 6, 8, 12, 11, 13, 12, 14, 10, 11, 10, 21, 10},
            {11, 12, 6, 5, 18, 17, 9, 14, 5, 13, 6, 12, 15, 4, 9, 10, 11, 15, 2, 6, 8, 12, 11, 13, 12, 14, 10, 11, 10, 21, 10},
            {21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
            {25, 26, 26, 24, 25, 26, 24, 25, 27, 28, 29, 30, 31, 33, 30, 31, 32, 31, 32, 31, 32, 31, 32, 32, 32, 32, 32, 32, 32, 32, 32},
            {25, 26, 26, 24, 25, 26, 24, 25, 27, 28, 29, 30, 31, 32, 30, 31, 32, 31, 32, 31, 32, 31, 32, 32, 32, 32, 32, 32, 32, 32, 32},
            {21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
            {11, 12, 6, 5, 18, 17, 9, 14, 5, 13, 6, 12, 15, 4, 9, 10, 11, 15, 2, 6, 8, 12, 11, 13, 12, 14, 10, 11, 10, 21, 10},
            {11, 12, 6, 5, 18, 17, 14, 5, 13, 6, 12, 15, 4, 9, 10, 11, 15, 2, 6, 8, 12, 11, 13, 12, 14, 10, 11, 10, 21, 10},
            {1, 12, 6, 5, 8, 7, 9, 4, 5, 3, 6, 12, 5, 4, 9, 1, 1, 1, 2, 6, 8, 1, 1, 1, 2, 4, 10, 1, 1, 1, 1}
        };
        String mes[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        
        //a) Mostrar por pantalla la temperatura media de cada mes
        for(int meses=0;meses<a.length;meses++){
            int mediaTempMes=0;
            for(int dia=0;dia<a[meses].length;dia++){
                mediaTempMes+=a[meses][dia];
            }
            System.out.println("La temperatura media de "+mes[meses]+" es "+mediaTempMes/a[meses].length);
        }
        
        /*b)Indicar cuál es el día más frío y más cálido de cada mes, para ello, utilizad dos
            vectores, uno de ellos se utilizará para los días más fríos de cada mes y otro
            para los más calurosos*/
        int frio[]=new int[12];
        int calor[]=new int[12];
        for(int meses=0;meses<a.length;meses++){
            int masFrio=Integer.MAX_VALUE, masCalor=Integer.MIN_VALUE;
            for(int dia=0;dia<a[meses].length;dia++){
                if(a[meses][dia]<masFrio){masFrio=a[meses][dia];frio[meses]=dia;}
                if(a[meses][dia]>masCalor){masCalor=a[meses][dia];calor[meses]=dia;}
            }
        }
        System.out.println("\nDIAS MAS FRIOS");
        for(int x=0;x<frio.length;x++){
            System.out.println(mes[x]+": "+(frio[x]+1));
        }
        System.out.println("\nDIAS MAS CALUROSOS");
        for(int x=0;x<calor.length;x++){
            System.out.println(mes[x]+": "+(calor[x]+1));
        }
        
        //c)Calcular el día más caluroso del año, indicando el mes y el día.
        int tempCalorAnyo=Integer.MIN_VALUE, diaMasFrio=0;
        String mesMasFrio="a";
        for(int meses=0;meses<a.length;meses++){
            for(int dia=0;dia<a[meses].length;dia++){
               if(a[meses][dia]>tempCalorAnyo){diaMasFrio=dia+1;mesMasFrio=mes[meses];tempCalorAnyo=a[meses][dia];} 
            }
        }
        System.out.println("\nEl dia más caluroso del año fue el "+diaMasFrio+"/"+mesMasFrio+" con "+tempCalorAnyo+"º\n");
        
        /*d)Mostrad por pantalla las temperaturas de todos los días de un mes
            determinado (introducir el número), controlar que ese número esté 
            dentro de un rango de mes*/
        Scanner teclado=new Scanner(System.in);
        int dato;
        do{
            System.out.print("Introduce un mes: ");
            dato=teclado.nextInt();
            if(dato<1 || dato>12)System.out.println("Mes erroneo");
        }while(dato<1 || dato>12);
        System.out.println("Mes elegido: "+mes[dato-1]);
        for(int dias=0;dias<a[dato-1].length;dias++){
            System.out.print(a[dato-1][dias]+" ");
        }
    }   
}
