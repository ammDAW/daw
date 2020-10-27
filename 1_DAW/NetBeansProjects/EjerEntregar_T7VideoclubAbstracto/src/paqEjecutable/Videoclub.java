
package paqEjecutable;
import java.util.ArrayList;
import paqSubclases.*;

/**
 *
 * @author ALBERTO
 */
public class Videoclub {
    private String nombre;
    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos = new ArrayList();

//CONSTRUCTOR    
    public Videoclub(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList();
        //this.productos = new ArrayList();
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
    public void addProducto(Producto p) throws IllegalArgumentException{//añadir un producto a la lista
        if(this.productos.size()==50){
            throw new IllegalArgumentException("ERROR: número máximo de productos alquilados");
        }
        this.productos.add(p);
    }
    
    public void addCliente(Cliente c) throws IllegalArgumentException{//añadir un cliente a la lista
        if(this.clientes.size()==20){
            throw new IllegalArgumentException("ERROR: número máximo de clientes añadidos");
        }
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
            cadena+="\n No hay productos en el videoclub";
        else{
            cadena+="\n\n--- PRODUCTOS ---";
            for(int i=0; i<this.productos.size(); i++)
                cadena+="\n"+this.productos.get(i);
        }
        
        if(this.clientes.isEmpty())
            cadena+="\n No hay clientes registrados";
        else{
            cadena+="\n\n--- CLIENTES ---";
            for(int i=0; i<this.clientes.size(); i++)
                cadena+="\nID: "+this.clientes.get(i).getID()+"\tNombre: "+this.clientes.get(i).getNombre();
        }
        return cadena;
    }  
}
