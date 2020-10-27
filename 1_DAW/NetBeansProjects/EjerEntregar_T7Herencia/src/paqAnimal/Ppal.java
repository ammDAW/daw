
package paqAnimal;
import java.util.ArrayList;
import paqFecha.Fecha;

/**
 *
 * @author ALBERTO
 */
public class Ppal {
    public static void main(String[] args) {
        Fecha f1 = new Fecha(4,10,2001);
        Animal a1 = new Animal(3,f1);
        Vertebrado v1= new Vertebrado(14,a1);
        
        ArrayList <Hijo> hijos = new ArrayList();
        hijos.add(new Hijo("Pepe", new Fecha(3,10,2000)));
        hijos.add(new Hijo("Carlos", new Fecha(16,2,2004)));
        hijos.add(new Hijo("Maria", new Fecha(7,7,2005)));
        hijos.add(new Hijo("Juan", new Fecha(18,8,2006)));
        hijos.add(new Hijo("Ana", new Fecha(18,8,2006)));
        
        Hombre h1 = new Hombre();
        try{
            h1 = new Hombre("Pedro Perez",true,hijos,v1);
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(h1);
        a1=h1;
        /*a1 sólo puede acceder a los metodos y propiedades únicas de la clase
        Animal porque a1 sigue siendo un objeto de tipo Animal
        aunque coge las variables de h1 y el toString de Hombre*/
        
        a1.setPeso(45);
        System.out.println("peso h1= "+h1.peso);
        
        try{
            h1.tenerHijos(new Hijo("Raquel", new Fecha(1,1,2010)));
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        
        Fecha hoy = new Fecha(29,03,2020);
        System.out.println("\nEdad hijo menor de h1: "+h1.edadHijoMenor(hoy)); 
        System.out.println("Nombre hijo menor de h1: "+h1.nombreHijoMenor(hoy));
        
        //h1.lugarHijo(new Hijo("Pepe", new Fecha(3,10,2000)));
        
        try{
            h1.morir();
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }        
    }  
}
