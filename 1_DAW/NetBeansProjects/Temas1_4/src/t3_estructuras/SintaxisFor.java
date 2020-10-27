
package t3_estructuras;

public class SintaxisFor {
    public static void main(String[] args) {
        //1. Calculo de la suma 1+2+3+...+10
        {
            int suma=0;
            for(int i=1;i<=10;i++)
                suma+=i;
            System.out.println("La suma es "+suma);
        }
        //2. Con todas las variables inicializadas y los incrementos
        {
            int suma,i;
            for(suma=0,i=1; i<=10; suma+=i,i++);
                //no tiene cuerpo
            System.out.println("La suma es "+suma);
        }
        //3. Sin inicializacion de variables
        {
            int suma=0,i=1;
            for(;i<=10;i++)
                suma+=i;
            System.out.println("La suma es "+suma);
        }
        //4. Sin incrementos
        {
            int suma=0;
            for(int i=1;i<=10;)
                suma+=i++;
            System.out.println("La suma es "+suma);
        }
        //5. Sin sondicion de permanencia
        {
            int suma=0;
            for(int i=1; ;i++){
                if (i>10) break;
                suma+=i;
            }
            System.out.println("La suma es "+suma);
        }
        //6. Sin nada
            int suma=0,i=1;
            for(;;){
                if(i>10) break;
                suma+=i++;
            }
            System.out.println("La suma es "+suma);
    }
}
