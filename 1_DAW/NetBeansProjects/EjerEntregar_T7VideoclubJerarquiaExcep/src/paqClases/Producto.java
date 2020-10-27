
package paqClases;

/**
 *
 * @author ALBERTO
 */
public abstract class Producto {
    protected int id;
    protected String nombre;
    protected double precio;
    protected static int contProductos=0;
//CONSTRUCTOR    
    public Producto (String nombre){
        this.nombre = nombre;
    }
//GETTERS
    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public abstract double getPrecio();
    
    public static int getContProductos(){
        return Producto.contProductos;
    }
//SETTER    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
//TO_STRING    
    @Override
    public String toString() {
        return "\n[ID: "+this.id+"\tNombre: "+this.nombre+"\tPrecio: "+this.precio;
    }
//EQUALS    
    public boolean equals(Producto other){
        //if(this.id != other.id) return false; se qwuita porque pueden es para saber si hay más copias, ya que tiene un ID distinto
        if(this.nombre != other.nombre) return false;
        if(this.precio != other.precio) return false;
        return true;
    }
}
