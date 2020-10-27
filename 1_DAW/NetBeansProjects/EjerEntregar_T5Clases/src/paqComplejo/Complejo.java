
package paqComplejo;

/**
 *
 * @author ALBERTO
 */
public class Complejo {
    private int r, i; //r=real, i=imaginaria

    //Constructor por defecto
    public Complejo(){
        this.r=this.i=1;
    }
    //Constructores sobrecargados
    public Complejo(int r, int i){
        this.r=r;
        this.i=i;
    }
    public Complejo(Complejo c){
        this.r=c.r;
        this.i=c.i;
    }
    
    //Getters
    public int getReal() {
        return r;
    }
    public int getImaginaria() {
        return i;
    }
    
    //Setters    
    public void setReal(int r) {
        this.r = r;
    }
    public void setImaginaria(int i) {
        this.i = i;
    }
    
    public void setComplejo(int r, int i){//patrón
        this.setReal(r);
        this.setImaginaria(i);
    }
    public void setComplejo(Complejo other){
        this.setComplejo(other.r, other.i);
    }

    //toString
    @Override
    public String toString() {
        if (this.r==0 && this.i==0) return "{0}";
        else if (this.i==0) return "{"+this.r+"}";
        else if (this.i<0) return "{"+this.r+" "+this.i+"i}";
        else if (this.r==0) return "{"+this.i+"i}";
        else return "{"+this.r+" + "+this.i+"i}";
    }
    //equals
    public boolean equals(Complejo other){
        return (this.r==other.r && this.i==other.i);
    }
    public boolean equals(int r, int i){
        //return (this.r==r && this.i==i);
        return this.equals(new Complejo(r,i));
    }
    
    //Suma
    public Complejo complejoSuma(Complejo other){
        Complejo suma=new Complejo();
        suma.r=(this.r+this.i) + (other.r+other.i);
        suma.i=(this.r+other.r) + (this.i+other.i);
        return suma;
    }
    public Complejo complejoSuma(int r, int i){
        return this.complejoSuma(new Complejo(r,i));
    }
    
    //Resta
    public Complejo complejoResta(int r, int i){
        Complejo resta=new Complejo();
        resta.r=(this.r+this.i) - (r+i);
        resta.i=(this.r-r) + (this.i-i);
        return resta;
    }
    public Complejo complejorResta(Complejo other){
        return this.complejoResta(other.r, other.i);
    }
    
    //Producto
    public Complejo complejoProducto(Complejo other){
        Complejo pr=new Complejo();
        pr.r=(this.r+this.i) * (other.r+other.i);
        pr.i=(this.r*other.r - this.i*other.i) + (this.r*other.i + this.i*other.r);
        return pr;
    }
    public Complejo complejoProducto(int r, int i){
        return this.complejoProducto(new Complejo(r,i));
    }
    
    //Cociente
    public Complejo complejoCociente(Complejo other){
        Complejo co=new Complejo();
        co.r=(this.r+this.i) / (other.r+other.i);
        co.i=(int)((this.r*other.r+this.i*this.i) / (Math.pow(other.r,2)+Math.pow(other.i,2)) + ((this.i*other.r-this.r*other.i)/(Math.pow(other.r,2)+Math.pow(other.i,2))));
        return co;
    }
    public Complejo complejoCociente(int r, int i){
        return this.complejoCociente(new Complejo(r,i));
    }
    
}
    