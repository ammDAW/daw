
package paqPpal;
import paqClasesProductoCliente.Producto;
import paqClasesProductoCliente.Cliente;

/**
 *
 * @author ALBERTO
 */
public class Ppal {
    public static void main(String[] args) {
    //1.
        Videoclub v = new Videoclub("VideoMAx");
    //2.
        Cliente c1 = new Cliente("Francisco");
        Cliente c2 = new Cliente("Javier");
        Cliente c3 = new Cliente("Paco");
        Cliente c4 = new Cliente("Antonio");
    //3.
        Producto p1 = new Producto("El Señor de los Anillos", 180, 3.90, "ESPAÑOL");
        Producto p2 = new Producto("The Hobbit", 125, 15, "INGLES");
        Producto p3 = new Producto("Star Wars III", 93, 10.99, "ESPAÑOL");
        Producto p4 = new Producto("El discurso del Rey", 60, 20.50, "FRANCES");
        Producto p5 = new Producto("Shrek", 62, 5, "CHINO");
    //4.
        v.addCliente(c1);
        v.addCliente(c2); 
        v.addCliente(c3); 
        v.addCliente(c4);
    
        v.addProducto(p1);
        v.addProducto(p2);
        v.addProducto(p3);
        v.addProducto(p4);
        v.addProducto(p5);
    //5.
        v.alquilar(p1, c1); v.alquilar(p2, c1);
    //6.
        System.out.println("El número de peliculas es "+v.getNumProductos());
    //7.
        System.out.println("El número de clientes es "+v.getNumClientes());
    //8.
        v.alquilar(p3, c2);
    //9.
        System.out.println("\nCLIENTES");
        System.out.println(v.getClientes());
    //10.
        System.out.println("\nPRODUCTOS");
        System.out.println(v.getProductos());
    //11.
        System.out.println("\nProductos alquilados por Francisco");
        System.out.println(c1.getProductosAlquilados());
    //12.
        Producto p6 = new Producto(p3);
        System.out.println("\n"+p6);
        
        /*ArrayList <Producto> lista = v.getProductos();
        for(Producto p: lista) System.out.println("");*/
        
    }
    
}
