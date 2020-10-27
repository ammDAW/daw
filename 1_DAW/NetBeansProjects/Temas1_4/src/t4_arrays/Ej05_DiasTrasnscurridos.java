/*Realizar una clase que pida el día, mes y año, y nos diga cuántos días han transcurrido
desde el 1 de Enero hasta esa fecha introducida.(Controlar también si el año es
bisiesto, un año es bisiesto cuando el resto de dividirlo entre 400 es 0)*/
package t4_arrays;
import Clases.Vectores; import Clases.Pedir;

public class Ej05_DiasTrasnscurridos {

    public static void main(String[] args) {
        int diasMes[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
        
        int dia=Pedir.entero("Introduce un día: ");
        int mes=Pedir.entero("Introdue un mes: ");
        int anyo=Pedir.entero("Introduce un año: ");
        if(Vectores.fechaCorrecta(diasMes,dia,mes,anyo)==true){
            if(Vectores.bisiesto(anyo)==true) diasMes[2]=29;
            int sumaDias=0;
            for(int i=1;i<=mes-1;i++)sumaDias+=diasMes[i];
            sumaDias+=dia;
            System.out.println("Los días transcurridos desde el 1 de Enero son "+sumaDias+" días");
        }
        
    }
    
}
