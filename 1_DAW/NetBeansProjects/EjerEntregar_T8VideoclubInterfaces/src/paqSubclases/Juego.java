
package paqSubclases;
import paqClases.Producto;
import paqExcepciones.AlquilarException;
import paqInterfaces.Vendible;

/**
 *
 * @author ALBERTO
 */
public class Juego extends Producto implements Vendible{
    private String plataforma, genero;
    private static int contJuegos=0;
    private boolean vendido=false;// implementado por interfaz Vendible
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
    public double getPrecio(){
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
        return super.toString()+"\tPlataforma: "+this.plataforma+"\tGénero: "+this.genero+"]\n";
    }
//OTROS METODOS    
    public boolean equals (Juego other){
        if(!super.equals(other)) return false;
        if(this.plataforma!=other.plataforma) return false;
        if(this.genero!=other.genero) return false;
        return true;     
    }
//METODOS INTERFACES
    @Override
    public void alquilar() throws AlquilarException{//interfaz Alquilable
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
            Juego.contJuegos--;
        }
        else{System.out.println("No se puede retirar lel juego "+this.nombre+" porque está vendido");} 
    }
    
    @Override
    public void vender(int precio){//interfaz Vendible
       if(!this.alquilado && !this.retirado && !this.vendido){
            this.precio=precio;
            Juego.contJuegos--;
            Producto.contProductos--;
        }
        if(!this.vendido){this.vendido=true;}
        else{System.out.println("El juego "+this.nombre+" no puede ser vendidp porque está alquilado");} 
    }
    
    public boolean isVendido(){//interfaz Vendible
        return this.vendido;
    }
}
