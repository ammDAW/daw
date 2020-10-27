
/**
 *
 * @author ALBERTO
 */
public class JavadocPruebaANT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Prueba pue = new Prueba();
        Empleado emp = new Empleado("Alberto", "Martínez", 1200);
        System.out.println(pue.devuelveMensaje2("hola"));
        System.out.println("Empleado= "+emp);
    }
    
    /**
     * @see Empleado
     */
    public void creaEmpleado(){
        Empleado nuevo = new Empleado();
    }
    
}
