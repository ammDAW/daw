
package paqVehiculo;

import paqExcepciones.KmsIncorrectos;
import paqExcepciones.PotenciaIncorrecta;
import paqExcepciones.PrecioIncorrecto;

/**
 *
 * @author ALBERTO
 */
public class Moto extends VehiculoConMotor{
    protected int kms;
    
    public Moto(int kms, int potencia, int precio) throws PrecioIncorrecto, PotenciaIncorrecta, KmsIncorrectos{
        super(potencia, precio);
        if(kms<0)
            throw new IllegalArgumentException("KmsIncorrectos en Moto");
        this.kms=kms;
    }
}
