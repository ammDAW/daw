
package paqAnimal;
import java.util.ArrayList;
import paqFecha.Fecha;

/**
 *
 * @author ALBERTO
 */
public class Hombre extends Vertebrado{
    protected String nombre;
    protected boolean vivo;
    protected static int numHijos=0;
    protected ArrayList <Hijo> datosHijos;

    public Hombre(String nombre, boolean vivo, ArrayList hijos, int numv, int peso, Fecha f) throws IllegalArgumentException{
        super(numv,peso,f);
        if(this.datosHijos.size()==20)
            throw new IllegalArgumentException("Error. Número max de hijos es 20");
        
        this.nombre=nombre;
        this.vivo=vivo;
        this.datosHijos=hijos;
        this.numHijos=this.datosHijos.size();
    }
    
    public Hombre(String nombre, boolean vivo, ArrayList hijos, int numv, int peso, int dia, int mes, int anyo) throws IllegalArgumentException{
        super(numv, peso, dia, mes, anyo);
        if(this.datosHijos.size()==20)
            throw new IllegalArgumentException("Error. Número max de hijos es 20");
        
        this.nombre=nombre;
        this.vivo=vivo;
        this.datosHijos=hijos;
        this.numHijos=this.datosHijos.size();
    }

    public Hombre(String nombre, ArrayList hijos, int numv, Animal a) throws IllegalArgumentException{
        super(numv,a);
        if(this.datosHijos.size()==20)
            throw new IllegalArgumentException("Error. Número max de hijos es 20");
        
        this.nombre=nombre;
        this.datosHijos=hijos;
        this.numHijos=this.datosHijos.size();
    }
    
    public Hombre(){
        super();
        this.numHijos=0;
        this.datosHijos = new ArrayList();
    }
    
    public Hombre(String nombre, boolean vivo, ArrayList hijos, Vertebrado v){
        super(v.getNumVertebras(), v.getPeso() ,v.fechaNac.getDia(), v.fechaNac.getMes(), v.fechaNac.getYear());
        this.nombre=nombre;
        this.vivo=vivo;
        this.datosHijos = hijos;
        this.numHijos=hijos.size();
    }
    
    public Hombre(Hombre h){
        this(h.nombre,h.vivo,h.datosHijos,h.numVertebras,h.peso,h.getFecha());
    }
    
//GETTERS
    public String getNombre() {
        return nombre;
    }

    public boolean esVivo() {
        return vivo;
    }

    public static int getNumHijos() {
        return numHijos;
    }

    public ArrayList<Hijo> getDatosHijos() {
        return datosHijos;
    }
    
//SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
//OTROS METODOS
    public void morir() throws IllegalArgumentException{
        if(this.vivo!=true)
            throw new IllegalArgumentException("sólo se puede morir una vez");
        this.vivo=false;
    }
    
    public void tenerHijos(Hijo h)throws IllegalArgumentException{
        if(this.numHijos==20)
            throw new IllegalArgumentException("Error. Número máximo de hijos es 20");
        if(this.datosHijos.contains(h))
            throw new IllegalArgumentException("El hijo ya existe");      
        
        this.datosHijos.add(h);
        this.numHijos=datosHijos.size();                
    }
    
    public Hijo hijoMenor(Fecha f){
        /*int edad=f.getYear()-this.datosHijos.get(0).fechaNac.getYear();
        //int edad= this.datosHijos.get(0).edad(f);
        Hijo hm=this.datosHijos.get(0);
        for(int i=1;i<this.datosHijos.size();i++){
            if((f.getYear()-this.datosHijos.get(i).fechaNac.getYear())<edad){
                edad=f.getYear()-this.datosHijos.get(i).fechaNac.getYear();
                hm=this.datosHijos.get(i);
            }
        }*/
        int edad= this.datosHijos.get(0).edad(f);
        Hijo hm=this.datosHijos.get(0);
        
        for(int i=1;i<this.datosHijos.size();i++){
            if(this.datosHijos.get(i).edad(f)<edad){
               edad=this.datosHijos.get(i).edad(f);
               hm=this.datosHijos.get(i);
            }
        }
        return hm;
    }
    
    public int edadHijoMenor(Fecha f){
        return this.hijoMenor(f).edad(f);
    }
    
    public String nombreHijoMenor(Fecha f){
        return this.hijoMenor(f).getNombre();   
    }
    
    public int lugarHijo(String nombre){
        //Hijo hj= new Hijo();
        int pos=-1;
        for(int i=0;i<this.datosHijos.size();i++){
            if(this.datosHijos.get(i).nombre.equals(nombre)) 
                //hj=this.datosHijos.get(i);
                pos=i; break;
        }
        return pos;
        //return this.datosHijos.indexOf(hj);
    }
    
    public int lugarHijo(Hijo h){
        return this.datosHijos.indexOf(h);
    }
    
    public String darNombre(int n)throws IllegalArgumentException{
        if(n<0 || n>(this.numHijos-1))
            throw new IllegalArgumentException("Error en el entero");
        return this.datosHijos.get(n).nombre;
    }

    @Override
    public String toString() { 
        String cadena="[Nombre: "+ this.nombre+"\tVivo: "+this.vivo+super.toString();
        if(this.datosHijos.isEmpty())
            cadena+="\tHijos: NO tiene hijos]";
        else{
            cadena+="\n-LISTA HIJOS-";
            for(int i=0; i<this.datosHijos.size(); i++){
                cadena+="\n"+this.datosHijos.get(i);
            }
        }
        return cadena;
    }
    
    

}
