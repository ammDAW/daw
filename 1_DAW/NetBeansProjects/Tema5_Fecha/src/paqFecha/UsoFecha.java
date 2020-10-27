
package paqFecha;

import java.util.Scanner;

/**
 *
 * @author ALBERTO
 */
public class UsoFecha {
    public static void main(String[] args) {    
        int d,m,a;
        Scanner teclado=new Scanner(System.in);
//a)        
        Fecha f1 = new Fecha();
        
        Fecha f2 = new Fecha();
        try{
            f2=new Fecha(20,2,1);
        }catch(IllegalArgumentException ex){
            //System.out.println(ex.getMessage());
        }
        
        Fecha f3=new Fecha();
        while (f3.getDia()==1 && f3.getMes()==1 && f3.getYear()==1900){
            try{
                System.out.print("Introduce el día: ");
                d=teclado.nextInt();
                System.out.print("Introduce el mes: ");
                m=teclado.nextInt();
                System.out.print("Introduce el año: ");
                a=teclado.nextInt();
                f3=new Fecha(d,m,a);
            }catch(IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }  
        }
        
        Fecha f4=new Fecha(f2);

//b)        
        Fecha f5 = new Fecha();
        try{
            System.out.print("Introduce el día: ");
            d=teclado.nextInt();
            System.out.print("Introduce el año: ");
            a=teclado.nextInt();
            f5=new Fecha(d,12,a);
        } catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
//c)
        Fecha f6 = new Fecha();
        try{
            f6=new Fecha(f4.getDia(),f5.getMes(),2000);
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
//d)        
        System.out.println("f1: "+f1.toString(2));
        System.out.println("f2: "+f2.toString(3));
        System.out.println("f3: "+f3.toString(4));
        System.out.println("f4: "+f4.toString(6));
        System.out.println("f5: "+f5.toString(2));
        System.out.println("f6: "+f6.toString(6));
//e)
        f4 = new Fecha(f5.getDia(),f5.getMes(),f5.getYear());
//f)
        f6 = new Fecha(f1.getDia(),f1.getMes(),f3.getYear());
//g)
        System.out.println("Número de días trascurridos= "+f5.toDias());
//h)
        f3.fechaSiguiente();
        System.out.println("Fecha siguiente f3: "+f3.toString(6));
//i)
        System.out.println("Dias transcurridos entre f4 y f5: "+f5.diasEntreFechas(f4));

//j)
        Fecha mas_antigua = new Fecha(f2.fechaMenor(f5));
        System.out.println("La fecha más antigua entre f2 y f5: "+mas_antigua.toString(1));
//k)
        Fecha mas_nueva = new Fecha(f5.fechaMenor(f1));
        System.out.println("La fecha más nueva entre f1 y f5: "+mas_nueva.toString(1));
//l)
        f4.fechaAnterior();
        System.out.println("Fecha siguiente f4: "+f4.toString(2));
//m)
        //Fecha f7 = new Fecha ((f4.fechaSiguiente()).fechaMayor(f3.fechaAnterior()));
        f4.fechaSiguiente(); f3.fechaAnterior();
        Fecha f7 = new Fecha(f4.fechaMayor(f3));
    } 
}
