/*Se desea crear un vector cuyo nombre sea diaDelMes, que almacena el número de días
de los meses que componen un año, dándole un valor inicial a cada elemento del
vector. Mostrar por pantalla los días de todos los meses desde Enero hasta Diciembre
y además calcular la suma de los días de los 12 meses*/
package t4_arrays;

public class Ej01_DiasMeses {
    public static void main(String[] args) {
        int diasMes[]={31,28,31,30,31,30,31,31,30,31,30,31};
        int suma=0;
        String nombreMes[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        System.out.println("---MESES DEL AÑO---");
        for(int i=0;i<nombreMes.length;i++){
            System.out.println(nombreMes[i]+" tiene "+diasMes[i]+" días");
            suma+=diasMes[i];
        }
        System.out.println("\nDías totales que tiene un año: "+suma);
    }  
}
