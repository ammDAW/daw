
package paqEjecutable;
import java.util.ArrayList;
import paqSubclases.*;

/**
 *
 * @author ALBERTO
 */
public class Cliente {
    private String nombre;
    private int ID;
    private static int contClientes=0;
    /*private ArrayList <Pelicula> listaPeliculas;
    private ArrayList <CD> listaCDs;
    private ArrayList <Videojuego> listaVideojuegos;
    Todo esto pasa a un ArrayList de Productos que con polimorfismo va cambiando*/
    private ArrayList <Producto> listaProductos; //private ArrayList <Producto> listaProductos = new ArrayList(); se puede crear aquí y no hacerlo en el constructor
//CONSTRUCTORES    
    public Cliente(String nombre)throws IllegalArgumentException{
        if(Cliente.contClientes==5){
            throw new IllegalArgumentException("ERROR: número máximo de Clientes dados de alta");
        }
        this.nombre=nombre;
        this.listaProductos=new ArrayList();
        contClientes++;
        this.ID=Cliente.contClientes;
    }
//GETTERS
    public String getNombre() {
        return nombre;
    }

    public int getID() {
        return ID;
    }
    
    public int getNumClientes(){
        return Cliente.contClientes;
    }
    
//SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
//OTROS METODOS    
    @Override
    public String toString() {
        return "\nID: "+this.ID+"\tNombre: "+this.nombre;
    } 
    
    public void alquilarProducto(Producto p){ //añade objetos productos al ArrayList
        this.listaProductos.add(p);
    }
    
    public void devolverProducto(Producto p){
        if (this.listaProductos.contains(p))
            this.listaProductos.remove(p);
    }
    
    public void mostrarProductosAlquilados(){ //muestra el ArrayList
        System.out.println("\nLISTA DE PRODUCTOS ALQUILADOS POR "+this.nombre+':');
        for(Producto p: this.listaProductos)
            System.out.print(p);
    }
    
    public double calculoPago(){ //calcula el precio de los objetos productos del ArrayList
        double suma=0.0;
        for(Producto p: this.listaProductos)
            suma+=p.getPrecio();
        return suma;
    }
    
    public void mostrarPeliculasAlquiladas(){ //muestra los productos de tipo Pelicula que hay en el ArrayList
        System.out.println("\nLISTA DE PELICULAS ALQUILADAS POR "+this.nombre+':');
        for(Producto p: this.listaProductos)
            if(p instanceof Pelicula) System.out.print(p);
    }
    
    public void mostrarCDsAlquilados(){ //muestra los productos de tipo CD que hay en el ArrayList
        System.out.println("\nLISTA DE CDs ALQUILADOS POR "+this.nombre+':');
        for(Producto p: this.listaProductos)
            if(p instanceof CD) System.out.print(p);
    }
    
    public void mostrarJuegosAlquiladas(){ //muestra los productos de tipo Juego que hay en el ArrayList
        System.out.println("\nLISTA DE JUEGOS ALQUILADOS POR "+this.nombre+':');
        for(Producto p: this.listaProductos)
            if(p instanceof Juego) System.out.print(p);
    }
    
    public void mostrarPeliculasAlquiladasComienzoM(){//muestra los objetos peliculas que el nombre empiece por "M"
        System.out.println("\nLISTADO DE PELICULAS CUYO NOMBRE COMIENCE POR M:");
        for(Producto p: this.listaProductos){
            if(p instanceof Pelicula){
                if(p.getNombre().startsWith("M")) System.out.print("ID: "+p.getId()+",  Nombre: "+p.getNombre());
            }
        }  
    }
    
    public int peliculasAlquiladasIdioma(String idioma){ //muestra el numero de Peliculas con un idioma determinado hay en el ArrayList
        //System.out.println("\nPELICULAS CUYO IDIOMA ES "+idioma);
        int num=0;
        for(Producto p: this.listaProductos){
            if(p instanceof Pelicula){
                if(((Pelicula)p).getIdioma()==idioma){
                    //System.out.println(p.getNombre());
                    num++;
                }  
            }
        }
        return num;
    }
    
    public void disenhoTicket(){//muestra deglosadamente los precios de todas los distintos productos alquilados
        System.out.println("\n\nPRODUCTOS ALQUILADOS A "+this.nombre);
        double sumaTotal=0.0, sumaParcial=0.0;
        System.out.println("PELICULAS---");
        for(Producto p: this.listaProductos){
            if(p instanceof Pelicula){
                System.out.println(p.getNombre()+"\t"+p.getPrecio());
                sumaParcial+=p.getPrecio();
            }
        }
        System.out.println("Precio de Películas:............"+sumaParcial);
        sumaTotal+=sumaParcial;
        
        sumaParcial=0.0;
        System.out.println("CDs---");
        for(Producto p: this.listaProductos){
            if(p instanceof CD){
                System.out.println(p.getNombre()+"\t"+p.getPrecio());
                sumaParcial+=p.getPrecio();
            }
        }
        System.out.println("Precio de CDs:............"+sumaParcial);
        sumaTotal+=sumaParcial;
        
        sumaParcial=0.0;
        System.out.println("JUEGOS---");
        for(Producto p: this.listaProductos){
            if(p instanceof Juego){
                System.out.println(p.getNombre()+"\t"+p.getPrecio());
                sumaParcial+=p.getPrecio();
            }
        }
        System.out.println("Precio de Juegos:............"+sumaParcial);
        /*sumaTotal+=sumaParcial;
        System.out.println("PAGO TOTAL: "+sumaTotal);*/
    }
}
