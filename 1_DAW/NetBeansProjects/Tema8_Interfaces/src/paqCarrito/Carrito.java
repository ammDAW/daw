
package paqCarrito;
import java.util.ArrayList;

/**
 *
 * @author ALBERTO
 */
public class Carrito {
    private ArrayList <Vendible> listaCarrito = new ArrayList();
    //el ArrayList da lo mismo iniciarlo con el new aquí o en el constructor
    
    public Carrito(){
    }

    public ArrayList<Vendible> getListaCarrito() {
        return listaCarrito;
    }
    
    public void addCarrito(Vendible v){
    //v de entrada se convierte en cualquier objeto que hereda Vendible
        this.listaCarrito.add(v);
    }
    
    public void mostrarCarrito(){
        System.out.println("--LISTA DE CARRITO--");
        for(Vendible v: this.listaCarrito)
            System.out.println(v);
    }
    
    public double precioTotalCarrito(){
        double sumaPrecios=0;
        for(Vendible v: this.listaCarrito)
            sumaPrecios+=v.precioIva();
        return sumaPrecios;
    }
    
    public void mostrarViajes(){
        System.out.println("##LISTADO DE VIAJES##");
        for(Vendible v : this.listaCarrito)
            if(v instanceof Viaje) System.out.println(v);
    }
    
    public void mostrarDestinoViajes(){
        System.out.println("**DESTINO DE MIS VIAJES**");
        for(Vendible v: this.listaCarrito)
            if(v instanceof Viaje)System.out.println(((Viaje)v).getDestino());
    }
}
