
package paqVehiculo;

import paqExcepciones.PotenciaIncorrecta;
import paqExcepciones.PrecioIncorrecto;
import paqVehiculo.Vehiculo;

/**
 *
 * @author ALBERTO
 */
public class VehiculoConMotor extends Vehiculo{
    protected int potencia;

    public VehiculoConMotor(int potencia, int precio) throws PrecioIncorrecto, PotenciaIncorrecta {
        super(precio);
        if(potencia<0)
            throw new PotenciaIncorrecta("PotenciaIncorrecta personalizada en VehiculoConMotor");
        this.potencia = potencia;
    }
    
    public int getPotencia(){
        return this.potencia;
    }
    
    public void setPotencia(int potencia) throws PotenciaIncorrecta{
        if(potencia<0)
            throw new PotenciaIncorrecta();
        this.potencia=potencia;
    }

    @Override
    public String toString() {
        return '['+super.toString()+"\tPotencia:"+this.potencia+']';
    }

    
}
