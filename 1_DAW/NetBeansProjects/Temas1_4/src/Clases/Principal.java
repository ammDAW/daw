
package Clases;

public class Principal {
    public static void main(String[] args) {
        int nota;
        nota=Pedir.entero("Dime tu nota: ");
        System.out.println("Tienes un: "+nota);
        
        int edad=Pedir.entero("Dime tu edad: ");
        System.out.println("Tienes "+edad+" años");
    
        System.out.println(Pedir.entero("Dime el número de alumnos: "));
        
        int distancia;
        String msg="Dime la distancia en Kms de Madrid a Murcia: ";
        distancia=Pedir.entero(msg);
        System.out.println("Hay "+distancia+" kms");
        
       double numero=Pedir.pedirDouble(msg);
    } 
}
