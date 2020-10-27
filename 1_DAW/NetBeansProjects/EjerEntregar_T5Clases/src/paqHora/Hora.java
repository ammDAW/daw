
package paqHora;

/**
 *
 * @author ALBERTO
 */
public class Hora {
    private int h, m, s;

    //Constructores
    public Hora(){ //por defecto=0
        this.h=this.m=this.s=0;
    }
    public Hora(int h, int m, int s){
        this.h=h;
        this.m=m;
        this.s=s;
    }
    public Hora(int h){
        this(h,0,0);
    }
    public Hora(int h, int m){
        this(h,m,0);
    }
    public Hora(Hora other){
        this(other.h,other.m,other.s);
    }

    @Override
    public String toString() {
        return h+":"+m+":"+s;
    }
   
    //Getters
    public int getH() {
        return h;
    }
    public int getM() {
        return m;
    }
    public int getS() {
        return s;
    }
    
    //Setters
    public void setH(int h) {
        this.h = h;
    }
    public void setM(int m) {
        this.m = m;
    }
    public void setS(int s) {
        this.s = s;
    }

    //equals
    public boolean equals(Hora other){
        return (this.h==other.h && this.m==other.m && this.s==other.s);
    }
    public boolean equals(int h, int m, int s){
        return this.equals(new Hora(h,m,s));
    }

    //Método calcula la cantidad de segundos totales en una hora determinada
    public int toSegundos(Hora actual){
        return actual.s+actual.m*60+actual.h*3600;
    }
    //Método añade minutos a una hora determinada
    public static Hora addMinutos(Hora actual,int m){
        Hora nueva = new Hora(actual);
        nueva.m+=m;
        while(nueva.m>=60){
            nueva.m-=60;
            nueva.h++;
        }
        return actual;
    }
    //Método añade segundos a una hora determinada
    public static Hora addSegundos(Hora actual, int s){
        Hora nueva = new Hora(actual);
        nueva.s+=s;
        while(nueva.s>=3600){
            nueva.h++;
            nueva.s-=3600;
        }
        while(nueva.s>=60){
            nueva.m++;
            nueva.s-=60;
        }
        while(nueva.m>=60){
            nueva.h++;
            nueva.m-=60;
        }
        return nueva; 
        
        /*public void addMinutos(int minutos){
            this.m+=minutos;
        }*/
        //para llamarlo --> h1.addMinutos(2);
    }
}
