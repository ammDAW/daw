

/**
 *<h2> Esto es un ejemplo de documentación </h2>
 * Puedo añadir etiquetas HTML <b> para mejorar </b> la presentación
 * Por ejemplo añado unas viñetas
 * <ul>
 *      <li>Primer elemento</li>
 *      <li>Segundo elemento</li>
 * </ul>
 * @author ALBERTO
 * @version v1.0
 */
public class Prueba {
    /**
     * @param param1 Se pasa el mensaje que luego devuelve
     * @return Devuelve un mensaje de Hola
     * @deprecated  Se recomienda utilizar devuelveMensaje2
     */
    public String devuelveMensaje(String param1){
        String devuelve=param1;
        return devuelve;
    }
    
    public String devuelveMensaje2(String param1){
        return param1;
    }
}
