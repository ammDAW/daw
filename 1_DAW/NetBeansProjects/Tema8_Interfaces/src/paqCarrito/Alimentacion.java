
package paqCarrito;

/**
 *
 * @author ALBERTO
 */
public class Alimentacion extends Producto{
    protected double iva=0.4;

//CONSTRUCTOR
    public Alimentacion(String nombre, double precio) {
        super(nombre, precio);
    }

//GETTER & SETTER
    public double getIva() {return iva;}
    public void setIva(double iva) {this.iva = iva;}

//OTROS METODOS
    @Override
    public String toString() {
        return super.toString()+"\t IVA: " + this.iva + ']';
    }

    public double precioIva(){
        return this.precio*1.04;
    }
}
