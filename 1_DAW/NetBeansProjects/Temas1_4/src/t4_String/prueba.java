/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4_String;

public class prueba {
    public static void main(String[] args) {
        String nombre1="Rodrigo", nombre2="rodrigo";
        
        if(nombre1.equals(nombre2)==true)
            System.out.println(nombre1+" y "+nombre2+" son iguales");
        else
            System.out.println(nombre1+" y "+nombre2+" son distintos");
    
        if(nombre1.equalsIgnoreCase(nombre2)==true)
            System.out.println(nombre1+" y "+nombre2+" son iguales");
        else
            System.out.println(nombre1+" y "+nombre2+" son distintos");
        
        System.out.println(nombre1.compareTo(nombre2));
        System.out.println((int)'R');
        System.out.println((int)'r');
        
        System.out.println(nombre1.compareToIgnoreCase(nombre2));
        
        String nombre1My=nombre1.toUpperCase();
        String nombre2My=nombre2.toUpperCase();
        System.out.println(nombre1My);
        
        int n=12;
        String nCadena=String.valueOf(n);
        System.out.println(nCadena+"32");
        
        System.out.println(nombre1.length());
        
        String s1="Buenos ";
        String s2="dias";
        String s3=s1.concat(s2);
        System.out.println("concat= "+s3);
        String porcion=s3.substring(1);
        System.out.println("substring= "+porcion);
        porcion=s3.substring(7,s3.length()-1);
        System.out.println(porcion);
        
        String cadenaQ="quería decirte que quiero que te vayas";
        int ind=cadenaQ.indexOf("qu");
        System.out.println("La primera \"qu\" se encuentra en el índice "+ind);
        ind=cadenaQ.indexOf("qu",3);
        System.out.println("La psiguiente \"qu\" se encuentra en el índice "+ind);
        
        //Se desea saber el número de veces que aparece pa subcadena "qu" en la fraase
        int indX="queria decirte que quiero que te vayas".indexOf("qu");
        int cont=0;
        while(indX != -1){
            cont++;
            indX="queria decirte que quiero que te vayas".indexOf("qu",indX+1);
        }
        System.out.println("la frase tiene \"qu\" "+cont+" veces");
        
        String presidente="Pedro Sánchez Pérez-Castejón";
        if(presidente.endsWith("Culebrón"))
            System.out.println("Acertaste...");
        else
            System.out.println("Fallaste...");
        
        String nuevoPresidente=presidente.replace('e','u');
        System.out.println(nuevoPresidente);
        nuevoPresidente=presidente.replaceAll("Sánchez","Iglesias");
        System.out.println(nuevoPresidente);
        
        String martinez="Martinez";
        char arrayM[]=martinez.toCharArray();
        for(int i=0;i<arrayM.length;i++){
            System.out.println(arrayM[i]);
        }
        for(int i=0;i<martinez.length();i++)
            System.out.println(martinez.charAt(i));
        
        cont=0;
        for(int i=0;i<martinez.length();i++)
            if(arrayM[i]=='a')cont++;
        System.out.println("En Martinez hay "+cont+" aes");
    }
}
