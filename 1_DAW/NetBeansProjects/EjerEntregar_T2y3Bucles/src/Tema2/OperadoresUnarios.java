
package Tema2;

public class OperadoresUnarios {
    public static void main(String[] args) {
       int x=0, y=0, z;
       //1 x++
       x=x+1;
       //2 ++x
       x=x+1;
       //3 --x
       x=x-1;
       //4 x--
       x=x-1;
       //5 z=x+y++;
       x=9;y=20;
       z=x+y;
       y=y+1;
       //6 z=x+++y
       x=9;y=20;
       y=y+1;
       z=x+y;
       //7 z=--x+y++
       x=x-1;
       z=x+y;
       y=y+1;    
    } 
}
