
package paqExcepciones;

/**
 *
 * @author ALBERTO
 */
public class NoMas5ProductosAlquiladosPorClientesException extends CapacidadArrayException{
    public NoMas5ProductosAlquiladosPorClientesException() {
        super("ERROR: un cliente nunca puede alquilar más de 5 productos");
    }

    public NoMas5ProductosAlquiladosPorClientesException(String s) {
        super(s);
    }
    
}
