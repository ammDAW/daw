
package paqExcepciones;

/**
 *
 * @author ALBERTO
 */
public class PotenciaIncorrecta extends IllegalArgumentException{
    public PotenciaIncorrecta(){
        super("Error, potencia incorrecta");
    }
    //los super llaman a IllegalArgumentException
    public PotenciaIncorrecta(String s){
        super(s);
    }
    
}
