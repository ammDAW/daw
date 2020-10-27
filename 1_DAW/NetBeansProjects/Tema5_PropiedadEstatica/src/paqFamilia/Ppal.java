
package paqFamilia;

public class Ppal {
    public static void main(String[] args) {
        Familia padre=new Familia("Pepe",42); System.out.println("Padre= "+padre);
        Familia madre=new Familia("Pepa",40); System.out.println("Madre= "+madre);
        Familia hijo=new Familia("Pepito",10); System.out.println("Hijo= "+hijo);
        Familia hija=new Familia("Pepita",8); System.out.println("Hija= "+hija);
    
        System.out.println("\nDirección de la hija= "+Familia.getDIRECCION());
        System.out.println("Dirección del padre= "+Familia.getDIRECCION());
        
        Familia.setDIRECCION("Cataluña"); System.out.println("Nueva dirección= "+Familia.getDIRECCION());
        //se ha cambiado la direcciónb de toda la familia a "Cataluña" porque el la propiedad es estatica;
    }
}
