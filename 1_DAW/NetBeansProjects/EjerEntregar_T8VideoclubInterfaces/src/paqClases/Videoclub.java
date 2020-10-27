
package paqClases;
import java.util.ArrayList;
import paqSubclases.*;
import paqExcepciones.*;

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
    public void addProducto(Producto p) throws NoMas50ProductosVideoclubException, NoMas20ClientesVideoclubException{//añadir un producto a la lista
        if(this.productos.size()==50){
            throw new NoMas50ProductosVideoclubException();
        }
        this.productos.add(p);
    }
    
    public void addCliente(Cliente c) throws NoMas20ClientesVideoclubException{//añadir un cliente a la lista
        if(this.clientes.size()==20){
            throw new NoMas20ClientesVideoclubException();
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
    
    public void devolverProducto(Cliente c, Producto p){//ejercicios interfaces
        c.devolverProducto(p);
    }
    
    public void retirarProducto(Producto pr){//ejercicio interfaces
        if(this.productos.contains(pr))
            pr.retirar();            
    }
       
    public void venderProducto(Producto pr, int precio) throws ProductosException{//ejercicio interfaces
        //aunque el ejerccio pide lanzar un mensaje de error, he preferido hacerlo con una excepcion y personalizando el mensaje
        if(this.productos.contains(pr))
            if(pr instanceof Pelicula) ((Pelicula)pr).vender(precio);
            if(pr instanceof Juego) ((Juego)pr).vender(precio);
            else throw new ProductosException("ERROR: El producto no existe");
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
