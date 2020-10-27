package Clases;
import Clases.Pedir;

public class Vectores {
    public static int menor(int v[]){
        int mn=v[0];
        for(int i=1;i<v.length;i++){
            if(v[i]<mn)mn=v[i];
        }
        return mn;
    }
    
    public static int indiceDe(int v[],int n){
        int p=-1;
        for(int i=0;i<v.length;i++){
            if(v[i]==n){p=i;break;}
        }
        return p;
    }
    
    public static int repiteVeces(int x, int v[]){
        int contRepite=0;
        for(int i=0;i<v.length;i++){
            if(v[i]==x) contRepite++;
        }
        return contRepite;
    }
    
    public static void mostrarVector(int v[]){
        for(int i=0;i<v.length;i++){
            System.out.print(v[i]+"\t");
        }
        System.out.println(" ");
    }
    //el entero n será el tamaño del array
    public static int[] introducirVector(int n){
        int vec[]= new int[n];
        for(int i=0;i<vec.length;i++){
            vec[i]=Pedir.entero("Dime un número: ");
        }
        return vec;
    }
    //dado un año, mostar true o false si es bisiesto o no
    public static boolean bisiesto(int anyo){
        boolean es=false;
        if ((anyo%4==0) && ((anyo%100!=0) || (anyo%400==0))) es=true;
        return es;
    }
    
    public static boolean fechaCorrecta(int v[], int dia, int mes, int anyo){
        boolean correcta=false;
        if (anyo>=1900 && anyo<=2100){
            if(mes>=1 && mes<=12){
                //if((anyo%4==0) && (anyo%100!=0) || (anyo%400==0))diasMes[2]=29;
                if(Vectores.bisiesto(anyo)) v[2]=29;
                if(dia>=1 && dia<=v[mes])correcta=true;
            }
        }
        return correcta;
    }
}
