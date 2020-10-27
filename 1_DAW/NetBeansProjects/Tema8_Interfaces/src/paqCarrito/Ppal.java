
package paqCarrito;

/**
 *
 * @author ALBERTO
 */
public class Ppal {
    public static void main(String[] args) {
        Alimentacion a1 = new Alimentacion("Leche Pascual", 0.56);
        Alimentacion a2 = new Alimentacion("Colacao", 0.46);
        Alimentacion a3 = new Alimentacion("Magdalenas La Colegiala", 1.23);
        
        Ropa r1 = new Ropa ("Bañador", 23);
        Ropa r2 = new Ropa("Toalla", 5);
        
        Viaje v1 = new Viaje("Murcia","Jamaica",7,2000);
        
        Carrito corteIngles = new Carrito();
        corteIngles.addCarrito(a1);
        corteIngles.addCarrito(a2);
        corteIngles.addCarrito(a3);
        corteIngles.addCarrito(r1);
        corteIngles.addCarrito(r2);
        corteIngles.addCarrito(v1);
        
        corteIngles.mostrarCarrito();
        
        System.out.println("\nPrecio Total a pagar es = "+corteIngles.precioTotalCarrito()+'€');
        //System.out.printf("%.1f",corteIngles.precioTotalCarrito());
        corteIngles.mostrarDestinoViajes();
    }
    
}
