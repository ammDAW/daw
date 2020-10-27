/*Realizar un programa tal que, pida el día, mes y año y nos indique si 
la fecha es correcta o incorrecta*/
package t4_arrays;
import Clases.Pedir; 
import Clases.Vectores;

public class Ej06_FechaCorrecta {
    
    public static void main(String[] args) {
        int diasMes[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
        int dia;
        int mes;//entre 1 y 12
        int anyo;//entre 1900 y 2100 (siglo XXI)
        //boolean fechaCorrecta=false;
        dia=Pedir.entero("Introduce el día: ");
        mes=Pedir.entero("Introduce el mes: ");
        anyo=Pedir.entero("Introduce el año: ");
        
        /*if (anyo>=1900 && anyo<=2100){
            if(mes>=1 && mes<=12){
                //if((anyo%4==0) && (anyo%100!=0) || (anyo%400==0))diasMes[2]=29;
                if(Vectores.bisiesto(anyo)) diasMes[2]=29;
                if(dia>=1 && dia<=diasMes[mes])fechaCorrecta=true;
            }
        }*/
        /*if(fechaCorrecta)System.out.println("La fecha es correcta");
        else System.out.println("La fecha es incorrecta");*/
        System.out.println("La fecha"+((Vectores.fechaCorrecta(diasMes, dia, mes, anyo))?" ":" NO ")+"es correcta");
    }
}
