
package paqSubclases;
import paqClases.Producto;
import paqExcepciones.*;
import paqInterfaces.Vendible;

/**
 *
 * @author ALBERTO
 */
public class Pelicula extends Producto implements Vendible{
    protected String idioma;
    protected int duracion;
    protected String genero;
    private static int contPeliculas=0;
    private final static String IDIOMAS[]={"ESPAÑOL","INGLES","FRANCES","CHINO","ALEMAN"};
    protected boolean vendido=false; //interfaz Vendible
//CONSTRUCTORES
    public Pelicula(String idioma, int duracion, String genero, String nombre) throws DuracionPeliculaException, IdiomaPeliculaException{
        super(nombre); //llama al constructor de producto en que se define el nombre
        if(duracion<=0)
            throw new DuracionPeliculaException();
               
        boolean idiomaExiste=false;
        idioma=idioma.toUpperCase().trim();
        for(int i=0;i<Pelicula.IDIOMAS.length;i++){
            if(idioma==Pelicula.IDIOMAS[i])idiomaExiste=true;
        }       
        if(!idiomaExiste)
                throw new IdiomaPeliculaException();
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
    public String getIdioma() {return idioma;}
    public int getDuracion() {return duracion;}
    public String getGenero() {return genero;}
    public static int getContPeliculas() {return contPeliculas;}
    @Override   
    public double getPrecio(){
        return 2.0f; //f es float
    }
//SETTERS
    public void setIdioma(String idioma) throws IdiomaPeliculaException{
        boolean idiomaExiste=false;
        idioma=idioma.toUpperCase().trim();
        for(int i=0;i<Pelicula.IDIOMAS.length;i++){
            if(idioma==Pelicula.IDIOMAS[i])idiomaExiste=true;
        }       
        if(!idiomaExiste)
                throw new IdiomaPeliculaException();
        this.idioma = idioma;
    }

    public void setDuracion(int duracion) throws DuracionPeliculaException{
        if(duracion<=0)
            throw new DuracionPeliculaException();
        this.duracion = duracion;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    } 
//TO_STRING
    @Override
    public String toString() {
        return super.toString()+"\tIdioma: "+this.idioma+"\tDuración: "+this.duracion+"min \tGénero: "+this.genero+"]\n";
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
//METODOS INTERFACES
    @Override
     public void alquilar() throws AlquilarException{ //interfaz Alquilable
        if(this.alquilado)
            throw new AlquilarException();//este mensaje ya está en la clase
        if(this.retirado)
            throw new AlquilarException("ERROR: El producto está retirado");
        if(this.vendido)
            throw new AlquilarException("ERROR: El producto está vendido");
        this.alquilado=true;
     }
    @Override
     public void retirar(){//interfaz Retirable
        if(!this.vendido){
            super.retirar();
            Pelicula.contPeliculas--;
        }
        else{System.out.println("No se puede retirar la película "+this.nombre+" porque está vendida");}
     }
     
    @Override
    public void vender(int precio){//interfaz Vendible
        if(!this.alquilado && !this.retirado && !this.vendido){
            this.precio=precio;
            Pelicula.contPeliculas--;
            Producto.contProductos--;
        }
        if(!this.vendido){this.vendido=true;}
        else{System.out.println("La película "+this.nombre+" no puede ser vendida porque está alquilada");}
    }
    
    @Override
    public boolean isVendido(){//interfaz Vendible
        return this.vendido;
    }
}
