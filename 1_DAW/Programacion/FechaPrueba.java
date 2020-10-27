
package paqFechaPrueba;

public class FechaPrueba {

    public static void main(String[] args) {
       Fecha f1=new Fecha(01,2,1991);
       Fecha f2=new Fecha(31,3,2020);
       System.out.println("f1: "+f1.toString(1));
       System.out.println("f1: "+f1.toString(2));
       System.out.println("default: "+f1.toString(4));

       Fecha f3 = null;
       try{
           f3=new Fecha(29,12,2003);
        }catch(IllegalArgumentException ex){
            //f3=newfecha();
            System.out.println(ex.getMessage());
        }
       
        /*try{
            System.out.println("f3: "+f3.toString(3));
        }catch(NullPointerException e){
            System.out.println("El método toString(n) NO puede mostrar algo que no está creado");
        }*/
        System.out.println("f3: "+f3.toString(3));
    }
    
}
