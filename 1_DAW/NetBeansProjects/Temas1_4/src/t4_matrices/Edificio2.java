//Matriz m simula un edificio
//El edificio contiene plantas y en cada planta distinto número de viviendas
        
//El edificio contiene 3 plantas
//1ª planta tiene 5 viviendas
//2º planta tiene 3 vivientas
//3º planta tiene 4 vivientas
package t4_matrices;

import java.util.Scanner;

public class Edificio2 {
    public static void main(String[] args) {
        int m[][]={
                    {3,2,1,6,2},
                    {12,3,6},
                    {5,6,9,10}
                  };
        int persTotales=0, persPlanta, mayor=0, menor=0, auxMayor=Integer.MIN_VALUE, auxMenor=Integer.MAX_VALUE;
        //Recorrido del edificio para saber las personas que viven en cada vivienda
        //Saber también las plantas con más y con menos personas
        //m.length determina el número de plantas del edificio
        //m.length es el número de filas de la matriz m
        for(int planta=0;planta<m.length;planta++){
            System.out.println("PLANTA = "+planta);
            //m[planta].lenth es el num de viviendas
            persPlanta=0;
            for(int vivienda=0;vivienda<m[planta].length;vivienda++){
                System.out.println(m[planta][vivienda]);
                persTotales+=m[planta][vivienda];
                persPlanta+=m[planta][vivienda];
            }
            System.out.println("Hay "+persPlanta+" personas en la planta "+planta+"\n");
            if(persPlanta>auxMayor){mayor=planta;auxMayor=persPlanta;}
            if(persPlanta<auxMenor){menor=planta;auxMenor=persPlanta;}
            
        }
        System.out.println("En el edificio viven en total "+persTotales+" personas");
        System.out.println("La planta donde más gente vive es la "+mayor+" con "+auxMayor+" personas");
        System.out.println("La planta donde menos gente vive es la "+menor+" con "+auxMenor+" personas\n");
        
        //Saber la vivienda con las personas
        int viviendaMayor=0, auxViviendaPers=Integer.MIN_VALUE, auxPlanta=0;
        for(int planta=0;planta<m.length;planta++){
            for(int vivienda=0;vivienda<m[planta].length;vivienda++){
                if(m[planta][vivienda]>auxViviendaPers){viviendaMayor=vivienda;auxPlanta=planta;auxViviendaPers=m[planta][vivienda];}
            }
        }
        System.out.println("La vivienda con más personas es la "+viviendaMayor+" de la planta "+auxPlanta+" con "+auxViviendaPers+" personas");
        
        //Introducir un número y decir si está dentro de alguna vivienda
        Scanner teclado=new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int dato=teclado.nextInt(); boolean existe=false;
        for(int planta=0;planta<m.length;planta++){
            for(int vivienda=0;vivienda<m[planta].length;vivienda++){
                if(dato==m[planta][vivienda])existe=true;break;
                //este break sólo sale de este for por eso hay que crear otro fuera para salir de ambos
            }
            if(existe)break;
        }
        System.out.println("El número introducido"+(existe?" ":" NO ")+"está en el edificio/array");
    }
}
