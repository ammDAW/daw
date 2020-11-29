package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server{
	private ServerSocket serverSocket;
	private Socket socket;
	int numTarea;
	String descripcion, estado;
	Tarea t;
	ArrayList<Tarea> tareas = new ArrayList();
	
	public Server() throws IOException {
		int puerto = 9876;
		serverSocket = new ServerSocket(puerto);
		socket = new Socket();
	}
	
	public void iniciarServer() throws IOException {
			socket = serverSocket.accept();
			DataOutputStream mServidor = new DataOutputStream(socket.getOutputStream());
			DataInputStream mCliente = new DataInputStream(socket.getInputStream());

			mServidor = new DataOutputStream(socket.getOutputStream());
			mServidor.writeUTF("Bienvenido, ¿Cómo te llamas?");
			mCliente = new DataInputStream(socket.getInputStream());
			System.out.println(mCliente.readUTF());

			mServidor = new DataOutputStream(socket.getOutputStream());
			mServidor.writeUTF("¿Cuántas tareas has de realizar?");
			mCliente = new DataInputStream(socket.getInputStream());
			System.out.println(mCliente.readUTF());

			mCliente = new DataInputStream(socket.getInputStream());
			String aux =  mCliente.readUTF();
			int total = Integer.parseInt(aux);
			System.out.println(total);

			for (int i = 1; i<=total; i++){
				numTarea=i;				
				
				mServidor = new DataOutputStream(socket.getOutputStream());
				mServidor.writeUTF("Introduce la descripción");
				mCliente = new DataInputStream(socket.getInputStream());
				descripcion = mCliente.readUTF();
				System.out.println(descripcion);

				mServidor = new DataOutputStream(socket.getOutputStream());
				mServidor.writeUTF("Introduce el estado");
				mCliente = new DataInputStream(socket.getInputStream());
				estado = mCliente.readUTF();
				System.out.println(estado);

				t = new Tarea(numTarea, descripcion, estado);
				tareas.add(t);
			}
	}

	public void finalizarServer() throws IOException {
		serverSocket.close();
	}
}