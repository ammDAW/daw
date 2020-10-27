
package paqCarrito;

/**
 *
 * @author ALBERTO
 */
public abstract class Producto implements Vendible{
//al no codificar el método heredado precioIva, hay que hacer a la clase Producto abstracta    
    protected String nombre;
    protected double precio;

//CONSTRUCTOR
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

//GETTERS
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

//SETTERS
    public double getPrecio() {return precio;}
    public void setPrecio(double precio) {this.precio = precio;}

    @Override
    public String toString() {
        return "[Nombre: " + this.nombre + "\tPrecio:" +this.precio;
    }
    
    
}
