
package paqCarrito;

/**
 *
 * @author ALBERTO
 */
public class Ropa extends Producto{
    protected static double iva=0.1;
    /*se podría poner como final ya que no va a cambiar, 
    pero entonces no podráimos hacer el setIva*/

//CONSTRUCTOR
    public Ropa(String nombre, double precio) {
        super(nombre, precio);
    }

//GETTER & SETTER
    public static double getIva() {return iva;}
    public void setIva(double iva) {this.iva = iva;}

//OTROS
    @Override
    public String toString() {
        return super.toString()+"\tIVA: " + this.iva + ']';
    }
    
    @Override
    public double precioIva(){
        return this.precio*1.1;
    }  
}
