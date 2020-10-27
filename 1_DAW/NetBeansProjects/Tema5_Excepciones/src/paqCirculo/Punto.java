
package paqCirculo;

public class Punto {
    private int x;
    private int y;

    public Punto(int x, int y) { //constructor
        this.x = x;
        this.y = y;
    }

    @Override //sobreescrito
    public String toString() {
        return "(" + "x=" + x + ", y=" + y + ')';
    }
    //Getter
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    //Setter
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    //Calcula la distancia entre dos puntos (dato entrada: un objeto)
    public double distancia(Punto other){
        return Math.hypot(this.x-other.x, this.y-other.y);
    }
    //Calcula el punto intermedio que hay entre dos puntos
    public Punto ptoIntermedio(Punto other){
        int x=(this.x + other.x)/2;
        int y=(this.y + other.y)/2;
        Punto inter=new Punto(x,y);
        return inter;
    }
    //Calcula la suma de dos puntos (devuelve un punto)
    public Punto ptoSuma(Punto other){
        Punto s = new Punto(this.x+other.x, this.y+other.y);
        return s;
    }
    //Calcula el punto opuesto de un punto dado
    public Punto ptoOpuesto(){
        return new Punto(-this.x, -this.y);
    }
    
    //Comprueba si dos puntos son iguales
    //Método patrón
    public boolean equals(Punto other){
        if(this.x==other.x && this.y==other.y) return true;
        else return false;
    }

/*--METODOS SOBRECARGADOS--*/
    //Método distancia sobrecargado (dato entrada: dos enteros)
    public double distancia(int x, int y){
        return Math.hypot(this.x-x, this.y-y);
    }
    //Método distancia sobrecargado (sin datos de entrada)
    //devuelve la distancia entre un punto y el punto origen [0,0]
    public double distancia(){
        return Math.hypot(this.x-0, this.y-0);
    }
    
    //Método ptoIntermedio sobrecargado
    public Punto ptoIntermedio(int x, int y){
        Punto inter=new Punto((this.x+x)/2,(this.y+y)/2);
        return inter;      
    }
    //Método equals sobrecargado
    public boolean equals(int x, int y){
        /*if(this.x==x && this.y==y) return true;
        else return false;*/
        return this.equals(new Punto(x,y)); //llama al método patrón
    }
    
/*--CONSTRUCTOR SOBRECARGADOS--*/
    public Punto(){
        this.x=this.y=0;
    }
    public Punto(Punto other){
        this.x=other.x;
        this.y=other.y;
    }
}
