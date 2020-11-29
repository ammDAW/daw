package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	private Socket socket;
	public String nombre, descripcion, estado;
	public int totalTarea, numTarea;
	Scanner leer = new Scanner(System.in);
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Client() throws IOException {
		int puerto = 9876;
		String direccion = "localhost";
		socket = new Socket(direccion, puerto);
	}
	
	public void iniciarCliente() throws IOException {
		DataInputStream mServidor = new DataInputStream(socket.getInputStream());
		DataOutputStream mCliente = new DataOutputStream(socket.getOutputStream());

		if(mServidor.readUTF().equals("Bienvenido, ¿Cómo te llamas?")){
			System.out.print(mServidor.readUTF());
			setNombre(leer.nextLine());
			mCliente.writeUTF(nombre);
		}

		if(mServidor.readUTF().equals("¿Cuántas tareas has de realizar?")){
			System.out.print(mServidor.readUTF());
			String aux=leer.nextLine();
			totalTarea = Integer.parseInt(aux);
			mCliente.writeInt(totalTarea);
		}

		if(mServidor.readUTF().equals("Introduce la descripción")){
			System.out.print(mServidor.readUTF());
			descripcion=leer.nextLine();
			mCliente.writeUTF(descripcion);
		}

		if(mServidor.readUTF().equals("Introduce el estado")){
			System.out.print(mServidor.readUTF());
			estado=leer.nextLine();
			mCliente.writeUTF(estado);
		}

		socket.close();	
	}
}