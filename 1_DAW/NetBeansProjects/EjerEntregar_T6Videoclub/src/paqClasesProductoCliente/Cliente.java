
package paqClasesProductoCliente;
import java.util.ArrayList;


/**
 *
 * @author ALBERTO
 */
public class Cliente {
    private int id;
    private String nombre;
    private ArrayList <Producto> productosAlquilados;
    private static int contClientes=0;

//CONSTRUCTOR
    public Cliente(String nombre) {
        Cliente.contClientes++;
        this.id = Cliente.contClientes;
        this.nombre = nombre;
        this.productosAlquilados=new ArrayList();
    }

//GETTERS
    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<Producto> getProductosAlquilados() {
        return this.productosAlquilados;
    }

//SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
//OTROS METODOS
    public void alquilarProducto(Producto p){//añadir al ArrayList
        this.productosAlquilados.add(p);
    }
    
    public boolean devolverProducto(Producto p){//eliminar del ArrayList
        boolean borrado=false;
        for(int i=0;i<this.productosAlquilados.size();i++){
            if (p.equals(this.productosAlquilados.get(i))){
                this.productosAlquilados.remove(i);
                borrado=true;
                break;
            }
        }
        return borrado;
    }

    public String contieneProducto(Producto p){
        boolean esta=false;
        String cadena="No está alquilado";
        for(int i=0;i<this.productosAlquilados.size();i++){
            if(p.equals(this.productosAlquilados.get(i)))  esta=true;
        }
        if(esta)cadena="Está alquilado";
        return cadena;
    }
            
    @Override
    public String toString() {
        String cadena="\nID: "+this.id+"\tNombre: "+this.nombre;
        if (this.productosAlquilados.isEmpty())
            cadena+="\n NO ha realizado ningún alquiler";
        else
        {
            cadena+="\n--- ALQUILERS REALIZADOS ---";
            for(int i=0; i<this.productosAlquilados.size(); i++)
                cadena+="\n"+this.productosAlquilados.get(i);
        }       
        return cadena;
    }    
}
