
package paqEjecutable;
import paqSubclases.CD;
import paqSubclases.Pelicula;

/**
 *
 * @author ALBERTO
 */
public class Ppal {
    public static void main(String[] args) {
        //PELICULAS
        Pelicula p1 = new Pelicula("ESPAÑOL",123,"MIEDO","PESADILLA EN ELM STREET");
        System.out.println("p1= "+p1);
        Pelicula p2 = new Pelicula("INGLES",180,"MUSICAL","MAMMA MIA");
        System.out.println("p2= "+p2);
        Pelicula p3 = new Pelicula(p2);
        System.out.println("p3= "+p3);
        
        System.out.println("\nLas peliculas p2 y p3 son "+(p2.equals(p3)?"iguales":"distintas"));
        System.out.println("¿Cuántas películas hay? "+Pelicula.getContPeliculas());
        
        //CDs
        CD cd1=new CD(123, "OFIMATICA", "LIBRE OFFICE");
        System.out.println("\ncd1= "+cd1);
        
        System.out.println("¿Cuántos CDs hay? "+CD.getContCD());
        
        //CLIENTE
        Cliente c1 = new Cliente("ALBERTO");
        
        //alquilar
        c1.alquilarProducto(p1);
        c1.alquilarProducto(p2);
        c1.alquilarProducto(cd1);
        c1.mostrarProductosAlquilados();
        
        c1.mostrarPeliculasAlquiladas();
        
        //ticket y pago
        c1.disenhoTicket();
        System.out.println("\nEl cliente "+c1.getNombre()+" debe pagar "+c1.calculoPago()+'€');
        
        c1.mostrarPeliculasAlquiladasComienzoM();
        System.out.println("\nNúmero de películas alquiladas en Inglés= "+c1.peliculasAlquiladasIdioma("INGLES"));
    
    }
    
}
