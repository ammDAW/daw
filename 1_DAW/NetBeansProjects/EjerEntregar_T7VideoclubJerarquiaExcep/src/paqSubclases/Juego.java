
package paqSubclases;
import paqClases.Producto;

/**
 *
 * @author ALBERTO
 */
public class Juego extends Producto{
    protected String plataforma, genero;
    private static int contJuegos=0;
//CONSTRUCTORES
    public Juego(String plataforma, String genero, String nombre) {
        super(nombre);
        this.plataforma = plataforma;
        this.genero = genero;
        Producto.contProductos++;
        this.id=Producto.contProductos;
        Juego.contJuegos++;
        this.precio=3.0;
    }

    public Juego(Juego other){
        this(other.plataforma, other.genero, other.nombre);
    }
//GETTERS
    public String getPlataforma() {
        return plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public static int getContJuegos() {
        return contJuegos;
    }
    
    @Override
    public double getPrecio (){
        return 3.0;
    }
//SETTERS
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
//TO_STRING
    @Override
    public String toString() {
        return super.toString()+"\tPlataforma: "+this.plataforma+"\tGénero: "+this.genero+']';
    }
//OTROS METODOS    
    public boolean equals (Juego other){
        if(!super.equals(other)) return false;
        if(this.plataforma!=other.plataforma) return false;
        if(this.genero!=other.genero) return false;
        return true;     
    }
}
