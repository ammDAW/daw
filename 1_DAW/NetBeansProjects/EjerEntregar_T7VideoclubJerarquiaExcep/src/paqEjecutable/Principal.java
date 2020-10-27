
package paqEjecutable;
import paqClases.Producto;
import paqClases.Cliente;
import paqClases.Videoclub;
import paqSubclases.*;

/**
 *
 * @author ALBERTO
 */
public class Principal {
    public static void main(String[] args) {
    //VIDEOCLUB
        Videoclub videoMax = new Videoclub("VideoMax");
    //CLIENTES
        Cliente c1 = new Cliente("Francisco"); videoMax.addCliente(c1);
        Cliente c2 = new Cliente("Javier"); videoMax.addCliente(c2);
        Cliente c3 = new Cliente("Paco"); videoMax.addCliente(c3);
        Cliente c4 = new Cliente("Antonio"); videoMax.addCliente(c4);
    //PELICULAS
        try{
            Pelicula p0 = new Pelicula("EEE",-10,"FICCION","LA ARMADA INVENCIBLE");
            videoMax.addProducto(p0);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            //En excepciones primero saldrá el error de la duración y después el del idioma
        }
        
        Pelicula p1 = null;
        try{
            p1 = new Pelicula("ESPAÑOL",200,"FICCION","EL SEÑOR DE LOS ANILLOS");
            videoMax.addProducto(p1);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        Pelicula p2 = null;
        try{
            p2 = new Pelicula("INGLES",45,"FICCION","THE HOBBIT");
            videoMax.addProducto(p2);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        Pelicula p3 = null;
        try{
            p3 = new Pelicula("INGLES",29,"FICCION","STAR WARS III");
            videoMax.addProducto(p3);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        Pelicula p4 = null;
        try{
            p4 = new Pelicula("ESPAÑOL",78,"COMEDIA","EL DISCURSO DEL REY");
            videoMax.addProducto(p4);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        Pelicula p5 = null;
        try{
            p5 = new Pelicula("FRANCES",123,"INFANTIL","SHREK");
            videoMax.addProducto(p5);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    //CDs
        CD cd1 = null;
        try{
            cd1 = new CD(6,"U2","U2 BOY IN 1980");
            videoMax.addProducto(cd1);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        CD cd2 = null;
        try{
            cd2 = new CD(8,"QUEEN","QUEEN DON'T STOP NOW");
            videoMax.addProducto(cd2);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    //JUEGOS
        Juego j1 = null;
        try{
            j1 = new Juego("PS3","PLATAFORMAS","SIMPSONS GAME");
            videoMax.addProducto(j1);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        Juego j2 = null;
        try{
            j2 = new Juego("WII","AVENTURAS","ZELDA");
            videoMax.addProducto(j2);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        Juego j3 = null;
        try{
            j3 = new Juego("NINTENDO DS","CARRERAS","MARIO KART");
            videoMax.addProducto(j3);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    //alquilar
        videoMax.alquilar(p1, c1);
        videoMax.alquilar(p2, c1);
        videoMax.alquilar(p3, c2);
        
    //número clientes y número películas
        System.out.println("Número de clientes: "+videoMax.getNumClientes());
        
        int nump=0; // nariable que cuenta el número de peliculas
        //for(videoMax.getProductos())
        for(Producto p : videoMax.getProductos()){
            if (p instanceof Pelicula) nump++;
        }
        System.out.println("Número de peliculas: "+nump);
    
    //lista clientes
        System.out.println("\n--LISTA CLIENTES--");
        System.out.println(videoMax.getClientes());
    //lista productos
        System.out.println("\n--LISTA PRODUCTOS--");
        System.out.println(videoMax.getProductos());
    //lista productos alquilados Francisco
        c1.mostrarProductosAlquilados();
    //crear producto igual a p3 y mostra numero total productos
        Producto p6 = new Pelicula(p3);
        System.out.println("\nNumero de productos en total creados: "+Producto.getContProductos());
               
    } 
}
