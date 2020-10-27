
package paqExcepciones;

/**
 *
 * @author ALBERTO
 */
public class NoMas20ClientesVideoclubException extends CapacidadArrayException{
    public NoMas20ClientesVideoclubException() {
        super("ERROR: El videoclub no puede tener más de 20 clientes");
    }

    public NoMas20ClientesVideoclubException(String s) {
        super(s);
    }
    
}
