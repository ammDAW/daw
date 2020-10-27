/**
 *<h2> Clase Empleado, se utiliza para crear y leer empleados de una Base de Datos </h2>
 * 
 * Busca informacion de Javadoc en <a href="https://www.google.es/">GOOGLE</a>
 * 
 * @see Prueba
 * @version 1.0
 * @author ALBERTO
 * @since 1.0
 */
public class Empleado {
    /**
     * Atributo nombre del empleado. Tipo cadena
     */
    private String nombre;
    
    /**
     * Atributo apellido del empleado. Tipo cadena
     */
    private String apellido;
   
    /**
     * Se almacena el salario. Mínimo 1000 y máximo 2000
     */
    private double salario;
 //CONSTRUCTORES   
    /**
     * Constructor con 3 parámetros
     * Crea objetos empleado, con nombre, apellido y salario
     * @param nombre Nombre del empleado
     * @param apellido Apellido del empleado
     * @param salario Lo que gana el empeldado.
     */
    public Empleado(String nombre, String apellido, double salario){
        this.nombre=nombre;
        this.apellido = apellido;
        this.salario = salario;
    }
    
    /**
     * Constructor por defecto
     * Crea objetos empleados vacíos
     */
    public Empleado(){
        this.nombre=null;
        this.apellido=null;
        this.salario=0;
    }
//GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getSalario() {
        return salario;
    }
//SETTERS    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
//OTROS METODOS    
    /**
     * Este método sube el salario al empleado
     * @see Empleado
     * @param subida DFouble que se sumará al salario que ya tiene
     * @since 1.5
     */
    public void subidasalario(double subida) {
        salario=salario+subida;
    }
    
    /**
     * Comprueba que el nombre no esté vacío
     * @return <ul>
     *              <li>true: el nombre es una cadena vacía</li>
     *              <li>false: el nombre no está vacía</li>
     *         </ul>     
     */
    private boolean comprobar(){
        if(nombre.equals("")) return false;
        else return true;
    }
    
}
