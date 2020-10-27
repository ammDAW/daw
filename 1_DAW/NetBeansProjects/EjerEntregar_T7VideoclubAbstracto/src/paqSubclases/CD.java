
package paqSubclases;
import paqEjecutable.Producto;

/**
 *
 * @author ALBERTO
 */
public class CD extends Producto{
    protected int duracion;
    protected String genero;
    private static int contCD=0;
//CONSTRUCTORES
    public CD(int duracion, String genero, String nombre) {
        super(nombre);
        if(duracion<=0)
            throw new IllegalArgumentException("Duración debe ser positiva");
        
        this.duracion = duracion;
        this.genero = genero;
        Producto.contProductos++;
        this.id=Producto.contProductos;
        CD.contCD++;
        this.precio = 1.0;
    }
    
    public CD(CD other){
        this(other.duracion, other.genero, other.nombre);
    }
//GETTERS    
    public int getDuracion() {
        return this.duracion;
    }

    public String getGenero() {
        return this.genero;
    }

    public static int getContCD() {
        return CD.contCD;
    }
    
    @Override
    public double getPrecio (){
        return 1.0;
    }
//SETTERS
    public void setDuracion(int duracion) throws IllegalArgumentException{
        if(duracion<=0)
            throw new IllegalArgumentException("Duración debe ser positiva");
        this.duracion = duracion;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
//TO_STRING
    @Override
    public String toString() {
        return super.toString() + "\tDuración: " + this.duracion + "\tGénero: " + this.genero + ']';
    }
//OTROS METODOS    
    public boolean equals (CD other){
        if(!super.equals(other)) return false;
        if(this.duracion!=other.duracion) return false;
        if(this.genero!=other.genero) return false;
        return true;     
    }
}
