package t2_ejercicios;

public class OperadorTernario {
    public static void main(String[] args) {
        /*  ()?=
            (condicion)?instruccion_if:instruccion_else;
        */
              

        /*Introduceir la nota entera de una alumno y decir si está aprobado 
        o suspenso usando un operador ternario*/
        int nota=9;
        String variable;
        variable=(nota>=5)?"Aprobado":"Suspenso";
        System.out.println(variable);
        
        //calculo del valor mayor de 2 numeros enteros
        int num1=34, num2=90, mayor;
        mayor=(num1>num2)?num1:num2;
        System.out.println("El mayor es "+mayor);
        
        //saber si es par o impar
        String palabra=(6%2==0)?"Es par":"Es impar";
        System.out.println(palabra);       
    }   
}
