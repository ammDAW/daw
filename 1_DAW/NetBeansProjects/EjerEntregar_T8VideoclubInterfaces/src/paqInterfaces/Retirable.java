
package paqInterfaces;

/**
 *
 * @author ALBERTO
 */
public interface Retirable {
    void retirar();
    /*si el producto actual no está alquilado ni retirado, entonces,
    la propiedad retirado pasa a ser true, y la propiedad estática numProductos 
    se decrementa. En el caso de que el producto esté alquilado, emite el mensaje
    de que el producto ya está alquilado y en el caso de que esté ya retirado,
    emite el mensaje indicándolo*/
    
    boolean isRetirado();
}
