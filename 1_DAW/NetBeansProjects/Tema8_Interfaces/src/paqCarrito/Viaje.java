
package paqCarrito;

/**
 *
 * @author ALBERTO
 */
public class Viaje implements Vendible{
    private String origen, destino;
    private int ndias;
    private double precio;
    private static double iva=0.21;

//CONSTRUCTOR
    public Viaje(String origen, String destino, int ndias, double precio) {
        this.origen = origen;
        this.destino = destino;
        this.ndias = ndias;
        this.precio = precio;
    }

//GETTERS  
    public String getOrigen() {return origen;}
    public String getDestino() {return destino;}
    public int getNdias() {return ndias;}
    public double getPrecio() {return precio;}
    public static double getIva() {return iva;}

//SETTERS
    public void setOrigen(String origen) {this.origen = origen;}    
    public void setDestino(String destino) {this.destino = destino;}
    public void setNdias(int ndias) {this.ndias = ndias;}
    public void setPrecio(double precio) {this.precio = precio;} 
    public static void setIva(double iva) {Viaje.iva = iva;}

//OTROS METODOS
    @Override
    public String toString() {
        return "[Origen: " + this.origen + "\tDestino: " + this.destino + "\t NºDias: " + this.ndias + "\tPrecio: " + this.precio +"\tIVA: " + this.iva+']';
    }

    @Override
    public double precioIva() {
        return this.precio*1.21;
    }

    
}
