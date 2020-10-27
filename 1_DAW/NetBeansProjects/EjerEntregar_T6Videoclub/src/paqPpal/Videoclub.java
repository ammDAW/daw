
package paqPpal;
import java.util.ArrayList;
import paqClasesProductoCliente.Cliente;
import paqClasesProductoCliente.Producto;

/**
 *
 * @author ALBERTO
 */
public class Videoclub {
    private String nombre;
    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;

//CONSTRUCTOR    
    public Videoclub(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList();
        this.productos = new ArrayList();
    }
    
//GETTERS
    public String getNombre() {
        return this.nombre;
    }
    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }
    public ArrayList<Producto> getProductos() {
        return this.productos;
    }

//SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//OTROS METODOS
    public void addProducto(Producto p){//añadir un producto a la lista
        this.productos.add(p);
    }
    
    public void addCliente(Cliente c){//añadir un cliente a la lista
        this.clientes.add(c);
    }
    
    public int getNumProductos(){//devuelve el nºtotal de productos
        return this.productos.size();
    }
    
    public int getNumClientes(){//devuelve el nºtotal de clientes
        return this.clientes.size();
    }

    public void alquilar(Producto p, Cliente c){
        c.alquilarProducto(p);
    }

//TOSTRING
    @Override
    public String toString() {
        String cadena="\nNombre: "+this.nombre;
        if(this.productos.isEmpty())
            cadena+="\n No hay peliculas en el videoclub";
        else{
            cadena+="\n\n--- PELICULAS ---";
            for(int i=0; i<this.productos.size(); i++)
                cadena+="\n"+this.productos.get(i);
        }
        
        if(this.clientes.isEmpty())
            cadena+="\n No hay clientes registrados";
        else{
            cadena+="\n\n--- CLIENTES ---";
            for(int i=0; i<this.clientes.size(); i++)
                cadena+="\n"+this.clientes.get(i).getId()+" "+this.clientes.get(i).getNombre();
        }
        return cadena;
    }  
}
