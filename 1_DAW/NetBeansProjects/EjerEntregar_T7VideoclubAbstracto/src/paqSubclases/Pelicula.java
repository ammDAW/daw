
package paqSubclases;
import paqEjecutable.Producto;

/**
 *
 * @author ALBERTO
 */
public class Pelicula extends Producto{
    protected String idioma;
    protected int duracion;
    protected String genero;
    private static int contPeliculas=0;
    private final static String IDIOMAS[]={"ESPAÑOL","INGLES","FRANCES","CHINO","ALEMAN"};
//CONSTRUCTORES
    public Pelicula(String idioma, int duracion, String genero, String nombre) throws IllegalArgumentException{
        super(nombre); //llama al constructor de producto en que se define el nombre
        if(duracion<=0)
            throw new IllegalArgumentException("Duración debe ser positiva");
               
        boolean idiomaExiste=false;
        idioma=idioma.toUpperCase().trim();
        for(int i=0;i<Pelicula.IDIOMAS.length;i++){
            if(idioma==Pelicula.IDIOMAS[i])idiomaExiste=true;
        }       
        if(!idiomaExiste)
                throw new IllegalArgumentException("Idioma desconocido");
        this.idioma = idioma;
        this.duracion = duracion;
        this.genero = genero;
        Producto.contProductos++;
        this.id=Producto.contProductos;
        Pelicula.contPeliculas++;
        this.precio=2.0;
    }
    
    public Pelicula(Pelicula other){
        this(other.idioma, other.duracion, other.genero, other.nombre);
    }
//GETTERS
    public String getIdioma() {
        return idioma;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    public static int getContPeliculas() {
        return contPeliculas;
    }
  
    @Override   
    public double getPrecio(){
        return 2.0f; //f es float
    }
//SETTERS
    public void setIdioma(String idioma) throws IllegalArgumentException{
        boolean idiomaExiste=false;
        idioma=idioma.toUpperCase().trim();
        for(int i=0;i<Pelicula.IDIOMAS.length;i++){
            if(idioma==Pelicula.IDIOMAS[i])idiomaExiste=true;
        }       
        if(!idiomaExiste)
                throw new IllegalArgumentException("Idioma desconocido");
        this.idioma = idioma;
    }

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
        return super.toString()+"\tIdioma: "+this.idioma+"\tDuración: "+this.duracion+"min \tGénero: "+this.genero+']';
    }
//OTROS METODOS
    public boolean equals(Pelicula other){
        if(this.id != other.id) return false;
        if(this.nombre != other.nombre) return false;
        if(this.precio != other.precio) return false;
        if(this.duracion != other.duracion) return false;
        if(this.idioma != other.idioma) return false;
        if(this.genero != other.genero) return false;
        return true;
    }   
}
