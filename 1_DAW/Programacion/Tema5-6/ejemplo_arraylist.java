Función f1=new Funcion(“f1”,34);
Funcion f2=new Funcion(“f2”,42);
ArrayList <Funcion> funciones=new ArrayList();
ArrayList<Funcion> l=new ArrayList(funcion);
funciones.add(f1);
funciones.add(f2);
System.out.println(funciones.size()); //imprime el tamaño de funciones
System.out.println(funciones.get(0).getNombre()); //imprime el nombre de f1
if (funciones.contains(f2)
    funciones.remove(f2) //si funciones contiene f2, lo borra
System.out.println(“LISTADO DEL ARRAY “);
for(int i=0; i < funciones.size(); i++)
    System.out.println(funciones.get(i)); //Listado completo del array
System.out.println(“LISTADO DEL ARRAY CON FOREACH”);
for(Funcion f : funciones)
    System.out.println(f); //Listado completo del array