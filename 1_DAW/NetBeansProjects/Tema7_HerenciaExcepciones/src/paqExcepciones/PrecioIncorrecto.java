
package paqExcepciones;

/**
 *
 * @author ALBERTO
 */
public class PrecioIncorrecto extends IllegalArgumentException{
    public PrecioIncorrecto(){
        super("Error, precio incorrecto");
    }
    
    public PrecioIncorrecto(String msj){
        super(msj);
    }
}
