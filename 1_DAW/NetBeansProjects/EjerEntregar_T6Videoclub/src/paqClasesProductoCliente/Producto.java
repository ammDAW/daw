
package paqClasesProductoCliente;

/**
 *
 * @author ALBERTO
 */
public class Producto {
    private int id, duracion;
    private String nombre;
    private double precio;
    private String idioma;
    private static int contProductos=0;
    private final static String IDIOMAS[]={"ESPAÑOL","INGLES", "FRANCES", "CHINO", "ALEMAN"};

//CONSTRUCTORES
    public Producto(String nombre, int duracion, double precio, String idioma) throws IllegalArgumentException{
        if(duracion<=0)
            throw new IllegalArgumentException("Duración debe ser positiva");
        
        if(precio<=0)
            throw new IllegalArgumentException("Precio debe ser positivo");
        
        boolean idiomaExiste=false;
        idioma=idioma.toUpperCase().trim();
        for(int i=0;i<Producto.IDIOMAS.length;i++){
            if(idioma==Producto.IDIOMAS[i])idiomaExiste=true;
        }       
        if(!idiomaExiste)
                throw new IllegalArgumentException("Idioma desconocido");
        
        Producto.contProductos++;
        this.id=Producto.contProductos;
        this.duracion = duracion;
        this.nombre = nombre;
        this.precio = precio;
        this.idioma = idioma;
    }
    
    public Producto(Producto other) throws IllegalArgumentException{
        if(other.duracion<=0)
            throw new IllegalArgumentException("Duración debe ser positiva");
        
        if(other.precio<=0)
            throw new IllegalArgumentException("Precio debe ser positivo");
        
        boolean idiomaExiste=false;
        String strIdioma=other.idioma.toUpperCase().trim();
        for(int i=0;i<Producto.IDIOMAS.length;i++){
            if(strIdioma==Producto.IDIOMAS[i])idiomaExiste=true;
        }       
        if(!idiomaExiste)
                throw new IllegalArgumentException("Idioma desconocido");
        Producto.contProductos++;
        this.id=Producto.contProductos;
        this.duracion = other.duracion;
        this.nombre = other.nombre;
        this.precio = other.precio; 
        this.idioma = other.idioma;
    }

//GETTERS
    public int getId() {
        return this.id;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public String getIdioma() {
        return this.idioma;
    }

    public static int getContProductos() {
        return Producto.contProductos;
    }

//SETTERS    
    public void setDuracion(int duracion) {
        if(duracion<=0)
            throw new IllegalArgumentException("Duración debe ser positiva");
        else this.duracion=duracion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        if(precio<=0)
            throw new IllegalArgumentException("Precio debe ser positivo");
        else this.precio=precio;
    }

    public void setIdioma(String idioma) {
        boolean idiomaExiste=false;
        idioma=idioma.toUpperCase().trim();
        for(int i=0;i<Producto.IDIOMAS.length;i++){
            if(idioma==Producto.IDIOMAS[i])idiomaExiste=true;  
        }
        if(!idiomaExiste)
            throw new IllegalArgumentException("Idioma desconocido");
        else this.idioma = idioma;
    }

//TOSTRING
    @Override
    public String toString() {
        return "[ID: "+this.id+"\tNombre: "+this.nombre+"\tDuración: "+this.duracion+"\tPrecio: "+this.precio+"\tIdioma: "+this.idioma+']';
    }
}
